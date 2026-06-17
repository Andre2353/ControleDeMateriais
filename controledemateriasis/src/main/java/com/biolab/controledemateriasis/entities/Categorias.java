package com.biolab.controledemateriasis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomedacategoria;
    private String descricao;

    public Categorias() {
    }

    public Categorias(String nomedacategoria, String descricao) {
        this.nomedacategoria = nomedacategoria;
        this.descricao = descricao;
    }

    public Categorias(long idcategoria, String nomedacategoria, String descricao) {
        this.id = idcategoria;
        this.nomedacategoria = nomedacategoria;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
