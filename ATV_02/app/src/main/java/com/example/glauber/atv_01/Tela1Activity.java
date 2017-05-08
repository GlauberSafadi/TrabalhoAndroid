package com.example.glauber.atv_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tela1Activity extends AppCompatActivity {

    Button btn_toast, btn_tela2;
    EditText et_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_tela2 = (Button) findViewById(R.id.btn_mudartela);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_toast = (EditText) findViewById(R.id.et_toast);
                Toast.makeText(Tela1Activity.this, et_toast.getText(), Toast.LENGTH_LONG).show();
            }
        });

        btn_tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela1Activity.this, Tela2Activity.class);
                startActivity(intent);
            }
        });


    }
}
