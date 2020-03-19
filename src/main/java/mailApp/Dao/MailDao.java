package mailApp.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mailApp.entity.Message;
import mailApp.entity.User;

@Component
public class MailDao {
	
	@Autowired
	JdbcTemplate template;

	public User getUser(String user, String pass) {
		Object[] args = {user, pass};
		try {
			User userId = template.queryForObject("SELECT * FROM users WHERE username= ? and password = ?", args, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					int userId = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					return new User(userId, username, password);
				}} );
			return userId;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public List<Message> getMessages(int userId) {
		Object[] args = {userId};
		try {
			List<Message> messages = template.query("SELECT * FROM messages WHERE userId = ?", args, new RowMapper<Message>() {

				@Override
				public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
					int id = rs.getInt(1);
					String message = rs.getString(2);
					return new Message(id, message);
				}} );
			return messages;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	public boolean addMessage(int userId, String msg) {
		Object[] args = {msg, userId};
		try {
			int result = template.update("INSERT INTO mailapp.messages (message, userId) VALUES (?,?)", args);
			if(result != 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
