/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.Comment;

/**
 * @author xingyuchen
 *
 */
public interface CommentAdaptor {
	
	public String getAllCommentsByITagId(int tagId);
	
	public String createNewComment(Comment comment);
	
	public String updateComment(int commentId, String content);
	
	public String deleteComment(int commentId);
	
}
