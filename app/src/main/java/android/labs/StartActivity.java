package android.labs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"onCreate()");
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
