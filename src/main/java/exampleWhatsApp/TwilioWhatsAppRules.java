/*package exampleWhatsApp;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

public class TwilioWhatsAppRules extends HttpServlet {
  public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
	  String body = request.getParameter("Body");
	  System.out.println(body);
	  
	  String message = "Message";
    
	  if (body.equals("hello")) {
      // Say hi
      message = "Your hello code is teste";
    } else if (body.equals("bye")) {
      // Say goodbye
      message = "Your bye code is teste";
    }

    // Create a TwiML response and add our friendly message.
    Body messageBody = new Body
    		.Builder(message)
    		.build();
    
    Message msgWhats = new Message
    		.Builder()
    		.body(messageBody)
    		.build();
    
    MessagingResponse twiml = new MessagingResponse
    		.Builder()
    		.message(msgWhats)
    		.build();

    response.setContentType("application/xml");

    try {
      response.getWriter().print(twiml.toXml());
    } catch (TwiMLException e) {
      e.printStackTrace();
    }
  }
}*/