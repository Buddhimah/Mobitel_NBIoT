package com.example.Controllers;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Arrays;

/**
 * Created by Buddhima on 3/22/2018.
 */

@Controller
@RequestMapping(path="/morathings")
@ResponseBody
public class RSTControllers {
   String Addr="";
   String DataJson1="";String DataJson2="";String DataJson3="";String DataJson4="}";

    String DataJson5="";
    String DataJson6="";
    String DataJson7="";
    String rescode="";

    @RequestMapping(method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public String nbiot(@RequestBody Template  payload) {
        try {

            Addr="https://userapp-dbf47.firebaseio.com/Users/"+payload.getName()+"/Usage.json?auth=GoD8uJMuyzkTiY4uQQFfoCQTngVMhpyosODIq82j";
            URL url = new URL(Addr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            DataJson1="{ \"Usage\" : " +   "\""+payload.getUsage()+"\""    ;
            DataJson2="\"LastSync\": "+    "\""+ timeStamp+"\"";
            //osw.write(String.format("{\"Usage\":\"512\"}"));
            System.out.println(DataJson1+","+DataJson2+DataJson4);
            System.out.println(DataJson2);
            osw.write(DataJson1+","+DataJson2+DataJson4);
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());

        } catch (Exception e) {
            System.out.println(e);

        }
    return "Buddhima";
    }
    @RequestMapping(value= "/nbhack",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public String NBIOTHACK (@RequestBody NBIOTFORM payload) {


        String deviceId=payload.getDeviceId();
        int[] data = payload.getPayload().getData();
        String usage="";
        for(int i=0;i<data.length;i++){
            usage+=(char)data[i];

        }



        try {
        Addr="https://userapp-dbf47.firebaseio.com/Users/"+deviceId+"/Usage.json?auth=GoD8uJMuyzkTiY4uQQFfoCQTngVMhpyosODIq82j";
        URL url = new URL(Addr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            //1519862400
            String timeStamp2 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(1619862400));
        DataJson1="{ \"Usage\" : " +   "\""+usage+"\""    ;
        DataJson2="\"LastSync\": "+    "\""+ timeStamp+"\"";
            DataJson3="\"BillDate\": "+    "\""+ timeStamp2+"\"";
            DataJson5="\"CurrentOutstanding\": "+    "\""+ 1250+"\"";
            DataJson6="\"LastBillAmount\": "+    "\""+ 1000+"\"";
        //osw.write(String.format("{\"Usage\":\"512\"}"));
            System.out.println(DataJson1+","+DataJson2+","+DataJson3+","+DataJson5+","+DataJson6+"," +DataJson4);
        osw.write(DataJson1+","+DataJson2+","+DataJson3+","+DataJson5+","+DataJson6+DataJson4);
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
