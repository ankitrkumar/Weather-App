package kumarankit.nikeweathertest.weatherget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;

import kumarankit.nikeweathertest.fragments.FragmentCurrent;
import kumarankit.nikeweathertest.fragments.FragmentForecast;
import kumarankit.nikeweathertest.util.Constants;

/**
 * Created by Ankit on 4/2/2015.
 * AsyncTask to fetch weather data
 */
public class WeatherAsyncTask extends AsyncTask<String, Void, String> {

    private static final String WEB_SERVICE_URL = "http://www.myweather2.com/developer/forecast.ashx?";//Given in requirements
    private static final String WEB_SERVICE_UAC = "KDrRbvwbAt";//Given in requirements
    private static final String WEB_REQUEST_FORMAT = "json";//Given in requirements
    private static final String WEB_REQUEST_ZIPCODE = "97006";//Given in requirements
    private static final Long TIME_CHECK = 1800000L;

    private Context mContext;
    public WeatherAsyncTask (Context context){
        mContext = context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(mContext, "Last Updated at: " + mContext.getSharedPreferences(Constants.PREFS_NAME, mContext.MODE_PRIVATE).getString(Constants.PREFS_LAST_UPDATED, ""), Toast.LENGTH_LONG).show();
        FragmentCurrent.updateView();
        FragmentForecast.updateView();
    }

    @Override
    protected String doInBackground(String... params) {
        String lastUpdatedTime = "123";
        if((lastUpdatedTime=getPrefs(mContext,Constants.PREFS_LAST_UPDATED_TIME))!="" || isFirstTime(mContext)) {
            if(lastUpdatedTime==null)
            lastUpdatedTime = "123";
            long currentTime = System.currentTimeMillis();

            if((currentTime-Long.parseLong(lastUpdatedTime)) > TIME_CHECK) {
                //then do  the doInBackground else return the json string that was stored
                StringBuilder builder = new StringBuilder();
                int timeoutConnection = 5000;
                HttpParams httpParameters = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
                HttpClient client = new DefaultHttpClient(httpParameters);
                String requestUrl = assembledURL();
                HttpGet httpGet = new HttpGet(requestUrl);
                try {
                    HttpResponse response = client.execute(httpGet);
                    StatusLine statusLine = response.getStatusLine();
                    int statusCode = statusLine.getStatusCode();
                    if (statusCode == 200) {
                        HttpEntity entity = response.getEntity();
                        InputStream content = entity.getContent();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            builder.append(line);
                        }
                    }
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                putPrefs(mContext, Constants.PREFS_MJSON, builder.toString());
                putPrefs(mContext,Constants.PREFS_LAST_UPDATED_TIME,""+currentTime);
                putPrefs(mContext,Constants.PREFS_LAST_UPDATED,""+ DateFormat.getDateTimeInstance().format(currentTime));
                return builder.toString();
            }
            else
                return getPrefs(mContext,Constants.PREFS_MJSON);
        }
        return getPrefs(mContext,Constants.PREFS_MJSON);
    }

    private String assembledURL() {
        StringBuilder builder = new StringBuilder();
        builder.append(WEB_SERVICE_URL);
        builder.append("uac=");
        builder.append(WEB_SERVICE_UAC);
        builder.append("&output=");
        builder.append(WEB_REQUEST_FORMAT);
        builder.append("&query=");
        builder.append(WEB_REQUEST_ZIPCODE);
        return builder.toString();
    }
    public void putPrefs(Context context, String key, String value) {
        SharedPreferences weather = context.getSharedPreferences(Constants.PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = weather.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getPrefs(Context context, String key) {
        SharedPreferences weather = context.getSharedPreferences(Constants.PREFS_NAME,Context.MODE_PRIVATE);
        return weather.getString(key,null);
    }

    public boolean isFirstTime(Context context) {
        SharedPreferences weather = context.getSharedPreferences(Constants.PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        if(weather.getBoolean(Constants.PREFS_FIRST_TIME,true))
            return true;
        else
        {
            editor = weather.edit();
            editor.putBoolean(Constants.PREFS_FIRST_TIME, false);
            editor.apply();
        }
        return false;
    }


}