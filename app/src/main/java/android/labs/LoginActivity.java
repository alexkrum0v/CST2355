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
    Button button = (Button) findViewById(R.id.button2);
    EditText editText = (EditText) findViewById(R.id.plain_text_input1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"onCreate()");
        final SharedPreferences sharedP = getSharedPreferences("LogFile",MODE_PRIVATE);
        sharedP.edit().putString("DefaultMail", "email@domain.com");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(sharedP.getString("DefaultMail", "email@domain.com"));
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
