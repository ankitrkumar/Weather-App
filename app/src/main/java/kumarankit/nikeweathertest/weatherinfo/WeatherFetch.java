package kumarankit.nikeweathertest.weatherinfo;

import android.content.Context;

import kumarankit.nikeweathertest.MainActivity;
import kumarankit.nikeweathertest.weatherget.Weather;

/**
 * Created by Ankit on 4/2/2015.
 */
public class WeatherFetch {
    public static Context context= MainActivity.getContext();
    public static Weather weather = new Weather(context);   //To have the weather object accessible across classes
}
