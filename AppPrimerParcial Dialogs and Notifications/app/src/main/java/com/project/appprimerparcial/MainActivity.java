package com.project.appprimerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTopic3, btnTopic4, btnTopic6, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTopic3 = findViewById(R.id.btnTopic3);
        btnTopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frmUsuario = new Intent(getApplicationContext(), FrmUsuarioActivity.class);
                startActivity(frmUsuario);
            }
        });

        btnTopic4 = findViewById(R.id.btnTopic4);
        btnTopic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frmRateStars = new Intent(getApplicationContext(), RateStarsActivity.class);
                startActivity(frmRateStars);
            }
        });

        btnTopic6 = findViewById(R.id.btnTopic6);
        btnTopic6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frmDialogNotification = new Intent(getApplicationContext(), DialogNitificationActivity.class);
                startActivity(frmDialogNotification);
            }
        });

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}