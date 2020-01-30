package exampleSMS;

//fica aguardando um get ou post para enviar uma sms

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import static spark.Spark.*;

public class SmsApp {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hello Web testeeeee");

        post("/sms", (req, res) -> {
            
        	res.type("application/xml");
           
        	Body body = new Body
                    .Builder("The Robots are coming! Head for the hills! testeee ")
                    .build();
        	
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
            
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            
            return twiml.toXml();
        });
    }
}