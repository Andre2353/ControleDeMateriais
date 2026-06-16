package com.biolab.controledemateriasis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categorias {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nomedacategoria;
    private String descricao;

    public Categorias() {
    }

    public Categorias(String nomedacategoria, String descricao) {
        this.nomedacategoria = nomedacategoria;
        this.descricao = descricao;
    }

    public Categorias(long idcategoria, String nomedacategoria, String descricao) {
        this.Id = idcategoria;
        this.nomedacategoria = nomedacategoria;
        this.descricao = descricao;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getNomedacategoria() {
        return nomedacategoria;
    }

    public void setNomedacategoria(String nomedacategoria) {
        this.nomedacategoria = nomedacategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
