/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author xingyuchen
 * ITag class for store ITag information
 */
public class ITag {
    private int userId;
    private int iTagId;
    private String content;
    private double longitude;
    private String userName;
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private double latitude;
    private Date date;
    private ArrayList<Comment> comments;

    public ITag() {
        super();
    }

    public ITag(int userId, String content, double longitude, Date date, double latitude, ArrayList<Comment> comments) {
        this.userId = userId;
        this.content = content;
        this.longitude = longitude;
        this.date = date;
        this.latitude = latitude;
        this.comments = comments;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getiTagId() {
        return iTagId;
    }

    public void setiTagId(int iTagId) {
        this.iTagId = iTagId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
