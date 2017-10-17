package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GetRawInfo {
	
	public String RAW() throws Exception {
		String url = "https://public-api.adsbexchange.com/VirtualRadar/AircraftList.json?lat=52.3967476&lng=16.926047700000026&fDstL=0&fDstU=15";
		String USER_AGENT = "Mozilla/5.0";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
	
		String jObject = response.toString();

	
		


		return jObject;
		
	}
	
	

}
