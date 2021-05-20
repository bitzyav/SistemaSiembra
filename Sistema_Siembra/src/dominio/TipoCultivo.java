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
public enum TipoCultivo {
    TRIGO("Trigo"), 
    GARBANZO("Garbanzo"), 
    MAIZ("Maiz"), 
    SOYA("Soya"); 
    
    public final String label;

    private TipoCultivo(String label) {
        this.label = label;
    }
}
