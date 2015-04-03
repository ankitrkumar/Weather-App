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
import kumarankit.nikeweathertest.model.CurrentWeather;
import kumarankit.nikeweathertest.weatherinfo.WeatherFetch;


/**
 * Created by Ankit on 4/1/2015.
 * Current Weather fragment
 */
public class FragmentCurrent extends Fragment {
    private TextView tvCurrentTemp;
    private TextView tvCurrentTempUnit;
    private TextView tvCurrentWeatherText;
    private TextView tvCurrentHumidity;
    private TextView tvCurrentPressure;
    private TextView tvCurrentWind;
    private ImageView ivCurrentWeatherImage;
    CurrentWeather currentWeather;
    public FragmentCurrent()
    {
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =inflater.inflate(R.layout.fragment_current,container,false);

        tvCurrentTemp = (TextView)rootView.findViewById(R.id.currentTemp);
        tvCurrentTempUnit = (TextView)rootView.findViewById(R.id.currentTempUnit);
        tvCurrentHumidity = (TextView)rootView.findViewById(R.id.currentHumidity);
        tvCurrentWind = (TextView)rootView.findViewById(R.id.currentWind);
        tvCurrentWeatherText = (TextView)rootView.findViewById(R.id.currentWeatherText);
        tvCurrentPressure = (TextView)rootView.findViewById(R.id.currentPressure);
        ivCurrentWeatherImage = (ImageView)rootView.findViewById(R.id.currentWeatherImage);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateView();
    }

    private void updateView(){

        currentWeather = WeatherFetch.weather.getCurrentWeather();

        if(currentWeather!=null) {
            StringBuilder tempSb = new StringBuilder();
            tempSb.append(Integer.toString(currentWeather.getTemp()));
            tempSb.append('\u00B0');
            tempSb.append("");
            tvCurrentTemp.setText(tempSb.toString());
            tvCurrentTempUnit.setText(currentWeather.getTempUnit());
            tvCurrentWeatherText.setText(currentWeather.getWeatherText());
            StringBuilder windSb = new StringBuilder();
            windSb.append(Integer.toString(currentWeather.getWindSpeed()));
            windSb.append(" ");
            windSb.append(currentWeather.getWindUnit());
            windSb.append(" ");
            windSb.append(currentWeather.getWindDirection());
            tvCurrentWind.setText(windSb.toString());
            tvCurrentHumidity.setText(Integer.toString(currentWeather.getHumidity()) + "%");
            tvCurrentPressure.setText(Integer.toString(currentWeather.getPressure()) + "mb");
            ImageHelper.WeatherImage weatherImage = ImageHelper.imageHelper.getWeatherImage(currentWeather.getWeatherCode());
            ivCurrentWeatherImage.setImageResource(weatherImage.dayIcon);
        }
        }
}
