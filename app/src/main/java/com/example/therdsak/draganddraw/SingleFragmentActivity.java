package com.example.therdsak.draganddraw;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.alone_fragment);

        if(fragment == null){
            fragment = onCreateFragment();

            fm.beginTransaction().add(R.id.alone_fragment,fragment).commit();
        }
    }

 protected abstract Fragment onCreateFragment();
}
