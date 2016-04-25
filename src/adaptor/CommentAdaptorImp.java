/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import java.util.ArrayList;

import db.DBAdaptor;
import model.Comment;

/**
 * @author xingyuchen
 *
 */
public class CommentAdaptorImp implements CommentAdaptor{

	@Override
	public String getAllCommentsByITagId(int tagId) {
		ArrayList<Comment> comments = DBAdaptor.getAllCommentsByITagId(tagId);
		comments.size();
		return null;
	}


	@Override
	public String createNewComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteComment(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
