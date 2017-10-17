package main;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class RadarClass {
	
	public static void Radar(int r) throws InterruptedException {
		GpioController gpioController = GpioFactory.getInstance();
		GpioPinDigitalOutput pinOut_15 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_15);
		GpioPinDigitalOutput pinOut_16 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_16);
		if(r>0) {
			
		
			pinOut_15.pulse(2000,true);
			pinOut_16.high();
			gpioController.shutdown();
			
			gpioController.unprovisionPin(pinOut_15);
			gpioController.unprovisionPin(pinOut_16);
			
		
			}else {
				pinOut_16.pulse(1000,true);
			
				pinOut_15.high();
				
				gpioController.shutdown();
				
				gpioController.unprovisionPin(pinOut_15);
				gpioController.unprovisionPin(pinOut_16);
			}
	
	}
	
	public static void Arrivals(boolean ari) {
		
		GpioController gpioController = GpioFactory.getInstance();
		GpioPinDigitalOutput pinOut_08 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_08);
		if(ari==true) {
			pinOut_08.low();
		}else {
			pinOut_08.high();
		}
		
		gpioController.shutdown();
		
		gpioController.unprovisionPin(pinOut_08);
		
		
	}
	
public static void Outgoings(boolean ari) {
		
		GpioController gpioController = GpioFactory.getInstance();
		GpioPinDigitalOutput pinOut_09 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_09);
		if(ari==true) {
			pinOut_09.low();
		}else {
			pinOut_09.high();
		}
		
		gpioController.shutdown();
		
		gpioController.unprovisionPin(pinOut_09);
		
		
	}

public static void Spoted(boolean ari, boolean out, int s) {
	
	GpioController gpioController = GpioFactory.getInstance();
	GpioPinDigitalOutput pinOut_07 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07);
	if(ari==false && out==false && s>0) {
		pinOut_07.low();
	}else {
		pinOut_07.high();
	}
	gpioController.shutdown();
	
	gpioController.unprovisionPin(pinOut_07);
	

}

public static void Altitude(int v) {
	
	GpioController gpioController = GpioFactory.getInstance();
	GpioPinDigitalOutput pinOut_00 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00);
	GpioPinDigitalOutput pinOut_02 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02);
	GpioPinDigitalOutput pinOut_03 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03);
	GpioPinDigitalOutput pinOut_12 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_12);
	GpioPinDigitalOutput pinOut_13 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_13);
	GpioPinDigitalOutput pinOut_14 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_14);
	
	
	
	/*if(v>=8000) {
		pinOut_02 .low();
	}else if(v<=6000 && v>4000) {
		pinOut_00.low();
	}else if(v<=4000 && v>3000) {
		pinOut_03.low();
	}else if(v<=3000 && v>2000){
		pinOut_12.low();
	}else if(v<=2000 && v>1000){
		pinOut_13.low();
	}else if(v<=1000){
		pinOut_14.low();
	}else if(v==0){
		pinOut_00.high();
		pinOut_02.high();
		pinOut_03.high();
		pinOut_12.high();
		pinOut_13.high();
		pinOut_14.high();
	}
	*/
	pinOut_00.high();
	pinOut_02.high();
	pinOut_03.high();
	pinOut_12.high();
	pinOut_13.high();
	pinOut_14.high();
	
	
	if(v>8000) {
		pinOut_00.low();
	}else if(v<=7999 && v>=6000) {
		pinOut_02.low();
	}else if(v<=5999 && v>=4000) {
		pinOut_03.low();
	}else if(v<=3999 && v>=3000) {
		pinOut_12.low();
	}else if(v<=2999 && v>=2000) {
		pinOut_13.low();
	}else if(v<=1999 && v>=100) {
		pinOut_14.low();
	}
	gpioController.shutdown();
	
	gpioController.unprovisionPin(pinOut_00);
	gpioController.unprovisionPin(pinOut_02);
	gpioController.unprovisionPin(pinOut_03);
	gpioController.unprovisionPin(pinOut_12);
	gpioController.unprovisionPin(pinOut_13);
	gpioController.unprovisionPin(pinOut_14);
}
	

	
	
}
