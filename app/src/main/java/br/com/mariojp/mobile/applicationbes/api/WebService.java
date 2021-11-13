package br.com.mariojp.mobile.applicationbes.api;

import java.util.List;

import br.com.mariojp.mobile.applicationbes.model.Tarefa;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {
    @GET("ws.json")
    Call<List<Tarefa>> listTarefas();
}
