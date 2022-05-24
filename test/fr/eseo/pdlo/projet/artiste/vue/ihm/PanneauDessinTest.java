package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class PanneauDessinTest {

	public PanneauDessinTest()
	{
		testConstructeurParDefaut();
		testConstructeur();
	}
	
	private void testConstructeurParDefaut()
	{
		JFrame frame = new JFrame("Etre un Artiste"); // Creer fenetre
		PanneauDessin panneau = new PanneauDessin();  // Creer panneau
		
		frame.add(panneau , BorderLayout.CENTER);     // Ajoute le panneau a la fenetre
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Definit les parametre de fermeture
		frame.pack();				// Met tout ensemble
		frame.setLocationRelativeTo(null);	
		frame.setVisible(true);		// Affiche la page
	}
	
	private void testConstructeur()
	{
		JFrame frame = new JFrame("Blues du Businessman");
		PanneauDessin panneau = new PanneauDessin(1920 , 1200 , Color.LIGHT_GRAY);
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
				new PanneauDessinTest();
			}
		});
	}

}
