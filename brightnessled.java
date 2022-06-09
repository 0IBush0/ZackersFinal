import com.phidget22.*;

public class brightnessled {

	public static void main(String[] args) throws Exception{

	        //Create 
	        DigitalOutput redLED = new DigitalOutput();

	        //Address 
	        redLED.setHubPort(1);
	        redLED.setIsHubPortDevice(true);

	        //Open 
	        redLED.open(1000);

	        //Use your Phidgets with Duty Cycle 
	        redLED.setDutyCycle(1);//change value to change brightness
	        Thread.sleep(1000);
	        redLED.setDutyCycle(0.0);
	        
	}

}