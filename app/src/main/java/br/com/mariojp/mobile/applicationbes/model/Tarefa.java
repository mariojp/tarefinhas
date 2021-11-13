package br.com.mariojp.mobile.applicationbes.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


@Entity
public class Tarefa implements Serializable{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrimaryKey
    private Long id;

    private String titulo ="";
    private String descricao ="";
    private Boolean completa = false;
    private Integer pontuacao = 0;

    @Ignore
    public Tarefa(String titulo){
        this(titulo, "Descrição da "+titulo);
    }

    @Ignore
    public Tarefa(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.pontuacao = 5;
    }

    public Tarefa() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Boolean getCompleta() {
        return completa;
    }

    public void setCompleta(Boolean completa) {
        this.completa = completa;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", completa=" + completa +
                ", pontuacao=" + pontuacao +
                '}';
    }



}
