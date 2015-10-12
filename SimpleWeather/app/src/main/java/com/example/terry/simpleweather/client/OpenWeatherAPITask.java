package com.example.terry.simpleweather.client;

import android.os.AsyncTask;

/**
 * Created by terry on 2015. 8. 27..
 * 입력 인자 (Integer) : 위도와 경도
 * 리턴값 Weather
 */
public class OpenWeatherAPITask extends AsyncTask<Integer, Void, Weather> {
    @Override
    public Weather doInBackground(Integer... params) {
        OpenWeatherAPIClient client = new OpenWeatherAPIClient();

        int lat = params[0];
        int lon = params[1];
        // API 호출
        Weather w = client.getWeather(lat,lon);

        //System.out.println("Weather : "+w.getTemprature());

        // 작업 후 리
        return w;
    }
}
