/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Repository.HectareaRepository;
import dominio.Hectarea;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

/**
 *
 * @author Bitzy
 */
public class HectareaController {
    private final BaseController control = new BaseController();
    private final HectareaRepository hectareaRepository = control.getHectareaRepository();
    
    
    public boolean guardarHectarea(List<Object> lista) {
        return this.hectareaRepository.guardar(lista);
    }

    public boolean actualizarHectarea(Hectarea hectarea) {
         return this.hectareaRepository.actualizar(hectarea);
    }
    
    public boolean eliminarHectarea(Integer idHectarea) {
        return this.hectareaRepository.eliminar(idHectarea);
    }

    public Hectarea obtenerHectareaPorId(Integer idHectarea) {
        return this.hectareaRepository.buscarPorID(idHectarea);
    }

    public List<Hectarea> obtenerHectareas() {
        return this.hectareaRepository.buscarTodos();
    }
}
