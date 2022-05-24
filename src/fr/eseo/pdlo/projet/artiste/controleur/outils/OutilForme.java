package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil
{
	
	public void mouseClicked(MouseEvent event)
	{
		if(event.getClickCount() == 2) 
		{
			this.creerVueForme();
			super.getPanneauDessin().repaint();
		}
	}
	
	public void mouseReleased(MouseEvent event)
	{
		super.setFin(new Coordonnees(event.getX() , event.getY()));
		if((this.getFin().getAbscisse() != this.getDebut().getAbscisse()
				|| this.getDebut().getOrdonnee() != this.getFin().getOrdonnee())||
				(this.getFin().getAbscisse()!=event.getX() || this.getFin().getOrdonnee()!= event.getY()))
		{
			this.creerVueForme();
			super.getPanneauDessin().repaint();
			super.setPremier(true); // redevient true
		}
	}
	
	public void mousePressed(MouseEvent event)
	{
		super.setDebut(new Coordonnees(event.getX() , event.getY()));
		super.setPremier(true);
	}
	
	public void mouseDragged(MouseEvent event)
	{
		if(super.estPremier())
		{
			super.setFin(new Coordonnees(event.getX(),event.getY()));
			this.creerVueForme();
			super.setPremier(false); // Devient false
		}
		else
		{
			super.setFin(new Coordonnees(event.getX(),event.getY()));
			this.creerVueForme();
		}
		super.getPanneauDessin().repaint();
	}
	
	protected abstract VueForme creerVueForme();
	
}
