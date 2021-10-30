package br.com.mariojp.mobile.applicationbes.persistencia;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.applicationbes.model.Tarefa;

public class TarefaDAO {

    private BancoDados bd;

    public TarefaDAO(BancoDados bd){
        this.bd = bd;
    }

    public List<Tarefa> obterTodas(){
        Cursor cursor = bd.getReadableDatabase()
                .query("Tarefas",
                        new String[]{"_ID","TITULO","DESCRICAO"},
                        "WHERE COMPLETA = ?",
                        new String[]{"true"},
                        null,
                        null,
                        "TITULO DESC");

        List tarefasConsulta = new ArrayList<>();
        while(cursor.moveToNext()){
            Long ids = cursor.getLong(cursor.getColumnIndexOrThrow("_ID"));
            String titulo = cursor.getString(cursor.getColumnIndexOrThrow("TITULO"));
            String descricao = cursor.getString(cursor.getColumnIndexOrThrow("DESCRICAO"));
            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(titulo);
            tarefa.setTitulo(descricao);
            tarefasConsulta.add(tarefa);
        }
        return tarefasConsulta;
    }

    public Tarefa inserir(Tarefa tarefa){
        ContentValues valores = new ContentValues();
        valores.put("TITULO",tarefa.getTitulo());
        valores.put("DESCRICAO",tarefa.getDescricao());
        valores.put("COMPLETA",tarefa.getCompleta());
        valores.put("PONTUACAO",tarefa.getPontuacao());

        long id = bd.getWritableDatabase()
                .insert("TAREFAS",null,
                        valores);
        tarefa.setId(id);
        return tarefa;
    }

}
