import com.phidget22.*;

public class tugofwar
{
	//Handle Exceptions | Exceptions will happen in your code from time to time. These are caused by unexpected things happening. Make sure you’ve added "throws Exception" to your main method.
	public static void main(String[] args) throws Exception
	{
		//Create | Create objects for your buttons and LEDs.
		DigitalInput redButton = new DigitalInput();
		DigitalOutput redLED = new DigitalOutput();
		DigitalInput greenButton = new DigitalInput();
		DigitalOutput greenLED = new DigitalOutput();

		//Address | Address your four objects which lets your program know where to find them.
		redButton.setHubPort(0);
		redButton.setIsHubPortDevice(true);
		redLED.setHubPort(1);
		redLED.setIsHubPortDevice(true);
		greenButton.setHubPort(5);
		greenButton.setIsHubPortDevice(true);
		greenLED.setHubPort(4);
		greenLED.setIsHubPortDevice(true);

		//Open | Connect your program to your physical devices.
		redButton.open(1000);
		redLED.open(1000);
		greenButton.open(1000);
		greenLED.open(1000);
   
		int redCount = 0;
		int greenCount = 0;
		boolean redPlayer = false;
		boolean greenPlayer = false;
		//declare variables
		//Use your Phidgets | This code will turn on the LED when the matching button is pressed and turns off the LED when the matching button is released. The sleep function slows down the loop so the button state is only checked every 150ms.
		while(true)
		{

			if(redButton.getState() && !redPlayer)
			{
				redLED.setState(true);
				redCount++;
   
			}
			else if(!redButton.getState() && redPlayer)
			{
				redLED.setState(false);
   
			}

			if(greenButton.getState()&& !greenPlayer)
			{
				greenLED.setState(true);
				greenCount++;
   
			}
			else if(!greenButton.getState()&& greenPlayer)
			{
				greenLED.setState(false);
   
			}
				greenPlayer = greenButton.getState();
				redPlayer =redButton.getState();

				Thread.sleep(150);

			if(redCount == 10)//Check button count
			{
				while(redCount > 5)
				{
					redLED.setState(true);
					Thread.sleep(500);
					redLED.setState(false);
					Thread.sleep(500);
					redCount--;
   
				}
			}
			else if(greenCount == 10)//Check button count
			{
				while(greenCount > 5)
				{
					greenLED.setState(true);
					Thread.sleep(500);
					greenLED.setState(false);
					Thread.sleep(500);
					greenCount--;
   
				}
				
			}
		}  
	}
	
}
