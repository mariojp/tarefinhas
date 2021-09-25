package br.com.mariojp.mobile.applicationbes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    public static final int REQUEST_CODE = 1;
    public static final String TAREFA = "TAREFA";
    private ListView listView;
    private FloatingActionButton adicionar;
    private List<Tarefa> tarefas = new ArrayList<>();
    private TarefaAdapter adapter;
    private ActivityResultLauncher<Intent> novaTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_list_tarefas);

        adicionar = findViewById(R.id.main_fab_adicionar);

        novaTarefa = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                                Tarefa tarefa = (Tarefa) result.getData().getSerializableExtra(TAREFA);
                                tarefas.add(tarefa);
                                adapter.notifyDataSetChanged();
                            }
                        }
                }
        );

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
        Intent intent = new Intent(this,FormActivity.class);
        novaTarefa.launch(intent);

        //startActivityForResult(intent, REQUEST_CODE);
//        Tarefa tarefa = new Tarefa("Tarefa Nova");
//        tarefas.add(tarefa);
//        adapter.notifyDataSetChanged();
    }


}