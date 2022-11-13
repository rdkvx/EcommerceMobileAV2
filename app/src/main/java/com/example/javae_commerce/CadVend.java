package com.example.javae_commerce;

import static com.example.javae_commerce.MainActivity.funcionarios;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javae_commerce.Entities.funcionario;
import com.example.javae_commerce.utils.constants;
import com.example.javae_commerce.utils.misc;

public class CadVend extends AppCompatActivity {

    private Button btnCadVend;
    private EditText nomeForm;
    private EditText emailForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_vend);

        btnCadVend = (Button) findViewById(R.id.btnCadVend);

        btnCadVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeForm = findViewById(R.id.formCadastroNmUsuario);
                String nome = nomeForm.getText().toString();

                emailForm = findViewById(R.id.formCadastroEmailUsuario);
                String email = emailForm.getText().toString();

                btnCadVendActivity(nome, email);
            }
        });
    }

    private void btnCadVendActivity(String nome, String email) {
        funcionario f = new funcionario();

        String response = f.validaFuncionario(nome, email);

        if(response != constants.cadastroValidado){

            misc.msgAlert(btnCadVend.getContext(), response, constants.cadastroMenu);

        } else {
            f.setNome(nome.toLowerCase());
            f.setEmail(email.toLowerCase());

            funcionarios.add(f);

            misc.msgAlert(btnCadVend.getContext(), constants.cadastroConcluido, constants.cadastroMenu);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent( CadVend.this, AutenVend.class));
                }
            }, constants.timeout);
        }
    }
}