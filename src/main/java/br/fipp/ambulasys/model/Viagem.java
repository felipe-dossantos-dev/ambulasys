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
@Table(name = "viagem")
@NamedQueries({
    @NamedQuery(name = "Viagem.findAll", query = "SELECT v FROM Viagem v")})
public class Viagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_prevista_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrevistaSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_prevista_chegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrevistaChegada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    @Column(name = "data_chegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataChegada;
    @Size(max = 150)
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "kilometragem_inicial")
    private Integer kilometragemInicial;
    @Column(name = "kilometragem_final")
    private Integer kilometragemFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viagemId", fetch = FetchType.LAZY)
    private List<Despesa> despesaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viagem", fetch = FetchType.LAZY)
    private List<ViagemPessoa> viagemPessoaList;
    @JoinColumn(name = "destino", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade destino;
    @JoinColumn(name = "hospital_origem_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Hospital hospitalOrigemId;
    @JoinColumn(name = "paciente_principal", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa pacientePrincipal;
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pessoa motoristaId;
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Veiculo veiculoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viagem", fetch = FetchType.LAZY)
    private List<ViagemMaterialHospitalar> viagemMaterialHospitalarList;

    public Viagem() {
    }

    public Viagem(Integer id) {
        this.id = id;
    }

    public Viagem(Integer id, Date dataPrevistaSaida, Date dataPrevistaChegada) {
        this.id = id;
        this.dataPrevistaSaida = dataPrevistaSaida;
        this.dataPrevistaChegada = dataPrevistaChegada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPrevistaSaida() {
        return dataPrevistaSaida;
    }

    public void setDataPrevistaSaida(Date dataPrevistaSaida) {
        this.dataPrevistaSaida = dataPrevistaSaida;
    }

    public Date getDataPrevistaChegada() {
        return dataPrevistaChegada;
    }

    public void setDataPrevistaChegada(Date dataPrevistaChegada) {
        this.dataPrevistaChegada = dataPrevistaChegada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getKilometragemInicial() {
        return kilometragemInicial;
    }

    public void setKilometragemInicial(Integer kilometragemInicial) {
        this.kilometragemInicial = kilometragemInicial;
    }

    public Integer getKilometragemFinal() {
        return kilometragemFinal;
    }

    public void setKilometragemFinal(Integer kilometragemFinal) {
        this.kilometragemFinal = kilometragemFinal;
    }

    public List<Despesa> getDespesaList() {
        return despesaList;
    }

    public void setDespesaList(List<Despesa> despesaList) {
        this.despesaList = despesaList;
    }

    public List<ViagemPessoa> getViagemPessoaList() {
        return viagemPessoaList;
    }

    public void setViagemPessoaList(List<ViagemPessoa> viagemPessoaList) {
        this.viagemPessoaList = viagemPessoaList;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Hospital getHospitalOrigemId() {
        return hospitalOrigemId;
    }

    public void setHospitalOrigemId(Hospital hospitalOrigemId) {
        this.hospitalOrigemId = hospitalOrigemId;
    }

    public Pessoa getPacientePrincipal() {
        return pacientePrincipal;
    }

    public void setPacientePrincipal(Pessoa pacientePrincipal) {
        this.pacientePrincipal = pacientePrincipal;
    }

    public Pessoa getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Pessoa motoristaId) {
        this.motoristaId = motoristaId;
    }

    public Veiculo getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Veiculo veiculoId) {
        this.veiculoId = veiculoId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viagem)) {
            return false;
        }
        Viagem other = (Viagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.Viagem[ id=" + id + " ]";
    }
    
}
