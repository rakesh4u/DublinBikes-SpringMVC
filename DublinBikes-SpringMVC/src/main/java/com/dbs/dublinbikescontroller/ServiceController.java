package com.dbs.dublinbikescontroller;

import org.json.JSONArray;

import com.dbs.dublinbikes.CallHttpAPIService;
import com.dbs.dublinbikes.DBConnect;
import com.dbs.dublinbikes.Utils;

public class ServiceController {
	
	DBConnect dbConnection=new DBConnect();

	public void callhttpservice(){
		
		CallHttpAPIService callHttpAPIService=new CallHttpAPIService();
		String sourceLatitude=null;
		String sourceLongitude=null;
		
		JSONArray output=callHttpAPIService.getBikeDeatils(sourceLatitude,sourceLongitude);
		System.out.println("JSON Response from the API is ::()"+output);
		for(int i=0;i<output.length();i++){
			
			String number=output.getJSONObject(i).get("number")+"";
			String name=output.getJSONObject(i).get("name")+"";
			String lat=output.getJSONObject(i).getJSONObject("position").get("lat")+"";
			String lng=output.getJSONObject(i).getJSONObject("position").get("lng")+"";
			String bikeStands=output.getJSONObject(i).get("bike_stands")+"";
			String availableBikestands=output.getJSONObject(i).get("available_bike_stands")+"";
			String availableBikes=output.getJSONObject(i).get("available_bikes")+"";
			
		
			double kms=Utils.distance(Double.parseDouble("53.349562"),Double.parseDouble("-6.278198"),Double.parseDouble(lat),Double.parseDouble(lng));
			double meters=Utils.convertToMeter(kms);
			if(meters<=500&&meters!=0){
				System.out.println("Distance in Meter is::"+meters);
				String stationName=output.getJSONObject(i).get("name")+"";
				dbConnection.insertRecord(number, name, lat, lng, bikeStands, availableBikestands, availableBikes,meters);
				System.out.println(stationName);
			}
					
		}
	}
}
