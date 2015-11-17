/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "viagem_pessoa")
@NamedQueries({
    @NamedQuery(name = "ViagemPessoa.findAll", query = "SELECT v FROM ViagemPessoa v")})
public class ViagemPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViagemPessoaPK viagemPessoaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "passageiro")
    private boolean passageiro;
    @JoinColumn(name = "Viagem_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Viagem viagem;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoa;

    public ViagemPessoa() {
    }

    public ViagemPessoa(ViagemPessoaPK viagemPessoaPK) {
        this.viagemPessoaPK = viagemPessoaPK;
    }

    public ViagemPessoa(ViagemPessoaPK viagemPessoaPK, boolean passageiro) {
        this.viagemPessoaPK = viagemPessoaPK;
        this.passageiro = passageiro;
    }

    public ViagemPessoa(int viagemid, int pessoaId) {
        this.viagemPessoaPK = new ViagemPessoaPK(viagemid, pessoaId);
    }

    public ViagemPessoaPK getViagemPessoaPK() {
        return viagemPessoaPK;
    }

    public void setViagemPessoaPK(ViagemPessoaPK viagemPessoaPK) {
        this.viagemPessoaPK = viagemPessoaPK;
    }

    public boolean getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(boolean passageiro) {
        this.passageiro = passageiro;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viagemPessoaPK != null ? viagemPessoaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViagemPessoa)) {
            return false;
        }
        ViagemPessoa other = (ViagemPessoa) object;
        if ((this.viagemPessoaPK == null && other.viagemPessoaPK != null) || (this.viagemPessoaPK != null && !this.viagemPessoaPK.equals(other.viagemPessoaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.ViagemPessoa[ viagemPessoaPK=" + viagemPessoaPK + " ]";
    }
    
}
