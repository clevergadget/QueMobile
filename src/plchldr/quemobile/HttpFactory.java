package plchldr.quemobile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	
	public static String HttpPostJSON(List postValues, String url) throws ClientProtocolException, IOException
	{
		HttpClient client = new DefaultHttpClient();
		HttpPost loginPost = new HttpPost(url);
		UrlEncodedFormEntity loginForm = new UrlEncodedFormEntity(postValues, HTTP.UTF_8);
		loginPost.setEntity(loginForm);
		HttpResponse response=client.execute(loginPost);
		String test = EntityUtils.toString(response.getEntity());
	    try {
	    	JSONArray jsonArrayResults = new JSONArray(test);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return test;
	}

}
