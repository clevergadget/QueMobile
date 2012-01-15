package plchldr.quemobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class UserProxy {
	
	
	@SuppressWarnings("unchecked")
	static public boolean checkLogin(String username, String password)
	{
				String url = "http://www.scope-resolution.org/que/scripts/login.php";
				
				List<NameValuePair> postValues = new ArrayList<NameValuePair>();
				postValues.add(new BasicNameValuePair("username", username));
				postValues.add(new BasicNameValuePair("password", password));


				try {
					return HttpFactory.HttpPostString(postValues, url) == "true" ? true : false;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
    }
}


