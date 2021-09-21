package br.com.mariojp.mobile.applicationbes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton adicionar;
    private List tarefas;
    private TarefaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_list_tarefas);

        adicionar = findViewById(R.id.main_fab_adicionar);

        tarefas = carregaTarefas();

        // MVC
        //ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , tarefas);
        adapter = new TarefaAdapter(this, tarefas);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tarefa tarefa = (Tarefa) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, tarefa.toString(), Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Tarefa Completa", Toast.LENGTH_LONG).show();
                Tarefa tarefa = (Tarefa) parent.getItemAtPosition(position);
                tarefa.setCompleta(true);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    public void adicionar(View view){
        Tarefa tarefa = new Tarefa("Tarefa Nova");
        tarefas.add(tarefa);
        adapter.notifyDataSetChanged();
    }

    @NonNull
    private List<Tarefa> carregaTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            Tarefa tarefa = new Tarefa("Tarefa "+i);
            tarefas.add(tarefa);
        }
        return tarefas;
    }


}