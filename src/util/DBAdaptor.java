/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package util;

import java.util.ArrayList;

import com.google.gson.Gson;

import model.Comment;
import model.ITag;
import model.User;

/**
 * @author xingyuchen
 *
 */
public class DBAdaptor {
	
//	static public String getUserInfo(String email, String password) {
//		
//		User user = getUserByEmail(email);
//		String result = "";
//		
//		if (password.equals(user.getPassword())) {
//			result = new Gson().toJson(user);
//		} else {
//			result = "{\"UserId\":0}";
//		}
//
//		return result;
//	}
//	
//	static public String insertNewUser(String email, String password, String userName) {
//		User user = new User();
//		user.setEmail(email);
//		user.setPassword(password);
//		user.setUserName(userName);
//		user.setUserId(2);
//		String result =  new Gson().toJson(user);
//		return result;
//	}
//	
//	static public User getUserByEmail(String email) {
//		User user = new User();
//		user.setUserId(1);
//		user.setEmail("Chenxingyu.cs@gmail.com");
//		user.setGender(1);
//		user.setUserName("AccChenxy");
//		user.setPassword("123456");
//		return user;
//	}
//	
//	public static String getITagsByUserId(int userId) {
//		ArrayList<ITag> tags = retrieveITagsByUserId(userId);
//		String result = new Gson().toJson(tags);
//		return result;	
//	}
//	
//	
//	public static ArrayList<ITag> retrieveITagsByUserId(int userId) {
//		ArrayList<ITag> tags = new ArrayList<>();
//		ITag tag = new ITag();
//		tag.setLatitude(13232);
//		tag.setLongitude(434343);
//		tag.setContent("hahah it is a tag");
//		Comment comment = new Comment();
//		comment.setContent("content1");
//		comment.setUserId(1);
//		ArrayList<Comment> comments = new ArrayList<>();
//		comments.add(comment);
//		comments.add(comment);
//		tag.setComments(comments);
//		tags.add(tag);
//		tags.add(tag);
//		return tags;
//		
//	}
//	
//	public static void saveITagToDataBase(ITag tag) {
//		
//	}
//	
//	public static String getCommentsByITagId(int tagId) {
//		ArrayList<Comment> comments = retrieveCommentByItagId(tagId);
//		String result = new Gson().toJson(comments);
//		return result;	
//	}
//	
//	public static ArrayList<Comment> retrieveCommentByItagId(int tagId) {
//		Comment comment = new Comment();
//		comment.setContent("content1");
//		comment.setUserId(1);
//		ArrayList<Comment> comments = new ArrayList<>();
//		comments.add(comment);
//		comments.add(comment);
//		return comments;
//		
//	}
//	
//	
//	public static void saveCommentToDataBase(Comment comment) {
//		
//	}
	
	public static User getUserInfo(String email) {
		User user = new User();
		return user;
	}
	
	public static boolean createNewUser(User user) {
		return true;
	}
 
	public static boolean updateUserInfo(User user) {
		return true;
	}
	
	public static ArrayList<ITag> getAllITagsByUserId(int userId) {
		ArrayList<ITag> tags = new ArrayList<>();
		return tags;
	}
	
	public static boolean createNewITag(ITag tag) {
		return true;
	}
	
	public static ArrayList<ITag> getAllITagsNearBy(int userId) {
		ArrayList<ITag> tags = new ArrayList<>();
		return tags;
	}
	
	public static boolean updateITag(ITag tag) {
		return true;
	}
	
	public static boolean deleteITag(int tagId) {
		return true;
	}
	
	public static ArrayList<Comment> getAllCommentsByITagId(int tagId) {
		ArrayList<Comment> comments = new ArrayList<>();
		return comments;
	}
	
	public static boolean createNewComment(Comment comment) {
		return true;
	}
	
	public static boolean updateComment(Comment comment) {
		return true;
	}
	
	public static boolean deleteComment(int commentId) {
		return true;
	}
	

}
