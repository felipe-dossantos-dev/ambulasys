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
@Table(name = "viagem_material_hospitalar")
@NamedQueries({
    @NamedQuery(name = "ViagemMaterialHospitalar.findAll", query = "SELECT v FROM ViagemMaterialHospitalar v")})
public class ViagemMaterialHospitalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ViagemMaterialHospitalarPK viagemMaterialHospitalarPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @JoinColumns({
        @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", insertable = false, updatable = false),
        @JoinColumn(name = "veiculo_placa", referencedColumnName = "veiculo_placa", insertable = false, updatable = false),
        @JoinColumn(name = "material_hospitalar_id", referencedColumnName = "material_hospitalar_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MaterialHospitalarVeiculo materialHospitalarVeiculo;
    @JoinColumn(name = "viagem_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Viagem viagem;

    public ViagemMaterialHospitalar() {
    }

    public ViagemMaterialHospitalar(ViagemMaterialHospitalarPK viagemMaterialHospitalarPK) {
        this.viagemMaterialHospitalarPK = viagemMaterialHospitalarPK;
    }

    public ViagemMaterialHospitalar(ViagemMaterialHospitalarPK viagemMaterialHospitalarPK, int quantidade) {
        this.viagemMaterialHospitalarPK = viagemMaterialHospitalarPK;
        this.quantidade = quantidade;
    }

    public ViagemMaterialHospitalar(int viagemId, int hospitalId, String veiculoPlaca, int materialHospitalarId) {
        this.viagemMaterialHospitalarPK = new ViagemMaterialHospitalarPK(viagemId, hospitalId, veiculoPlaca, materialHospitalarId);
    }

    public ViagemMaterialHospitalarPK getViagemMaterialHospitalarPK() {
        return viagemMaterialHospitalarPK;
    }

    public void setViagemMaterialHospitalarPK(ViagemMaterialHospitalarPK viagemMaterialHospitalarPK) {
        this.viagemMaterialHospitalarPK = viagemMaterialHospitalarPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public MaterialHospitalarVeiculo getMaterialHospitalarVeiculo() {
        return materialHospitalarVeiculo;
    }

    public void setMaterialHospitalarVeiculo(MaterialHospitalarVeiculo materialHospitalarVeiculo) {
        this.materialHospitalarVeiculo = materialHospitalarVeiculo;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viagemMaterialHospitalarPK != null ? viagemMaterialHospitalarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViagemMaterialHospitalar)) {
            return false;
        }
        ViagemMaterialHospitalar other = (ViagemMaterialHospitalar) object;
        if ((this.viagemMaterialHospitalarPK == null && other.viagemMaterialHospitalarPK != null) || (this.viagemMaterialHospitalarPK != null && !this.viagemMaterialHospitalarPK.equals(other.viagemMaterialHospitalarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys2.model.ViagemMaterialHospitalar[ viagemMaterialHospitalarPK=" + viagemMaterialHospitalarPK + " ]";
    }
    
}
