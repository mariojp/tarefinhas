package br.com.mariojp.mobile.applicationbes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

import br.com.mariojp.mobile.applicationbes.FormLogicPresenter;
import br.com.mariojp.mobile.applicationbes.R;

public class FormActivity<T extends LogicPresenter> extends AppCompatActivity {

    private TextInputLayout titulo;
    private TextInputLayout descricao;


    private T presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = (T) new FormLogicPresenter(this);
        setContentView(R.layout.activity_form);
        setTitle("Criar Tarefa");
        titulo = findViewById(R.id.form_input_title);
        descricao = findViewById(R.id.form_input_description);

    }

    public void salvar(View v){
        Intent data = getIntent();
        String valor_titulo = titulo.getEditText().getText().toString();
        String valor_descricao = descricao.getEditText().getText().toString();
        Serializable model = presenter.salvar(valor_descricao, valor_titulo);
        data.putExtra(MainActivity.TAREFA,model);
        setResult(RESULT_OK,data);
        finish();
    }

    public void cancelar(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}