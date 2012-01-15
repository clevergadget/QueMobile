package plchldr.quemobile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;

public class UserProxy {
	
	
	@SuppressWarnings("unchecked")
	static public boolean checkLogin(String username, String password) throws ParseException, IOException
	{
				String url = "http://www.scope-resolution.org/que/scripts/login.php";
				
				List<NameValuePair> postValues = new ArrayList<NameValuePair>();
				postValues.add(new BasicNameValuePair("username", username));
				postValues.add(new BasicNameValuePair("password", password));


			
					String result =  HttpFactory.HttpPostString(postValues, url);
					return result.equals("true") ? true : false;
				

    }
}


