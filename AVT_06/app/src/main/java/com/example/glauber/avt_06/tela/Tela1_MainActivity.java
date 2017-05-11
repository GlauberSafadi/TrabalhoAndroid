package com.example.glauber.avt_06.tela;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.glauber.avt_06.R;
import com.example.glauber.avt_06.dao.EstudanteDAO;
import com.example.glauber.avt_06.model.Estudante;

import java.util.ArrayList;
import java.util.List;

public class Tela1_MainActivity extends AppCompatActivity {

    public static final int CONST_TELA_1 = 1;
    List<Estudante> estudantes_lista = new ArrayList<>();
    private ArrayAdapter<String> adapter; //temporario
    private ListView lv_estudantes;
    private Button btn_inserir, btn_remover;
    EstudanteDAO dao = new EstudanteDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_main);

        btn_inserir = (Button) findViewById(R.id.btn_tela_inserir);
        btn_remover = (Button) findViewById(R.id.btn_tela_deletar);
        lv_estudantes = (ListView) findViewById(R.id.lv_estudantes);

        carregarEstudantes(); //Carrega a lista na criação da tela.

        btn_inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela1_MainActivity.this, Tela2_InserirActivity.class);
                startActivityForResult(intent, CONST_TELA_1);
            }
        });

        btn_remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela1_MainActivity.this, Tela3_RemoverActivity.class);
                startActivityForResult(intent, CONST_TELA_1);
            }
        });

    }

    //Temporario, quero por baseadapter
    private void carregarEstudantes() {

        estudantes_lista = dao.listarEstudantes();

        List<String> studentsNames = new ArrayList<String>();

        for (Estudante estudante : estudantes_lista) {
            studentsNames.add(estudante.getNome());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, studentsNames);
        lv_estudantes.setAdapter(adapter);

        lv_estudantes.setOnItemClickListener(atualizarNome());
    }

    public AdapterView.OnItemClickListener atualizarNome() {
        return (new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                //faltou o atualizar

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        carregarEstudantes();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CONST_TELA_1) {
                Estudante estudante = (Estudante) data.getSerializableExtra("estudante");
                EstudanteDAO dao = new EstudanteDAO(this);
                dao.inserirEstudante(estudante);

                //Toast.makeText(Tela1_MainActivity.this, estudante.getNome().toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

}
