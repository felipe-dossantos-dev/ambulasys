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
@Table(name = "pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 15)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 15)
    @Column(name = "telefone2")
    private String telefone2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
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
    @Column(name = "data_registro")
    @Temporal(TemporalType.DATE)
    private Date dataRegistro;
    @Size(max = 20)
    @Column(name = "cnh")
    private String cnh;
    @Size(max = 2)
    @Column(name = "tipo_cnh")
    private String tipoCnh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cartao_sus")
    private long cartaoSus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ativo")
    private boolean ativo;
    @Size(max = 1000)
    @Column(name = "historico_doenca")
    private String historicoDoenca;
    @Size(max = 45)
    @Column(name = "login")
    private String login;
    @Size(max = 15)
    @Column(name = "senha")
    private String senha;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidadeId;
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Hospital hospitalId;
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Perfil perfilId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId", fetch = FetchType.LAZY)
    private List<Multa> multaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId", fetch = FetchType.LAZY)
    private List<EntradaMaterialHospitalar> entradaMaterialHospitalarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<ViagemPessoa> viagemPessoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientePrincipal", fetch = FetchType.LAZY)
    private List<Viagem> viagemList;
    @OneToMany(mappedBy = "motoristaId", fetch = FetchType.LAZY)
    private List<Viagem> viagemList1;
    @OneToMany(mappedBy = "motoristaId", fetch = FetchType.LAZY)
    private List<ChamadoEmergencial> chamadoEmergencialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavel", fetch = FetchType.LAZY)
    private List<Hospital> hospitalList;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String name, String cpf, String logradouro, Date dataNascimento, int numero, String bairro, Date dataRegistro, long cartaoSus, String cep, boolean ativo, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.bairro = bairro;
        this.dataRegistro = dataRegistro;
        this.cartaoSus = cartaoSus;
        this.cep = cep;
        this.ativo = ativo;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTipoCnh() {
        return tipoCnh;
    }

    public void setTipoCnh(String tipoCnh) {
        this.tipoCnh = tipoCnh;
    }

    public long getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(long cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getHistoricoDoenca() {
        return historicoDoenca;
    }

    public void setHistoricoDoenca(String historicoDoenca) {
        this.historicoDoenca = historicoDoenca;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    public Hospital getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Perfil getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Perfil perfilId) {
        this.perfilId = perfilId;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public List<EntradaMaterialHospitalar> getEntradaMaterialHospitalarList() {
        return entradaMaterialHospitalarList;
    }

    public void setEntradaMaterialHospitalarList(List<EntradaMaterialHospitalar> entradaMaterialHospitalarList) {
        this.entradaMaterialHospitalarList = entradaMaterialHospitalarList;
    }

    public List<ViagemPessoa> getViagemPessoaList() {
        return viagemPessoaList;
    }

    public void setViagemPessoaList(List<ViagemPessoa> viagemPessoaList) {
        this.viagemPessoaList = viagemPessoaList;
    }

    public List<Viagem> getViagemList() {
        return viagemList;
    }

    public void setViagemList(List<Viagem> viagemList) {
        this.viagemList = viagemList;
    }

    public List<Viagem> getViagemList1() {
        return viagemList1;
    }

    public void setViagemList1(List<Viagem> viagemList1) {
        this.viagemList1 = viagemList1;
    }

    public List<ChamadoEmergencial> getChamadoEmergencialList() {
        return chamadoEmergencialList;
    }

    public void setChamadoEmergencialList(List<ChamadoEmergencial> chamadoEmergencialList) {
        this.chamadoEmergencialList = chamadoEmergencialList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fipp.ambulasys.model.Pessoa[ id=" + id + " ]";
    }
    
}
