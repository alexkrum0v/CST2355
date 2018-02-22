package android.labs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends Activity {
    protected static final String ACTIVITY_NAME = "ChatWindow";
    ListView chatView;
    EditText chatTxt;
    Button sendChtMsg;
    ArrayList<String> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_chat_window);


        chatView = (ListView) findViewById(R.id.chatListView);
        chatTxt = (EditText) findViewById(R.id.chatText);
        sendChtMsg = (Button) findViewById(R.id.sendChatMsg);

//in this case, “this” is the ChatWindow, which is-A Context object
        final ChatAdapter messageAdapter = new ChatAdapter( this );
        chatView.setAdapter (messageAdapter);

        sendChtMsg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount() & getView()

        messages.add(String.valueOf(chatTxt.getText()));

         chatTxt.setText("");
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

    private class ChatAdapter extends ArrayAdapter<String> {
        ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount() {
            return messages.size();
        }

        public String getItem(int position){
            return messages.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){
           LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result;
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView)result.findViewById(R.id.userMessage);
            message.setText(   getItem(position)  ); // get the string at position
            return result;
        }

        public long getId (int position){
            return position;
        }
    }
}
