import com.phidget22.*;

public class GettingStarted5 {
    public static void main(String[] args) throws Exception{

        //Create | Here you've created a HumiditySensor and a TemperatureSensor object for your Humidity Phidget. This allows you to access both temperature and humidity data from your Phidget.
        HumiditySensor humiditySensor = new HumiditySensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        //Open | Open establishes a connection between your object and your physical Phidget. You provide a timeout value of 1000 to give the program 1000 milliseconds (1 second) to locate your Phidget. If your Phidget can't be found, an exception occur.
        humiditySensor.open(1000);
        temperatureSensor.open(1000);

        //Use your Phidgets | This code will print humidity and temperature read by the sensor every 150ms.
        while(true){
        	if(humiditySensor.getHumidity() > 30)//check if humidity is above 30
        	{
        		System.out.println("Humidity: " + humiditySensor.getHumidity() + 
        				"% RH, Temperature: " + temperatureSensor.getTemperature() + " °C" );
        		Thread.sleep(1000);
        		//print humidity if is above 30
        	}
        	else 
        	{
        		System.out.println("Humidity is low, Temperature: " 
        				+ temperatureSensor.getTemperature() + " °C" );
        		Thread.sleep(1000);
        		//if under, then print low message
        	}
        	
        }
    }
}