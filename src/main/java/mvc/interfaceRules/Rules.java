package mvc.interfaceRules;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Rules {

	String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;

}

