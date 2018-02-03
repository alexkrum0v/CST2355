package android.labs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    Button button2;
    EditText email;
    SharedPreferences sharedP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"onCreate()");

        email = findViewById (R.id.email);
        button2 = findViewById(R.id.button2);
        sharedP = getSharedPreferences("LogFile",MODE_PRIVATE);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email.setText(sharedP.getString("DefaultMail", "email@domain.com"));
                sharedP.edit().putString("DefaultMail", "email@domain.com");
                sharedP.edit().commit();
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume()");
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "onStart()");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "onPause()");
}
    @Override
    public void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "onStop()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "onDestroy()");
    }
}
