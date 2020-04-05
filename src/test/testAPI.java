/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
/**
 *
 * @author os
 */
public class testAPI {
    public static void main(String args[]) {
        
 
System.out.println("OK");


NexmoClient client = NexmoClient.builder()
        .apiKey("f481785d")
        .apiSecret("pIO6oRfhxut8UBG0")
        .build();

SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
        "TEST",
        "21653133667",
        "Hello from Nexmo!"));
for (SmsSubmissionResponseMessage response : responses.getMessages()) {
    System.out.println(response);
}
    }
}
