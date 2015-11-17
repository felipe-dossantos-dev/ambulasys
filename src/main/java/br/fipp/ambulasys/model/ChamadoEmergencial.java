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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "chamado_emergencial")
@NamedQueries({
    @NamedQuery(name = "ChamadoEmergencial.findAll", query = "SELECT c FROM ChamadoEmergencial c")})
public class ChamadoEmergencial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_abertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAbertura;
    @Column(name = "data_fechamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFechamento;
    @Size(max = 150)
    @Column(name = "endereco_motorista")
    private String enderecoMotorista;
    @Size(max = 300)
    @Column(name = "descricao_motorista")
    private String descricaoMotorista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chamadoEmergencial", fetch = FetchType.LAZY)
    private List<ChamadoMaterialHospitalar> chamadoMaterialHospitalarList;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Hospital hospitalId;
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Veiculo veiculoId;
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa motoristaId;

    public ChamadoEmergencial() {
    }

    public ChamadoEmergencial(Integer id) {
        this.id = id;
    }

    public ChamadoEmergencial(Integer id, String descricao, String endereco, Date dataAbertura) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
        this.dataAbertura = dataAbertura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getEnderecoMotorista() {
        return enderecoMotorista;
    }

    public void setEnderecoMotorista(String enderecoMotorista) {
        this.enderecoMotorista = enderecoMotorista;
    }

    public String getDescricaoMotorista() {
        return descricaoMotorista;
    }

    public void setDescricaoMotorista(String descricaoMotorista) {
        this.descricaoMotorista = descricaoMotorista;
    }

    public List<ChamadoMaterialHospitalar> getChamadoMaterialHospitalarList() {
        return chamadoMaterialHospitalarList;
    }

    public void setChamadoMaterialHospitalarList(List<ChamadoMaterialHospitalar> chamadoMaterialHospitalarList) {
        this.chamadoMaterialHospitalarList = chamadoMaterialHospitalarList;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Veiculo getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Veiculo veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Pessoa getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Pessoa motoristaId) {
        this.motoristaId = motoristaId;
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
        if (!(object instanceof ChamadoEmergencial)) {
            return false;
        }
        ChamadoEmergencial other = (ChamadoEmergencial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChamadoEmergencial{" + "id=" + id + ", descricao=" + descricao + ", endereco=" + endereco + ", dataAbertura=" + dataAbertura + ", dataFechamento=" + dataFechamento + ", enderecoMotorista=" + enderecoMotorista + ", descricaoMotorista=" + descricaoMotorista + ", chamadoMaterialHospitalarList=" + chamadoMaterialHospitalarList + ", hospitalId=" + hospitalId + ", veiculoId=" + veiculoId + ", motoristaId=" + motoristaId + '}';
    }
}
