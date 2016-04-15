/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import java.util.ArrayList;

import model.ITag;
import util.DBAdaptor;

/**
 * @author xingyuchen
 *
 */
public class ITagAdaptorImp implements ITagAdaptor {

	@Override
	public String getAllITagsByUserId(int userId) {
		ArrayList<ITag> itags = DBAdaptor.getAllITagsByUserId(userId);
		return null;
	}


	@Override
	public String createNewITag(ITag tag) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String discoverAllTagsNearby(double longitude, double latitude) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String updateITag(ITag tag) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteITag(int tagId) {
		// TODO Auto-generated method stub
		return null;
	}

}
