package com.example.capi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }
    }
    private void loadFragment(Fragment fmNew){
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_frame, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
    private void addEvents(){
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                if(item.getItemId()==R.id.bottomHome){
                    fmNew = new HomeFragment();
                    loadFragment(fmNew);
                    return true;
                }

                if(item.getItemId()==R.id.bottomInformation){
                    fmNew = new InformationFragment();
                    loadFragment(fmNew);
                    return true;
                }

                if(item.getItemId()== R.id.bottomDiary){
                    fmNew = new DiaryFragment();
                    loadFragment(fmNew);
                    return true;
                }
                if(item.getItemId()==R.id.bottomSettings){
                    fmNew = new SettingFragment();
                    loadFragment(fmNew);
                    return true;
                }
                return true;
            }
        });
    }
    private void addControls(){
        bottomNav = findViewById(R.id.bottomNav);
    }
}