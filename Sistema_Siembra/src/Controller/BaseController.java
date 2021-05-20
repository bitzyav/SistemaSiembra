/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import Repository.CultivoRepository;
import Repository.HectareaRepository;
import Repository.RiegoRepository;

/**
 *
 * @author Bitzy
 */
public class BaseController {
    private HectareaRepository hectareaRepository;
    private RiegoRepository riegoRepository;
//    private CultivoRepository cultivoRepository;

    public HectareaRepository getHectareaRepository() {
        if (this.hectareaRepository == null) {
            return new HectareaRepository();
        }
        return hectareaRepository;
    }
    
    public RiegoRepository getRiegoRepository() {
        if (this.riegoRepository == null) {
            return new RiegoRepository();
        }
        return riegoRepository;
    }
    
//    public CultivoRepository getCultivoRepository() {
//        if (this.cultivoRepository == null) {
//            return new CultivoRepository();
//        }
//        return cultivoRepository;
//    }
}
