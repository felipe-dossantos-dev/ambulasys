/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cidade")
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "regiao_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Regiao regiaoId;
    @JoinColumn(name = "uf_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Uf ufId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId", fetch = FetchType.LAZY)
    private List<Pessoa> pessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId", fetch = FetchType.LAZY)
    private List<Multa> multaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino", fetch = FetchType.LAZY)
    private List<Viagem> viagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeId", fetch = FetchType.LAZY)
    private List<Hospital> hospitalList;

    public Cidade() {
    }

    public Cidade(Integer id) {
        this.id = id;
    }

    public Cidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Regiao getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(Regiao regiaoId) {
        this.regiaoId = regiaoId;
    }

    public Uf getUfId() {
        return ufId;
    }

    public void setUfId(Uf ufId) {
        this.ufId = ufId;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public List<Viagem> getViagemList() {
        return viagemList;
    }

    public void setViagemList(List<Viagem> viagemList) {
        this.viagemList = viagemList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.Cidade[ id=" + id + " ]";
    }
    
}
