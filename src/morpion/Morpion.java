/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import Controler.Controler;
import View.ViewGraphique;
import View.ViewTexte;

/**
 *
 * @author valetmax
 */
public class Morpion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ViewGraphique graph = new ViewGraphique();
        ViewTexte texte = new ViewTexte();
        
        Controler controler = new Controler(graph, texte);
        
        graph.addObserver(controler);
        texte.addObserver(controler);
        
    }
    
}
