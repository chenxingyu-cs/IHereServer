/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import java.util.ArrayList;

import com.google.gson.Gson;

import db.DBAdaptor;
import model.Comment;

/**
 * @author xingyuchen
 * The implementation of commentadaptor
 */
public class CommentAdaptorImp implements CommentAdaptor{

	@Override
	public String getAllCommentsByITagId(int tagId) {
		ArrayList<Comment> comments = DBAdaptor.getAllCommentsByITagId(tagId);
		String result = new Gson().toJson(comments);
		return result;
	}


	@Override
	public String createNewComment(Comment comment) {
		boolean result = DBAdaptor.createNewComment(comment);
		return result + "";
	}


	@Override
	public String updateComment(int commentId, String content) {
		boolean result = DBAdaptor.updateComment(commentId, content);
		return result + "";
	}


	@Override
	public String deleteComment(int commentId) {
		boolean result = DBAdaptor.deleteComment(commentId);
		return result + "";
	}

}
