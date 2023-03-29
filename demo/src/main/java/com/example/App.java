package com.example;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            String urlString="https://sis-tuni.funidata.fi/kori/api/module-search?curriculumPeriodId=uta-lvv-2021&universityId=tuni-university-root-id&moduleType=DegreeProgramme&limit=1000";
            URL url = new URL(urlString);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if(responseCode!=200){
                throw new RuntimeException("HttpsResponseCode: "+responseCode);
            }
            else{
                StringBuilder informationString = new StringBuilder();
                Scanner scanner =new Scanner(url.openStream());

                while (scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                //System.out.println(informationString.toString());
                String json = informationString.toString();
                JsonParser parser = new JsonParser();
                JsonElement jsonTree = parser.parse(json);
                JsonObject jsonObject = jsonTree.getAsJsonObject();
                JsonElement results = jsonObject.getAsJsonArray("searchResults");
                
                Gson gson = new Gson();
                Program[] program = gson.fromJson(results, Program[].class);
                for (Program prog : program){
                    System.out.println(prog.toString());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

