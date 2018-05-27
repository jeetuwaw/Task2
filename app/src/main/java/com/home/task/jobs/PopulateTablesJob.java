package com.home.task.jobs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Spinner;
import android.widget.TextView;

import com.home.task.daogenerator.ContactsDatabase;
import com.home.task.listeners.CustomOnItemSelectedListener;
import com.home.task.model.entities.MyAccounts;
import com.home.task.model.entities.MyContacts;
import com.home.task.model.entities.MyExtensions;

import static com.home.task.Utils.Constants.CONTACTS_ID1;
import static com.home.task.Utils.Constants.CONTACTS_ID2;
import static com.home.task.Utils.Constants.CONTACTS_ID3;
import static com.home.task.Utils.Constants.EXTENSION_CONTEXT1;
import static com.home.task.Utils.Constants.EXTENSION_CONTEXT2;
import static com.home.task.Utils.Constants.PHONECONTACT_ID1;
import static com.home.task.Utils.Constants.PHONECONTACT_ID2;
import static com.home.task.Utils.Constants.PHONECONTACT_ID3;
import static com.home.task.Utils.Constants.STAGING_ID1;
import static com.home.task.Utils.Constants.STAGING_ID2;
import static com.home.task.Utils.Constants.STAGING_ID3;
import static com.home.task.Utils.Constants.STATUS1;
import static com.home.task.Utils.Constants.STATUS2;
import static com.home.task.Utils.Constants.USER_ID1;
import static com.home.task.Utils.Constants.USER_ID2;
import static com.home.task.Utils.Constants._ID1;
import static com.home.task.Utils.Constants._ID2;
import static com.home.task.Utils.Constants._ID3;


@SuppressLint("StaticFieldLeak")
public class PopulateTablesJob extends AsyncTask<Void, Void, Boolean> {
    // only retain a weak reference to the activity
    private final Context mContext;
    private final Spinner mSpinner;
    private final TextView mContactsText;


    public PopulateTablesJob(Context context, Spinner spinner, TextView contactsText){
        mContext = context;
        mSpinner = spinner;
        mContactsText = contactsText;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        MyContacts myContact1 = new MyContacts(_ID1, CONTACTS_ID1, STAGING_ID1);
        MyContacts myContact2 = new MyContacts(_ID2, CONTACTS_ID2, STAGING_ID2);
        MyContacts myContact3 = new MyContacts(_ID3, CONTACTS_ID3, STAGING_ID3);

        MyExtensions myExtensions1 = new MyExtensions(EXTENSION_CONTEXT1, PHONECONTACT_ID1);
        MyExtensions myExtensions2 = new MyExtensions(EXTENSION_CONTEXT1, PHONECONTACT_ID2);
        MyExtensions myExtensions3 = new MyExtensions(EXTENSION_CONTEXT2, PHONECONTACT_ID3);

        MyAccounts myAccounts1 = new MyAccounts(STATUS1, USER_ID1, EXTENSION_CONTEXT1);
        MyAccounts myAccounts2 = new MyAccounts(STATUS2, USER_ID2, EXTENSION_CONTEXT2);

        ContactsDatabase.getInstance(mContext).getMyDao().inserContacts(myContact1);
        ContactsDatabase.getInstance(mContext).getMyDao().inserContacts(myContact2);
        ContactsDatabase.getInstance(mContext).getMyDao().inserContacts(myContact3);
        ContactsDatabase.getInstance(mContext).getMyDao().inserExtensions(myExtensions1);
        ContactsDatabase.getInstance(mContext).getMyDao().inserExtensions(myExtensions2);
        ContactsDatabase.getInstance(mContext).getMyDao().inserExtensions(myExtensions3);
        ContactsDatabase.getInstance(mContext).getMyDao().inserAccounts(myAccounts1);
        ContactsDatabase.getInstance(mContext).getMyDao().inserAccounts(myAccounts2);

        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        com.home.task.listeners.CustomOnItemSelectedListener listener = new CustomOnItemSelectedListener(mContext, mContactsText);
        mSpinner.setOnItemSelectedListener(listener);

    }

    /*private class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
           *//* Toast.makeText(parent.getExtensionContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();*//*

            if (parent.getItemAtPosition(pos).toString().equals(Constants.CONTACTS_ID1)) {

                displayList(Constants.CONTACTS_ID1);

            } else if (parent.getItemAtPosition(pos).toString().equals(Constants.CONTACTS_ID2)) {
                displayList(Constants.CONTACTS_ID2);

            } else if (parent.getItemAtPosition(pos).toString().equals(Constants.CONTACTS_ID3)) {
                displayList(Constants.CONTACTS_ID3);

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }
    private void displayList(String s) {

        new DisplayResultJob(mContext, s, mContactsText).execute();


    }*/

}