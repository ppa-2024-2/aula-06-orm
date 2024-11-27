package br.edu.ifrs.riogrande.tads.ppa.ligaa.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity // Notação Húngara (Hungarian Notation)
@Table(name = "tbl_alunos")
public class Aluno {
    // -- campos de controle
    @Id // primary key
    @Column(name = "codigo_aluno")
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "criacao")
    private LocalDateTime dataHoraCriacao;

    @Column(name = "alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataHoraAlteracao;

    @Column(nullable = false)
    private boolean desativado; // false

    @Column(nullable = false, length = 254) // VARCHAR(254)
    private String nome;

    @Column(name = "email", nullable = false, length = 254)
    private String enderecoEletronico;

    @Column(nullable = false, unique = true, length = 254)
    private String login; // e-mail

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Transient // não-persistido
    private String dado;

    public String getEnderecoEletronico() {

        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao=" + dataHoraAlteracao
                + ", desativado=" + desativado + ", nome=" + nome + ", enderecoEletronico=" + enderecoEletronico
                + ", login=" + login + ", cpf=" + cpf + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    
}
