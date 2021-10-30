package br.com.mariojp.mobile.applicationbes.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDados extends SQLiteOpenHelper {

    public static final String BANCO_DE_DADOS_NOME = "Tarefas.db";
    public static final int BANCO_DE_DADOS_VERSAO = 2;

    private static final String SQL_CRIAR_TABELA = "CREATE TABLE TAREFAS (" +
            "_ID INTEGER PRIMARY KEY," +
            "TITULO TEXT," +
            "DESCRICAO TEXT," +
            "COMPLETA BOOLEAN," +
            "PONTUACAO INTEGER," +
            "CAMPO1 INTEGER," +
            "CAMPO2 INTEGER" +
            ")";
    private static final String SQL_APAGAR_TABELA = "DROP TABLE IF EXISTS TAREFAS";

    private static final String SQL_VERSAO_2 = "ALTER TABLE TAREFAS ADD CAMPO1 INTEGER";

    private static final String SQL_VERSAO_3 = "ALTER TABLE TAREFAS ADD CAMPO2 INTEGER";


    //INSTALANDO O APP
    //Criar o arquivo Tarefas.db
    //onCreate

    public BancoDados(Context context){
        super(context,BANCO_DE_DADOS_NOME,null,BANCO_DE_DADOS_VERSAO);
    }

    //Na instalação
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRIAR_TABELA);
    }

    //if vesão intalada 1 < version atualizacao 3
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){
            case 1:
                db.execSQL(SQL_VERSAO_2);
            case 2:
                db.execSQL(SQL_VERSAO_3);
        }

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //url
    //usuario
    //senha
    //driver
}
