package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauBarreEtatTest 
{
	public PanneauBarreEtatTest()
	{
		testConstructeurParDefaut();
	}
	
	private void testConstructeurParDefaut()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreEtat panneauEtat = new PanneauBarreEtat(panneau);
		
		frame.add(panneau , BorderLayout.CENTER);
		frame.add(panneauEtat , BorderLayout.SOUTH);
		
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
				new PanneauBarreEtatTest();
			}
		});
	}

}
