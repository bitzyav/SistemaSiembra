/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Bitzy
 */
public enum EstadoProceso {
    EN_ESPERA("En espera"), 
    INICIADO("Iniciado"), 
    EN_PROCESO("En proceso"), 
    FINALIZADO("Finalizado");
    
    public final String label;

    private EstadoProceso(String label) {
        this.label = label;
    }
}
