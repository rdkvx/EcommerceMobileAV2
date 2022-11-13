package com.example.javae_commerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.funcionario;
import com.example.javae_commerce.utils.constants;
import com.example.javae_commerce.utils.misc;

public class AutenVend extends AppCompatActivity {

    private Button btnLoginVend, btnCadVend;
    private EditText nomeForm;
    private EditText emailForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auten_vend);

        btnLoginVend = (Button) findViewById(R.id.btnLoginVend);
        btnCadVend = (Button) findViewById(R.id.btnCadVend);

        btnLoginVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeForm = findViewById(R.id.formNomeUsuario);
                String nome = nomeForm.getText().toString();

                emailForm = findViewById(R.id.formEmailUsuario);
                String email = emailForm.getText().toString();

                btnLoginVendActivity(nome, email);

            }
        });

        btnCadVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCadVendActivity();

            }
        });
    }

    private void btnLoginVendActivity(String nome, String email) {
        funcionario f = new funcionario();

        boolean resp = f.autenticaFuncionario(nome, email);
        if (!resp){
            misc.msgAlert(btnLoginVend.getContext(), constants.dadosInvalidos, constants.login);
        } else {
            startActivity(new Intent(AutenVend.this, PainelV.class));
        }
    }

    private void btnCadVendActivity() {



        startActivity(new Intent(AutenVend.this, CadVend.class));
    }


}