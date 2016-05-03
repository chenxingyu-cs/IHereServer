/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import model.ITag;

/**
 * @author xingyuchen
 * Interface of iTag related operations
 */
public interface ITagAdaptor {
	
	/**
	 * @param userId
	 * @return
	 * Get all the itags according to the userId
	 */
	public String getAllITagsByUserId(int userId);
	
	/**
	 * @param tag
	 * @return
	 * Create a new ITag
	 */
	public String createNewITag(ITag tag);
	
	/**
	 * @param longitude
	 * @param latitude
	 * @return
	 * Return all the itags around
	 */
	public String discoverAllTagsNearby(double longitude, double latitude, double direction);
	
	/**
	 * @param iTagId
	 * @param content
	 * @return
	 * Update the corresponding iTag
	 */
	public String updateITag(int iTagId, String content);
	
	/**
	 * @param tagId
	 * @return
	 * Delete the corresponding iTag
	 */
	public String deleteITag(int tagId);
	
	/**
	 * @param iTagId
	 * @return
	 * Return the iTag details according to the iTagId
	 */
	public String getItagById(int iTagId);

}
