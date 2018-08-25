package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Buddhima on 3/24/2018.
 */

@Controller
@RequestMapping(path="/stopservice")
@ResponseBody
public class Stop {

    @RequestMapping( method = RequestMethod.GET)
    public String  stopService(@RequestParam("name") String name){
        String DataJson1="";
        String DataJson2="";
        String DataJson3="";
        String DataJson4="1";
        String DataJson5="}";
        String rescode="";

        //http://13.76.88.107:8088/nbsend

        try {

            URL url = new URL("http://13.76.88.107:8088/nbsend");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());

            //Send a get to https://userapp-dbf47.firebaseio.com/Users/863703031921617/Usage/DeviceKey.json?auth=GoD8uJMuyzkTiY4uQQFfoCQTngVMhpyosODIq82j
            //get the devicekey

            //osw.write(String.format("{\"Usage\":\"512\"}"));



            StringBuilder result = new StringBuilder();
            URL url2 = new URL("https://userapp-dbf47.firebaseio.com/Users/"+name.substring(1,16)+"/Usage/DeviceKey.json?auth=GoD8uJMuyzkTiY4uQQFfoCQTngVMhpyosODIq82j");
            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
         System.out.println( result.toString());



//            DataJson1="{ \"deviceId\" : " +   "\""+name.substring(1,16)+"\""    ;
//            DataJson2="\"deviceKey\": "+    "\""+ result.toString().substring(1,16)+"\"";
//            DataJson3="\"payload\": "+    "\""+ DataJson4+"\"";
            DataJson1="{ \"deviceId\" : " +   "\""+"863703031921617" +"\""    ;
            DataJson2="\"deviceKey\": "+    "\""+ "ed36bf6fed3ae6d81073f518bff612ba"+"\"";
            DataJson3="\"payload\": "+    "\""+ "1"+"\"";


            osw.write(DataJson1+","+DataJson2+","+DataJson3+DataJson5);
            System.out.println(DataJson1+","+DataJson2+","+DataJson3+DataJson5);



            osw.flush();
            osw.close();

            rescode+=connection.getResponseCode();
            System.err.println(rescode);

        } catch (Exception e) {
            System.out.println(e);

        }


        return rescode;

    }


    }





