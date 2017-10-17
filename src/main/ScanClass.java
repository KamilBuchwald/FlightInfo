package main;



import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class ScanClass {
	
	public String IsFlight() throws Exception {
		
		boolean incomings = false;
		boolean outgoings = false;
		int ver = 0;
		String[] incoming = null;
		String[] outgoing = null;
		int[] altitude = null;
		int s=0 ;
		
		
		GetRawInfo raw = new  GetRawInfo();
		String jObject = raw.RAW();
		JSONObject tkn = (JSONObject) new JSONTokener(jObject).nextValue();
		

			JSONArray qw = (JSONArray) tkn.get("acList");
			s = qw.length();
			 
			for(int a=0; a<s; a++) {
					
				incoming = new String[s];
				outgoing = new String[s];
				altitude = new int[s];
				JSONObject jsob1 = qw.getJSONObject(a);
				
				incoming[a] = jsob1.optString("To");
				outgoing[a] = jsob1.optString("From");
				altitude[a] = jsob1.getInt("Alt");
				ver = getMax(altitude);
				
				
				
				String value = "EPPO Poznań-Ławica, Poznań, Poland";
				if(incoming[a].equals(value)) {
					 incomings=true;
				 }
				else {
					incomings=false;
				}
				if(outgoing[a].equals(value)) {
					 outgoings=true;
				 }
				else {
					outgoings=false;
				}
				if(incomings==true || outgoings==true) {
					ver=getMin(altitude);					
				}
				else {
					ver = getMax(altitude);
				}
				if(incomings ==true) {
					ver = getSecound(altitude);
				}
			}
			
			
			RadarClass.Radar(s);
			RadarClass.Arrivals(incomings);
			RadarClass.Outgoings(outgoings);
			RadarClass.Spoted(incomings,outgoings,s);
			RadarClass.Altitude(ver);
		
			
		
			
			String res = "A-D-Altitude-Radar"+" "+s+" "+ver;
			return res;
					
		
	

	//return res+" "+outgoings+" "+" "+incomings+"  "+ver+"  "+s;
		
		
	}

	public static int getMax(int[] inputArray){ 
	    int maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
	
	public static int getMin(int[] inputArray){ 
	    int minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	}
	
	
	public static int getSecound(int[] inputArray){ 
	    int SecValue = inputArray[1]; 
	    for(int i=2;i<inputArray.length;i++){ 
	      if(inputArray[i] < SecValue){ 
	        SecValue = inputArray[i]; 
	      } 
	    } 
	    return SecValue; 
	}
	

	

}
	


