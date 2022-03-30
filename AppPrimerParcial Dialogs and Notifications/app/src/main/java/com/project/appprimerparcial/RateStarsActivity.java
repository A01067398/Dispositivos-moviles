package com.project.appprimerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateStarsActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnCalificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_stars);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ratingBar = findViewById(R.id.ratingBar);

        btnCalificar = findViewById(R.id.btnCalificar);
        btnCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float stars = ratingBar.getRating();
                Toast.makeText(getApplicationContext(), "Calificaste con " + stars + " estrellas", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }
}