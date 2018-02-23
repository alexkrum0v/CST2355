package android.labs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    protected static final String MAIL = "DefaultMail";
    Button btnLogin;
    EditText email;
    SharedPreferences sharedP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"onCreate()");

        email = findViewById (R.id.email);
        btnLogin = findViewById(R.id.btnLogin);

        sharedP = getSharedPreferences("LogFile",MODE_PRIVATE);

        email.setText(sharedP.getString(MAIL, "email@domain.com"));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEmail();
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
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

    private void saveEmail(){
        Log.i(ACTIVITY_NAME,"saveEmail");
        String savedUserName = email.getText().toString();
        SharedPreferences.Editor editor = sharedP.edit().putString(MAIL, savedUserName);
        editor.apply();
    }
}
