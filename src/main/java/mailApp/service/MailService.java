package mailApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mailApp.Dao.MailDao;
import mailApp.entity.*;

@Service
public class MailService {
	
	@Autowired
	MailDao dao;

	public User getUser(String user, String pass) {
		User userId = dao.getUser(user, pass);
		return userId;
	}
	
	public List<Message> getMessages(int userId) {
		return dao.getMessages(userId);
	}
	
	public boolean addMessages(int userId, String msg) {
		return dao.addMessage(userId, msg);
	}

}
