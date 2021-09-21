package br.com.mariojp.mobile.applicationbes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TarefaAdapter extends BaseAdapter {

    List<Tarefa> dados;
    Context contexto;

    public TarefaAdapter(Context contexto, List<Tarefa> dados){
        this.dados = dados;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Tarefa getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            Log.d("Cria View", "Criando uma nova View");
            view = LayoutInflater.from(contexto).inflate(R.layout.tarefa_list_item, parent, false);
        }
        TextView titulo = view.findViewById(R.id.tarefa_item_titulo);
        TextView completa = view.findViewById(R.id.tarefa_item_completa);
        TextView pontos = view.findViewById(R.id.tarefa_item_pontuacao);

        Tarefa tarefa = dados.get(position);

        titulo.setText(tarefa.getTitulo());
        completa.setText("COMPLETA: "+ (tarefa.getCompleta()?"SIM":"NÃO") );

        pontos.setText("Pontos: "+(tarefa.getCompleta()?tarefa.getPontuacao():0)+"/"+tarefa.getPontuacao());

        return view;
    }
}
