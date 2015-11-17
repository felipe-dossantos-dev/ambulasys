/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felipe
 */
@Embeddable
public class ViagemPessoaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Viagem_id")
    private int viagemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pessoa_id")
    private int pessoaId;

    public ViagemPessoaPK() {
    }

    public ViagemPessoaPK(int viagemid, int pessoaId) {
        this.viagemid = viagemid;
        this.pessoaId = pessoaId;
    }

    public int getViagemid() {
        return viagemid;
    }

    public void setViagemid(int viagemid) {
        this.viagemid = viagemid;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) viagemid;
        hash += (int) pessoaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViagemPessoaPK)) {
            return false;
        }
        ViagemPessoaPK other = (ViagemPessoaPK) object;
        if (this.viagemid != other.viagemid) {
            return false;
        }
        if (this.pessoaId != other.pessoaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.ViagemPessoaPK[ viagemid=" + viagemid + ", pessoaId=" + pessoaId + " ]";
    }
    
}
