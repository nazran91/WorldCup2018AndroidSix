package com.aiub.worldcup2018androidsix.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    private String API_URL =
            "https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/data.json";
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        databaseHelper = new DatabaseHelper(SplashScreenActivity.this);

        getDataFromAPI();
    }

    private void getDataFromAPI() {

        RequestQueue requestQueue = Volley.newRequestQueue(SplashScreenActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, response.toString());

                try {
                    JSONArray stadiums = response.getJSONArray("stadiums");

                    for (int i = 0; i < stadiums.length(); i++) {
                         JSONObject stadiumObject = stadiums.getJSONObject(i);

                         int id = stadiumObject.getInt("id");
                         String name = stadiumObject.getString("name");
                         String city = stadiumObject.getString("city");
                         double lat = stadiumObject.getDouble("lat");
                         double lng = stadiumObject.getDouble("lng");
                         String image = stadiumObject.getString("image");
                    }

                    JSONArray teams = response.getJSONArray("teams");

                    for (int i = 0; i < teams.length(); i++){
                        JSONObject teamsObject = teams.getJSONObject(i);

                        int id = teamsObject.getInt("id");
                        String name = teamsObject.getString("name");
                        String fifaCode = teamsObject.getString("fifaCode");

                        Team team = new Team(id, name, fifaCode);
                        databaseHelper.addTeam(team);
                    }

                    JSONObject groups = response.getJSONObject("groups");

                    JSONObject groupObject = groups.getJSONObject("a");

                    JSONArray matches = groupObject.getJSONArray("matches");

                    for (int i = 0; i < matches.length(); i++){
                        JSONObject matchObject = matches.getJSONObject(i);

                        String name = matchObject.getString("name");
                        int home_team = matchObject.getInt("home_team");
                        int away_team = matchObject.getInt("away_team");
                        int home_result = matchObject.getInt("home_result");
                        int away_result = matchObject.getInt("away_result");
                        String date = matchObject.getString("date");
                        int stadium = matchObject.getInt("stadium");
                        boolean finished = matchObject.getBoolean("finished");
                        int matchday = matchObject.getInt("matchday");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        }
        );

        requestQueue.add(jsonObjectRequest);
    }
}
