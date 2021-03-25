/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import dominio.Cultivo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Bitzy
 */
public class CultivoRepository extends BaseRepository<Cultivo>{

    EntityManager entityManager = this.createEntityManager();
    
    @Override
    public boolean guardar(Cultivo cultivo) {
        entityManager.getTransaction().begin();
        entityManager.persist(cultivo);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean actualizar(Cultivo actualizado) {
        entityManager.getTransaction().begin();
        Cultivo cultivo = entityManager.find(Cultivo.class, actualizado.getId());
        if (cultivo != null) {
            cultivo.setCiclo(actualizado.getCiclo());
            cultivo.setTipoCultivo(actualizado.getTipoCultivo());
            cultivo.setHectareas(actualizado.getHectareas());

            entityManager.merge(cultivo);
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
        Cultivo cultivo = entityManager.find(Cultivo.class, id);
        if (cultivo != null) {
            entityManager.remove(cultivo);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public ArrayList<Cultivo> buscarTodos() {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Cultivo.class));
        Query query = entityManager.createQuery(criteria);
        ArrayList<Cultivo> cultivos = new ArrayList<>(query.getResultList());
        entityManager.getTransaction().commit();
        entityManager.close();
        return cultivos;
    }
    
    @Override
    public Cultivo buscarPorID(Integer id) {
        entityManager.getTransaction().begin();
        Cultivo cultivo = entityManager.find(Cultivo.class, id);
        entityManager.getTransaction().commit();
        return cultivo;
    } 
}
