package com.example.glauber.avt_06.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.glauber.avt_06.model.Estudante;

import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO extends SQLiteOpenHelper {


    public EstudanteDAO(Context context) {
        super(context, "ATV_06", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE estudante (nome_estudante TEXT NOT NULL, telefone_estudante TEXT NOT NULL, " +
                "idade_estudante INTEGER NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS estudante";
        db.execSQL(sql);
        onCreate(db);
    }

    //Inserir Estudante
    public void inserirEstudante(Estudante estudante) {
        String sql = "INSERT INTO estudante (nome_estudante, telefone_estudante, idade_estudante)" +
                "VALUES ('" + estudante.getNome() + "', '" + estudante.getTelefone() + "', '" +
                estudante.getIdade() + "');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //Selecionar Todos Estudantes
    public List<Estudante> listarEstudantes() {
        String sql = "SELECT * FROM estudante;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Estudante> estudantes_lista = new ArrayList<Estudante>();

        while (cursor.moveToNext()) {
            Estudante estudante = new Estudante();
            estudante.setNome(cursor.getString(cursor.getColumnIndex("nome_estudante")));
            estudante.setTelefone(cursor.getString(cursor.getColumnIndex("telefone_estudante")));
            estudante.setIdade(cursor.getInt(cursor.getColumnIndex("idade_estudante")));
            estudantes_lista.add(estudante);
        }

        db.close();
        return estudantes_lista;
    }

    //Remover um Estudante pelo NOME
    public void removerEstudante(String estudante_nome) {
        this.getWritableDatabase().delete("estudante", "nome_estudante = '" + estudante_nome + "'", null);
    }

    //Atualizar o NOME do Estudante
    public void atualizarNomeEstudante(String nome_velho, String nome_novo) {
        this.getWritableDatabase().execSQL("UPDATE estudante SET nome_estudante = '" + nome_novo + "' WHERE nome_estudante = '"
                + nome_velho + "';");
    }

}
