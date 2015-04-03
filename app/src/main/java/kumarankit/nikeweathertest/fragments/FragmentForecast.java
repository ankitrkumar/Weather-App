package kumarankit.nikeweathertest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kumarankit.nikeweathertest.R;
import kumarankit.nikeweathertest.helper.ImageHelper;
import kumarankit.nikeweathertest.model.ForecastWeather;
import kumarankit.nikeweathertest.weatherinfo.WeatherFetch;

/**
 * Created by Ankit on 4/1/2015.
 * Forecast Weather fragment
 *
 */
public class FragmentForecast extends Fragment{

    private TextView tvForecastDayTemp;
    private TextView tvForecastNightTemp;

    private TextView tvForecastDayWeatherText;
    private TextView tvForecastNightWeatherText;

    private TextView tvForecastDayWind;
    private TextView tvForecastNightWind;

    private ImageView ivForecastDayImage;
    private ImageView ivForecastNightImage;

    ForecastWeather forecastWeather;

    public FragmentForecast()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);

        tvForecastDayTemp = (TextView)rootView.findViewById(R.id.forecastDayTemp);
        tvForecastNightTemp = (TextView) rootView.findViewById(R.id.forecastNightTemp);
        tvForecastDayWind = (TextView)rootView.findViewById(R.id.forecastDayWind);
        tvForecastNightWind = (TextView)rootView.findViewById(R.id.forecastNightWind);
        tvForecastDayWeatherText = (TextView)rootView.findViewById(R.id.forecastDayWeatherText);
        tvForecastNightWeatherText = (TextView)rootView.findViewById(R.id.forecastNightWeatherText);
        ivForecastDayImage = (ImageView)rootView.findViewById(R.id.forecastDayImage);
        ivForecastNightImage = (ImageView)rootView.findViewById(R.id.forecastNightImage);

        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateView();
    }

    private void updateView(){

        forecastWeather = WeatherFetch.weather.getForecastWeather();
        if(forecastWeather!=null) {

            StringBuilder tempSb = new StringBuilder();
            tempSb.append(Integer.toString(forecastWeather.getDayMaxTemp()));
            tempSb.append('\u00B0');
            tempSb.append("");
            tvForecastDayTemp.setText(tempSb.toString());
            StringBuilder tempnSb = new StringBuilder();
            tempnSb.append(Integer.toString(forecastWeather.getNightMinTemp()));
            tempnSb.append('\u00B0');
            tempnSb.append("");
            tvForecastNightTemp.setText(tempnSb.toString());

            tvForecastDayWeatherText.setText(forecastWeather.getDayWeatherText());
            tvForecastNightWeatherText.setText(forecastWeather.getNightWeatherText());

            StringBuilder windSb = new StringBuilder();
            windSb.append(Integer.toString(forecastWeather.getDayWindSpeed()));
            windSb.append(" ");
            windSb.append(forecastWeather.getDayWindUnit());
            windSb.append(" ");
            windSb.append(forecastWeather.getDayWindDirection());
            tvForecastDayWind.setText(windSb.toString());
            StringBuilder windnSb = new StringBuilder();
            windnSb.append(Integer.toString(forecastWeather.getNightWindSpeed()));
            windnSb.append(" ");
            windnSb.append(forecastWeather.getNightWindUnit());
            windnSb.append(" ");
            windnSb.append(forecastWeather.getNightWindDirection());
            tvForecastNightWind.setText(windnSb.toString());

            ImageHelper.WeatherImage weatherImage = ImageHelper.imageHelper.getWeatherImage(forecastWeather.getDayWeatherCode());
            ivForecastDayImage.setImageResource(weatherImage.dayIcon);
            weatherImage = ImageHelper.imageHelper.getWeatherImage(forecastWeather.getNightWeatherCode());
            ivForecastNightImage.setImageResource(weatherImage.nightIcon);
        }
    }
}
