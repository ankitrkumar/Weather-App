package kumarankit.nikeweathertest.helper;

import java.util.Hashtable;

import kumarankit.nikeweathertest.R;

/**
 * Created by Ankit on 4/2/2015.
 * Helper Class for getting the images as given by weather2.com
 */
public class ImageHelper {
    public static ImageHelper imageHelper = new ImageHelper();

    private Hashtable<Integer, WeatherImage> mHashTable = new Hashtable<Integer, WeatherImage>();

    public ImageHelper()
    {
        addWeatherData( 0, R.drawable.sunny, R.drawable.clear );
        addWeatherData( 1,R.drawable.partlycloudyday,R.drawable.partlycloudynight );
        addWeatherData( 2,R.drawable.cloudy,R.drawable.cloudy );
        addWeatherData( 3,R.drawable.overcast,R.drawable.overcast );
        addWeatherData( 10,R.drawable.mist,R.drawable.mist );
        addWeatherData( 21,R.drawable.occlightrain,R.drawable.occlightrain );
        addWeatherData( 22,R.drawable.isosleetswrsday,R.drawable.isosleetswrsnight );
        addWeatherData( 23,R.drawable.occlightsleet,R.drawable.occlightsleet );
        addWeatherData( 24,R.drawable.freezingdrizzle,R.drawable.freezingdrizzle );
        addWeatherData( 29,R.drawable.partcloudrainthunderday,R.drawable.partcloudrainthundernight );
        addWeatherData( 38,R.drawable.modsnow,R.drawable.modsnow );
        addWeatherData( 39,R.drawable.blizzard,R.drawable.blizzard );
        addWeatherData( 45,R.drawable.fog,R.drawable.fog );
        addWeatherData( 49,R.drawable.freezingfog,R.drawable.freezingfog );
        addWeatherData( 50,R.drawable.isorainswrsday,R.drawable.isorainswrsnight );
        addWeatherData( 51,R.drawable.occlightrain,R.drawable.occlightrain );
        addWeatherData( 56,R.drawable.freezingdrizzle,R.drawable.freezingdrizzle );
        addWeatherData( 57,R.drawable.freezingdrizzle,R.drawable.freezingdrizzle );
        addWeatherData( 60,R.drawable.occlightrain,R.drawable.occlightrain );
        addWeatherData( 61, R.drawable.modrain,R.drawable.modrain );
        addWeatherData( 62,R.drawable.modrainswrsday,R.drawable.modrainswrsnight );
        addWeatherData( 63,R.drawable.modrain,R.drawable.modrain );
        addWeatherData( 64,R.drawable.heavyrainswrsday,R.drawable.heavyrainswrsnight );
        addWeatherData( 65,R.drawable.heavyrain,R.drawable.heavyrain );
        addWeatherData( 66,R.drawable.freezingrain,R.drawable.freezingrain );
        addWeatherData( 67,R.drawable.freezingrain,R.drawable.freezingrain );
        addWeatherData( 68,R.drawable.modsleet,R.drawable.modsleet );
        addWeatherData( 69,R.drawable.heavysleet,R.drawable.heavysleet );
        addWeatherData( 70,R.drawable.occlightsnow,R.drawable.occlightsnow );
        addWeatherData( 71,R.drawable.occlightsnow,R.drawable.occlightsnow );
        addWeatherData( 72,R.drawable.modsnow,R.drawable.modsnow );
        addWeatherData( 73,R.drawable.modsnow,R.drawable.modsnow );
        addWeatherData( 74,R.drawable.heavysnowswrsday,R.drawable.heavysnowswrsnight );
        addWeatherData( 75,R.drawable.heavysnow,R.drawable.heavysnow );
        addWeatherData( 79,R.drawable.freezingrain,R.drawable.freezingrain );
        addWeatherData( 80,R.drawable.isorainswrsday,R.drawable.isorainswrsnight );
        addWeatherData( 81,R.drawable.modrainswrsday,R.drawable.modrainswrsnight );
        addWeatherData( 82,R.drawable.heavyrain,R.drawable.heavyrain );
        addWeatherData( 83,R.drawable.modsleetswrsday,R.drawable.modsleetswrsnight );
        addWeatherData( 84,R.drawable.modsleetswrsday,R.drawable.modsleetswrsnight );
        addWeatherData( 85,R.drawable.isosnowswrsday,R.drawable.isosnowswrsnight );
        addWeatherData( 86,R.drawable.modsnowswrsday,R.drawable.modsnowswrsnight );
        addWeatherData( 87,R.drawable.freezingrain,R.drawable.freezingrain );
        addWeatherData( 88,R.drawable.freezingrain,R.drawable.freezingrain );
        addWeatherData( 91,R.drawable.partcloudrainthunderday,R.drawable.partcloudrainthundernight );
        addWeatherData( 92,R.drawable.cloudrainthunder,R.drawable.cloudrainthunder );
        addWeatherData( 93,R.drawable.partcloudsleetsnowthunderday,R.drawable.partcloudsleetsnowthundernight );
        addWeatherData( 94,R.drawable.cloudsleetsnowthunder,R.drawable.cloudsleetsnowthunder );
    }

    private void addWeatherData( int code, int di, int ni)
    {
        WeatherImage wi = new WeatherImage(code, di, ni);
        mHashTable.put(code, wi);
    }

    public WeatherImage getWeatherImage(int code)
    {
        WeatherImage image = mHashTable.get(code);
        return image;
    }

    public static class WeatherImage
    {
        public WeatherImage( int wc, int di, int ni)
        {
            weatherCode = wc;
            dayIcon = di;
            nightIcon = ni;
        }
        public int weatherCode;
        public int dayIcon;
        public int nightIcon;
    }
}
