/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.ChamadoMaterialHospitalar;
import br.fipp.ambulasys.model.ChamadoMaterialHospitalarPK;

/**
 *
 * @author felipe
 */
public class ChamadoMateriaisHospitalares extends 
        RepositorioGenerico<ChamadoMaterialHospitalar, ChamadoMaterialHospitalarPK> {

    public ChamadoMateriaisHospitalares() {
        super(ChamadoMaterialHospitalar.class);
    }
}
