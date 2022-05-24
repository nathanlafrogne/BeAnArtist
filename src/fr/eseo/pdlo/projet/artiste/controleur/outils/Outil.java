package fr.eseo.pdlo.projet.artiste.controleur.outils;


import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;


public abstract class Outil implements javax.swing.event.MouseInputListener 
{	
	private Coordonnees debut;
	private Coordonnees fin;
	private Coordonnees enCours;
	private PanneauDessin panneauDessin;
	private boolean premier;
	
	public void setDebut(Coordonnees debut)
	{
		this.debut = debut;
	}
	
	public void setFin(Coordonnees fin)
	{
		this.fin = fin;
	}
	
	public boolean estPremier()
	{
		return this.premier;
	}
	
	public void setPremier(boolean b)
	{
		this.premier = b;
	}
	
	public PanneauDessin getPanneauDessin()
	{
		return this.panneauDessin;
	}
	
	public Coordonnees getDebut()
	{
		return this.debut;
	}
	
	public Coordonnees getFin()
	{
		return this.fin;
	}
	
	public Coordonnees getPositionCourant()
	{
		return this.enCours;
	}
	
	public void setPositionCourant(Coordonnees coord)
	{
		this.enCours = coord;
	}
	
	public void setPanneauDessin(PanneauDessin panneau)
	{
		this.panneauDessin = panneau;
	}
	
	public void mouseEntered(MouseEvent event)
	{
		
	}
	
	public void mouseDragged(MouseEvent event)
	{
		
	}
	
	public void mouseExited(MouseEvent event)
	{
		
	}
	
	public void mouseMoved(MouseEvent event)
	{
		
	}
	
	public void mouseClicked(MouseEvent event)
	{
		
	}
	
	public void mousePressed(MouseEvent event)
	{
		this.setDebut(new Coordonnees(event.getX() , event.getY()));
	}
	
	public void mouseReleased(MouseEvent event)
	{
		this.setFin(new Coordonnees(event.getX(),event.getY()));
	}
	
	public abstract String getNom();
	
}
