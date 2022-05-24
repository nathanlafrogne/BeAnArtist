package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme
{
	public static final String NOM = "Ligne";
	
	protected VueForme creerVueForme()
	{
		Coordonnees debut = super.getDebut();
		Coordonnees fin = super.getFin();
		Ligne ligne;
		if(debut.getAbscisse() != fin.getAbscisse() || debut.getOrdonnee() != fin.getOrdonnee())
			ligne = new Ligne(debut , fin.getAbscisse() - debut.getAbscisse() , fin.getOrdonnee() - debut.getOrdonnee());
		else
			ligne = new Ligne(super.getDebut());
		
		ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
		VueLigne vueLigne = new VueLigne(ligne);
		vueLigne.setAlias(this.getPanneauDessin().aliasActif());
		if(!super.estPremier())
        	this.getPanneauDessin().removeLast();
		super.getPanneauDessin().ajouterVueForme(vueLigne);
		return vueLigne;
	}
	
	public String getNom()
	{
		return this.NOM;
	}
}
