/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

public class Action {
    private Joueur joueur;
    private Case carreau;

    public Action(Joueur joueur, Case carreau) {
        this.joueur = joueur;
        this.carreau = carreau;
    }
    
    public int getNumCase() {
        return carreau.getNumero();
    }

    public Joueur getJoueur() {
        return joueur;
    }
    
    
}
