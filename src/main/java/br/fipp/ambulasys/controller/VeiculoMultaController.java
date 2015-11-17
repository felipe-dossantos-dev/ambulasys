package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Cidade;
import br.fipp.ambulasys.model.Infracao;
import br.fipp.ambulasys.model.Multa;
import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.model.Uf;
import br.fipp.ambulasys.model.Veiculo;
import br.fipp.ambulasys.repository.Cidades;
import br.fipp.ambulasys.repository.Infracoes;
import br.fipp.ambulasys.repository.Multas;
import br.fipp.ambulasys.repository.Pessoas;
import br.fipp.ambulasys.repository.Ufs;
import br.fipp.ambulasys.repository.Veiculos;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author felipe.santos
 */
@ManagedBean
@ViewScoped
public class VeiculoMultaController {

    @EJB
    private Multas multas;

    @EJB
    private Veiculos veiculos;

    @EJB
    private Infracoes infracoes;

    @EJB
    private Ufs ufs;

    @EJB
    private Cidades cidades;

    @EJB
    private Pessoas pessoas;

    private Multa multa;
    private Integer hospitalId;
    private List<Infracao> listaInfracoes;
    private List<Veiculo> listaVeiculos;
    private List<Pessoa> listaMotoristas;
    private List<Uf> listaUfs;
    private List<Cidade> listaCidades;
    private Uf uf;

    @PostConstruct
    public void init() {
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
        listaInfracoes = infracoes.findAll();
        listaMotoristas = pessoas.findByMotoristaHospital(hospitalId);
        listaVeiculos = veiculos.findByHospital(hospitalId);
        listaUfs = ufs.findAll();
        multa = new Multa();
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public List<Infracao> getListaInfracoes() {
        return listaInfracoes;
    }

    public void setListaInfracoes(List<Infracao> listaInfracoes) {
        this.listaInfracoes = listaInfracoes;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public List<Pessoa> getListaMotoristas() {
        return listaMotoristas;
    }

    public void setListaMotoristas(List<Pessoa> listaMotoristas) {
        this.listaMotoristas = listaMotoristas;
    }

    public void salvar() {
        try {
            multas.save(multa);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Multa lançada com sucesso",
                            null));
            limpar();
        } catch (PersistenceException ex) {
            System.out.println(ex);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao lançar a multa",
                            null));
        }
    }

    public void limpar() {
        multa = new Multa();
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public List<Uf> getListaUfs() {
        return listaUfs;
    }

    public void setListaUfs(List<Uf> listaUfs) {
        this.listaUfs = listaUfs;
    }

    public void naMudancaEstado() {
        if (uf != null) {
            listaCidades = cidades.findByEstado(uf);
        }
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }
}
