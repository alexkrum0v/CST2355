package android.labs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;


public class ListItemsActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    private static  final int captureRequested = 1;
    ImageView imageViewButton;
    Switch switchToggle;
    CheckBox checkBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"onCreate()");
        imageViewButton =  (ImageButton) findViewById(R.id.imageButton);
        switchToggle = findViewById(R.id.switch1);
        checkBox = findViewById(R.id.Checkbox);

        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent cameraIntent  = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null){
                startActivityForResult(cameraIntent, captureRequested);
            }
            }
        });

    switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            CharSequence on = "Switch is On";
            CharSequence off = "Switch is off";

            int durationL = Toast.LENGTH_LONG;
            /* = Toast.LENGTH_LONG if Off */
            int durationS = Toast.LENGTH_SHORT;

            if (checked){
                Toast toast = Toast.makeText(getApplicationContext() , on, durationS); //this is the ListActivity
                toast.show();
                /* display your message box */
            }else {
                Toast toast = Toast.makeText(getApplicationContext(), off, durationL); //this is the ListActivity
                toast.show();
                /* display your message box */
            }
        }
    });

    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
            if (checked){
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(R.string.dialogMessage) //Add a dialog message to strings.xml
                        .setTitle(R.string.dialogTitle)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                Intent intentOK = new Intent();
                                intentOK.putExtra("Response", "Here is my response");
                                setResult(Activity.RESULT_OK, intentOK);
                                finish();

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        })
                        .show();
            }
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
