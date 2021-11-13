package br.com.mariojp.mobile.applicationbes.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

import br.com.mariojp.mobile.applicationbes.Repository;
import br.com.mariojp.mobile.applicationbes.api.Servico;
import br.com.mariojp.mobile.applicationbes.api.WebService;
import br.com.mariojp.mobile.applicationbes.model.Tarefa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TarefaViewModel extends ViewModel {

    private Repository repository;

    private MutableLiveData<List<Tarefa>> tarefas;


    public TarefaViewModel(Repository repository){
        this.repository = repository;
    }

    public LiveData<List<Tarefa>> getTarefas(){
        if(tarefas == null){
            tarefas = new MutableLiveData<List<Tarefa>>();
            Call<List<Tarefa>> call = Servico.getInstacia().getService().listTarefas();
            call.enqueue(new Callback<List<Tarefa>>() {
                @Override
                public void onResponse(Call<List<Tarefa>> call, Response<List<Tarefa>> response) {
                    List<Tarefa> t = response.body();
                    tarefas.postValue(t);
                }

                @Override
                public void onFailure(Call<List<Tarefa>> call, Throwable t) {
                    Log.e("deu ruim", t.getMessage());
                }
            });

        }
        return tarefas;
    }

//    private void carregarTarefas(){
//        //Da internet ou do Banco
//        List<Tarefa> tempTarefa = new ArrayList<>();
//        Tarefa tarefa = new Tarefa();
//        tarefa.setTitulo("Titulo ");
//        tarefa.setDescricao("Descricao ");
//        tempTarefa.add(tarefa);
//        this.tarefas.postValue(tempTarefa);
//    }


//    public MutableLiveData<String> getUsuario(){
//        if(usuario == null){
//            usuario = new MutableLiveData<String>();
//        }
//        return usuario;
//    }

}
