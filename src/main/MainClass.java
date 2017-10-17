package main;


public class MainClass {
	
	
	public static void main(String[] args) throws Exception{
		
		ScanClass IsF = new ScanClass();
		String Info = "";
		long t= System.currentTimeMillis();
		long end = t+3000;
		while(t < end) {

		
			Info = IsF.IsFlight();
			System.out.println(Info);
			
			Thread.sleep(5000);
			
		
			
		}

	}
}
