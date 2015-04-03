package kumarankit.nikeweathertest.model;

import java.util.Date;

/**
 * Created by Ankit on 4/1/2015.
 * ForecastWeather
 */
public class ForecastWeather {
    private String mDateString;
    private Date mDate;
    private int mDayMaxTemp;
    private int mNightMinTemp;
    private String mTempUnit;
    private int mDayWindSpeed;
    private String mDayWindDirection;
    private String mDayWindUnit;
    private int mDayWeatherCode;
    private String mDayWeatherText;
    private int mNightWindSpeed;
    private String mNightWindDirection;
    private String mNightWindUnit;
    private int mNightWeatherCode;
    private String mNightWeatherText;

    public String getDateString() {
        return mDateString;
    }

    public void setDateString(String mDateString) {
        this.mDateString = mDateString;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getDayMaxTemp() {
        return mDayMaxTemp;
    }

    public void setDayMaxTemp(int mDayMaxTemp) {
        this.mDayMaxTemp = mDayMaxTemp;
    }

    public int getNightMinTemp() {
        return mNightMinTemp;
    }

    public void setNightMinTemp(int mNightMinTemp) {
        this.mNightMinTemp = mNightMinTemp;
    }

    public String getTempUnit() {
        return mTempUnit;
    }

    public void setTempUnit(String mTempUnit) {
        this.mTempUnit = mTempUnit;
    }

    public int getDayWindSpeed() {
        return mDayWindSpeed;
    }

    public void setDayWindSpeed(int mDayWindSpeed) {
        this.mDayWindSpeed = mDayWindSpeed;
    }

    public String getDayWindDirection() {
        return mDayWindDirection;
    }

    public void setDayWindDirection(String mDayWindDirection) {
        this.mDayWindDirection = mDayWindDirection;
    }

    public String getDayWindUnit() {
        return mDayWindUnit;
    }

    public void setDayWindUnit(String mDayWindUnit) {
        this.mDayWindUnit = mDayWindUnit;
    }

    public int getDayWeatherCode() {
        return mDayWeatherCode;
    }

    public void setDayWeatherCode(int mDayWeatherCode) {
        this.mDayWeatherCode = mDayWeatherCode;
    }

    public String getDayWeatherText() {
        return mDayWeatherText;
    }

    public void setDayWeatherText(String mDayWeatherText) {
        this.mDayWeatherText = mDayWeatherText;
    }

    public int getNightWindSpeed() {
        return mNightWindSpeed;
    }

    public void setNightWindSpeed(int mNightWindSpeed) {
        this.mNightWindSpeed = mNightWindSpeed;
    }

    public String getNightWindDirection() {
        return mNightWindDirection;
    }

    public void setNightWindDirection(String mNightWindDirection) {
        this.mNightWindDirection = mNightWindDirection;
    }

    public String getNightWindUnit() {
        return mNightWindUnit;
    }

    public void setNightWindUnit(String mNightWindUnit) {
        this.mNightWindUnit = mNightWindUnit;
    }

    public int getNightWeatherCode() {
        return mNightWeatherCode;
    }

    public void setNightWeatherCode(int mNightWeatherCode) {
        this.mNightWeatherCode = mNightWeatherCode;
    }

    public String getNightWeatherText() {
        return mNightWeatherText;
    }

    public void setNightWeatherText(String mNightWeatherText) {
        this.mNightWeatherText = mNightWeatherText;
    }
}
