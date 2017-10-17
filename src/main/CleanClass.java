package main;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class CleanClass {
	
	public static void Clean() {
		GpioController gpioController = GpioFactory.getInstance();
		GpioPinDigitalOutput pinOut_00 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		GpioPinDigitalOutput pinOut_02 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02);
		GpioPinDigitalOutput pinOut_03 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03);
		GpioPinDigitalOutput pinOut_12 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_12);
		GpioPinDigitalOutput pinOut_13 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_13);
		GpioPinDigitalOutput pinOut_14 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_14);
		GpioPinDigitalOutput pinOut_07 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07);
		GpioPinDigitalOutput pinOut_09 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_09);
		GpioPinDigitalOutput pinOut_08 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_08);
		GpioPinDigitalOutput pinOut_15 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_15);
		GpioPinDigitalOutput pinOut_16 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_16);
		
		
		pinOut_00.high();
		pinOut_02.high();
		pinOut_03.high();
		pinOut_12.high();
		pinOut_13.high();
		pinOut_14.high();
		pinOut_07.high();
		pinOut_09.high();
		pinOut_08.high();
		pinOut_15.high();
		pinOut_16.high();
		
	}

}
