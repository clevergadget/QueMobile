package plchldr.quemobile;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpFactory {
	
	
	public static String HttpPostString(List postValues, String url) throws ParseException, IOException
	{

		HttpClient client = new DefaultHttpClient();
		HttpPost loginPost = new HttpPost(url);
		UrlEncodedFormEntity loginForm = new UrlEncodedFormEntity(postValues, HTTP.UTF_8);
		loginPost.setEntity(loginForm);
		HttpResponse response=client.execute(loginPost);
		String test = EntityUtils.toString(response.getEntity());
		return test;
	}

}
