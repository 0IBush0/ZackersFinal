import com.phidget22.*;

public class attachdetach2
{
	static boolean turnRedLEDOn = false;
   
	public static void main(String[] args) throws Exception 
    {
        //Create
    	TemperatureSensor temperatureSensor = new TemperatureSensor();
        DigitalInput redButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();

        //Address
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        //Data Event | Event code runs when data from sensor changes. 
        temperatureSensor.addTemperatureChangeListener(new TemperatureSensorTemperatureChangeListener() 
        {
            public void onTemperatureChange(TemperatureSensorTemperatureChangeEvent e) 
            {
                //Print temperature
                System.out.println("Temperature: " + e.getTemperature() + "°C");
                
            }
        });
  

        //Attach Event | Attach Events run when a Phidget is connected to the Object
        temperatureSensor.addAttachListener(new AttachListener() 
        {
            public void onAttach(AttachEvent e) 
            {
                System.out.println("Attach!");
                //print attach
            }
        });

        //Detach Event | Detach Events run when a Phidget is disconnected from the Object
        temperatureSensor.addDetachListener(new DetachListener() 
        {
            public void onDetach(DetachEvent e) 
            {
                System.out.println("Detach!");
               //print detach
            }
        });
        
        redLED.addAttachListener(new AttachListener() 
        {
            public void onAttach(AttachEvent e) 
            {
                System.out.println("Attach!");
               //print detach
            }
        });

        //Detach Event | Detach Events run when a Phidget is disconnected from the Object
        redLED.addDetachListener(new DetachListener() 
        {
            public void onDetach(DetachEvent e) 
            {
                System.out.println("Detach!");
                //print detach
            }
        });
        
        redButton.addAttachListener(new AttachListener() 
        {
            public void onAttach(AttachEvent e) 
            {
                System.out.println("Attach!");
               //print detach
            }
        });

        //Detach Event | Detach Events run when a Phidget is disconnected from the Object
        redButton.addDetachListener(new DetachListener() 
        {
            public void onDetach(DetachEvent e) 
            {
                System.out.println("Detach!");
                //print detach
            }
        });

        //Open
        temperatureSensor.open(1000);
        redLED.open(1000);

        while (true) 
        {
        	Thread.sleep(150);
        	//time
        }
        
    }
}