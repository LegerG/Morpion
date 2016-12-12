/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import Modele.Joueur;
import java.awt.Font;

/**
 *
 * @author valetmax
 */
public class ViewGraphique extends View{
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel gridCenter = new JPanel(new GridLayout(3, 3));
    

    public ViewGraphique() {
        super();
        fenetre.setSize(700, 700);
        fenetre.setLocation(700, 200);
        
        
        borderPanel.add(gridCenter, BorderLayout.CENTER) ;
        
        for (int i=1; i<=9; i++) {
            JButton button = new JButton() ;
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
            button.setBackground(Color.white);
            gridCenter.add(button);
            button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setChanged(); 
                                int msg = getButtons().indexOf(button);
                                notifyObservers(msg);
                                clearChanged();
                        }
            
            });
            
            button.setEnabled(false);
            buttons.add(button);
        }  
    }

    public JPanel getGridPanel() {
        return gridNorth;
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    @Override
    public void aClique(int arg, Joueur jCourant) {
        
        buttons.get(arg).setFont(new Font("Calibri", Font.PLAIN, 100));
        buttons.get(arg).setText(jCourant.getSymbole().name());
        buttons.get(arg).setEnabled(false);
        
    }

    @Override
    public String getJoueur1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoueur2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setEnableButton(boolean bool) {
        for (JButton b : buttons) {
            b.setEnabled(bool);
        }
    }
    
    public void nettoie(){
        for(JButton b: this.buttons){
            b.setText(null);
        }
    }
    
    

    
    
    
}
