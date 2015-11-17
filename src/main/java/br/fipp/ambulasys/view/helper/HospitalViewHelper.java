package br.fipp.ambulasys.view.helper;

import br.fipp.ambulasys.model.Cidade;
import br.fipp.ambulasys.model.Hospital;
import br.fipp.ambulasys.model.Pessoa;
import br.fipp.ambulasys.model.Uf;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Moe
 */
public class HospitalViewHelper implements Serializable {

    private Hospital hospital;
    private Uf estado;
    private List<Cidade> listaCidades;
    private List<Hospital> hospitais;
    private List<Hospital> hospitaisSelecionados;
    private List<Pessoa> pessoas;
    private List<Uf> estados;
    private Cidade cidade;

    public HospitalViewHelper() {
        resetValues();
    }

    public void resetValues() {
        hospital = new Hospital();
        hospital.setResponsavel(new Pessoa());
        cidade = new Cidade();
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Uf getEstado() {
        return estado;
    }

    public void setEstado(Uf estado) {
        this.estado = estado;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public List<Hospital> getHospitais() {
        return hospitais;
    }

    public void setHospitais(List<Hospital> hospitais) {
        this.hospitais = hospitais;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Uf> getEstados() {
        return estados;
    }

    public void setEstados(List<Uf> estados) {
        this.estados = estados;
    }

    public void editar() {
        estado = hospital.getCidadeId().getUfId();
        cidade = hospital.getCidadeId();
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public void viewToObject(){
        cidade.setUfId(estado);
        hospital.setCidadeId(cidade);
    }

    public List<Hospital> getHospitaisSelecionados() {
        return hospitaisSelecionados;
    }

    public void setHospitaisSelecionados(List<Hospital> hospitaisSelecionados) {
        this.hospitaisSelecionados = hospitaisSelecionados;
    }
}
