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
import javax.validation.constraints.Size;

/**
 *
 * @author felipe
 */
@Embeddable
public class ChamadoMaterialHospitalarPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "chamado_emergencial_id")
    private int chamadoEmergencialId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hospital_id")
    private int hospitalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "veiculo_placa")
    private String veiculoPlaca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_hospitalar_id")
    private int materialHospitalarId;

    public ChamadoMaterialHospitalarPK() {
    }

    public ChamadoMaterialHospitalarPK(int chamadoEmergencialId, int hospitalId, String veiculoPlaca, int materialHospitalarId) {
        this.chamadoEmergencialId = chamadoEmergencialId;
        this.hospitalId = hospitalId;
        this.veiculoPlaca = veiculoPlaca;
        this.materialHospitalarId = materialHospitalarId;
    }

    public int getChamadoEmergencialId() {
        return chamadoEmergencialId;
    }

    public void setChamadoEmergencialId(int chamadoEmergencialId) {
        this.chamadoEmergencialId = chamadoEmergencialId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public int getMaterialHospitalarId() {
        return materialHospitalarId;
    }

    public void setMaterialHospitalarId(int materialHospitalarId) {
        this.materialHospitalarId = materialHospitalarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) chamadoEmergencialId;
        hash += (int) hospitalId;
        hash += (veiculoPlaca != null ? veiculoPlaca.hashCode() : 0);
        hash += (int) materialHospitalarId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChamadoMaterialHospitalarPK)) {
            return false;
        }
        ChamadoMaterialHospitalarPK other = (ChamadoMaterialHospitalarPK) object;
        if (this.chamadoEmergencialId != other.chamadoEmergencialId) {
            return false;
        }
        if (this.hospitalId != other.hospitalId) {
            return false;
        }
        if ((this.veiculoPlaca == null && other.veiculoPlaca != null) || (this.veiculoPlaca != null && !this.veiculoPlaca.equals(other.veiculoPlaca))) {
            return false;
        }
        if (this.materialHospitalarId != other.materialHospitalarId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys2.model.ChamadoMaterialHospitalarPK[ chamadoEmergencialId=" + chamadoEmergencialId + ", hospitalId=" + hospitalId + ", veiculoPlaca=" + veiculoPlaca + ", materialHospitalarId=" + materialHospitalarId + " ]";
    }
    
}
