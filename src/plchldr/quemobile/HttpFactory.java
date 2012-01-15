package plchldr.quemobile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

public class HttpFactory {
	
	
	public static String HttpPostString(List postValues, String url)
	{
		try{
				DefaultHttpClient client = new DefaultHttpClient();
				HttpPost loginPost = new HttpPost(url);
				UrlEncodedFormEntity loginForm = new UrlEncodedFormEntity(postValues, HTTP.UTF_8);
				loginPost.setEntity(loginForm);
				HttpResponse response = client.execute(loginPost);
				InputStream isResponseData = response.getEntity().getContent();
				BufferedReader buffer = new BufferedReader(new InputStreamReader(isResponseData, "UTF-8"));
			    StringBuilder sb = new StringBuilder();
			    String responseString;
			    while(true )
			    {
			    	responseString = buffer.readLine();
			        if(responseString==null || responseString.length()==0)
			            break;
			        sb.append(responseString);
			
			    }
			    buffer.close();
			    isResponseData.close();
			    
			    return responseString;
				
				
				}catch (Exception e){
					e.printStackTrace();
				}
				//Test for branch
		return null;
					
				}

}
