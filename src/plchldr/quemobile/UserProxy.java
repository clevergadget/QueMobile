package plchldr.quemobile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class UserProxy {
	
	
	static public boolean checkLogin(String username, String password)
	{
				String url = "http://www.scope-resolution.org/que/scripts/login.php";
				
				List postValues = new ArrayList();
				postValues.add(new BasicNameValuePair("username", username));
				postValues.add(new BasicNameValuePair("password",password));
				
				String s = HttpFactory.HttpPostString(postValues, url);
				return s == "true" ? true : false;
    }
	}


