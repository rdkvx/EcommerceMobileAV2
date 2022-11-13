package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AutenVend extends AppCompatActivity {

    private Button btnLoginVend, btnCadVend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auten_vend);

        btnLoginVend = (Button) findViewById(R.id.btnLoginVend);
        btnCadVend = (Button) findViewById(R.id.btnCadVend);

        btnLoginVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnLoginVendActivity();

            }
        });

        btnCadVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCadVendActivity();

            }
        });
    }

    private void btnLoginVendActivity() {


        startActivity(new Intent(AutenVend.this, PainelV.class));
    }

    private void btnCadVendActivity() {



        startActivity(new Intent(AutenVend.this, CadVend.class));
    }


}