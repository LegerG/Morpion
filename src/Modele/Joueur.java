/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author valetmax
 */
public class Joueur {
    
    private String nom;
    private int score;
    private Symbole symbole;
    private ArrayList<Case> casesCochees = new ArrayList<>();
    
    
    public Joueur (String nom,Symbole symbole) {
        this.nom=nom;
        this.score=0;
        this.symbole=symbole;       
    }

    public Symbole getSymbole() {
        return symbole;
    }

    public ArrayList<Case> getCasesCochees() {
        return casesCochees;
    }
    
    public void resetCases(){
        casesCochees.clear();
    }
    
    
    public boolean aGagner() {
        boolean aGagne = false;
            
            
                //Cette partie est surement bugué
                for (Case s : casesCochees) {
                    if (s.getNumero() == 1) {
                        for (Case d : casesCochees) {
                            if(d.getNumero() == 2) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 3) {
                                        aGagne = true;
                                    }
                                }
                            }
                            else if(d.getNumero() == 4) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 7) {
                                        aGagne = true;
                                    }
                                }
                            }
                            else if(d.getNumero() == 5) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 9) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                    else if(s.getNumero()==4){
                        for (Case d : casesCochees) {
                            if(d.getNumero() == 5) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 6) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                    else if(s.getNumero()==7){
                        for (Case d : casesCochees) {
                            if(d.getNumero() == 8) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 9) {
                                        aGagne = true;
                                    }
                                }
                            }
                            else if(d.getNumero() == 5) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 3) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                    else if (s.getNumero() == 2) {
                        for (Case d : casesCochees) {
                            if(d.getNumero() == 5) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 8) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                    else if (s.getNumero() == 3) {
                        for (Case d : casesCochees) {
                            if(d.getNumero() == 6) {
                                for (Case e : casesCochees) {
                                    if(e.getNumero() == 9) {
                                        aGagne = true;
                                    }
                                }
                            }
                        }
                    }
                }
                     
        return aGagne;
    }
    
    
    public void setScore(){
        this.score=score+1;
    }
    public int getScore(){
        return score;
    }

    public String getNom() {
        return nom;
    }
    
    public int supprDerniereCase() {
        int i = 0;
        if (!casesCochees.isEmpty()) {
            i = casesCochees.get(casesCochees.size() - 1).getNumero();
            casesCochees.remove(casesCochees.size() - 1);
        }
        
        
        
        return i;
        
    }
    
    
}
