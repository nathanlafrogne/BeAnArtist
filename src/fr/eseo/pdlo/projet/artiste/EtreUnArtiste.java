package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreMenuOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste 
{
	
	private EtreUnArtiste() {}
	
	public static void main(String [] args)
	{
		JFrame frame;
		PanneauDessin panneau = new PanneauDessin();
		panneau.activeAntiAlias();
		if(args.length == 0)
		{
			frame = new JFrame("Etre un Artiste");
		}
		else
		{
			frame = new JFrame(args[0]);
			Dimension d = new Dimension();
			try {
				d.setSize(0, Integer.parseInt(args[1]));
			}
			catch(Exception e) {
				d.setSize(0,panneau.HAUTEUR_PAR_DEFAUT);
			}
			
			try {
				d.setSize(Integer.parseInt(args[2]), d.getHeight());
			}
			catch(Exception e) {
				d.setSize(panneau.LARGEUR_PAR_DEFAUT,d.getHeight());
			}
			frame.setPreferredSize(d);
		}
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);
		PanneauBarreEtat panneauEtat = new PanneauBarreEtat(panneau);
		PanneauBarreMenuOutils panneauMenu = new PanneauBarreMenuOutils(panneau);
		
		
		frame.add(panneau , BorderLayout.CENTER);
		frame.add(panneauEtat , BorderLayout.SOUTH);
		frame.add(panneauOutils , BorderLayout.EAST);
		frame.add(panneauMenu , BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
			
	}
}
