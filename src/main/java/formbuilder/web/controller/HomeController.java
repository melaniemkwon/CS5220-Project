package formbuilder.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import formbuilder.model.core.User;
import formbuilder.model.pdfform.PdfMap;
import formbuilder.model.pdfform.dao.PdfMapDao;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.dao.FormDao;
import formbuilder.model.uploadFileDao.FileUploadDAO;
import formbuilder.model.uploadfile.UploadFile;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private FileUploadDAO fileUploadDao;

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private FormDao formDao;
	
	@Autowired
	private PdfMapDao pdfMapDao;

	@RequestMapping({ "/index.html", "/home.html" })
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password.");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.setViewName("login");

		return model;

	}

	@RequestMapping("/userHome.html")
	public String userHome() {
		return "userHome";
	}

	@RequestMapping("/staffHome.html")
	public String staffHome() {
		return "staffHome";
	}

	// ############### file upload controllers ######################


	@RequestMapping(value = "/pdf/upload.html", method = RequestMethod.GET)
	public String showUploadForm(HttpServletRequest request, ModelMap models) throws IOException {

		String realPath = context.getServletContext().getRealPath("/PDFresource");
		System.out.println(realPath);
		File dir = new File(realPath);
		dir.mkdir();
		request.setAttribute("path", dir);
		File[] files = dir.listFiles();
		if (files.length > 0) {
			request.setAttribute("files", files);
		}
		
		// Application forms
		models.put("forms", formDao.getForms());
		
		// UploadFiles
//		models.put("uploadFiles", fileUploadDao.getFiles());
		
		return "/pdf/upload";
	}

	@RequestMapping(value = "/pdf/upload.html", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request,
			@RequestParam CommonsMultipartFile fileUpload) throws Exception {

		if (fileUpload != null) {

				System.out.println("Saving file: " + fileUpload.getOriginalFilename());
				UploadFile uploadFile = new UploadFile();
				uploadFile.setFileName(fileUpload.getOriginalFilename());
				uploadFile.setData(fileUpload.getBytes());
				fileUploadDao.save(uploadFile);

				if (!fileUpload.isEmpty()) {
					try {
						// Creating the directory to store file
						String realPath = context.getServletContext().getRealPath("/PDFresource");
						File dir = new File(realPath);
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						fileUpload.transferTo(new File(dir, fileUpload.getOriginalFilename()));
						System.out.println("You successfully uploaded file=" + fileUpload.getOriginalFilename());
					} catch (Exception e) {
						System.out.println(
								"You failed to upload " + fileUpload.getOriginalFilename() + " => " + e.getMessage());
					}
				} else {
					System.out.println(
							"You failed to upload " + fileUpload.getOriginalFilename() + " because the file was empty.");
				}

			}


		return "redirect:/pdf/upload.html";
	}
	
	// ###################### view file ####################

	@RequestMapping(value = "/pdf/upload/view.html", method = RequestMethod.GET)
	public void viewFile(HttpServletResponse response, @RequestParam File f) throws IOException {

		File file = new File(f.getAbsolutePath());

		if (!file.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println("Sorry. The file you are looking for does not exist");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println(
					"mimetype is not detectable, will take default" + file.getName() + " " + file.getAbsolutePath());
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : " + mimeType);

		response.setContentType(mimeType);

		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		// Copy bytes from source to destination(outputstream in this example),
		// closes both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	// ################### Download #####################
	@RequestMapping(value = "/pdf/upload/download.html", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @RequestParam File f) throws IOException {

		File file = new File(f.getAbsolutePath());

		 String mimeType =
		 URLConnection.guessContentTypeFromName(file.getName());
		 if (mimeType == null) {
		 System.out.println(
					"mimetype is not detectable, will take default" + file.getName() + " " + file.getAbsolutePath());
		 mimeType = "application/octet-stream";
		 }

		response.setContentType(mimeType);

		response.setHeader("Content-Disposition", String.format("atachment; filename=\"" + file.getName() + "\""));

		response.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		// Copy bytes from source to destination(outputstream in this example),
		// closes both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

	// ###################### delete file ####################

	@RequestMapping(value = "/pdf/upload/delete.html", method = RequestMethod.GET)
	public String deleteFile(@RequestParam File f) {

		System.out.println("delete" + f.getAbsolutePath());
		File file = new File(f.getAbsolutePath());
		file.delete();

		return "redirect:/pdf/upload.html";
	}

	@RequestMapping(value = "/pdf/upload/edit.html", method = RequestMethod.GET)
	public String editFile(@RequestParam String fileName, @RequestParam String userName) {

		File f = new File(fileName);
		File newName = new File(f.getParentFile() + "/" + userName + ".pdf");
		f.renameTo(newName);
		return "redirect:/pdf/upload.html";
	}
	
	// ##### Map an 'Application Form' to the 'PDF Form' #####
	// -------------------------------------------------------
	@RequestMapping(value = "/pdf/upload/map", method = RequestMethod.GET)
	public String mapPDFtoForm(@RequestParam Integer formId, @RequestParam File fileName) throws IOException {

		System.out.println("DEBUG: File f= " + fileName);
		System.out.println("DEBUG: formID= " + formId);
		
		List<UploadFile> uploadFiles = fileUploadDao.getFiles();
		for (UploadFile u : uploadFiles) {
			if (u.getFileName().equals(fileName.getName())) {
				Form form = formDao.getForm(formId);
				form.setUploadFile(u);
				u.setForm(form);
				
				
				// Clear all old pdf mappings
				// TODO: have all old pdfmaps delete from database. Right now they're just nulled.
				List<PdfMap> pdfMaps = u.getPdfMaps();
				for (PdfMap pdfMap : pdfMaps) {
					pdfMap.setUploadFile(null);
					pdfMapDao.save(pdfMap);
					pdfMapDao.delete(pdfMap.getId());
				}
				u.resetPdfMaps();
				fileUploadDao.save(u);
//				pdfMaps.remove(pdfMap);
				
				System.out.println("DEBUG: list of pdfmaps reset");
				System.out.println(u.getPdfMaps());
				
				// Get PDF fields
				PDDocument pdfTemplate = PDDocument.load(fileName);
				PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
				PDAcroForm acroForm = docCatalog.getAcroForm();
				List<PDField> fieldList = acroForm.getFields();
				
				for (PDField sField : fieldList) {
					PdfMap pdfMap = new PdfMap();
					pdfMap.setFieldName(sField.getFullyQualifiedName());
					u.addPdfMap(pdfMap);
				}
				
				fileUploadDao.save(u);
				formDao.saveForm(form);
				
				break;
			}
		}
		
//		Form form = formDao.getForm(formId);
//		UploadFile uploadFile = fileUploadDao.getFile(8);
//		
//		uploadFile.setForm(form);				
//		form.setUploadFile(uploadFile);
//		
//		fileUploadDao.save(uploadFile);
//		formDao.saveForm(form);
		
		return "redirect:/pdf/upload.html";
	}

}
