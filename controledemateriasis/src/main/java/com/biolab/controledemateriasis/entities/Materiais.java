package com.biolab.controledemateriasis.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "materiais")
public class Materiais {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categorias categorias;
    private String nomedomaterial;
    private String unidadeeMedida;
    private double valorUnitario;
    private Integer quantidade;
    private Integer valorMinimo;
    private Integer getValorMaximo;

    public Materiais() {
    }

    public Materiais(long id, String nomedoMatrial, String unidadeeMedida, double valorUnitario, Integer quantidade, Integer valorMinimo, Integer getValorMaximo) {
        this.id = id;
        this.nomedomaterial = nomedoMatrial;
        this.unidadeeMedida = unidadeeMedida;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorMinimo = valorMinimo;
        this.getValorMaximo = getValorMaximo;
    }

    public Materiais( String nomedoMatrial, String unidadeeMedida, double valorUnitario, Integer quantidade, Integer valorMinimo, Integer getValorMaximo) {
        this.nomedomaterial = nomedoMatrial;
        this.unidadeeMedida = unidadeeMedida;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valorMinimo = valorMinimo;
        this.getValorMaximo = getValorMaximo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer GetValorMaximo() {
        return getValorMaximo;
    }

    public void setGetValorMaximo(Integer getValorMaximo) {
        this.getValorMaximo = getValorMaximo;
    }
}
