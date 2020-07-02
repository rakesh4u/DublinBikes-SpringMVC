package com.dbs.dublinbikes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;


public class CallHttpAPIService {
	
	public JSONArray getBikeDeatils(String latitude,String longitude){
		String output;
		JSONArray data=null;
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			//calling JCDecaux API with KEY
			HttpGet getRequest = new HttpGet("https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=224f0a5503a4603d78371d84426426bf923e79e4");
			getRequest.addHeader("accept", "application/json");

			//Executing the HTTPRequest 
			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				output="Error"+response.getStatusLine().getStatusCode();
				System.out.println("Failed to get Response from service:"+ response.getStatusLine().getStatusCode());
			}

			//Reading Response using BufferReader
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			while ((output = br.readLine()) != null) {
				System.out.println("Response from JSON::"+output);
				data=new JSONArray(output);
				System.out.println(data);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			output="Exception";
		} catch (IOException e) {
			output="Exception";
		}

		return data;

	}
}
