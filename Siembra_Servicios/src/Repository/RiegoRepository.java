/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import dominio.Riego;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Bitzy
 */
public class RiegoRepository extends BaseRepository<Riego>{
    EntityManager entityManager = this.createEntityManager();
    
    @Override
    public boolean guardar(Riego riego) {
        entityManager.getTransaction().begin();
        entityManager.persist(riego);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Riego actualizado) {
        entityManager.getTransaction().begin();
        Riego riego = entityManager.find(Riego.class, actualizado.getId());
        if (riego != null) {
            riego.setCapacidadAgua(actualizado.getCapacidadAgua());
            riego.setEstado(actualizado.getEstado());
            riego.setFecha(actualizado.getFechaHora());
            riego.setHectareas(actualizado.getHectareas());
            riego.setNumHectareas(actualizado.getNumHectareas());
            riego.setObservaciones(actualizado.getObservaciones());
            riego.setTipoRiego(actualizado.getTipoRiego());

            entityManager.merge(riego);
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
        Riego riego = entityManager.find(Riego.class, id);
        if (riego != null) {
            entityManager.remove(riego);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public ArrayList<Riego> buscarTodos() {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Riego.class));
        Query query = entityManager.createQuery(criteria);
        ArrayList<Riego> riegos = new ArrayList<>(query.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return riegos;
    }

    @Override
    public Riego buscarPorID(Integer id) {
        entityManager.getTransaction().begin();
        Riego riego = entityManager.find(Riego.class, id);
        entityManager.getTransaction().commit();
        return riego;
    } 
}
