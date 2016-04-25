package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adaptor.CommentAdaptorImp;
import adaptor.ITagAdaptorImp;
import adaptor.UserAdaptorImp;
import model.Comment;
import model.ITag;
import model.User;

/**
 * Servlet implementation class IHereQuery
 */
public class IHereQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String queryIdStr = request.getParameter("queryId");
		
		int queryId = Integer.parseInt(queryIdStr);
		
		String result = "";
		
		switch (queryId) {
		case GET_USER_INFO:
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			result = userAdaptorImp.getUserInfo(email, password);
			break;
		case CREATE_NEW_USER:
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
			iTag.setLatitude(Float.parseFloat(request.getParameter("latitude")));
			iTag.setLongitude(Float.parseFloat(request.getParameter("longitude")));
			iTag.setContent(request.getParameter("content"));
			iTag.setUserId(Integer.parseInt(request.getParameter("userId")));
			result = itagAdaptorImp.createNewITag(iTag);
			break;
		case DISCOVER_ITAGS_AROUND:
			float longitude = Float.parseFloat(request.getParameter("longitude"));
			float latitude = Float.parseFloat(request.getParameter("latitude"));
			result = itagAdaptorImp.discoverAllTagsNearby(longitude, latitude);
			break;
		case UPDATE_ITAG_INFO:
			int iTagId = Integer.parseInt(request.getParameter("iTagId"));
			String content = request.getParameter("content");
			result = itagAdaptorImp.updateITag(iTagId, content);
			break;
		case DELETE_ITAG:
			int tagId2 = Integer.parseInt(request.getParameter("iTagId"));
			result = itagAdaptorImp.deleteITag(tagId2);
			break;
		case GET_ALL_COMMENT_BY_ITAG_ID:
			int tagId = Integer.parseInt(request.getParameter("tagId"));
			result = commentAdaptorImp.getAllCommentsByITagId(tagId);
			break;
		case CREATE_NEW_COMMENT:
			Comment comment = new Comment();
			result = commentAdaptorImp.createNewComment(comment);
			break;
		case UPDATE_COMMENT_INFO:
			Comment comment2 = new Comment();
			result = commentAdaptorImp.updateComment(comment2);
			break;
		case DELETE_COMMENT:
			int commentId = Integer.parseInt(request.getParameter("commentId"));
			result = commentAdaptorImp.deleteComment(commentId);
			break;
		default:
			break;
		}
		
		
//	    response.setContentType("application/json");
//	    response.setCharacterEncoding("UTF-8");
//	    response.getWriter().write(json);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		out.print(result);
		

	}

}
