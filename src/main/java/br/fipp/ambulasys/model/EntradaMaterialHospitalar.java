/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "entrada_material_hospitalar")
@NamedQueries({
    @NamedQuery(name = "EntradaMaterialHospitalar.findAll", query = "SELECT e FROM EntradaMaterialHospitalar e")})
public class EntradaMaterialHospitalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumns({
        @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id"),
        @JoinColumn(name = "material_hospitalar_id", referencedColumnName = "material_hospitalar_id"),
        @JoinColumn(name = "veiculo_id", referencedColumnName = "veiculo_id")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MaterialHospitalarVeiculo materialHospitalarVeiculo;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pessoaId;

    public EntradaMaterialHospitalar() {
    }

    public EntradaMaterialHospitalar(Integer id) {
        this.id = id;
    }

    public EntradaMaterialHospitalar(Integer id, int quantidade, Date data) {
        this.id = id;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public MaterialHospitalarVeiculo getMaterialHospitalarVeiculo() {
        return materialHospitalarVeiculo;
    }

    public void setMaterialHospitalarVeiculo(MaterialHospitalarVeiculo materialHospitalarVeiculo) {
        this.materialHospitalarVeiculo = materialHospitalarVeiculo;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
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
        if (!(object instanceof EntradaMaterialHospitalar)) {
            return false;
        }
        EntradaMaterialHospitalar other = (EntradaMaterialHospitalar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.EntradaMaterialHospitalar[ id=" + id + " ]";
    }
    
}
