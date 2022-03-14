package com.example.currencyapp.MainActivity.Data.Web;

import android.os.AsyncTask;
import android.util.Log;

import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class AsyncGet extends AsyncTask<Void, Integer, ArrayList<Currency>>
{
    //names of arrays in json
    String valute = "Valute";

    ArrayList<Currency> currencyArrayList = new ArrayList<>();
    Currency currency;


    protected ArrayList<Currency> doInBackground(Void... voids)
    {
        String LINK = "https://www.cbr-xml-daily.ru/daily_json.js";
        URL MAIN_URL;
        HttpURLConnection urlConnection;
        try
        {
            MAIN_URL = new URL(LINK);

            urlConnection = (HttpURLConnection) MAIN_URL.openConnection();

            if (urlConnection.getResponseCode() == 200)
            {
                //String where all json file will be written
                String line = null;
                //get all inputStream from connected HHTP
                InputStream inputStream = urlConnection.getInputStream();
                //Copy this inputStream to bufferedReader to read Stream of data
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //initialize StringBuffer to get data from bufferedReader [consequently from Stream] since we don't exact length of data
                //therefore of exact number of lines
                StringBuffer stringBuffer = new StringBuffer();
                //if line's value taken from bufferedReader equals to null, stop loop
                while ((line = bufferedReader.readLine()) != null)
                {
                    //give one line string value of var Line to stringBuffer
                    stringBuffer.append(line);
                }
                //close bufferedReader since we don't need to handle Stream data anymore,
                //so it closes the stream and frees PC's resources
                bufferedReader.close();

                //JSONObject/Array class to navigate and easily transform json file in string's view
                //to the objects of java or just fetch data from string view of json file [or in other word StringBuffer] more conveniently
                //get MainObj that includes all others from stringBuffer

                final JSONObject mainObj = new JSONObject(stringBuffer.toString());


                //since we need weather array we write JSONArray var and get it from mainObj in form of string
                JSONObject valute_object = new JSONObject(mainObj.getString(valute));
                Iterator iterator = valute_object.keys();
                JSONArray valute_array = new JSONArray();

                while (iterator.hasNext())
                {
                    String key = (String) iterator.next();
                    valute_array.put(valute_object.get(key));
                }

                Gson gson = new Gson();

                for(int i =0; i<valute_array.length(); i++)
                {
                    currency = gson.fromJson(valute_array.getJSONObject(i).toString(), Currency.class);
                    currencyArrayList.add(currency);
                    //Log.d("MyLog","LINE: "+ currencyArrayList + "\n");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return currencyArrayList;
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(ArrayList<Currency> currencyArrayList)
    {
    }
}
