/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import db.DBAdaptor;
import model.ITag;

/**
 * @author xingyuchen
 * The implementation of ITagAdaptor
 */
public class ITagAdaptorImp implements ITagAdaptor {

	@Override
	public String getAllITagsByUserId(int userId) {
		ArrayList<ITag> itags = DBAdaptor.getAllITagsByUserId(userId);
		String result = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(itags);
		return result;
	}


	@Override
	public String createNewITag(ITag tag) {
		boolean result = DBAdaptor.createNewITag(tag);
		return result + "";
	}


	@Override
	public String discoverAllTagsNearby(double longitude, double latitude) {
		ArrayList<ITag> itags = DBAdaptor.getAllITagsNearBy(longitude, latitude);
		String result = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(itags);
		return result;
	}


	@Override
	public String updateITag(int iTagId, String content) {
		boolean result = DBAdaptor.updateITag(iTagId, content);
		return result + "";
	}


	@Override
	public String deleteITag(int tagId) {
		boolean result = DBAdaptor.deleteITag(tagId);
		return result + "";
	}


	@Override
	public String getItagById(int iTagId) {
		ITag itag = DBAdaptor.getItagById(iTagId);
		String result = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(itag);
		return result;
	}

}
