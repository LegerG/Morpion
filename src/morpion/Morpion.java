
package morpion;

import Controler.Controler;
import View.ViewGraphique;
import View.ViewTexte;


public class Morpion {

    
    public static void main(String[] args) {
        
        ViewGraphique graph = new ViewGraphique();
        ViewTexte texte = new ViewTexte();
        
        Controler controler = new Controler(graph, texte);
        
        graph.addObserver(controler);
        texte.addObserver(controler);
        
    }
    
}
