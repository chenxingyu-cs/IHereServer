/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package model;

import java.util.Date;

/**
 * @author xingyuchen
 * Comment class for store comment information
 */
public class Comment {
    private int commentId;
    private int iTagId;
    private int userId;
    private String content;
    private Date date;

    public Comment() {
        super();
    }

	public Comment(int iTagId, int userId, String content, Date date) {
		super();
		this.iTagId = iTagId;
		this.userId = userId;
		this.content = content;
		this.date = date;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getiTagId() {
		return iTagId;
	}

	public void setiTagId(int iTagId) {
		this.iTagId = iTagId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    

}