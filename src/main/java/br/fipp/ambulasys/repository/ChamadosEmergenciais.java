/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.ChamadoEmergencial;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

/**
 *
 * @author felipe
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class ChamadosEmergenciais extends RepositorioGenerico<ChamadoEmergencial, Integer>{
    public ChamadosEmergenciais() {
        super(ChamadoEmergencial.class);
    }
    
    public List<ChamadoEmergencial> findByHospital(Integer hospital) {
        Query q = manager.createQuery("SELECT c from ChamadoEmergencial c WHERE c.hospitalId.id = :id");
        q.setParameter("id", hospital);
        List<ChamadoEmergencial> returnList = q.getResultList();
        return returnList;
    }

    public List<ChamadoEmergencial> findByHospitalENaoLancado(Integer hospital) {
        Query q = manager.createQuery("SELECT c from ChamadoEmergencial c WHERE c.hospitalId.id = :id and c.motoristaId.id = NULL");
        q.setParameter("id", hospital);
        List<ChamadoEmergencial> returnList = q.getResultList();
        return returnList;
    }
}
