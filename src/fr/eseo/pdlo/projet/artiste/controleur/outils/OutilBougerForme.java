package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.FormeComposee;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilBougerForme extends Outil
{
	public static final String FONCTIONNEMENT = "Cliquer sur les formes à bouger puis glisser pour deplacer";
	public static final String NOM = "Bouger Forme";
	private FormeComposee formeCompo;
	private double deltaPosX;
	private double deltaPosY;
	
	public void mousePressed(MouseEvent event)
	{
		System.out.println("pressed");
		System.out.println(this.getPanneauDessin().getVueFormes().size());
		for(int k = 0 ; k < super.getPanneauDessin().getVueFormes().size() ; k++)
			if(super.getPanneauDessin().getVueFormes().get(k).getForme().contient(new Coordonnees(event.getX() , event.getY())))
			{
				if(this.formeCompo != null)
				{
					this.deltaPosX = event.getX() - this.formeCompo.getPosition().getAbscisse();
					this.deltaPosY = event.getY() - this.formeCompo.getPosition().getOrdonnee();
				}
			}
	}
	
	public void mouseDragged(MouseEvent event)
	{
		if(this.formeCompo!=null)
		{
			super.setFin(new Coordonnees(event.getX(),event.getY()));
			this.formeCompo.deplacerVers(super.getFin().getAbscisse() - this.deltaPosX,
					super.getFin().getOrdonnee() - this.deltaPosY);
			super.getPanneauDessin().repaint();
		}
	}
	
	public void mouseClicked(MouseEvent event)
	{
		System.out.println("clicked");
		for(int k = 0 ; k < super.getPanneauDessin().getVueFormes().size() ; k++)
		{
			if(super.getPanneauDessin().getVueFormes().get(k).getForme().contient(new Coordonnees(event.getX() , event.getY())))
			{
				if(this.formeCompo == null)
					this.formeCompo = new FormeComposee();
				System.out.print(this.formeCompo.getFormes().size() + " ");
				this.formeCompo.ajouterForme(super.getPanneauDessin().getVueFormes().get(k).getForme());
				System.out.println(this.formeCompo.getFormes().size() + " ");
			}
		}
	}
	
	public String getNom()
	{
		return this.NOM;
	}
	
//	public void mouseReleased(MouseEvent event)
//	{
//		this.formeCompo = null;
//	}
}
