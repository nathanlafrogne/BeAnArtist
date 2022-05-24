package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest 
{
	public OutilCercleTest()
	{
		testDessinOutilLigne();
	}
	
	private void testDessinOutilLigne()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		
		OutilCercle outilCercle = new OutilCercle();
		panneau.associerOutil(outilCercle);
		
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
				new OutilCercleTest();
			}
		});
	}
}
