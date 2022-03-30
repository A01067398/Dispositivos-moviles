package com.project.appprimerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTopic3, btnClose;

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

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}