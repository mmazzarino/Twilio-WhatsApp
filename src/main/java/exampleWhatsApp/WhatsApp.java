package exampleWhatsApp;

//fica aguardando algum whats para retornar um whats personalizado

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import static spark.Spark.*;

public class WhatsApp {
	

	    public static void main(String[] args) {
	        get("/", (req, res) -> "Your teste code is teste");

	        post("/sms", (req, res) -> {	
	        
	        	String str = req.body();
	        	String parBody = GetParam(str, "Body");
	        	String parFrom = GetParam(str, "From");	        	
	        	System.out.println("From:" + parFrom);
	        	System.out.println("Body:" + parBody);
	        	
	        	String msg ="Your teste code is teste";
	        	
	        			if(parBody.equals("=Olá")) {
	        		msg = "olá";
	        	}
	        	else if(parBody.equals("=tchau")) {
	        		msg = "tchau";
	        	}
	        	res.type("application/xml");
	            
	        	Body body = new Body
	                    .Builder(msg) 
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
	    

	    private static String GetParam(String s, String pParam) 
		{
			String pAux  = "";
			String pChar = "";
			boolean pAchei = false;
			int pPos   = -1;
			int pTam   = 0;
			int pCount = 0;
		
			pTam   = s.length();             // tamanho do string contendo o filtro
			pPos   = s.indexOf(pParam);      // posição inicial que encontrou o parâmetro
			pCount = pPos + pParam.length(); // posição final que encontrou o parâmetro

			if (pPos != -1) 
			{
				while ((pCount <= pTam) && (pAchei == false)) 
				{
					if (pCount < pTam)
					{
						pChar = s.substring(pCount, pCount + 1);
					}
					else
					{
						pAchei = true;
						pChar  = "&";
					}

					if (pChar.equals("&") == false) 
					{
						if (pChar.equals("") == false) 
						{	
							pAux = pAux.concat(pChar);
						}	
					}
					else 
					{
						pAchei = true;
					}
					pCount ++;
				}
			}
		
			return pAux.trim();
		}    
	}

