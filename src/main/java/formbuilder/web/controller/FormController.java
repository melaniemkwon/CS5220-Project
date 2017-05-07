package formbuilder.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.core.User;
import formbuilder.model.core.dao.UserDao;
import formbuilder.model.questionform.ChoiceQuestion;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.TagAttribute;
import formbuilder.model.questionform.TextQuestion;
import formbuilder.model.questionform.dao.FormDao;

@Controller
@SessionAttributes({ "form", "question" })
public class FormController {

	@Autowired
	private FormDao formDao;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/form/listForm.html")
	public String listForm(ModelMap models) {

		models.put("forms", formDao.getForms());
		return "form/listForm";
	}

	@RequestMapping(value = "/form/addForm.html", method = RequestMethod.GET)
	public String addForm(ModelMap models) {
		models.put("form", new Form());

		return "form/addForm";
	}

	@RequestMapping(value = "/form/addForm.html", method = RequestMethod.POST)
	public String addForm(@ModelAttribute Form form, SessionStatus status) {

		form.setTotalPages(1);
		formDao.saveForm(form);

		return "redirect:/form/listForm.html";
	}

	@RequestMapping(value = "/form/editForm.html", method = RequestMethod.GET)
	public String editForm(@RequestParam Integer id, ModelMap models) {

		Form form = formDao.getForm(id);
		models.put("form", form);

		return "form/editForm";
	}

	@RequestMapping(value = "/form/editForm.html", method = RequestMethod.POST)
	public String editForm(@ModelAttribute Form form, SessionStatus sessionStatus) {

		formDao.saveForm(form);
		sessionStatus.setComplete();
		return "redirect:listForm.html";
	}

	@RequestMapping("/form/deleteForm.html")
	public String deleteForm(@RequestParam Integer id) {

		formDao.deleteForm(id);
		return "redirect:listForm.html";
	}

	@RequestMapping("/form/listAssignForm.html")
	public String listAssignForm(@RequestParam Integer id, ModelMap models) {

		// Set<User> users = form.getUsers();
		models.put("form", formDao.getForm(id));
		models.put("users", userDao.getUsers());
		return "form/listAssignForm";
	}

	@RequestMapping(value = "/form/assignForm.html")
	public String assignForm(@RequestParam Integer id, @RequestParam Integer uId) {

		Form form = formDao.getForm(id);
		User user = userDao.getUser(uId);
		form.getUsers().add(user);
		user.getForms().add(form);
		formDao.saveForm(form);
		userDao.saveUser(user);
		return "redirect:/form/listAssignForm.html?id=" + id;
	}

	@RequestMapping(value = "/form/deassignForm.html")
	public String deassignForm(@RequestParam Integer id, @RequestParam Integer uId) {

		Form form = formDao.getForm(id);
		User user = userDao.getUser(uId);
		form.getUsers().remove(user);
		user.getForms().remove(form);
		formDao.saveForm(form);
		userDao.saveUser(user);
		return "redirect:/form/listAssignForm.html?id=" + id;
	}

	@RequestMapping(value = "/form/viewPage.html")
	public String viewPage(@RequestParam Integer id, @RequestParam Integer pageNum, ModelMap models) {

		Form form = formDao.getForm(id);
		if (pageNum > form.getTotalPages())
			return "redirect:/form/viewPage.html?id=" + id + "&pageNum=1";
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("form", form);
		models.put("questionsPage", questionsPage);
		return "form/viewPage";
	}

	@RequestMapping(value = "/form/editPage.html", method = RequestMethod.GET)
	public String editPage(@RequestParam Integer id, @RequestParam Integer pageNum, ModelMap models) {

		Form form = formDao.getForm(id);
		if (pageNum > form.getTotalPages())
			return "redirect:/form/editPage.html?id=" + id + "&pageNum=1";
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("form", form);
		models.put("questionsPage", questionsPage);
		return "form/editPage";
	}
	
	@RequestMapping(value = "/form/editPage.html", method = RequestMethod.POST)
	public String editPage(@RequestParam Integer id, @RequestParam Integer pageNum, ModelMap models, @ModelAttribute Form form) {
		formDao.saveForm(form);
		if (pageNum > form.getTotalPages())
			return "redirect:/form/editPage.html?id=" + id + "&pageNum=1";
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("form", form);
		models.put("questionsPage", questionsPage);
		return "form/editPage";
	}

	@RequestMapping(value = "/form/addPage.html")
	public String addPage(@RequestParam Integer id) {

		Form form = formDao.getForm(id);
		int newPageNum = form.getTotalPages() + 1;
		form.setTotalPages(newPageNum);
		formDao.saveForm(form);
		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + newPageNum;
	}

	@RequestMapping("/form/deletePage.html")
	public String deletePage(@RequestParam Integer id, @RequestParam Integer pageNum) {
	
		Form form = formDao.getForm(id);
		if (form.getTotalPages() > 1) {
	
			ListIterator<Question> listIterator = form.getQuestions().listIterator();
			while (listIterator.hasNext()) {
				Question question = listIterator.next();
				if (question.getPageNumber() == pageNum) {
					listIterator.remove();
				} else if (question.getPageNumber() > pageNum) {
					question.setPageNumber(question.getPageNumber() - 1);
					listIterator.set(question);
				}
			}
			form.setTotalPages(form.getTotalPages() - 1);
	
			formDao.saveForm(form);
		}
		return "redirect:/form/editPage.html?id=" + id + "&pageNum=1";
	}

	@RequestMapping(value = "/form/addTextQuestion.html")
	public String addTextQuestion(@RequestParam Integer id, @RequestParam Integer pageNum, @RequestParam String type) {

		Form form = formDao.getForm(id);
		TextQuestion question = new TextQuestion();
		question.setPageNumber(pageNum);
		// set tag attribute
		TagAttribute tagAttribute = question.getTagAttribute();
		tagAttribute.setType(type);
		question.setTagAttribute(tagAttribute);

		question.setQuestionNumber(form.getQuestionsPage(pageNum).size() + 1);

		form.addQuestion(question);

		formDao.saveForm(form);

		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + pageNum;
	}

	@RequestMapping(value = "/form/addChoiceQuestion.html")
	public String addChoiceQuestion(@RequestParam Integer id, @RequestParam Integer pageNum,
			@RequestParam String type) {

		Form form = formDao.getForm(id);
		ChoiceQuestion question = new ChoiceQuestion();
		question.setPageNumber(pageNum);
		// set tag attribute
		TagAttribute tagAttribute = question.getTagAttribute();
		tagAttribute.setType(type);
		question.setTagAttribute(tagAttribute);

		question.setQuestionNumber(form.getQuestionsPage(pageNum).size() + 1);

		form.addQuestion(question);

		formDao.saveForm(form);

		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + pageNum;
	}

	@RequestMapping("/form/deleteQuestion.html")
	public String deleteQuestion(@RequestParam Integer qId) {

		Question deleteQuestion = formDao.getQuestion(qId);
		Form form = deleteQuestion.getForm();
		int id = form.getId();
		int pageNum = deleteQuestion.getPageNumber();
		int questionNumber = deleteQuestion.getQuestionNumber();

		form.removeQuestion(deleteQuestion);
		// Update question number
		List<Question> questions = form.getQuestionsPage(pageNum);

		for (Question question : questions) {
			if (question.getQuestionNumber() > questionNumber)
				question.setQuestionNumber(question.getQuestionNumber() - 1);
		}
		formDao.saveForm(form);

		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + pageNum;
	}

	@RequestMapping("/form/copyQuestion.html")
	public String copyQuestion(@RequestParam Integer qId) {

		Question originalQuestion = formDao.getQuestion(qId);
		Form form = originalQuestion.getForm();
		int id = form.getId();
		int pageNum = originalQuestion.getPageNumber();
		int questionNumber = originalQuestion.getQuestionNumber();
		// Update question number
		List<Question> questions = form.getQuestionsPage(pageNum);

		for (Question question : questions) {
			if (question.getQuestionNumber() > questionNumber)
				question.setQuestionNumber(question.getQuestionNumber() + 1);
		}

		Question newQuestion = (Question) originalQuestion.clone();
		form.addQuestion(newQuestion);
		formDao.saveForm(form);

		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + pageNum;
	}

	@RequestMapping("/form/moveUpQuestion.html")
	public String moveUpQuestion(@RequestParam Integer qId) {

		Question question = formDao.getQuestion(qId);
		Form form = question.getForm();
		int id = form.getId();
		int pageNum = question.getPageNumber();
		int questionNumber = question.getQuestionNumber();

		if (questionNumber > 1) {
			Question priorQuestion = formDao.getQuestion(questionNumber - 1, pageNum);
			System.out.println(question.getQuestionNumber());
			System.out.println(priorQuestion.getQuestionNumber());
			// Update question number
			question.setQuestionNumber(questionNumber - 1);
			priorQuestion.setQuestionNumber(questionNumber);

			System.out.println(question.getQuestionNumber());
			System.out.println(priorQuestion.getQuestionNumber());

			formDao.saveForm(form);
		}
		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + pageNum;
	}

	@RequestMapping("/form/moveDownQuestion.html")
	public String moveDownQuestion(@RequestParam Integer qId) {

		Question question = formDao.getQuestion(qId);
		Form form = question.getForm();
		int id = form.getId();
		int pageNum = question.getPageNumber();
		int questionNumber = question.getQuestionNumber();

		Question nextQuestion = formDao.getQuestion(questionNumber + 1, pageNum);

		System.out.println(question.getQuestionNumber());
		System.out.println(nextQuestion.getQuestionNumber());

		if (nextQuestion != null) {

			// Update question number
			question.setQuestionNumber(questionNumber + 1);
			nextQuestion.setQuestionNumber(questionNumber);

			System.out.println(question.getQuestionNumber());
			System.out.println(nextQuestion.getQuestionNumber());

			formDao.saveForm(form);
		}
		return "redirect:/form/editPage.html?id=" + id + "&pageNum=" + pageNum;
	}

	@RequestMapping(value = "/form/editQuestion.html", method = RequestMethod.GET)
	public String editQuestion(@RequestParam Integer qId, ModelMap models) {

		Question question = formDao.getQuestion(qId);

		models.put("question", question);
		models.put("id", question.getForm().getId());
		models.put("pageNum", question.getPageNumber());

		return "form/editQuestion";
	}

	@RequestMapping(value = "/form/editQuestion.html", method = RequestMethod.POST)
	public String editQuestion(@ModelAttribute Question question, SessionStatus status) {
		Integer qId = question.getId();
		formDao.saveQuestion(question);

		return "redirect:/form/editQuestion.html?qId=" + qId;
	}
	
	@RequestMapping(value = "/form/editQuestionOrder", params = "questionOrder")
	@ResponseBody
	public void editQuestionOrder(@RequestParam String questionOrder) {
		System.out.println("DEBUG: " + questionOrder);
		List<String> questionsList = Arrays.asList(questionOrder.split(","));
		
		for (int i = 0; i < questionsList.size(); i++) {
			Question question = formDao.getQuestion(Integer.parseInt(questionsList.get(i)));
			question.setQuestionNumber(i+1);
			formDao.saveQuestion(question);
			System.out.println("Setting question " + question.getId() + " to number " + question.getQuestionNumber());
		}
	}

	@RequestMapping(value = "/form/addChoice.html")
	public String addChoice(@RequestParam Integer qId, @RequestParam Integer choiceIndex) {

		ChoiceQuestion question = (ChoiceQuestion) formDao.getQuestion(qId);
		List<String> choices = question.getChoices();
		choices.add(choiceIndex, choices.get(choiceIndex));

		formDao.saveQuestion(question);

		return "redirect:/form/editQuestion.html?qId=" + qId;
	}

	@RequestMapping(value = "/form/deleteChoice.html")
	public String deleteChoice(@RequestParam Integer qId, @RequestParam Integer choiceIndex) {

		ChoiceQuestion question = (ChoiceQuestion) formDao.getQuestion(qId);
		List<String> choices = question.getChoices();

		choices.remove(choiceIndex.intValue());

		formDao.saveQuestion(question);

		return "redirect:/form/editQuestion.html?qId=" + qId;
	}

}
