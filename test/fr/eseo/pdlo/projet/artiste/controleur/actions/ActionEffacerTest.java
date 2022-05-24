package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionEffacerTest 
{
	public ActionEffacerTest()
	{
		testDessinOutilLigne();
	}
	
	private void testDessinOutilLigne()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauOutils = new PanneauBarreOutils(panneau);
		PanneauBarreEtat panneauEtat = new PanneauBarreEtat(panneau);
		
		
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);		
		
		frame.add(panneau , BorderLayout.CENTER);
		frame.add(panneauEtat , BorderLayout.SOUTH);
		frame.add(panneauOutils,BorderLayout.EAST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
	}
	
	public static void main(String [] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				new ActionEffacerTest();
			}
		});
	}
}
