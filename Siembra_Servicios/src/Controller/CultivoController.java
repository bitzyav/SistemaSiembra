/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Repository.CultivoRepository;
import dominio.Cultivo;
import java.util.ArrayList;

/**
 *
 * @author Bitzy
 */
public class CultivoController {
    private final BaseController control = new BaseController();
    private final CultivoRepository cultivoRepository = control.getCultivoRepository();
    
    
    public boolean guardarCultivo(Cultivo cultivo) {
        return this.cultivoRepository.guardar(cultivo);
    }

    public boolean actualizarCultivo(Cultivo cultivo) {
         return this.cultivoRepository.actualizar(cultivo);
    }
    
    public boolean eliminarCultivo(Integer idCultivo) {
        return this.cultivoRepository.eliminar(idCultivo);
    }

    public Cultivo obtenerCultivoPorId(Integer idCultivo) {
        return this.cultivoRepository.buscarPorID(idCultivo);
    }

    public ArrayList<Cultivo> obtenerCultivos() {
        return this.cultivoRepository.buscarTodos();
    }
}
