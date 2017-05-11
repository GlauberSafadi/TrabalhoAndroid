package com.example.glauber.avt_06.tela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.glauber.avt_06.R;
import com.example.glauber.avt_06.dao.EstudanteDAO;

public class Tela3_RemoverActivity extends AppCompatActivity {

    EstudanteDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3__remover);

        Button btn_voltar = (Button) findViewById(R.id.btn_voltarR);
        Button btn_remover = (Button) findViewById(R.id.btn_remover);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_estudante_nomeR = (EditText) findViewById(R.id.et_estudante_nomeR);
                if (et_estudante_nomeR.getText().toString().isEmpty()) {
                    Toast.makeText(Tela3_RemoverActivity.this, R.string.toastRemover, Toast.LENGTH_SHORT).show();
                } else {
                    dao = new EstudanteDAO(Tela3_RemoverActivity.this);
                    dao.removerEstudante(et_estudante_nomeR.getText().toString());
                    finish();
                }
            }
        });

    }
}
