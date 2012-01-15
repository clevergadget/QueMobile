package plchldr.quemobile;


import java.io.IOException;

import org.apache.http.ParseException;


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

					try {
						if(UserProxy.checkLogin(username.getText().toString(), password.getText().toString()))
						{
							String holler = UserProxy.getQuestionsForUser("4");
							String yup;
						}
						else
						{

						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};

					



			
			}
        });
    }
}