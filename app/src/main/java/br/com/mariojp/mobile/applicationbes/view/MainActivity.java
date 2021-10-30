package br.com.mariojp.mobile.applicationbes.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.mariojp.mobile.applicationbes.R;
import br.com.mariojp.mobile.applicationbes.model.Tarefa;
import br.com.mariojp.mobile.applicationbes.persistencia.BancoDados;
import br.com.mariojp.mobile.applicationbes.persistencia.BancoDadosRoom;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    public static final String TAREFA = "TAREFA";
    private RecyclerView listView;
    private RecyclerView listView2;

    private FloatingActionButton adicionar;
    private List<Tarefa> tarefas = new ArrayList<>();
    private CustomAdapter adapter;

    private ActivityResultLauncher<Intent> novaTarefa;

    private BancoDados bancoDados;
    private BancoDadosRoom db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bancoDados = new BancoDados(this);

        db = Room.databaseBuilder(this, BancoDadosRoom.class,
                "banco.db")
                .allowMainThreadQueries()
                .build();

        tarefas = db.tarefaRoomDao().findAll();

        listView = findViewById(R.id.main_list_tarefas);



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
        adapter = new CustomAdapter(tarefas);

        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));



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
        db.tarefaRoomDao().insert(nova);
        tarefas.clear();
        tarefas.addAll(db.tarefaRoomDao().findAll());
        adapter.notifyDataSetChanged();
//        Intent intent = new Intent(this,FormActivity.class);
//        novaTarefa.launch(intent);

        //startActivityForResult(intent, REQUEST_CODE);
//        Tarefa tarefa = new Tarefa("Tarefa Nova");
//        tarefas.add(tarefa);
//        adapter.notifyDataSetChanged();
    }


}