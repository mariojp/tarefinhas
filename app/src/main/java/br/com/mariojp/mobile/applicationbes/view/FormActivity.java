package br.com.mariojp.mobile.applicationbes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import br.com.mariojp.mobile.applicationbes.R;
import br.com.mariojp.mobile.applicationbes.model.Tarefa;

public class FormActivity extends AppCompatActivity {

    private TextInputLayout titulo;
    private TextInputLayout descricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("Criar Tarefa");
        titulo = findViewById(R.id.form_input_title);
        descricao = findViewById(R.id.form_input_description);

    }

    public void salvar(View v){
        Intent data = getIntent();
        String valor_titulo = titulo.getEditText().getText().toString();
        String valor_descricao = descricao.getEditText().getText().toString();
        Tarefa tarefa = new Tarefa(valor_titulo,valor_descricao);
        data.putExtra(MainActivity.TAREFA,tarefa);
        setResult(RESULT_OK,data);
        finish();
    }

    public void cancelar(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}