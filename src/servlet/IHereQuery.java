package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import adaptor.CommentAdaptorImp;
import adaptor.ITagAdaptorImp;
import adaptor.UserAdaptorImp;
import exception.CustomException;
import model.Comment;
import model.ITag;
import model.User;
import sun.java2d.loops.CustomComponent;

/**
 * Servlet implementation class IHereQuery Used to handle the request from
 * Android client
 */
public class IHereQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// The API Id as regulated
	private static final int GET_USER_INFO = 1;
	private static final int CREATE_NEW_USER = 2;
	private static final int UPDATE_USER_INFO = 3;
	private static final int GET_ALL_ITAGS_BY_USER_ID = 4;
	private static final int CREATE_NEW_ITAG = 5;
	private static final int DISCOVER_ITAGS_AROUND = 6;
	private static final int UPDATE_ITAG_INFO = 7;
	private static final int DELETE_ITAG = 8;
	private static final int GET_ALL_COMMENT_BY_ITAG_ID = 9;
	private static final int CREATE_NEW_COMMENT = 10;
	private static final int UPDATE_COMMENT_INFO = 11;
	private static final int DELETE_COMMENT = 12;
	private static final int GET_ITAG_BY_ITAG_ID = 13;
	private static final int GET_USERNAME_BY_USER_ID = 14;

	private UserAdaptorImp userAdaptorImp = new UserAdaptorImp();
	private ITagAdaptorImp itagAdaptorImp = new ITagAdaptorImp();
	private CommentAdaptorImp commentAdaptorImp = new CommentAdaptorImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IHereQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryIdStr = request.getParameter("queryId");

		int queryId = Integer.parseInt(queryIdStr);

		String result = "";

		try {
			// Handle the request according to id
			switch (queryId) {
			case GET_USER_INFO:
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				result = userAdaptorImp.getUserInfo(email, password);
				break;
			case CREATE_NEW_USER:
				Gson gson = new GsonBuilder().create();
				email = request.getParameter("email");
				password = request.getParameter("password");
				String userName = request.getParameter("userName");
				result = userAdaptorImp.createNewUser(email, password, userName);
				break;
			case UPDATE_USER_INFO:
				User user = new User();
				user.setEmail(request.getParameter("email"));
				user.setPassword(request.getParameter("password"));
				user.setDescription(request.getParameter("description"));
				user.setUserName(request.getParameter("userName"));
				user.setGender(Integer.parseInt(request.getParameter("gender")));
				result = userAdaptorImp.updateUserInfo(user);
				break;
			case GET_ALL_ITAGS_BY_USER_ID:
				int userId = Integer.parseInt(request.getParameter("userId"));
				result = itagAdaptorImp.getAllITagsByUserId(userId);
				break;
			case CREATE_NEW_ITAG:
				ITag iTag = new ITag();
				gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				System.out.println(request.getParameter("itag"));
				iTag = gson.fromJson(request.getParameter("itag"), new TypeToken<ITag>() {
				}.getType());
				result = itagAdaptorImp.createNewITag(iTag);
				break;
			case DISCOVER_ITAGS_AROUND:
				double longitude = Double.parseDouble(request.getParameter("longitude"));
				double latitude = Double.parseDouble(request.getParameter("latitude"));
				double direction = Double.parseDouble(request.getParameter("direction"));
				result = itagAdaptorImp.discoverAllTagsNearby(longitude, latitude, direction);
				break;
			case UPDATE_ITAG_INFO:
				int iTagId = Integer.parseInt(request.getParameter("iTagId"));
				String content = request.getParameter("content");
				result = itagAdaptorImp.updateITag(iTagId, content);
				break;
			case DELETE_ITAG:
				iTagId = Integer.parseInt(request.getParameter("iTagId"));
				result = itagAdaptorImp.deleteITag(iTagId);
				break;
			case GET_ALL_COMMENT_BY_ITAG_ID:
				iTagId = Integer.parseInt(request.getParameter("iTagId"));
				result = commentAdaptorImp.getAllCommentsByITagId(iTagId);
				break;
			case CREATE_NEW_COMMENT:
				gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				Comment comment = gson.fromJson(request.getParameter("comment"), new TypeToken<Comment>() {
				}.getType());
				result = commentAdaptorImp.createNewComment(comment);
				break;
			case UPDATE_COMMENT_INFO:
				int commentId = Integer.parseInt(request.getParameter("commentId"));
				content = request.getParameter("content");
				result = commentAdaptorImp.updateComment(commentId, content);
				break;
			case DELETE_COMMENT:
				commentId = Integer.parseInt(request.getParameter("commentId"));
				result = commentAdaptorImp.deleteComment(commentId);
				break;
			case GET_ITAG_BY_ITAG_ID:
				iTagId = Integer.parseInt(request.getParameter("iTagId"));
				result = itagAdaptorImp.getItagById(iTagId);
				break;
			case GET_USERNAME_BY_USER_ID:
				userId = Integer.parseInt(request.getParameter("userId"));
				result = userAdaptorImp.getUserName(userId);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			CustomException customException = new CustomException();
			customException.handle();
		}

		// response.setContentType("application/json");
		// response.setCharacterEncoding("UTF-8");
		// response.getWriter().write(json);

		// return the result in format of html
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print(result);

	}

}
