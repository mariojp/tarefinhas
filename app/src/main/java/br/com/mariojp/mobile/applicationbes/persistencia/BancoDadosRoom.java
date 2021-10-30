package br.com.mariojp.mobile.applicationbes.persistencia;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.mariojp.mobile.applicationbes.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1, exportSchema=false)
public abstract class BancoDadosRoom extends RoomDatabase {

    public abstract TarefaRoomDao tarefaRoomDao();

}
