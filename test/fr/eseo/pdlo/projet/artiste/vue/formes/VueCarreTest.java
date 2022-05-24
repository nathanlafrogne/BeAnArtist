package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest 
{
	
	public VueCarreTest()
	{
		testDessinCercle();
	}
	
	private void testDessinCercle()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		
		Carre cercle = new Carre(30.0);
		cercle.deplacerDe(10.0, 10.0);
		cercle.setCouleur(Color.BLUE);
		VueCarre vueCercle = new VueCarre(cercle);
		panneau.ajouterVueForme(vueCercle);
		
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
				new VueCarreTest();
			}
		});
	}
}
