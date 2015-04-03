package kumarankit.nikeweathertest.weatherget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import kumarankit.nikeweathertest.weatherinfo.WeatherFetch;

/**
 * Created by Ankit on 4/2/2015.
 * AlarmReceiver to invoke AsyncTask to fetch weather data
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        WeatherFetch.weather = new Weather(context);
    }
}
