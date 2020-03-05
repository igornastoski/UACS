package com.uacs.android.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.AsyncTask;

import android.widget.TextView;

import com.uacs.android.networking.data.SunshinePreferences;
import com.uacs.android.networking.utilities.NetworkUtils;
import com.uacs.android.networking.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Using findViewById, we get a reference to our TextView from xml. This allows us to
         * do things like set the text of the TextView.
         */
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);

        // TODO (4) Delete the dummy weather data. You will be getting REAL data from the Internet in this lesson.
        /*
         * This String array contains dummy weather data. Later in the course, we're going to get
         * real weather data. For now, we want to get something on the screen as quickly as
         * possible, so we'll display this dummy data.
         */
        /*String[] dummyWeatherData = {
                "Today, May 17 - Clear - 17°C / 15°C",
                "Tomorrow - Cloudy - 19°C / 15°C",
                "Thursday - Rainy- 30°C / 11°C",
                "Friday - Thunderstorms - 21°C / 9°C",
                "Saturday - Thunderstorms - 16°C / 7°C",
                "Sunday - Rainy - 16°C / 8°C",
                "Monday - Partly Cloudy - 15°C / 10°C",
                "Tue, May 24 - Meatballs - 16°C / 18°C",
                "Wed, May 25 - Cloudy - 19°C / 15°C",
                "Thu, May 26 - Stormy - 30°C / 11°C",
                "Fri, May 27 - Hurricane - 21°C / 9°C",
                "Sat, May 28 - Meteors - 16°C / 7°C",
                "Sun, May 29 - Apocalypse - 16°C / 8°C",
                "Mon, May 30 - Post Apocalypse - 15°C / 10°C",
        }; */

        // TODO (3) Delete the for loop that populates the TextView with dummy data
        /*
         * Iterate through the array and append the Strings to the TextView. The reason why we add
         * the "\n\n\n" after the String is to give visual separation between each String in the
         * TextView. Later, we'll learn about a better way to display lists of data.
         */
        //for (String dummyWeatherDay : dummyWeatherData) {
        //  mWeatherTextView.append(dummyWeatherDay + "\n\n\n");
        //}

        // TODO (9) Call loadWeatherData to perform the network request to get the weather
        loadWeatherData();
    }

    // TODO (8) Create a method that will get the user's preferred location and execute your new AsyncTask and call it loadWeatherData
    private void loadWeatherData() {
        String location = SunshinePreferences.getPreferredWeatherLocation(this);
        new FetchWeatherTask().execute(location);

    }

    // TODO (5) Create a class that extends AsyncTask to perform network requests
    // TODO (6) Override the doInBackground method to perform your network requests
    // TODO (7) Override the onPostExecute method to display the results of the network request
    public class FetchWeatherTask extends AsyncTask<String, Void, String[]> {
        @Override
        protected String[] doInBackground(String... params) {

            /* If there's no zip code, there's nothing to look up. */
            if (params.length == 0) {
                return null;
            }

            String location = params[0];
            URL weatherRequestUrl = NetworkUtils.buildUrl(location);
            try {
                String jsonWeatherResponse = NetworkUtils
                        .getResponseFromHttpUrl(weatherRequestUrl);

                String[] simpleJsonWeatherData = OpenWeatherJsonUtils
                        .getSimpleWeatherStringsFromJson(MainActivity.this, jsonWeatherResponse);

                return simpleJsonWeatherData;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] weatherData) {
            if (weatherData != null) {
                /*
                 * Iterate through the array and append the Strings to the TextView. The reason why we add
                 * the "\n\n\n" after the String is to give visual separation between each String in the
                 * TextView. Later, we'll learn about a better way to display lists of data.
                 */
                for (String weatherString : weatherData) {
                    mWeatherTextView.append((weatherString) + "\n\n\n");
                }
            }
        }
    }

    // TODO (2) Create a menu resource in res/menu/ called forecast.xml
    // TODO (3) Add one item to the menu with an ID of action_refresh
    // TODO (4) Set the title of the menu item to "Refresh" using strings.xml


    // TODO (5) Override onCreateOptionsMenu to inflate the menu for this Activity
    // TODO (6) Return true to display the menu
    // TODO (7) Override onOptionsItemSelected to handle clicks on the refresh button

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.forecast, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if (menuItemThatWasSelected == R.id.action_refresh) {

            mWeatherTextView.setText("");
            loadWeatherData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
