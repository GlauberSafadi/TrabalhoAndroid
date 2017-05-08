package com.example.glauber.atv_02;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Tela2Activity extends AppCompatActivity {

    Button btn_voltar, btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        final Intent intent = getIntent();

        btn_voltar = (Button) findViewById(R.id.btn_voltar);
        btn_save = (Button) findViewById(R.id.btn_save);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent();

                EditText et_nome = (EditText) findViewById(R.id.et_nome);
                EditText et_telefone = (EditText) findViewById(R.id.et_telefone);
                EditText et_rua = (EditText) findViewById(R.id.et_rua);
                EditText et_site = (EditText) findViewById(R.id.et_site);
                EditText et_nota = (EditText) findViewById(R.id.et_nota);

                Bundle params = new Bundle();
                params.putString("nomeKey", et_nome.getText().toString());
                params.putString("telefoneKey", et_telefone.getText().toString());
                params.putString("ruaKey", et_rua.getText().toString());
                params.putString("siteKey", et_site.getText().toString());
                params.putInt("notaKey", Integer.parseInt(et_nota.getText().toString()));

                intent1.putExtras(params);
                setResult(1, intent1);
                finish();
            }
        });

    }
}
