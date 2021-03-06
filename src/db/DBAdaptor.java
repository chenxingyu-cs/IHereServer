/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.Comment;
import model.ITag;
import model.User;

/**
 * @author xingyuchen
 * Used to handle connection with database
 */
public class DBAdaptor {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/iHereServer";

	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	static Connection connection;

	// Set the connection with MySQL database
	static {
		try {
			try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User getUserInfo(String email, String password) {
		User user = new User();

		String sql = "SELECT * FROM user WHERE email = '" + email + "';";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					user.setEmail(email);
					user.setPassword(rs.getString("password"));
					user.setUserId(rs.getInt("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setDescription(rs.getString("description"));
					user.setGender(rs.getInt("gender"));
				} else {
					user.setUserId(0);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			user.setUserId(0);
		}

//		user.setUserId(1);
//		user.setEmail("flubber@ihere.com");
//		user.setUserName("Flubber");
//		user.setPassword("123455");
//		Comment comment = new Comment();
//		comment.setCommentId(1);
//		comment.setContent("First Comment");
//		Comment comment2 = new Comment();
//		comment2.setCommentId(2);
//		comment2.setContent("Second Comment");
//		ArrayList<Comment> comments = new ArrayList<>();
//		comments.add(comment);
//		comments.add(comment2);
//		ITag iTag = new ITag();
//		iTag.setiTagId(1);
//		iTag.setContent("First ITag");
//		iTag.setComments(comments);
//		ArrayList<ITag> iTags = new ArrayList<>();
//		iTags.add(iTag);
//		user.setTags(iTags);
//		System.out.println("Login request handled");
		return user;
	}

	public static boolean createNewUser(User user) {
		String sql = "insert into user (email, password, user_name)" + "values (?, ?, ?);";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		sql = "SELECT * FROM user ORDER BY user_id DESC limit 1";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static boolean updateUserInfo(User user) {
		String sql = "update user SET user_name = ?, description = ?, gender = ?" + " WHERE email = ?;";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getDescription());
			preparedStatement.setInt(3, user.getGender());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static ArrayList<ITag> getAllITagsByUserId(int userId) {
		ArrayList<ITag> tags = new ArrayList<>();

		String sql = "SELECT * FROM itag WHERE user_id = " + userId + ";";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ITag tag = new ITag();
				tag.setiTagId(rs.getInt("tag_id"));
				tag.setContent(rs.getString("content"));
				tag.setLongitude(rs.getDouble("longitude"));
				tag.setLatitude(rs.getDouble("latitude"));
				tag.setUserId(rs.getInt("user_id"));
				tag.setDate(rs.getTimestamp("date"));
				String userName = getUserName(rs.getInt("user_id"));
				tag.setUserName(userName);
				tags.add(tag);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tags;
	}

	public static boolean createNewITag(ITag tag) {
		String sql = "insert into itag (user_id, content, longitude, latitude, date)" + "values (?, ?, ?, ?, ?);";
		try {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = simpleDateFormat.format(tag.getDate());
			java.sql.Date sqlDate = new java.sql.Date(tag.getDate().getTime());
			System.out.println(tag.getDate());
			System.out.println(sqlDate.toString());
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, tag.getUserId());
			preparedStatement.setString(2, tag.getContent());
			preparedStatement.setDouble(3, tag.getLongitude());
			preparedStatement.setDouble(4, tag.getLatitude());
			preparedStatement.setString(5, currentTime);
			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static ArrayList<ITag> getAllITagsNearBy(double longitude, double latitude) {
		ArrayList<ITag> tags = new ArrayList<>();

		String sql = "SELECT * FROM itag;";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ITag tag = new ITag();
				tag.setiTagId(rs.getInt("tag_id"));
				tag.setContent(rs.getString("content"));
				tag.setLongitude(rs.getDouble("longitude"));
				tag.setLatitude(rs.getDouble("latitude"));
				tag.setUserId(rs.getInt("user_id"));
				tag.setDate(rs.getTimestamp("date"));
				String userName = getUserName(rs.getInt("user_id"));
				tag.setUserName(userName);
				tags.add(tag);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tags;
	}

	public static boolean updateITag(int iTagId, String content) {
		String sql = "update itag SET content = ? " + " WHERE tag_id = ?;";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, content);
			preparedStatement.setInt(2, iTagId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean deleteITag(int tagId) {
		String sql = "DELETE FROM itag WHERE tag_Id = ? ;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, tagId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static ArrayList<Comment> getAllCommentsByITagId(int tagId) {
		ArrayList<Comment> comments = new ArrayList<>();

		String sql = "SELECT * FROM comment WHERE itag_id = " + tagId + ";";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Comment comment = new Comment();
				comment.setiTagId(rs.getInt("itag_id"));
				comment.setCommentId(rs.getInt("comment_id"));
				comment.setUserId(rs.getInt("user_id"));
				comment.setContent(rs.getString("content"));
				String userName = getUserName(rs.getInt("user_id"));
				comment.setUserName(userName);
				comments.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comments;
	}

	public static boolean createNewComment(Comment comment) {
		String sql = "insert into comment (user_id, content, itag_id)" + "values (?, ?, ?);";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, comment.getUserId());
			preparedStatement.setString(2, comment.getContent());
			preparedStatement.setInt(3, comment.getiTagId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean updateComment(int commentId, String content) {
		String sql = "update comment SET content = ? " + " WHERE comment_id = ?;";
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, content);
			preparedStatement.setInt(2, commentId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean deleteComment(int commentId) {
		String sql = "DELETE FROM comment WHERE comment_Id = ? ;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, commentId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public static ITag getItagById(int itagId) {
		ITag iTag = new ITag();

		String sql = "SELECT * FROM itag WHERE tag_id = " + itagId + ";";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				iTag.setContent(rs.getString("content"));
				iTag.setUserId(rs.getInt("user_id"));
				iTag.setiTagId(rs.getInt("tag_id"));
				iTag.setLongitude(rs.getDouble("longitude"));
				iTag.setLatitude(rs.getDouble("latitude"));
				iTag.setDate(rs.getTimestamp("date"));
				ArrayList<Comment> comments = getAllCommentsByITagId(rs.getInt("tag_id"));
				iTag.setComments(comments);
				String userName = getUserName(rs.getInt("user_id"));
				iTag.setUserName(userName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return iTag;
	}
	
	public static String getUserName(int userId) {
		String result = "";
		
		String sql = "SELECT * FROM user WHERE user_id = " + userId + ";";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				result = rs.getString("user_name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
