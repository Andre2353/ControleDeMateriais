package com.biolab.controledemateriasis.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "MOvimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idmateriais")
    private Materiais materiais;
    private String tipodemateriais;
    private Integer quantidademovimentacao;
    private LocalDate datademovimentacao;
    private String observacao;

    public Movimentacao() {
    }

    public Movimentacao(Materiais materiais, String tipodemateriais, Integer quantidademovimentacao, LocalDate datademovimentacao, String observacao) {
        this.materiais = materiais;
        this.tipodemateriais = tipodemateriais;
        this.quantidademovimentacao = quantidademovimentacao;
        this.datademovimentacao = datademovimentacao;
        this.observacao = observacao;
    }

    public Movimentacao(Long id, Materiais materiais, String tipodemateriais, Integer quantidademovimentacao, LocalDate datademovimentacao, String observacao) {
        this.id = id;
        this.materiais = materiais;
        this.tipodemateriais = tipodemateriais;
        this.quantidademovimentacao = quantidademovimentacao;
        this.datademovimentacao = datademovimentacao;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materiais getMateriais() {
        return materiais;
    }

    public void setMateriais(Materiais materiais) {
        this.materiais = materiais;
    }

    public String getTipodemateriais() {
        return tipodemateriais;
    }

    public void setTipodemateriais(String tipodemateriais) {
        this.tipodemateriais = tipodemateriais;
    }

    public Integer getQuantidademovimentacao() {
        return quantidademovimentacao;
    }

    public void setQuantidademovimentacao(Integer quantidademovimentacao) {
        this.quantidademovimentacao = quantidademovimentacao;
    }

    public LocalDate getDatademovimentacao() {
        return datademovimentacao;
    }

    public void setDatademovimentacao(LocalDate datademovimentacao) {
        this.datademovimentacao = datademovimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
