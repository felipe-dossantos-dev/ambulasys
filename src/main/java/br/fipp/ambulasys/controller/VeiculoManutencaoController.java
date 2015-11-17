package br.fipp.ambulasys.controller;

import br.fipp.ambulasys.model.Manutencao;
import br.fipp.ambulasys.model.Veiculo;
import br.fipp.ambulasys.repository.Manutencoes;
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
public class VeiculoManutencaoController {

    @EJB
    private Manutencoes manutencoes;

    @EJB
    private Veiculos veiculos;

    private List<Veiculo> listaVeiculos;
    private Manutencao manutencao;
    private Integer hospitalId;

    @PostConstruct
    public void init() {
        hospitalId = (Integer) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("hospitalId");
        manutencao = new Manutencao();
        listaVeiculos = veiculos.findByHospital(hospitalId);
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public void salvar() {
        try {
            this.manutencoes.save(manutencao);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Manutenção lançada com sucesso",
                            null));
            limpar();
        } catch (PersistenceException ex) {
            System.out.println(ex);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao lançar a manutenção",
                            null));
        }
    }

    public void limpar() {
        manutencao = new Manutencao();
    }

}
