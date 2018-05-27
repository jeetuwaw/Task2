package com.home.task.listeners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.home.task.Utils.Constants;
import com.home.task.jobs.DisplayResultJob;


public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    private final TextView textView;
    private final Context mContext;

    public CustomOnItemSelectedListener(Context context, TextView textView) {
        this.mContext = context;
        this.textView = textView;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
           /* Toast.makeText(parent.getExtensionContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();*/

        if (parent.getItemAtPosition(pos).toString().equals(Constants.CONTACTS_ID1)) {

            new DisplayResultJob(mContext, Constants.CONTACTS_ID1, textView).execute();


        } else if (parent.getItemAtPosition(pos).toString().equals(Constants.CONTACTS_ID2)) {
            new DisplayResultJob(mContext, Constants.CONTACTS_ID2, textView).execute();

        } else if (parent.getItemAtPosition(pos).toString().equals(Constants.CONTACTS_ID3)) {
            new DisplayResultJob(mContext, Constants.CONTACTS_ID3, textView).execute();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
