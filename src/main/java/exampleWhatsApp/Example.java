package exampleWhatsApp;

//envia um whats com mensagem modelo

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
 // Find your Account Sid and Token at twilio.com/console
 // DANGER! This is insecure. See http://twil.io/secure
 public static final String ACCOUNT_SID = "";
 
 public static final String AUTH_TOKEN = "";
 

 public static void main(String[] args) {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
     
     Message message = Message.creator(
             new com.twilio.type.PhoneNumber("whatsapp:+555192900889"),
             new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
             "Your appointment is coming up on teste at 3PM")
         .create();

     System.out.println(message.getSid());
 }
}