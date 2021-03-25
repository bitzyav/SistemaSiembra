/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import dominio.Hectarea;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Bitzy
 */
public class HectareaRepository extends BaseRepository<Hectarea>{
    EntityManager entityManager = this.createEntityManager();
    
    @Override
    public boolean guardar(Hectarea hectarea) {
        entityManager.getTransaction().begin();
        entityManager.persist(hectarea);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Hectarea actualizado) {
        entityManager.getTransaction().begin();
        Hectarea hectarea = entityManager.find(Hectarea.class, actualizado.getId());
        if (hectarea != null) {
            hectarea.setBloque(actualizado.getBloque());
            hectarea.setUbicacionPredio(actualizado.getUbicacionPredio());
            hectarea.setRiegos(actualizado.getRiegos());

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
    public ArrayList<Hectarea> buscarTodos() {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Hectarea.class));
        Query query = entityManager.createQuery(criteria);
        ArrayList<Hectarea> hectareas = new ArrayList<>(query.getResultList());
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
}
