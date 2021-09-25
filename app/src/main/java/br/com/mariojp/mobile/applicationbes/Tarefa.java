package br.com.mariojp.mobile.applicationbes;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private String titulo;
    private String descricao;
    private Boolean completa;
    private Integer pontuacao;

    public Tarefa(String titulo){
        this(titulo, "Descrição da "+titulo);
    }

    public Tarefa(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.pontuacao = 5;
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
