package com.gitlab.theresajayne.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ElasticService
{
    private static String url = "192.168.4.185:9200";
    private static String index = "bookindex";

    public static boolean putToElastic(String payload)
    {
        try
        {
            URL elasticUrl = new URL("http://" + url + "/" + index+"/_doc/");
            System.out.println(elasticUrl);
            HttpURLConnection putConnection = (HttpURLConnection)elasticUrl.openConnection();
            putConnection.setRequestMethod("POST");
            putConnection.setRequestProperty("Content-Type","application/json");
            putConnection.setDoOutput(true);
            OutputStream os = putConnection.getOutputStream();
            System.out.println(payload);
            os.write(payload.getBytes());
            os.flush();
            os.close();

            int responseCode = putConnection.getResponseCode();
            System.out.println("PUT Response Code : "+responseCode);
            System.out.println("PUT Response Message : "+ putConnection.getResponseMessage());

            if(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(putConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while((inputLine = in.readLine())!= null)
                {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
                return true;
            } else
            {
                System.out.println("PUT NOT WORKING");
            }
            return false;
        }
        catch (IOException mue)
        {
            return false;
        }
    }

}
