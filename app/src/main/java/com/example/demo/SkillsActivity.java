package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SkillsActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        ImageView arrow = findViewById(R.id.arrow);
        arrow.setOnClickListener(view -> {
            Intent intent = new Intent(SkillsActivity.this, AboutActivity.class);
            startActivity(intent);
        });
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.view_pager);

        adapter = new MainAdapter(getSupportFragmentManager());
        adapter.AddFragment(new FrontEnd(), "FrontEnd");
        adapter.AddFragment(new BackEnd(), "BackEnd");
        adapter.AddFragment(new Database(), "Database");
        adapter.AddFragment(new Other(), "Other");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(R.drawable.bottom_button_after));
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.about:
                    startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.skills:

                    return true;
                case R.id.certification:
                    startActivity(new Intent(getApplicationContext(), Certification.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }

    private static class MainAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        public void AddFragment(Fragment fragment, String s) {
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringArrayList.get(position);
        }
    }
}