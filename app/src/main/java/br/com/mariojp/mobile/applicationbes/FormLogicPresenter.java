package br.com.mariojp.mobile.applicationbes;

import android.content.Context;

import br.com.mariojp.mobile.applicationbes.model.Tarefa;
import br.com.mariojp.mobile.applicationbes.persistencia.BancoDados;
import br.com.mariojp.mobile.applicationbes.view.LogicPresenter;

public class FormLogicPresenter implements LogicPresenter {

    private Context context;

    public FormLogicPresenter(Context context) {
        this.context = context;
    }

    public Tarefa salvar(String valor_descricao, String valor_titulo) {
        Tarefa tarefa = new Tarefa(valor_titulo,valor_descricao);
        BancoDados.getInstance(context).tarefaDao().insert(tarefa);
        return tarefa;
    }
}
