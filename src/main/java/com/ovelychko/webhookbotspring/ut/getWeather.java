package com.ovelychko.webhookbotspring.ut;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Locale;

public class getWeather {

    public static String doHTTPGet() throws IOException {
//        String key = "kg2V2AfWXYABMJJgTTK4UhO0Qs2b382T"; API KEY
        String url = "http://dataservice.accuweather.com/currentconditions/v1/898675?apikey=kg2V2AfWXYABMJJgTTK4UhO0Qs2b382T";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response;

        HttpEntity entity = null;
        try {
            response = client.execute(get);
            entity = response.getEntity();

            System.out.println("Working ");
//            System.out.println(EntityUtils.toString(entity));

            return parser(EntityUtils.toString(entity));

        } catch (IIOException ioe) {
            System.err.println("Error");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unknown error: ");
            e.printStackTrace();
        }
        return parser(EntityUtils.toString(entity));
    }

    public static String parser(String responseContent) {
        JSONArray albums = new JSONArray(responseContent);
        getWeather getWeather = new getWeather();
        var isDay = "";
        var condition = "";


        for (int i = 0; i < albums.length(); i++) {
            JSONObject ab = albums.getJSONObject(i);
            String weatherText = ab.getString("WeatherText");
            boolean IsDayTime = ab.getBoolean("IsDayTime");

            if (IsDayTime)
                isDay = "Good morning";
            else
                isDay = "Good evening";


            switch (weatherText.toLowerCase(Locale.ROOT)) {
                case "sunny", "partly sunny" -> condition = "This current weather condition is " + weatherText + "☀. Make sure you wear clothes that will not make you sweat much.";
                case "mostly stormy", "stormy" -> condition = "This current weather condition is " + weatherText + "🌧💨. Stormy signals are detected with heavy downpours. Prepare yourself, take at a safe place.";
                case "intermittent clouds" -> condition = "This current weather condition is " + weatherText + "🌧💨. Stormy signals are detected with heavy downpours. Prepare yourself, take at a safe place.";
                case "fog" -> condition = "This current weather condition is " + weatherText + "🌁🌫. It's foggy, this can cause perplexity or confusion. Make sure you move carefully";
                case "dreary (overcast)" -> condition = "This current weather condition is " + weatherText + "🌧💨. Stormy signals are detected with heavy downpours. Prepare yourself, take at a safe place.";
                case "most cloudy", "cloudy", "partly cloudy" -> condition = "This current weather condition is " + weatherText + "☁. It is most likely that it will rain today. Make sure you prepare of all necessary things before it rain.";
                case "showers" -> condition = "This current weather condition is " + weatherText + "☁. It is most likely that it will rain today. Make sure you prepare of all necessary things before it rain.";
                case "mostly cloudy w/ showers" -> condition = "This current weather condition is " + weatherText + "☁. It is most likely that it will rain today. Make sure you prepare of all necessary things before it rain.";
                case "partly sunny w/ showers" -> condition = "This current weather condition is " + weatherText + "☁. It is most likely that it will rain today. Make sure you prepare of all necessary things before it rain.";
                case "t-storms" -> condition = "This current weather condition is " + weatherText + "🌪. It is stormy today, Legon campus is exposed to strong blowing winds. Be careful";
                case "mostly cloudy w/ t-storms" -> condition = "This current weather condition is " + weatherText + "☁. It is most likely that it will rain today. Make sure you prepare of all necessary things before it rain.";
                case "partly sunny w/ t-storms" -> condition = "This current weather condition is " + weatherText + "⛅. This weather is unpredictable, it is sunny at the moment but the weather may be stormy any moment from now.";
                case "rain", "rainy" -> condition = "This current weather condition is " + weatherText + "☔. It is raining at the moment. Make sure you have yourself a raincoat or umbrella before going outside.";
                case "windy" -> condition = "This current weather condition is " + weatherText + "💨. It is windy today, Legon campus is exposed to strong blowing winds. Be careful";
                case "clear", "mostly clear" -> condition = "This current weather condition is " + weatherText + "🌞. The skies are clear and beautiful. It is good for taking pictures 😋📷";
                case "Sleet" -> condition = "This current weather condition is " + weatherText + "💨. It is windy today, Legon campus is exposed to strong blowing winds. Be careful";
                case "Snow" -> condition = "This current weather condition is " + weatherText + "💨. It is windy today, Legon campus is exposed to strong blowing winds. Be careful";
                case "Ice" -> condition = "This current weather condition is " + weatherText + "💨. It is windy today, Legon campus is exposed to strong blowing winds. Be careful";
//                case "windy" -> condition = "This current weather condition is " + weatherText + "💨. It is windy today, Legon campus is exposed to strong blowing winds. Be careful";
//                case "windy" -> condition = "This current weather condition is " + weatherText + "💨. It is windy today, Legon campus is exposed to strong blowing winds. Be careful";

            }

            return condition + isDay;
        }
        return null;
    }

}
