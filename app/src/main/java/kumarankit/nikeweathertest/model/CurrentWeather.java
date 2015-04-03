package kumarankit.nikeweathertest.model;

/**
 * Created by Ankit on 4/1/2015.
 * CurrentWeather
 */
public class CurrentWeather {
    private int mTemp;
    private String mTempUnit;
    private int mWindSpeed;
    private String mWindUnit;
    private String mWindDirection;
    private int mHumidity;
    private int mPressure;
    private String mWeatherText;
    private int mWeatherCode;

    public String getWindDirection() {
        return mWindDirection;
    }

    public void setWindDirection(String mWindDirection) {
        this.mWindDirection = mWindDirection;
    }

    public int getTemp() {
        return mTemp;
    }

    public void setTemp(int mTemp) {
        this.mTemp = mTemp;
    }

    public String getTempUnit() {
        return mTempUnit;
    }

    public void setTempUnit(String mTempUnit) {
        this.mTempUnit = mTempUnit;
    }

    public int getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(int mWindSpeed) {
        this.mWindSpeed = mWindSpeed;
    }

    public String getWindUnit() {
        return mWindUnit;
    }

    public void setWindUnit(String mWindUnit) {
        this.mWindUnit = mWindUnit;
    }

    public int getHumidity() {
        return mHumidity;
    }

    public void setHumidity(int mHumidity) {
        this.mHumidity = mHumidity;
    }

    public int getPressure() {
        return mPressure;
    }

    public void setPressure(int mPressure) {
        this.mPressure = mPressure;
    }

    public String getWeatherText() {
        return mWeatherText;
    }

    public void setWeatherText(String mWeatherText) {
        this.mWeatherText = mWeatherText;
    }

    public int getWeatherCode() {
        return mWeatherCode;
    }

    public void setWeatherCode(int mWeatherCode) {
        this.mWeatherCode = mWeatherCode;
    }
}
