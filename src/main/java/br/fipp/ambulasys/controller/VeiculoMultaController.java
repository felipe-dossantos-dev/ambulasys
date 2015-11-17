package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Infracao;
import br.fipp.ambulasys.model.Multa;
import br.fipp.ambulasys.model.Pessoa;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

    @PostConstruct
    public void init() {
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
        listaInfracoes = infracoes.findAll();
        listaMotoristas = pessoas.findByMotoristaHospital(hospitalId);
        listaVeiculos = veiculos.findByHospital(hospitalId);
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
        multas.save(multa);
    }

    public void limpar() {
        multa = new Multa();
    }
}
