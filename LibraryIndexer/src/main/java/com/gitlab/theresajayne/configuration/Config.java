package com.gitlab.theresajayne.configuration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Configuration Class will hold config Key Value Pairs as loaded from the config file stored in the
 * same folder as the jar file.
 */
public class Config
{
    private Map<String,String> configuration = new HashMap<>();

    public Config()
    {
        File configFile =new File("LibraryIndexerConfig.json");
        if(!configFile.exists())
        {
            //first try to get from resources
            configFile = new File(getClass().getClassLoader().getResource("LibraryIndexerConfig.json").getFile());
            if(!configFile.exists()) {
                System.err.println("Config File Missing, Exiting");
                System.exit(1);
            }
        }
        try {
            //Open the config file as a JSon file.
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(configFile));
            JSONObject jsonObject = (JSONObject)obj;
            Iterator it = jsonObject.keySet().iterator();
            while(it.hasNext())
            {
                String item = (String)it.next();
                configuration.put(item,(String)jsonObject.get(item));
            }
        } catch (FileNotFoundException ex)
        {
            System.err.println("Config File Inaccessible");
            System.exit(1);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEntry(String key)
    {
        return configuration.getOrDefault(key,"");
    }

    public void setConfiguration(Map<String, String> configuration)
    {
        this.configuration = configuration;
    }
}
