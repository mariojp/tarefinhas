package br.com.mariojp.mobile.applicationbes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Tarefa> dados;

    public CustomAdapter(List<Tarefa> dados){
        this.dados = dados;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarefa_list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Tarefa tarefa = dados.get(position);
        holder.getTitulo().setText(tarefa.getTitulo());
        holder.getCompleta().setText("COMPLETA: "+ (tarefa.getCompleta()?"SIM":"NÃO") );
        holder.getPontos().setText("Pontos: "+(tarefa.getCompleta()?tarefa.getPontuacao():0)+"/"+tarefa.getPontuacao());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private final TextView titulo;
        private final TextView completa;
        private final TextView pontos;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            titulo = view.findViewById(R.id.tarefa_item_titulo);
            completa = view.findViewById(R.id.tarefa_item_completa);
            pontos = view.findViewById(R.id.tarefa_item_pontuacao);
        }

        public TextView getTitulo() {
            return titulo;
        }

        public TextView getCompleta() {
            return completa;
        }

        public TextView getPontos() {
            return pontos;
        }




    }

}
