package com.dbs.dbikes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

public class CallHttpService {
	
	public string getBikeDeatils(){
		String output;

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			//calling JCDecaux API with KEY
			HttpGet getRequest = new HttpGet(
					"https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=224f0a5503a4603d78371d84426426bf923e79e4");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
				JSONArray data=new JSONArray(output);
				System.out.println(data.getJSONObject(0));
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			output="Exception";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			output="Exception";
			e.printStackTrace();
		}

		return output;

	}
}
