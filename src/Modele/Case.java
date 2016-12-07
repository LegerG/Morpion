/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author valetmax
 */
public class Case {
    private int numero;
    
    public Case (int numcase){
        this.numero=numcase + 1;
    }

    public int getNumero() {
        return numero;
    }
    
}
