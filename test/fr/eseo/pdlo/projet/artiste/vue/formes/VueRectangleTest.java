package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest 
{
	
	public VueRectangleTest()
	{
		testDessinEllipse();
	}
	
	private void testDessinEllipse()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin(500,500,Color.WHITE);
		
		
		Rectangle ellipse1 = new Rectangle(200.0 , 90.0);
		ellipse1.setCouleur(Color.BLUE);
		ellipse1.setRemplissage(Remplissage.UNIFORME);
		Rectangle ellipse2 = new Rectangle();
		ellipse2.setCouleur(Color.GREEN);
		VueRectangle vueEllipse = new VueRectangle(ellipse1);
		VueRectangle vueDeBase = new VueRectangle(ellipse2);
		panneau.ajouterVueForme(vueEllipse);
		panneau.ajouterVueForme(vueDeBase);
		
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
				new VueRectangleTest();
			}
		});
	}
}
