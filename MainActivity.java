package com.example.backablefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        SimpleFragment simpleFragment = new SimpleFragment();
        fragmentTransaction.add(R.id.fragment_container, simpleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        boolean handled = false;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment fragment: fragments) {
            if (fragment instanceof Backable) {
                handled = ((Backable)fragment).onBackPressed();
            }
        }
        if (!handled) super.onBackPressed();
    }
}
