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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "material_hospitalar_veiculo")
@NamedQueries({
    @NamedQuery(name = "MaterialHospitalarVeiculo.findAll", query = "SELECT m FROM MaterialHospitalarVeiculo m")})
public class MaterialHospitalarVeiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MaterialHospitalarVeiculoPK materialHospitalarVeiculoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "estoque_min")
    private Integer estoqueMin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialHospitalarVeiculo", fetch = FetchType.LAZY)
    private List<ChamadoMaterialHospitalar> chamadoMaterialHospitalarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialHospitalarVeiculo", fetch = FetchType.LAZY)
    private List<EntradaMaterialHospitalar> entradaMaterialHospitalarList;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Hospital hospital;
    @JoinColumn(name = "material_hospitalar_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MaterialHospitalar materialHospitalar;
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Veiculo veiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialHospitalarVeiculo", fetch = FetchType.LAZY)
    private List<ViagemMaterialHospitalar> viagemMaterialHospitalarList;

    public MaterialHospitalarVeiculo() {
    }

    public MaterialHospitalarVeiculo(MaterialHospitalarVeiculoPK materialHospitalarVeiculoPK) {
        this.materialHospitalarVeiculoPK = materialHospitalarVeiculoPK;
    }

    public MaterialHospitalarVeiculo(MaterialHospitalarVeiculoPK materialHospitalarVeiculoPK, int quantidade) {
        this.materialHospitalarVeiculoPK = materialHospitalarVeiculoPK;
        this.quantidade = quantidade;
    }

    public MaterialHospitalarVeiculo(int hospitalId, int materialHospitalarId, int veiculoId) {
        this.materialHospitalarVeiculoPK = new MaterialHospitalarVeiculoPK(hospitalId, materialHospitalarId, veiculoId);
    }

    public MaterialHospitalarVeiculoPK getMaterialHospitalarVeiculoPK() {
        return materialHospitalarVeiculoPK;
    }

    public void setMaterialHospitalarVeiculoPK(MaterialHospitalarVeiculoPK materialHospitalarVeiculoPK) {
        this.materialHospitalarVeiculoPK = materialHospitalarVeiculoPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(Integer estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public List<ChamadoMaterialHospitalar> getChamadoMaterialHospitalarList() {
        return chamadoMaterialHospitalarList;
    }

    public void setChamadoMaterialHospitalarList(List<ChamadoMaterialHospitalar> chamadoMaterialHospitalarList) {
        this.chamadoMaterialHospitalarList = chamadoMaterialHospitalarList;
    }

    public List<EntradaMaterialHospitalar> getEntradaMaterialHospitalarList() {
        return entradaMaterialHospitalarList;
    }

    public void setEntradaMaterialHospitalarList(List<EntradaMaterialHospitalar> entradaMaterialHospitalarList) {
        this.entradaMaterialHospitalarList = entradaMaterialHospitalarList;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public MaterialHospitalar getMaterialHospitalar() {
        return materialHospitalar;
    }

    public void setMaterialHospitalar(MaterialHospitalar materialHospitalar) {
        this.materialHospitalar = materialHospitalar;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<ViagemMaterialHospitalar> getViagemMaterialHospitalarList() {
        return viagemMaterialHospitalarList;
    }

    public void setViagemMaterialHospitalarList(List<ViagemMaterialHospitalar> viagemMaterialHospitalarList) {
        this.viagemMaterialHospitalarList = viagemMaterialHospitalarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialHospitalarVeiculoPK != null ? materialHospitalarVeiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialHospitalarVeiculo)) {
            return false;
        }
        MaterialHospitalarVeiculo other = (MaterialHospitalarVeiculo) object;
        if ((this.materialHospitalarVeiculoPK == null && other.materialHospitalarVeiculoPK != null) || (this.materialHospitalarVeiculoPK != null && !this.materialHospitalarVeiculoPK.equals(other.materialHospitalarVeiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.MaterialHospitalarVeiculo[ materialHospitalarVeiculoPK=" + materialHospitalarVeiculoPK + " ]";
    }
    
}
