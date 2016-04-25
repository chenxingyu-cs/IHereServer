/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import com.google.gson.Gson;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.jndi.url.dns.dnsURLContext;

import db.DBAdaptor;
import model.User;
import sun.launcher.resources.launcher;

/**
 * @author xingyuchen
 *
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
		return result + "";
	}


	@Override
	public String updateUserInfo(User user) {
		boolean result = DBAdaptor.updateUserInfo(user);
		return result + "";
	}

}
