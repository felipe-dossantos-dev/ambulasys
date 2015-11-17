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
import javax.persistence.JoinColumns;
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
@Table(name = "chamado_material_hospitalar")
@NamedQueries({
    @NamedQuery(name = "ChamadoMaterialHospitalar.findAll", query = "SELECT c FROM ChamadoMaterialHospitalar c")})
public class ChamadoMaterialHospitalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChamadoMaterialHospitalarPK chamadoMaterialHospitalarPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumn(name = "chamado_emergencial_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChamadoEmergencial chamadoEmergencial;
    @JoinColumns({
        @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", insertable = false, updatable = false),
        @JoinColumn(name = "material_hospitalar_id", referencedColumnName = "material_hospitalar_id", insertable = false, updatable = false),
        @JoinColumn(name = "veiculo_id", referencedColumnName = "veiculo_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MaterialHospitalarVeiculo materialHospitalarVeiculo;

    public ChamadoMaterialHospitalar() {
    }

    public ChamadoMaterialHospitalar(ChamadoMaterialHospitalarPK chamadoMaterialHospitalarPK) {
        this.chamadoMaterialHospitalarPK = chamadoMaterialHospitalarPK;
    }

    public ChamadoMaterialHospitalar(ChamadoMaterialHospitalarPK chamadoMaterialHospitalarPK, int quantidade) {
        this.chamadoMaterialHospitalarPK = chamadoMaterialHospitalarPK;
        this.quantidade = quantidade;
    }

    public ChamadoMaterialHospitalar(int chamadoEmergencialId, int hospitalId, int materialHospitalarId, int veiculoId) {
        this.chamadoMaterialHospitalarPK = new ChamadoMaterialHospitalarPK(chamadoEmergencialId, hospitalId, materialHospitalarId, veiculoId);
    }

    public ChamadoMaterialHospitalarPK getChamadoMaterialHospitalarPK() {
        return chamadoMaterialHospitalarPK;
    }

    public void setChamadoMaterialHospitalarPK(ChamadoMaterialHospitalarPK chamadoMaterialHospitalarPK) {
        this.chamadoMaterialHospitalarPK = chamadoMaterialHospitalarPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ChamadoEmergencial getChamadoEmergencial() {
        return chamadoEmergencial;
    }

    public void setChamadoEmergencial(ChamadoEmergencial chamadoEmergencial) {
        this.chamadoEmergencial = chamadoEmergencial;
    }

    public MaterialHospitalarVeiculo getMaterialHospitalarVeiculo() {
        return materialHospitalarVeiculo;
    }

    public void setMaterialHospitalarVeiculo(MaterialHospitalarVeiculo materialHospitalarVeiculo) {
        this.materialHospitalarVeiculo = materialHospitalarVeiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chamadoMaterialHospitalarPK != null ? chamadoMaterialHospitalarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChamadoMaterialHospitalar)) {
            return false;
        }
        ChamadoMaterialHospitalar other = (ChamadoMaterialHospitalar) object;
        if ((this.chamadoMaterialHospitalarPK == null && other.chamadoMaterialHospitalarPK != null) || (this.chamadoMaterialHospitalarPK != null && !this.chamadoMaterialHospitalarPK.equals(other.chamadoMaterialHospitalarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.ChamadoMaterialHospitalar[ chamadoMaterialHospitalarPK=" + chamadoMaterialHospitalarPK + " ]";
    }
    
}
