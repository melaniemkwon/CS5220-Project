package formbuilder.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import formbuilder.model.core.dao.UserDao;
import formbuilder.model.questionform.dao.FormDao;

public class FormService {
	@Autowired
	private FormDao formDao;

	@Autowired
	private UserDao userDao;
}
