package com.example.backablefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment implements Backable {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getContext(), "You clicked the back button", Toast.LENGTH_SHORT).show();
        return true;
    }
}
