package com.devsuperior.evento.entities;

import jakarta.persistence.*;

import java.util.*;


@Entity
@Table(name = "tb_atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;
    @ManyToMany(mappedBy = "atividades")
    private Set<Participante> participantes = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @OneToMany(mappedBy = "atividade")
    private List<Bloco> blocos = new ArrayList<>();

    public Atividade(String nome, Long id, String descricao, Double preco, Categoria categoria) {
        this.nome = nome;
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Atividade(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;
        return Objects.equals(getId(), atividade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }


}
