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
@Table(name = "hospital")
@NamedQueries({
    @NamedQuery(name = "Hospital.findAll", query = "SELECT h FROM Hospital h")})
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inscricao")
    @Temporal(TemporalType.DATE)
    private Date dataInscricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cep")
    private String cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalId", fetch = FetchType.LAZY)
    private List<Veiculo> veiculoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalId", fetch = FetchType.LAZY)
    private List<Pessoa> pessoaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hospital", fetch = FetchType.LAZY)
    private Parametros parametros;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalOrigemId", fetch = FetchType.LAZY)
    private List<Viagem> viagemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<MaterialHospitalarVeiculo> materialHospitalarVeiculoList;
    @OneToMany(mappedBy = "hospitalId", fetch = FetchType.LAZY)
    private List<Notificacao> notificacaoList;
    @JoinColumn(name = "responsavel", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pessoa responsavel;

    public Hospital() {
    }

    public Hospital(Integer id) {
        this.id = id;
    }

    public Hospital(Integer id, String razaoSocial, String nomeFantasia, String inscricaoEstadual, String logradouro, int numero, String bairro, Date dataInscricao, String cnpj, String cep) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.dataInscricao = dataInscricao;
        this.cnpj = cnpj;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
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

    public List<Notificacao> getNotificacaoList() {
        return notificacaoList;
    }

    public void setNotificacaoList(List<Notificacao> notificacaoList) {
        this.notificacaoList = notificacaoList;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
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
        if (!(object instanceof Hospital)) {
            return false;
        }
        Hospital other = (Hospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.Hospital[ id=" + id + " ]";
    }
    
}
