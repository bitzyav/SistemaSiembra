/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Repository.RiegoRepository;
import dominio.Riego;
import java.util.List;
/**
 *
 * @author Bitzy
 */
public class RiegoController {
    private final BaseController control = new BaseController();
    private final RiegoRepository riegoRepository = control.getRiegoRepository();
    
    
    public boolean guardarRiego(List<Riego> lista) {
        return this.riegoRepository.guardar(lista);
    }

    public boolean actualizarRiego(Riego riego) {
         return this.riegoRepository.actualizar(riego);
    }
    
    public boolean eliminarRiego(Integer idRiego) {
        return this.riegoRepository.eliminar(idRiego);
    }

    public Riego obtenerRiegoPorId(Integer idRiego) {
        return this.riegoRepository.buscarPorID(idRiego);
    }

    public List<Riego> obtenerRiegos() {
        return this.riegoRepository.buscarTodos();
    }
}
