package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest 
{
	
	public VueLigneTest()
	{
		testDessinLigne();
	}
	
	private void testDessinLigne()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		
		Ligne ligne = new Ligne(30.0 , 40.0);
		ligne.setCouleur(Color.GREEN);
		VueLigne vueLigne = new VueLigne(ligne);
		panneau.ajouterVueForme(vueLigne);
		
		frame.add(panneau , BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		panneau.paintComponents(g);
		
		
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
				new VueLigneTest();
			}
		});
	}
}
