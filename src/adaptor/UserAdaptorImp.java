/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.User;
import util.DBAdaptor;

/**
 * @author xingyuchen
 *
 */
public class UserAdaptorImp implements UserAdaptor {

	@Override
	public String getUserInfo(String email, String password) {
		User user = DBAdaptor.getUserInfo(email);
		return null;
	}


	@Override
	public String createNewUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
