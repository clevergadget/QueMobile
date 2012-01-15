package plchldr.quemobile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QueMobileActivity extends Activity {
	EditText username;
	EditText password;
	Button submit;
	TextView responsetext;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        responsetext = (TextView) findViewById(R.id.response);
        submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				try{
					DefaultHttpClient client = new DefaultHttpClient();
					HttpPost loginPost = new HttpPost("http://www.scope-resolution.org/que/login.php");
					List postValues = new ArrayList();
					postValues.add(new BasicNameValuePair("username", username.getText().toString()));
					postValues.add(new BasicNameValuePair("password", password.getText().toString()));
					UrlEncodedFormEntity loginForm = new UrlEncodedFormEntity(postValues, HTTP.UTF_8);
					loginPost.setEntity(loginForm);
					HttpResponse response=client.execute(loginPost);
					InputStream isResponseData = response.getEntity().getContent();
					InputStreamReader reader = new InputStreamReader(isResponseData);
					BufferedReader buffer = new BufferedReader(reader);
					StringBuilder stringBuilder = new StringBuilder();
					String currentLine = "";
					while ( (currentLine=buffer.readLine()) != null) {
						stringBuilder.append(currentLine + "\n");
					}
					responsetext.setText(stringBuilder.toString());
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
        	
        });
    }
}