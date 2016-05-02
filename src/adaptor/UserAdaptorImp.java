/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import com.google.gson.Gson;

import db.DBAdaptor;
import model.User;

/**
 * @author xingyuchen
 * The implementation of UserAdaptor
 */
public class UserAdaptorImp implements UserAdaptor {

	@Override
	public String getUserInfo(String email, String password) {
		User user = DBAdaptor.getUserInfo(email, password);
		user.getClass();
		String result = new Gson().toJson(user);
		return result;
	}


	@Override
	public String createNewUser(String email, String password, String userName) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUserName(userName);
		boolean result = DBAdaptor.createNewUser(user);
		if (result) {
			String response = new Gson().toJson(user);
			return response;
		}
		user = new User();
		user.setUserId(0);
		String response = new Gson().toJson(user);
		return response;
	}


	@Override
	public String updateUserInfo(User user) {
		boolean result = DBAdaptor.updateUserInfo(user);
		return result + "";
	}

	
	@Override
	public String getUserName(int userId) {
		return DBAdaptor.getUserName(userId);
	}

}
