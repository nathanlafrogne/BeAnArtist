package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilPolygoneIrregulier;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilPolygoneRegulier;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilTrace;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction
{
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_RECTANGLE = "Rectangle";
	public static final String NOM_ACTION_CARRE = "Carré";
	public static final String NOM_ACTION_TRACE = "Trace";
	public static final String NOM_ACTION_POLYGONE_REGULIER = "Polygone Regulier";
	public static final String NOM_ACTION_POLYGONE_IRREGULIER = "Polygone Irrégulier";
	
	private PanneauDessin panneauDessin;
	private String nom;
	
	public ActionChoisirForme(PanneauDessin panneauDessin , PanneauBarreOutils panneauOutil , String nom)
	{
		super(nom);
		this.panneauDessin = panneauDessin;
		this.panneauDessin.add(panneauOutil);
		this.nom = nom;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		Outil outil = null;
		if(this.nom.equals(NOM_ACTION_LIGNE))
			outil = new OutilLigne();
		else if(this.nom.equals(NOM_ACTION_ELLIPSE))
			outil = new OutilEllipse();
		else if(this.nom.equals(NOM_ACTION_CERCLE))
			outil = new OutilCercle();
		else if(this.nom.equals(NOM_ACTION_RECTANGLE))
			outil = new OutilRectangle();
		else if(this.nom.equals(NOM_ACTION_CARRE))
			outil = new OutilCarre();
		else if(this.nom.equals(NOM_ACTION_TRACE))
			outil = new OutilTrace();
		else if(this.nom.equals(NOM_ACTION_POLYGONE_REGULIER))
			// Demander nombre cote
			outil = new OutilPolygoneRegulier();
		else if(this.nom.equals(NOM_ACTION_POLYGONE_IRREGULIER))
			outil = new OutilPolygoneIrregulier();
		this.panneauDessin.associerOutil(outil);
	}
}
