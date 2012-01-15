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
		try{
			
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost loginPost = new HttpPost("http://www.scope-resolution.org/que/scripts/login.php");
		List postValues = new ArrayList();
		postValues.add(new BasicNameValuePair("username", username));
		postValues.add(new BasicNameValuePair("password",password));
		UrlEncodedFormEntity loginForm = new UrlEncodedFormEntity(postValues, HTTP.UTF_8);
		loginPost.setEntity(loginForm);
		HttpResponse response=client.execute(loginPost);
		InputStream isResponseData = response.getEntity().getContent();
		BufferedReader buffer = new BufferedReader( new InputStreamReader(isResponseData, "UTF-8"));
	   StringBuilder sb = new StringBuilder();
	    String s;
	    while(true )
	    {
	        s = buffer.readLine();
	        if(s==null || s.length()==0)
	            break;
	        sb.append(s);
	
	    }
	    buffer.close();
	    isResponseData.close();
		return s == "true" ? true : false;
	  }catch (Exception e){
		e.printStackTrace();
		return false;
	}
	}

}
