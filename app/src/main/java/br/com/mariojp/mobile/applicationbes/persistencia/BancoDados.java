package br.com.mariojp.mobile.applicationbes.persistencia;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.mariojp.mobile.applicationbes.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1, exportSchema=false)
public abstract class BancoDados extends RoomDatabase {

    private static volatile BancoDados instance = null;
    public abstract TarefaDao tarefaDao();
    static final ExecutorService executor = Executors.newFixedThreadPool(4);


    public static synchronized BancoDados getInstance(Context context){
        if(instance == null){
                instance = Room.databaseBuilder(context, BancoDados.class,
                        "banco.db")
                        .build();
        }
        return instance;
    }

}
