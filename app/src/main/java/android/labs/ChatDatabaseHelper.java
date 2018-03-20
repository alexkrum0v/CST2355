package android.labs;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

/**
 * Created by Aleksandar Krumov on 2018-02-22.
 */

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Messages.db";
    public static final int VERSION_NUM = 2;
    public static final String TABLE_NAME = "ChatHist";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_ID = "ID";

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_MESSAGE + " text);");
        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) // newVer > oldVer
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //delete any existing data
        onCreate(db);

        Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" + oldVer + " newVersion=" + newVer);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVer, int newVer) // newVer < oldVer
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //delete any existing data
        onCreate(db);
    }
}
