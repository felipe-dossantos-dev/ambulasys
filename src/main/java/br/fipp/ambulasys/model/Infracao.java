/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "infracao")
@NamedQueries({
    @NamedQuery(name = "Infracao.findAll", query = "SELECT i FROM Infracao i")})
public class Infracao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo_infracao")
    private String codigoInfracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 45)
    @Column(name = "enquadramento_ctb")
    private String enquadramentoCtb;
    @Size(max = 15)
    @Column(name = "gravidade")
    private String gravidade;
    @Size(max = 20)
    @Column(name = "responsabilidade")
    private String responsabilidade;
    @Size(max = 15)
    @Column(name = "competencia")
    private String competencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pontos")
    private int pontos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoInfracao", fetch = FetchType.EAGER)
    private List<Multa> multaList;

    public Infracao() {
    }

    public Infracao(String codigoInfracao) {
        this.codigoInfracao = codigoInfracao;
    }

    public Infracao(String codigoInfracao, String descricao, int pontos, BigDecimal valor) {
        this.codigoInfracao = codigoInfracao;
        this.descricao = descricao;
        this.pontos = pontos;
        this.valor = valor;
    }

    public String getCodigoInfracao() {
        return codigoInfracao;
    }

    public void setCodigoInfracao(String codigoInfracao) {
        this.codigoInfracao = codigoInfracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEnquadramentoCtb() {
        return enquadramentoCtb;
    }

    public void setEnquadramentoCtb(String enquadramentoCtb) {
        this.enquadramentoCtb = enquadramentoCtb;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(String responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInfracao != null ? codigoInfracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infracao)) {
            return false;
        }
        Infracao other = (Infracao) object;
        if ((this.codigoInfracao == null && other.codigoInfracao != null) || (this.codigoInfracao != null && !this.codigoInfracao.equals(other.codigoInfracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys2.model.Infracao[ codigoInfracao=" + codigoInfracao + " ]";
    }
    
}
