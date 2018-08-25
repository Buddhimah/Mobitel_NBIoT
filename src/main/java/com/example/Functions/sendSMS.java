package com.example.Functions;

/**
 * Created by Buddhima on 3/22/2018.
 */

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class sendSMS {
    public String sendSms(String username, String password, String message) {

        Twitter twitter = TwitterFactory.getSingleton();

        //Status status = twitter.updateStatus(lateststatus);
        //System.out.println("Successfully updated the status to [" + status.getText() + "].");
return "SMS";
    }
}