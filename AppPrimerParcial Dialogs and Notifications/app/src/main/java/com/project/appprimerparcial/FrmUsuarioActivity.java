package com.project.appprimerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FrmUsuarioActivity extends AppCompatActivity {

    private EditText txtNombres, txtApellidos, txtCorreo;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_usuario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtCorreo = findViewById(R.id.txtCorreo);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

    }

    private boolean validateForm(){
        if(txtNombres.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Los nombres son requeridos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtApellidos.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Los apellidos son requeridos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtCorreo.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "El correo es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void registrar(){
        if(validateForm()){

            String information = "Nombres:\n" + txtNombres.getText().toString() +
                    "\n\nApellidos:\n" + txtApellidos.getText().toString() +
                    "\n\nCorreo:\n" + txtCorreo.getText().toString();

            Intent frmInformation = new Intent(getApplicationContext(), InformationActivity.class);
            frmInformation.putExtra("information", information);
            startActivity(frmInformation);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }
}