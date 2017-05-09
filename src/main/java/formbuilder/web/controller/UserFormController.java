package formbuilder.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import formbuilder.model.core.User;
import formbuilder.model.core.dao.UserDao;
import formbuilder.model.questionform.Answer;
import formbuilder.model.questionform.ChoiceAnswer;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.TextAnswer;
import formbuilder.model.questionform.dao.FormDao;

@Controller

@SessionAttributes({ "form", "question" })
@PropertySource("WEB-INF/formbuilder.properties")
public class UserFormController {
	@Autowired
	private FormDao formDao;

	@Autowired
	private UserDao userDao;

	@Value("${upload.location}")
	private String uploadLocation;

	@RequestMapping("/userForm/listForm.html")
	public String listForm(@RequestParam Integer id, ModelMap models) {

		models.put("user", userDao.getUser(id));

		Set<Form> forms = userDao.getUser(id).getForms();

		models.put("forms", forms);

		return "userForm/listForm";
	}

	@RequestMapping(value = "/userForm/fillForm.html", method = RequestMethod.GET)
	public String fillForm(@RequestParam Integer uId, @RequestParam Integer fId, @RequestParam Integer pageNum,
			ModelMap models) {

		User user = userDao.getUser(uId);
		Form form = formDao.getForm(fId);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		int numQuestion = questionsPage.size();
		// get all questions
		for (Question question : questionsPage) {
			// get answers from all users
			List<Answer> answers = question.getAnswers();
			boolean found = false;
			// searching for specific user answer and move to index 0
			if (answers.size() > 0) {
				for (Answer answer : answers) {
					if (answer.getUser().equals(user)) {
						found = true;
						answers.set(0, answer);
						break;
					}
				}
			}
			// not found answer create new one
			if (!found) {
				if (question.getType().equals("TEXT")) {
					TextAnswer newAnswer = new TextAnswer();
					newAnswer.setUser(user);
					newAnswer.setQuestion(question);
					if (answers.size() > 0)
						answers.set(0, newAnswer);
					else
						answers.add(newAnswer);
				} else if (question.getType().equals("CHOICE")) {
					ChoiceAnswer newAnswer = new ChoiceAnswer();
					newAnswer.setUser(user);
					newAnswer.setQuestion(question);
					if (answers.size() > 0)
						answers.set(0, newAnswer);
					else
						answers.add(newAnswer);
				}
			}
		}

		models.put("form", form);
		models.put("numQuestion", numQuestion);

		models.put("uId", uId);
		models.put("fId", fId);
		models.put("pageNum", pageNum);

		return "userForm/fillForm";
	}

	@RequestMapping(value = "/userForm/fillForm.html", method = RequestMethod.POST)
	public String fillForm(@ModelAttribute Form form, @RequestParam Integer uId, @RequestParam Integer fId,
			@RequestParam Integer pageNum, @RequestParam("file") File[] files, SessionStatus sessionStatus) {
		for (File file : files)
			System.out.println(file.getAbsolutePath());
		System.out.println("Reach fillForm Method");
		formDao.saveForm(form);
		sessionStatus.setComplete();
		return "redirect:/userForm/fillForm.html?uId=" + uId + "&fId=" + fId + "&pageNum=" + pageNum;

	}

	@PostMapping("/userForm/uploadAnswer.html")
	public String uploadAnswer(@RequestParam("file") MultipartFile[] files, @RequestParam Integer uId,
			@RequestParam Integer fId, @RequestParam Integer pageNum, @RequestParam Integer qId,
			RedirectAttributes redirectAttributes) {

		StringJoiner sj = new StringJoiner(" , ");
		System.out.println("reach Upload Answer Method");
		System.out.println("qId = " + qId);

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				System.out.println("Empty File");
				continue; // next pls
			}

			try {

				byte[] bytes = file.getBytes();
				// Path is C:/temp/formbuilder/uId_XX/qId_YY/FILE
				Path path = Paths.get(uploadLocation + "uId_" + uId + "/qId_" + qId + "/" + file.getOriginalFilename());
				Files.createDirectories(path.getParent());
				Files.write(path, bytes);

				sj.add(file.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String uploadedFileName = sj.toString();
		if (StringUtils.isEmpty(uploadedFileName)) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		} else {
			redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + uploadedFileName + "'");
		}

		return "redirect:/userForm/fillForm.html?uId=" + uId + "&fId=" + fId + "&pageNum=" + pageNum;
	}

}
