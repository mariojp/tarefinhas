package br.com.mariojp.mobile.applicationbes;

import br.com.mariojp.mobile.applicationbes.api.WebService;
import br.com.mariojp.mobile.applicationbes.model.Tarefa;
import br.com.mariojp.mobile.applicationbes.persistencia.TarefaDao;

public class Repository {

    private TarefaDao tarefaDao;


    public Repository(TarefaDao dao){
        this.tarefaDao = dao;
    }

}
