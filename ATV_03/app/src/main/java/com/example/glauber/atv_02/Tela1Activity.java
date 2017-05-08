package com.example.glauber.atv_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Tela1Activity extends AppCompatActivity {

    ListView lv_students;
    Button btn_new;
    public static final int CONST_TELA_1 = 1;
    ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        btn_new = (Button) findViewById(R.id.btn_new_student);

        btn_new.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela1Activity.this, Tela2Activity.class);
                startActivityForResult(intent, CONST_TELA_1);
            }
        });

    }

    protected void onActivityResult(int codigoTela, int resultado, Intent intent) {

        if (codigoTela == CONST_TELA_1) {
            Bundle params = intent.getExtras();

            if (params != null) {

                Student student = new Student();
                student.setName(params.getString("nomeKey"));
                student.setPhone(params.getString("telefoneKey"));
                student.setStreet(params.getString("ruaKey"));
                student.setSite(params.getString("siteKey"));
                student.setGrade(params.getInt("notaKey"));
                
                studentsList.add(student);
                lv_students = (ListView) findViewById(R.id.lv_students);
                lv_students.setAdapter(new StudentAdapter(this, studentsList));

                lv_students.setOnItemClickListener(eventoClick(student));

            }
        }

    }

    //só pra testar se tá vindo o objeto completo
    public AdapterView.OnItemClickListener eventoClick(final Student student) {
        return (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;

                switch (position) {
                    case 0:
                        Toast.makeText(Tela1Activity.this, "Nome: " + student.getName() + "\nTelefone: " + student.getPhone()
                                        + "\nRua: " + student.getStreet() + "\nSite: " + student.getSite() + "\nNota: " + student.getGrade(),
                                Toast.LENGTH_SHORT).show();
                    case 1:
                        Toast.makeText(Tela1Activity.this, "Nome: " + student.getName() + "\nTelefone: " + student.getPhone()
                                        + "\nRua: " + student.getStreet() + "\nSite: " + student.getSite() + "\nNota: " + student.getGrade(),
                                Toast.LENGTH_SHORT).show();
                    case 3:
                        Toast.makeText(Tela1Activity.this, "Nome: " + student.getName() + "\nTelefone: " + student.getPhone()
                                        + "\nRua: " + student.getStreet() + "\nSite: " + student.getSite() + "\nNota: " + student.getGrade(),
                                Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


}
