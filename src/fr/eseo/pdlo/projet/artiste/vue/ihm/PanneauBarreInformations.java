package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class PanneauBarreInformations extends javax.swing.JPanel implements MouseMotionListener
{
	private JLabel message;
	private PanneauDessin panneauDessin;
	
	public PanneauBarreInformations(PanneauDessin panneauDessin)
	{
		this.panneauDessin = panneauDessin;
		this.panneauDessin.addMouseMotionListener(this);
		this.message = new JLabel("Selectionner un Outil");
		this.add(message);
	}
	
	public void mouseDragged(MouseEvent event)
	{
		Coordonnees temp = new Coordonnees(event.getX(),event.getY());
		this.mettreAJourAffichage(temp);
	}
	
	public void mouseMoved(MouseEvent event)
	{
		Coordonnees temp = new Coordonnees(event.getX(),event.getY());
		this.mettreAJourAffichage(temp);
	}
	
	private void mettreAJourAffichage(Coordonnees coords)
	{
		this.message.setText("x: " + coords.getAbscisse());
	}

}
