package com.example.glauber.avt_06.tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.glauber.avt_06.R;
import com.example.glauber.avt_06.model.Estudante;

public class Tela2_InserirActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2__inserir);

        Button btn_voltar = (Button) findViewById(R.id.btn_voltarI);
        Button btn_inserir = (Button) findViewById(R.id.btn_inserir);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_estudante_nome = (EditText) findViewById(R.id.et_estudante_nome);
                EditText et_estudante_telefone = (EditText) findViewById(R.id.et_estudante_telefone);
                EditText et_estudante_idade = (EditText) findViewById(R.id.et_estudante_idade);

                if (et_estudante_nome.getText().toString().isEmpty() || et_estudante_telefone.getText().toString().isEmpty() ||
                        et_estudante_idade.getText().toString().isEmpty()) {
                    Toast.makeText(Tela2_InserirActivity.this, R.string.txtToastEmpty, Toast.LENGTH_SHORT).show();
                } else {

                    Estudante estudante = new Estudante();
                    estudante.setNome(et_estudante_nome.getText().toString());
                    estudante.setTelefone(et_estudante_telefone.getText().toString());
                    estudante.setIdade(Integer.parseInt(et_estudante_idade.getText().toString()));

                    //Toast.makeText(Tela2_InserirActivity.this, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                    Intent intent = getIntent().putExtra("estudante", estudante);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

    }
}
