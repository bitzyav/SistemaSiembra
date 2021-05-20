/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bitzy
 */
public abstract class BaseRepository <T>{
    
    public abstract boolean guardar(List<Object> lista);
    
    public abstract boolean actualizar(T entidad);
    
    public abstract boolean eliminar(Integer id);
    
    public abstract List<T> buscarTodos();
    
    public abstract T buscarPorID(Integer id);
    
//    public abstract T buscarHectareasPorBloque(String bloque);
    
    public EntityManager createEntityManager(){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("Siembra_DominioPU");
        EntityManager entityManager= factory.createEntityManager();
        return entityManager;
    }
}
