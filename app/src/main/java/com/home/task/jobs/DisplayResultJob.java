package com.home.task.jobs;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.home.task.daogenerator.ContactsDatabase;




@SuppressLint("StaticFieldLeak")
public class DisplayResultJob extends AsyncTask<Void, Void, String> {

    private final Context mContext;
    private final String mColumnInfo;
    private final TextView mContactsText;
    private static ProgressDialog mProgress;
    public DisplayResultJob(Context context, String columnInfo, TextView contactsText){
        mContext = context;
        mColumnInfo = columnInfo;
        mContactsText = contactsText;
        mProgress = new ProgressDialog(mContext);
        mProgress.setCancelable(true);
        mProgress.setMessage("Please wait....");
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgress.show();
    }

    @Override
    protected String doInBackground(Void... voids) {

        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(mContext);
        Cursor c = contactsDatabase.getMyDao().diaplayData(mColumnInfo);
        Log.e("Count()", String.valueOf(c.getCount()));
        if (c.getCount() > 0) {
            if(c.moveToNext()) {
                return c.getString(0) + ", " + c.getString(1)+", "+c.getString(2) + ", " + c.getString(3);
            }
            c.close();
        }


        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mContactsText.setText(s);
        mProgress.dismiss();
    }
}
