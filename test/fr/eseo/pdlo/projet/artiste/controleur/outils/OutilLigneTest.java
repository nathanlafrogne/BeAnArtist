package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigneTest;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest 
{
	public OutilLigneTest()
	{
		testDessinOutilLigne();
	}
	
	private void testDessinOutilLigne()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		
		OutilLigne outilLigne = new OutilLigne();
		panneau.associerOutil(outilLigne);
		
		frame.add(panneau , BorderLayout.CENTER);
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
				new OutilLigneTest();
			}
		});
	}
}
