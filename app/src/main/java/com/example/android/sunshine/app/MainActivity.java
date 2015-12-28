package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] forecastArray = {
                    "Today-Sunny-86/64",
                    "Tomorrow-Foggy-70/53",
                    "Weds-rainy-60/43",
                    "Thurs-Cloudy-70/55",
                    "Fri-Sunny-85/50",
                    "Sat-Foggy-70/50",
                    "Sun-Sunny-86/50"
            };

            List<String> weekWeather = new ArrayList<String>(Arrays.asList(forecastArray));

            ArrayList<String> weather = new ArrayList<>();
            weather.add("OToday-Sunny-86/64");
            weather.add("OTomorrow-Foggy-70/53");
            weather.add("OWeds-rainy-60/43");
            weather.add("OThurs-Cloudy-70/55");
            weather.add("OFri-Sunny-85/50");
            weather.add("OSat-Foggy-70/50");

            mForecastAdapter = new ArrayAdapter<String>(
                    // the current context
                    getActivity(),
                    //
                    R.layout.test_list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weather
            );

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
    private static ArrayAdapter<String> mForecastAdapter;
}
