/**
 * @author xingyuchen
 * Created on Apr 14, 2016
 */
package adaptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;

import db.DBAdaptor;
import model.ITag;

/**
 * @author xingyuchen
 * The implementation of ITagAdaptor
 */
public class ITagAdaptorImp implements ITagAdaptor {
	
	private static final double DISTANCE_LIMIT = 0.001;
	private static final double ANGLE_LIMIT = 45;
	private static final int ITAG_NUMBER_IIMIT = 10;

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
	public String discoverAllTagsNearby(double longitude, double latitude, double direction) {
		ArrayList<ITag> itags = DBAdaptor.getAllITagsNearBy(longitude, latitude);
		final double myLongitude = longitude;
		final double myLatitude = latitude;
		System.out.println("\n\n\nEVERY THING BEGIN...");
		System.out.println(longitude + ", " + latitude + ", " + direction);
		PriorityQueue<ITag> iTagQueue = new PriorityQueue<ITag>(5, new Comparator<ITag>() {
	        public int compare(ITag iTag1, ITag iTag2) {
	        	double distance1 = Math.pow((myLongitude - iTag1.getLongitude()), 2.0) 
						+ Math.pow(myLatitude - iTag1.getLatitude(), 2.0);
	        	double distance2 = Math.pow((myLongitude - iTag2.getLongitude()), 2.0) 
						+ Math.pow(myLatitude - iTag2.getLatitude(), 2.0);
	        	if (distance1 > distance2)
	        		return 1;
	        	else 
	        		return -1;
	        }
	    });
		for (ITag iTag: itags) {
			iTagQueue.add(iTag);
		}

		ArrayList<ITag> itagsFiltered = new ArrayList<>();
		
		for (int i = 0; i < ITAG_NUMBER_IIMIT && !iTagQueue.isEmpty(); i++) {
			ITag iTag = iTagQueue.poll();
			double distance = Math.pow((myLongitude - iTag.getLongitude()), 2.0) 
					+ Math.pow(myLatitude - iTag.getLatitude(), 2.0);
			
			LatLng loc1 = new LatLng(latitude, longitude);
			LatLng loc2 = new LatLng(iTag.getLatitude(), iTag.getLongitude());
			double init = LatLngTool.initialBearing(loc1, loc2);
			double deg = LatLngTool.normalizeBearing(init);
			
//			double iTagDirection = angleFromCoordinate(latitude, longitude, iTag.getLatitude(), iTag.getLongitude());
//			System.out.println(distance + "  Angle: " + iTagDirection + "Difference: " + (iTagDirection - direction));
//			System.out.println("or: " + angleFromCoordinate(iTag.getLatitude(), iTag.getLongitude(), latitude, longitude));
//			System.out.println("test: " + angleFromCoordinate(0, 1, 0, 0) + "                      " + deg);
			System.out.println("distance: " + distance);
			double difference = Math.abs(deg - direction);
			if (difference > 180)
				difference = 360 - difference;
			System.out.println("direction: " + direction + "  deg: " + deg + "   difference: " + difference);
			if (distance < DISTANCE_LIMIT && difference < ANGLE_LIMIT)
				itagsFiltered.add(iTag);
		}
		
		
		
		String result = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(itagsFiltered);
		
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
	
	private double angleFromCoordinate(double lat1, double long1, double lat2,
	        double long2) {

	    double dLon = (long2 - long1);

	    double y = Math.sin(dLon) * Math.cos(lat2);
	    double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1)
	            * Math.cos(lat2) * Math.cos(dLon);

	    double brng = Math.atan2(y, x);

	    brng = Math.toDegrees(brng);
	    brng = (brng + 360) % 360;
	    brng = 360 - brng;

	    return brng;
	}

}
