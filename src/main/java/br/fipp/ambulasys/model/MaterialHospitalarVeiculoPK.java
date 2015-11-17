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
public class MaterialHospitalarVeiculoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "hospital_id")
    private int hospitalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "material_hospitalar_id")
    private int materialHospitalarId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "veiculo_id")
    private int veiculoId;

    public MaterialHospitalarVeiculoPK() {
    }

    public MaterialHospitalarVeiculoPK(int hospitalId, int materialHospitalarId, int veiculoId) {
        this.hospitalId = hospitalId;
        this.materialHospitalarId = materialHospitalarId;
        this.veiculoId = veiculoId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getMaterialHospitalarId() {
        return materialHospitalarId;
    }

    public void setMaterialHospitalarId(int materialHospitalarId) {
        this.materialHospitalarId = materialHospitalarId;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hospitalId;
        hash += (int) materialHospitalarId;
        hash += (int) veiculoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialHospitalarVeiculoPK)) {
            return false;
        }
        MaterialHospitalarVeiculoPK other = (MaterialHospitalarVeiculoPK) object;
        if (this.hospitalId != other.hospitalId) {
            return false;
        }
        if (this.materialHospitalarId != other.materialHospitalarId) {
            return false;
        }
        if (this.veiculoId != other.veiculoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.MaterialHospitalarVeiculoPK[ hospitalId=" + hospitalId + ", materialHospitalarId=" + materialHospitalarId + ", veiculoId=" + veiculoId + " ]";
    }
    
}
