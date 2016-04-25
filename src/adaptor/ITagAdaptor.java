/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.ITag;

/**
 * @author xingyuchen
 *
 */
public interface ITagAdaptor {
	
	public String getAllITagsByUserId(int userId);
	
	public String createNewITag(ITag tag);
	
	public String discoverAllTagsNearby(double longitude, double latitude);
	
	public String updateITag(int iTagId, String content);
	
	public String deleteITag(int tagId);

}
