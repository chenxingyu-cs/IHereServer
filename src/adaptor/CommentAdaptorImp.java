/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import java.util.ArrayList;

import model.Comment;
import util.DBAdaptor;

/**
 * @author xingyuchen
 *
 */
public class CommentAdaptorImp implements CommentAdaptor{

	@Override
	public String getAllCommentsByITagId(int tagId) {
		ArrayList<Comment> comments = DBAdaptor.getAllCommentsByITagId(tagId);
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
