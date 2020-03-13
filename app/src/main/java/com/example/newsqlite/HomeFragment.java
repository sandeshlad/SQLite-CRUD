package com.example.newsqlite;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private Button BnSave, BnView, BnUpdate, BnDelete;
    OnDbOpListener dbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener {
        public void dBOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        BnSave = (Button) view.findViewById(R.id.addContactButton);
        BnSave.setOnClickListener(this);

        BnView = (Button) view.findViewById(R.id.viewContactButton);
        BnView.setOnClickListener(this);

        BnUpdate = (Button) view.findViewById(R.id.udateContactButton);
        BnUpdate.setOnClickListener(this);

        BnDelete = (Button) view.findViewById(R.id.deleteContactButton);
        BnDelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addContactButton:
                dbOpListener.dBOpPerformed(0);
                break;

            case R.id.viewContactButton:
                dbOpListener.dBOpPerformed(1);
                break;

            case R.id.udateContactButton:
                dbOpListener.dBOpPerformed(2);
                break;

            case R.id.deleteContactButton:
                dbOpListener.dBOpPerformed(3);
                break;
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "Must implement the interface method...");
        }

    }
}
