package com.dbs.dublinbikes;

public class Utils {

	

	public static double distance(double sourceLat, double sourceLon, double destLat, double destLon) {
		
	      double theta = sourceLon - destLon;
	      double dist = Math.sin(degreeToradians(sourceLat)) * Math.sin(degreeToradians(destLat)) + Math.cos(degreeToradians(sourceLat)) * Math.cos(degreeToradians(destLat)) * Math.cos(degreeToradians(theta));
	      dist = Math.acos(dist);
	      dist = radiansTodegree(dist);
	      dist = dist * 60 * 1.1515;
	      dist = dist * 1.609344;
	      return (dist);
	    }

	   
	  public static double degreeToradians(double degree) {
	      return (degree * Math.PI / 180.0);
	    }

	    
	    public  static double radiansTodegree(double radian) {
	      return (radian * 180.0 / Math.PI);
	    }
	    public static double convertToMeter(double km) {
		      return km*1000;
		    }

}
