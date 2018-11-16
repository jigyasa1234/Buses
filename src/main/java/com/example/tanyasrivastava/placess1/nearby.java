package com.example.tanyasrivastava.placess1;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class nearby extends AsyncTask<Object,String,String> {
    GoogleMap mMap;
    String url;
    InputStream is;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    String data;




    @Override
    protected String doInBackground(Object... objects) {
        mMap=(GoogleMap)objects[0];
        url=(String)objects[1];

        try {
            URL myurl=new URL(url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)myurl.openConnection();
            httpURLConnection.connect();
             is=httpURLConnection.getInputStream();
             bufferedReader=new BufferedReader(new InputStreamReader(is));
             String line="";
             stringBuilder=new StringBuilder();

             while ((line=bufferedReader.readLine())!=null)
             {
                 stringBuilder.append(line);

             }
             data=stringBuilder.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return data;
    }

   @Override
    protected  void onPostExecute(String s)
   {
       try {
           JSONObject parentObject=new JSONObject(s);
           JSONArray resultsarray=parentObject.getJSONArray("results");
           int d=resultsarray.length();
           String latitude="";
           String longitude="";
           String name_b="";
          // float l;
           String []l = new String[d];
           String []lg = new String[d];
           String []n=new String[d];
           for (int i=0;i<resultsarray.length();i++)
           {
               JSONObject jsonObject=resultsarray.getJSONObject(i);
               JSONObject locationobj=jsonObject.getJSONObject("geometry").getJSONObject("location");

                latitude=locationobj.getString("lat");
                l[i]=latitude;

                longitude=locationobj.getString("lng");
                lg[i]=longitude;

               JSONObject nameObject=resultsarray.getJSONObject(i);
               name_b=nameObject.getString("name");
               n[i]=name_b;





           }

          for(int j=0;j<resultsarray.length();j++)
          {
              Log.i("lat:",l[j]);
              Log.i("lng:",lg[j]);
              Log.i("name:",n[j]);

          }

       }catch(JSONException e)
       {
           e.printStackTrace();
       }


   }
}




