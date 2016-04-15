/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.User;

/**
 * @author xingyuchen
 *
 */
public interface UserAdaptor {
	
	public String getUserInfo(String email, String password);
	
	public String createNewUser(User user);
	
	public String updateUserInfo(User user);
	
}
