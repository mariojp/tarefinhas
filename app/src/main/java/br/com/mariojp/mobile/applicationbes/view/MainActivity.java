package br.com.mariojp.mobile.applicationbes.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mariojp.mobile.applicationbes.R;
import br.com.mariojp.mobile.applicationbes.Repository;
import br.com.mariojp.mobile.applicationbes.view.viewmodel.TarefaViewModel;
import br.com.mariojp.mobile.applicationbes.model.Tarefa;
import br.com.mariojp.mobile.applicationbes.persistencia.BancoDados;
import br.com.mariojp.mobile.applicationbes.view.viewmodel.TarefaViewModelFabrica;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    public static final String TAREFA = "TAREFA";

    private FloatingActionButton adicionar;
    private RecyclerView listView;
    private CustomAdapter adapter;
    private TarefaViewModel tarefaViewModel;


    private List<Tarefa> tarefas = new ArrayList<>();

    private ActivityResultLauncher<Intent> novaTarefa;

 //   private BancoDados db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new Gson();
        Object[] t = Arrays.asList(
                new Tarefa("titulo 1","d1"),
                new Tarefa("titulo 2","d2"),
                new Tarefa("titulo 3","d3"),
                new Tarefa("titulo 4","d4")
        ).toArray();
        String json = gson.toJson(t);
        System.out.println(json);

        Repository repository = new Repository(BancoDados.getInstance(this).tarefaDao());

        TarefaViewModelFabrica fabrica = new TarefaViewModelFabrica(repository);
       
 ViewModelProvider provider = new ViewModelProvider(this, fabrica);
        tarefaViewModel = provider.get(TarefaViewModel.class);
        listView = findViewById(R.id.main_list_tarefas);
        adapter = new CustomAdapter(tarefas);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        tarefaViewModel.getTarefas().observe(this, i -> adapter.update(i));




        //   db = BancoDados.getInstance(this);

      //  tarefas = db.tarefaDao().findAll();




        adicionar = findViewById(R.id.main_fab_adicionar);



//        novaTarefa = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if(result.getResultCode() == RESULT_OK){
//                                Tarefa tarefa = (Tarefa) result.getData().getSerializableExtra(TAREFA);
//                                tarefas.add(tarefa);
//                                adapter.notifyDataSetChanged();
//                            }
//                        }
//                }
//        );

        // MVC
        //ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , tarefas);
        //adapter = new TarefaAdapter(this, tarefas);



        //listView.setLayoutManager(new GridLayoutManager(this,2));
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Tarefa tarefa = (Tarefa) parent.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, tarefa.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "Tarefa Completa", Toast.LENGTH_LONG).show();
//                Tarefa tarefa = (Tarefa) parent.getItemAtPosition(position);
//                tarefa.setCompleta(true);
//                adapter.notifyDataSetChanged();
//                return true;
//            }
//        });

    }

    public void adicionar(View view){
        Log.d("Adicionando Tarefa","Adicionando Tarefa");
        Tarefa nova = new Tarefa("Nova","descricao 2");
        //db.tarefaDao().insert(nova);
        //tarefas.clear();
        //tarefas.addAll(db.tarefaDao().findAll());
        //adapter.notifyDataSetChanged();
//        Intent intent = new Intent(this,FormActivity.class);
//        novaTarefa.launch(intent);

        //startActivityForResult(intent, REQUEST_CODE);
//        Tarefa tarefa = new Tarefa("Tarefa Nova");
//        tarefas.add(tarefa);
//        adapter.notifyDataSetChanged();
    }


}