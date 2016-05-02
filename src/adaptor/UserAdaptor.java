/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.User;

/**
 * @author xingyuchen
 * Interface of user related operations
 */
public interface UserAdaptor {
	
	/**
	 * @param email
	 * @param password
	 * @return
	 * Get user info if the email and password are correct
	 */
	public String getUserInfo(String email, String password);
	
	/**
	 * @param email
	 * @param password
	 * @param userName
	 * @return
	 * Create a new User in the database
	 */
	public String createNewUser(String email, String password, String userName);
	
	/**
	 * @param user
	 * @return
	 * Update the corresponding user in the database
	 */
	public String updateUserInfo(User user);
	
	/**
	 * @param userId
	 * @return
	 * Return the user Name according the the userId
	 */
	public String getUserName(int userId);
	
}
