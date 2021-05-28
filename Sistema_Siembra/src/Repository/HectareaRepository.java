/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import dominio.Hectarea;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Bitzy
 */
public class HectareaRepository extends BaseRepository<Hectarea> {

    EntityManager entityManager = this.createEntityManager();

    /**
     *
     * @param lista
     * @return
     */
    @Override
    public boolean guardar(List<Hectarea> lista) {
        entityManager.getTransaction().begin();
        for (Hectarea object : lista) {
            entityManager.persist(object);
        }

        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Hectarea actualizado) {
        entityManager.getTransaction().begin();
        Hectarea hectarea = entityManager.find(Hectarea.class, actualizado.getId());
        if (hectarea != null) {
            hectarea.setBloque(actualizado.getBloque());
            hectarea.setRiegos(actualizado.getRiegos());
            hectarea.setTipoHectarea(actualizado.getTipoHectarea());
            hectarea.setLote(actualizado.getLote());
            hectarea.setCoordenadas(actualizado.getCoordenadas());
            hectarea.setArrendatario(actualizado.getArrendatario());

            entityManager.merge(hectarea);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public boolean eliminar(Integer id) {
        entityManager.getTransaction().begin();
        Hectarea hectarea = entityManager.find(Hectarea.class, id);
        if (hectarea != null) {
            entityManager.remove(hectarea);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public List<Hectarea> buscarTodos() {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Hectarea.class));
        Query query = entityManager.createQuery(criteria);
        List<Hectarea> hectareas = new ArrayList<>(query.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return hectareas;
    }

    @Override
    public Hectarea buscarPorID(Integer id) {
        entityManager.getTransaction().begin();
        Hectarea hectarea = entityManager.find(Hectarea.class, id);
        entityManager.getTransaction().commit();
        return hectarea;
    }
    
    
    public List<Hectarea> buscarHectPropia(String tipo) {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Hectarea.class));
        Query query = entityManager.createQuery(criteria);
        List<Hectarea> hectareas = new ArrayList<>(query.getResultList());
        List<Hectarea> coincidencias = new ArrayList<>();
        
        for (Hectarea h : hectareas) {
            if(h.getTipoHectarea().equals(tipo)){
                coincidencias.add(h);
            }
        }
        return coincidencias;
    }
    
    public List<Hectarea> buscarHectArrendada(String tipo) {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Hectarea.class));
        Query query = entityManager.createQuery(criteria);
        List<Hectarea> hectareas = new ArrayList<>(query.getResultList());
        List<Hectarea> coincidencias = new ArrayList<>();
        
        for (Hectarea h : hectareas) {
            if(h.getTipoHectarea().equals(tipo)){
                coincidencias.add(h);
            }
        }
        return coincidencias;
    }
    
    

  
    

  
}
