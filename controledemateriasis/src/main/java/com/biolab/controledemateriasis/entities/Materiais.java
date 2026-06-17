package com.biolab.controledemateriasis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "materiais")
public class Materiais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categorias categorias;
    private String nomedomaterial;
    private String unidadeeMedida;
    private double valorUnitario;
    private Integer quantidade;
    private Integer valorMinimo;
    private Integer valorMaximo;

    public Materiais() {
    }

    public Materiais(Categorias categorias, String nomedomaterial, String unidadeeMedida, double valorUnitario, Integer quantidade, Integer valorMinimo, Integer valorMaximo) {
        this.categorias = categorias;
        this.nomedomaterial = nomedomaterial;
        this.unidadeeMedida = unidadeeMedida;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
    }

    public Materiais(Long id, Categorias categorias, String nomedomaterial, String unidadeeMedida, double valorUnitario, Integer quantidade, Integer valorMinimo, Integer valorMaximo) {
        this.id = id;
        this.categorias = categorias;
        this.nomedomaterial = nomedomaterial;
        this.unidadeeMedida = unidadeeMedida;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorMinimo = valorMinimo;
        this.valorMaximo = valorMaximo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public String getNomedomaterial() {
        return nomedomaterial;
    }

    public void setNomedomaterial(String nomedomaterial) {
        this.nomedomaterial = nomedomaterial;
    }

    public String getUnidadeeMedida() {
        return unidadeeMedida;
    }

    public void setUnidadeeMedida(String unidadeeMedida) {
        this.unidadeeMedida = unidadeeMedida;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Integer valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Integer getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Integer valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
}
