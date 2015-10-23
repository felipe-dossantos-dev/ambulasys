/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "veiculo")
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")})
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "chassi")
    private String chassi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_aquisicao")
    @Temporal(TemporalType.DATE)
    private Date dataAquisicao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lotacao_max")
    private int lotacaoMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "renavam")
    private int renavam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "combustivel")
    private String combustivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kilometragem")
    private int kilometragem;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Hospital hospitalId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculoPlaca", fetch = FetchType.EAGER)
    private List<Multa> multaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "veiculoPlaca", fetch = FetchType.EAGER)
    private Manutencao manutencao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculoPlaca", fetch = FetchType.EAGER)
    private List<Viagem> viagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo", fetch = FetchType.EAGER)
    private List<MaterialHospitalarVeiculo> materialHospitalarVeiculoList;
    @OneToMany(mappedBy = "veiculoPlaca", fetch = FetchType.EAGER)
    private List<ChamadoEmergencial> chamadoEmergencialList;

    public Veiculo() {
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, String modelo, String chassi, Date ano, Date dataAquisicao, int lotacaoMax, int renavam, String cor, String combustivel, int kilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.chassi = chassi;
        this.ano = ano;
        this.dataAquisicao = dataAquisicao;
        this.lotacaoMax = lotacaoMax;
        this.renavam = renavam;
        this.cor = cor;
        this.combustivel = combustivel;
        this.kilometragem = kilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public int getLotacaoMax() {
        return lotacaoMax;
    }

    public void setLotacaoMax(int lotacaoMax) {
        this.lotacaoMax = lotacaoMax;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public List<Viagem> getViagemList() {
        return viagemList;
    }

    public void setViagemList(List<Viagem> viagemList) {
        this.viagemList = viagemList;
    }

    public List<MaterialHospitalarVeiculo> getMaterialHospitalarVeiculoList() {
        return materialHospitalarVeiculoList;
    }

    public void setMaterialHospitalarVeiculoList(List<MaterialHospitalarVeiculo> materialHospitalarVeiculoList) {
        this.materialHospitalarVeiculoList = materialHospitalarVeiculoList;
    }

    public List<ChamadoEmergencial> getChamadoEmergencialList() {
        return chamadoEmergencialList;
    }

    public void setChamadoEmergencialList(List<ChamadoEmergencial> chamadoEmergencialList) {
        this.chamadoEmergencialList = chamadoEmergencialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys2.model.Veiculo[ placa=" + placa + " ]";
    }
    
}
