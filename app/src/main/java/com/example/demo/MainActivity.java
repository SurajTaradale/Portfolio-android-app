package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    TextView typingName, typingPosition;
    Button personalWebsite, download, Hireme;
    CardView github, Email, instagram, linkedin;
    DownloadManager manager;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        download = findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://surajtaradale8002.web.app/static/media/CVSurajTaradale.143d6993.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                long reference = manager.enqueue(request);
            }
        });
        Hireme = findViewById(R.id.Hireme);
        Hireme.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:surajtaradale@gmail.com"));
            i.putExtra(Intent.EXTRA_SUBJECT, "Hello");
            startActivity(Intent.createChooser(i, "Send feedback"));
        });
        typingName = findViewById(R.id.typingName);
        typingPosition = findViewById(R.id.typingPosition);
        personalWebsite = findViewById(R.id.personalWebsite);
        github = findViewById(R.id.github);
        Email = findViewById(R.id.Email);
        instagram = findViewById(R.id.instagram);
        linkedin = findViewById(R.id.linkedin);
        linkedin.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.linkedin.com/in/suraj-taradale-ab124b197/");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.linkedin.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/suraj-taradale-ab124b197/")));
            }
        });
        instagram.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.instagram.com/simplecodingworld/");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/simplecodingworld/")));
            }
        });

        Email.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:surajtaradale@gmail.com"));
            i.putExtra(Intent.EXTRA_SUBJECT, "Hello");
            startActivity(Intent.createChooser(i, "Send feedback"));
        });
        github.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SurajTaradale"));
            startActivity(browserIntent);
        });

        personalWebsite.setOnClickListener(view -> {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://surajtaradale8002.web.app/"));
            startActivity(browserIntent);
        });
        new Handler().postDelayed(() -> typingPosition.setText("|"), 1000);

        new Handler().postDelayed(() -> typingPosition.setText(" "), 1200);
        new Handler().postDelayed(() -> typingPosition.setText("|"), 1400);
        new Handler().postDelayed(() -> typingPosition.setText("W"), 1700);
        new Handler().postDelayed(() -> typingPosition.append("e"), 2000);
        new Handler().postDelayed(() -> typingPosition.append("b"), 2300);
        new Handler().postDelayed(() -> typingPosition.append(" "), 2600);
        new Handler().postDelayed(() -> typingPosition.append("D"), 2800);
        new Handler().postDelayed(() -> typingPosition.append("e"), 3000);
        new Handler().postDelayed(() -> typingPosition.append("v"), 3200);
        new Handler().postDelayed(() -> typingPosition.append("e"), 3400);
        new Handler().postDelayed(() -> typingPosition.append("l"), 3600);
        new Handler().postDelayed(() -> typingPosition.append("o"), 3800);
        new Handler().postDelayed(() -> typingPosition.append("p"), 4000);
        new Handler().postDelayed(() -> typingPosition.append("e"), 4200);
        new Handler().postDelayed(() -> typingPosition.append("r"), 4400);


        //
        new Handler().postDelayed(() -> typingPosition.append(" "), 4600);

        new Handler().postDelayed(() -> typingPosition.append("a"), 4800);
        new Handler().postDelayed(() -> typingPosition.append("n"), 5000);
        new Handler().postDelayed(() -> typingPosition.append("d"), 5200);
        new Handler().postDelayed(() -> typingPosition.append(" "), 5400);
        new Handler().postDelayed(() -> typingPosition.append("W"), 5600);
        new Handler().postDelayed(() -> typingPosition.append("e"), 5800);
        new Handler().postDelayed(() -> typingPosition.append("b"), 6000);
        new Handler().postDelayed(() -> typingPosition.append(" "), 6200);
        new Handler().postDelayed(() -> typingPosition.append("D"), 6400);
        new Handler().postDelayed(() -> typingPosition.append("e"), 6600);
        new Handler().postDelayed(() -> typingPosition.append("s"), 6800);
        new Handler().postDelayed(() -> typingPosition.append("i"), 7000);
        new Handler().postDelayed(() -> typingPosition.append("g"), 7200);
        new Handler().postDelayed(() -> typingPosition.append("n"), 7400);
        new Handler().postDelayed(() -> typingPosition.append("e"), 7600);
        new Handler().postDelayed(() -> typingPosition.append("r"), 7800);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(R.drawable.bottom_button_after));
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    return true;

                case R.id.about:
                    startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.skills:
                    startActivity(new Intent(getApplicationContext(), SkillsActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.certification:
                    startActivity(new Intent(getApplicationContext(), Certification.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });

    }
}