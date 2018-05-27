package com.home.task.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.home.task.Utils.Constants;
import com.home.task.activitys.MainActivity;
import com.home.task.jobs.PopulateTablesJob;
import com.home.task.R;

import java.util.ArrayList;

@SuppressWarnings({"ALL", "ConstantConditions"})
public class MainActivityFragment extends Fragment {

    private MainActivity mActivity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_activity_main_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialiseView(view);
    }
    @SuppressLint("SetTextI18n")
    private void initialiseView(View view) {
        TextView txtContacts = view.findViewById(R.id.txtContacts);
        Spinner spinner1 = view.findViewById(R.id.spnList);

        ArrayList arrayList = new ArrayList();
        arrayList.add(Constants.CONTACTS_ID1);
        arrayList.add(Constants.CONTACTS_ID2);
        arrayList.add(Constants.CONTACTS_ID3);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mActivity,
                android.R.layout.simple_spinner_item, arrayList);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        if(dataAdapter.getItem(0).equals(Constants.CONTACTS_ID1)) {
            txtContacts.setText(Constants.STAGING_ID1 + ", " + Constants.EXTENSION_CONTEXT1 + ", " + Constants.STATUS1 + ", " + Constants.USER_ID1);
        }

        new PopulateTablesJob(mActivity, spinner1, txtContacts).execute();

    }


}
