package br.com.mariojp.mobile.applicationbes.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.applicationbes.Repository;
import br.com.mariojp.mobile.applicationbes.model.Tarefa;

public class TarefaViewModel extends ViewModel {

    private Repository repository;

    private MutableLiveData<List<Tarefa>> tarefas;


    public TarefaViewModel(Repository repository){
        this.repository = repository;
    }

    public LiveData<List<Tarefa>> getTarefas(){
        if(tarefas == null){
            tarefas = new MutableLiveData<List<Tarefa>>();
            carregarTarefas();
        }
        return tarefas;
    }

    private void carregarTarefas(){
        //Da internet ou do Banco
        List<Tarefa> tempTarefa = new ArrayList<>();
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Titulo ");
        tarefa.setDescricao("Descricao ");
        tempTarefa.add(tarefa);
        this.tarefas.postValue(tempTarefa);
    }


//    public MutableLiveData<String> getUsuario(){
//        if(usuario == null){
//            usuario = new MutableLiveData<String>();
//        }
//        return usuario;
//    }

}
