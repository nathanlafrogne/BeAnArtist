package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest 
{
	
	public VueEllipseTest()
	{
		testDessinEllipse();
	}
	
	private void testDessinEllipse()
	{
		JFrame frame = new JFrame("Etre un Artiste");
		PanneauDessin panneau = new PanneauDessin(500,500,Color.WHITE);
		
		
		Ellipse ellipse1 = new Ellipse(100.0 , 90.0);
		ellipse1.setCouleur(Color.BLUE);
		ellipse1.setRemplissage(Remplissage.UNIFORME);
		Ellipse ellipse2 = new Ellipse();
		ellipse2.setCouleur(Color.GREEN);
		VueEllipse vueEllipse = new VueEllipse(ellipse1);
		VueEllipse vueDeBase = new VueEllipse(ellipse2);
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
				new VueEllipseTest();
			}
		});
	}
}
