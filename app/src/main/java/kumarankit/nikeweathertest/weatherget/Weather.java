package kumarankit.nikeweathertest.weatherget;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

import kumarankit.nikeweathertest.model.CurrentWeather;
import kumarankit.nikeweathertest.model.ForecastWeather;

/**
 * Created by Ankit on 4/2/2015.
 */
public class Weather {
    private static final String JSON_WEATHER = "weather";
    private static final String JSON_WIND = "wind";
    private static final String JSON_WIND_SPEED = "speed";
    private static final String JSON_WIND_DIR = "dir";
    private static final String JSON_WIND_UNIT = "wind_unit";
    private static final String JSON_WEATHER_TEXT = "weather_text";
    private static final String JSON_CURRENT_WEATHER = "curren_weather";
    private static final String JSON_CURRENT_TEMP = "temp";
    private static final String JSON_TEMPUNIT = "temp_unit";
    private static final String JSON_CURRENT_HUMIDITY = "humidity";
    private static final String JSON_CURRENT_PRESSURE = "pressure";
    private static final String JSON_FORECAST = "forecast";
    private static final String JSON_FORECAST_DATE = "date";
    private static final String JSON_FORECAST_DAYMAXTEMP = "day_max_temp";
    private static final String JSON_FORECAST_NIGHTMINTEMP = "night_min_temp";
    private static final String JSON_FORECAST_DAY = "day";
    private static final String JSON_FORECAST_NIGHT = "night";
    private static final String JSON_WEATHERCODE = "weather_code";

    private String mJson; // last successful json value retrieved from myweather2.com server

    public CurrentWeather getCurrentWeather() {
        return mCurrentWeather;
    }

    public ForecastWeather getForecastWeather() {
        return mForecastWeather;
    }
    //private Date mLastUpdated; // date value for last successful weather update from myweather2.com server
    private CurrentWeather mCurrentWeather; // single instance of CurrentWeather
    private ForecastWeather mForecastWeather;

    public Weather(Context context)
    {
        try {
            mJson=new WeatherAsyncTask(context).execute().get();//Execute the AsyncTask
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        getJSONdata();

    }
    private void getJSONdata()//deserialze json
    {
        try {
            JSONObject jsonObject = new JSONObject(mJson);
            JSONObject weatherJsonObject = jsonObject.getJSONObject(JSON_WEATHER);

            //current weather
            JSONObject currentJsonObject = (JSONObject) weatherJsonObject.getJSONArray(JSON_CURRENT_WEATHER).get(0);
            mCurrentWeather = new CurrentWeather();
            mCurrentWeather.setTemp(currentJsonObject.getInt(JSON_CURRENT_TEMP));
            mCurrentWeather.setTempUnit(currentJsonObject.getString(JSON_TEMPUNIT));
            mCurrentWeather.setHumidity(currentJsonObject.getInt(JSON_CURRENT_HUMIDITY));
            mCurrentWeather.setPressure(currentJsonObject.getInt(JSON_CURRENT_PRESSURE));
            JSONObject currentWindJsonObject = (JSONObject) currentJsonObject.getJSONArray(JSON_WIND).get(0);
            mCurrentWeather.setWindSpeed(currentWindJsonObject.getInt(JSON_WIND_SPEED));
            String currentWindDirection = currentWindJsonObject.getString(JSON_WIND_DIR);
            if(!currentWindDirection.equalsIgnoreCase("Not Available")){
                mCurrentWeather.setWindDirection(currentWindDirection);
            }
            else{
                mCurrentWeather.setWindDirection("");
            }
            mCurrentWeather.setWindUnit(currentWindJsonObject.getString(JSON_WIND_UNIT));
            mCurrentWeather.setWeatherText(currentJsonObject.getString(JSON_WEATHER_TEXT));
            mCurrentWeather.setWeatherCode(currentJsonObject.getInt(JSON_WEATHERCODE));

            //forecast weather
            JSONArray forecastJsonArray = weatherJsonObject.getJSONArray(JSON_FORECAST);
            JSONObject forecastJsonObject = forecastJsonArray.getJSONObject(1);
            mForecastWeather = new ForecastWeather();
            mForecastWeather.setDateString(forecastJsonObject.getString(JSON_FORECAST_DATE));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            mForecastWeather.setDate(sdf.parse(mForecastWeather.getDateString()));
            mForecastWeather.setDayMaxTemp(forecastJsonObject.getInt(JSON_FORECAST_DAYMAXTEMP));
            mForecastWeather.setNightMinTemp(forecastJsonObject.getInt(JSON_FORECAST_NIGHTMINTEMP));
            mForecastWeather.setTempUnit(forecastJsonObject.getString(JSON_TEMPUNIT));
            JSONObject forecastDayJsonObject = (JSONObject) forecastJsonObject.getJSONArray(JSON_FORECAST_DAY).get(0);
            JSONObject forecastDayWindJsonObject = (JSONObject) forecastDayJsonObject.getJSONArray(JSON_WIND).get(0);
            mForecastWeather.setDayWindSpeed(forecastDayWindJsonObject.getInt(JSON_WIND_SPEED));
            String forecastDayWindDirection = forecastDayWindJsonObject.getString(JSON_WIND_DIR);
            if(!forecastDayWindDirection.equalsIgnoreCase("Not Available")){
                mForecastWeather.setDayWindDirection(forecastDayWindDirection);
            }
            else{
                mForecastWeather.setDayWindDirection("");
            }
            mForecastWeather.setDayWindUnit(forecastDayWindJsonObject.getString(JSON_WIND_UNIT));
            mForecastWeather.setDayWeatherCode(forecastDayJsonObject.getInt(JSON_WEATHERCODE));
            mForecastWeather.setDayWeatherText(forecastDayJsonObject.getString(JSON_WEATHER_TEXT));
            JSONObject forecastNightJsonObject = (JSONObject) forecastJsonObject.getJSONArray(JSON_FORECAST_NIGHT).get(0);
            JSONObject forecastNightWindJsonObject = (JSONObject) forecastNightJsonObject.getJSONArray(JSON_WIND).get(0);
            mForecastWeather.setNightWindSpeed(forecastNightWindJsonObject.getInt(JSON_WIND_SPEED));
            String forecastNightWindDirection = forecastNightWindJsonObject.getString(JSON_WIND_DIR);
            if(!forecastNightWindDirection.equalsIgnoreCase("Not Available")){
                mForecastWeather.setNightWindDirection(forecastNightWindDirection);
            }
            else{
                mForecastWeather.setNightWindDirection("");
            }
            mForecastWeather.setNightWindUnit(forecastNightWindJsonObject.getString(JSON_WIND_UNIT));
            mForecastWeather.setNightWeatherCode(forecastNightJsonObject.getInt(JSON_WEATHERCODE));
            mForecastWeather.setNightWeatherText(forecastNightJsonObject.getString(JSON_WEATHER_TEXT));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}