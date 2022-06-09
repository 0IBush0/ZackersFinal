import com.phidget22.*;

public class buttonledevent2
{
    //Turn on/off LEDs with Global Variables
    static boolean turnRedLEDOn = false;
    static boolean turnGreenLEDOn = false;

    //Handle Exceptions
    public static void main(String[] args) throws Exception 
    {

        //Create
        DigitalInput redButton = new DigitalInput();
        DigitalInput greenButton = new DigitalInput();
        DigitalOutput redLED = new DigitalOutput();
        DigitalOutput greenLED = new DigitalOutput();

        //Address
        redButton.setHubPort(0);
        redButton.setIsHubPortDevice(true);
        greenButton.setHubPort(5);
        greenButton.setIsHubPortDevice(true);
        redLED.setHubPort(1);
        redLED.setIsHubPortDevice(true);
        greenLED.setHubPort(4);
        greenLED.setIsHubPortDevice(true);

        int redbuttonPress = 0;
        int greenbuttonPress = 0;
        //Event | Event code runs when data input from the sensor changes. The following event is a state change event. The code will listen to the button (Digital Input Object) and only run the contain code when the button is pressed or released (state changes).
        redButton.addStateChangeListener(new DigitalInputStateChangeListener() 
        {
            public void onStateChange(DigitalInputStateChangeEvent e) 
            {
                //Record button state to turn on/off the red LED
                turnRedLEDOn = e.getState(); 
                //redled
            }
        });

        //Event | Event code runs when data input from the sensor changes. The following event is a state change event. It will listen to the button (Digital Input Object) and only run the contain code when the button is pressed or released (state changes).
        greenButton.addStateChangeListener(new DigitalInputStateChangeListener() 
        {
            public void onStateChange(DigitalInputStateChangeEvent e) 
            {
                //Record button state to turn on/off the green LED
                turnGreenLEDOn = e.getState();
                //greenled
            }
        });

        //Open
        redLED.open(1000);
        greenLED.open(1000);
        redButton.open(1000);
        greenButton.open(1000);

        //Use your Phidgets | In the button events you recorded the Button State. Here we will use that data to turn on/off the LEDs
        while(true) 
        {
            //turn red LED on based on red button input
            redLED.setState(turnRedLEDOn);
            //turn green LED on based on green button input
            greenLED.setState(turnGreenLEDOn);
            //sleep for 150 milliseconds 
            if(redButton.getState())
            {
            	redbuttonPress++;
            	System.out.println("Red button pressed: " + redbuttonPress + " times");
            	//count time
            }
            if(greenButton.getState())
            {
            	greenbuttonPress++;
            	System.out.println("Green button pressed: " + greenbuttonPress + " times");
            	//count time
            }
            Thread.sleep(150);
        }
    }
    
}