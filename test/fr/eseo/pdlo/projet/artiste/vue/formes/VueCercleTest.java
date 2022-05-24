package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest 
{
	
	public VueCercleTest()
	{
		testDessinCercle();
	}
	
	private void testDessinCercle()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		
		Cercle cercle = new Cercle(30.0);
		cercle.setCouleur(Color.BLUE);
		VueCercle vueCercle = new VueCercle(cercle);
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
				new VueCercleTest();
			}
		});
	}
}
