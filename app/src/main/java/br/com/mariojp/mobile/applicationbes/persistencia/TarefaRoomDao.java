package br.com.mariojp.mobile.applicationbes.persistencia;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.mariojp.mobile.applicationbes.model.Tarefa;

@Dao
public interface TarefaRoomDao {


    @Insert
    public void insert(Tarefa tarefa);

    @Query("SELECT * FROM Tarefa")
    public List<Tarefa> findAll();

}
