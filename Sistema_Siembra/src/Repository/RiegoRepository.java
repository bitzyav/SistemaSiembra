/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import dominio.Hectarea;
import dominio.Riego;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Bitzy
 */
public class RiegoRepository extends BaseRepository<Riego> {

    EntityManager entityManager = this.createEntityManager();

    @Override
    public boolean guardar(List<Riego> lista) {
        entityManager.getTransaction().begin();
        for (Object object : lista) {
            entityManager.persist(object);
        }

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
            riego.setFechaHora(actualizado.getFechaHora());
            riego.setHectareas(actualizado.getHectareas());
            riego.setObservaciones(actualizado.getObservaciones());
            riego.setTipoRiego(actualizado.getTipoRiego());
            riego.setNombreEmpleado(actualizado.getNombreEmpleado());

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
    public List<Riego> buscarTodos() {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Riego.class));
        Query query = entityManager.createQuery(criteria);
        List<Riego> riegos = query.getResultList();
        entityManager.getTransaction().commit();
        return riegos;
    }

    @Override
    public Riego buscarPorID(Integer id) {
        entityManager.getTransaction().begin();
        Riego riego = entityManager.find(Riego.class, id);
        entityManager.getTransaction().commit();
        return riego;
    }

    public List<Riego> buscarPorFecha(Date fecha) {
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Riego.class));
        Query query = entityManager.createQuery(criteria);
        List<Riego> riegos = new ArrayList<>(query.getResultList());
        List<Riego> coincidencias = new ArrayList<>();

        for (Riego r : riegos) {
            String f1 = fecha.toString().split(" ")[0];
            String f2 = r.getFechaHora().toString().split(" ")[0];
            if (f1.equals(f2)) {
                coincidencias.add(r);
            }
        }
        return coincidencias;
    }
}
