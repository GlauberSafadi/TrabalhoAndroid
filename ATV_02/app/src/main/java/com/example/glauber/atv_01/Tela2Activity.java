package com.example.glauber.atv_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    Button btn_voltar;
    TextView et_nome, et_telefone, et_rua, et_site, et_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        btn_voltar = (Button) findViewById(R.id.btn_voltar);
        et_nome = (TextView) findViewById(R.id.txt_nome);
        et_telefone = (TextView) findViewById(R.id.txt_telefone);
        et_rua = (TextView) findViewById(R.id.txt_rua);
        et_site = (TextView) findViewById(R.id.txt_site);
        et_nota = (TextView) findViewById(R.id.txt_nota);

        Estudante estudante = new Estudante("Glauber", "33355232", "Faustino Porto", "www.glaub.com", 5);
        et_nome.setText(estudante.getNome().toString());
        et_telefone.setText(estudante.getTelefone().toString());
        et_rua.setText(estudante.getRua().toString());
        et_site.setText(estudante.getSite().toString());
        et_nota.setText(String.valueOf(estudante.getNota()));
        
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
