/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.Comment;

/**
 * @author xingyuchen
 * Interface of comment related operations
 */
public interface CommentAdaptor {
	
	
	/**
	 * @param tagId
	 * @return
	 * Get all the comments according to the itagId given
	 */
	public String getAllCommentsByITagId(int tagId);
	
	/**
	 * @param comment
	 * @return
	 * create a new comment in the database
	 */
	public String createNewComment(Comment comment);
	
	/**
	 * @param commentId
	 * @param content
	 * @return
	 * Update the corresponding comment in the database
	 */
	public String updateComment(int commentId, String content);
	
	/**
	 * @param commentId
	 * @return
	 * Delete the corresponding comment in the database
	 */
	public String deleteComment(int commentId);
	
}
