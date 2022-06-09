import com.phidget22.*;

public class hotorcold
{
	public static void main(String[] args) throws Exception
	{

        //Create | Here you've created a HumiditySensor and a TemperatureSensor object for your Humidity Phidget. This allows you to access both temperature and humidity data from your Phidget.
        HumiditySensor humiditySensor = new HumiditySensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        DigitalOutput redLED = new DigitalOutput();
	    DigitalOutput greenLED = new DigitalOutput();
        
	    redLED.setHubPort(1);
	    redLED.setIsHubPortDevice(true);
	    greenLED.setHubPort(4);
	    greenLED.setIsHubPortDevice(true);
	    
	    //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000 to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception occur.
        humiditySensor.open(1000);
        temperatureSensor.open(1000);

	    redLED.open(1000);
	    greenLED.open(1000);
	    
        //Use your Phidgets | This code will print humidity and temperature read by the sensor every 150ms.
        while(true)
        {
        	if(temperatureSensor.getTemperature() > 20 && temperatureSensor.getTemperature() < 24)//check for temperature within range
        	{
        		System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C" );
        		//print temperature
        		Thread.sleep(1000);
        		redLED.setState(false);
        		Thread.sleep(1000);
        		greenLED.setState(true);
        		//greenled turn on
        		Thread.sleep(1000);

        	}
        	else
        	{
        		
        		System.out.println("Temperature: " + temperatureSensor.getTemperature() + " °C");
        		//print temperature
        		Thread.sleep(1000);
        		greenLED.setState(false);
        		Thread.sleep(1000);
        		redLED.setState(true);
        		//redled turn on
        		Thread.sleep(1000);
        		
        	}
        	
        }
	}
	
}