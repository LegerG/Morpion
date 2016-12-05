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

/**
 *
 * @author valetmax
 */
public class ViewGraphique extends View{
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JPanel gridCenter = new JPanel(new GridLayout(3, 3));
    

    public ViewGraphique() {
        super();
        
        
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
        buttons.get(arg).setText(jCourant.getSymbole().name());
        buttons.get(arg).setEnabled(false);
        
    }
    
    
    
    
    
    
}
