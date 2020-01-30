package exampleSMS;

//manda sms 

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender{ 


 public static final String ACCOUNT_SID ="";
 
 public static final String AUTH_TOKEN ="";

 
 
 public static void main(String[] args) {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

     Message message = Message
             .creator(new PhoneNumber("+5551992900889"), // to
                     new PhoneNumber("+12075172912"), // from 
                     "testandooo SMS Twilio")
             .create();

     System.out.println(message.getSid());
 }
}