import com.phidget22.*;

public class datainterval
{
    //Handle Exceptions
    public static void main(String[] args) throws Exception 
    {

        //Create
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        //Temperature Event |  Event code runs when data input from the sensor changes. The following event is a Temperature change event. The contained code will only run when the temperature input changes.
        temperatureSensor.addTemperatureChangeListener(new TemperatureSensorTemperatureChangeListener() {
            public void onTemperatureChange(TemperatureSensorTemperatureChangeEvent e) {
                System.out.println("Temperature: " + e.getTemperature());
                //print temperature
            }
        });

        //Open
        temperatureSensor.open(5000);

        //Set Data Interval | The Data Interval controls how often the program collects data from your Phidget. The Data Interval ranges from 500 ms - 60000 ms.
        temperatureSensor.setDataInterval(500);
        //set interval

        while (true) 
        {
            Thread.sleep(150);
            //time
        }
    }
}