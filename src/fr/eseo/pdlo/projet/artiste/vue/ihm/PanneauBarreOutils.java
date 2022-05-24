package fr.eseo.pdlo.projet.artiste.vue.ihm;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionAnnulerSuppressionForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChangerCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;


public class PanneauBarreOutils extends JPanel
{
	private PanneauDessin panneauDessin;

	public PanneauBarreOutils(PanneauDessin panneauDessin)
	{
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.initComponents();
	}
	
	private void initComponents()
	{
		// Création bouton Effacer
		JButton boutonEffacer = new JButton(new ActionEffacer(this.panneauDessin));
		this.add(boutonEffacer);
		boutonEffacer.setText(ActionEffacer.NOM_ACTION);
		
		
		
		// Création ToggleButton Action
		ActionChoisirForme actionLigne = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_LIGNE);
		ActionChoisirForme actionCercle = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_CERCLE);
		ActionChoisirForme actionEllipse = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ActionChoisirForme actionRectangle = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_RECTANGLE);
		ActionChoisirForme actionCarre = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_CARRE);
		ActionChoisirForme actionTrace = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_TRACE);
		ActionChoisirForme actionPolygone = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_POLYGONE_REGULIER);
		ActionChoisirForme actionPolygoneIrr = new ActionChoisirForme(this.panneauDessin , 
				this , ActionChoisirForme.NOM_ACTION_POLYGONE_IRREGULIER);
		ButtonGroup boutonGroupe = new ButtonGroup();
		
		this.ajouteBoutonForme(actionCercle, boutonGroupe, ActionChoisirForme.NOM_ACTION_CERCLE);
		this.ajouteBoutonForme(actionLigne, boutonGroupe, ActionChoisirForme.NOM_ACTION_LIGNE);
		this.ajouteBoutonForme(actionEllipse, boutonGroupe, ActionChoisirForme.NOM_ACTION_ELLIPSE);
		this.ajouteBoutonForme(actionRectangle, boutonGroupe, ActionChoisirForme.NOM_ACTION_RECTANGLE);
		this.ajouteBoutonForme(actionCarre, boutonGroupe, ActionChoisirForme.NOM_ACTION_CARRE);
		this.ajouteBoutonForme(actionTrace, boutonGroupe, ActionChoisirForme.NOM_ACTION_TRACE);
		this.ajouteBoutonForme(actionPolygone, boutonGroupe, ActionChoisirForme.NOM_ACTION_POLYGONE_REGULIER);
		this.ajouteBoutonForme(actionPolygoneIrr, boutonGroupe, ActionChoisirForme.NOM_ACTION_POLYGONE_IRREGULIER);
		
		
		// Création ToggleButton ActionSelectionner
		ActionSelectionner actionSelectionner = new ActionSelectionner(this.panneauDessin);
		this.ajouteBoutonForme(actionSelectionner, boutonGroupe, ActionSelectionner.NOM_ACTION);
		
		// Création ToggleButton ActionChangerCouleur
		ActionChangerCouleur actionChangerCouleur = new ActionChangerCouleur(this.panneauDessin);
		this.ajouteBoutonForme(actionChangerCouleur, boutonGroupe, ActionChangerCouleur.NOM_ACTION);
		
		// Création Button ActionerChoisirCouleur
		ActionChoisirCouleur actionChoisirCouleur = new ActionChoisirCouleur(this.panneauDessin);
		this.ajouterBouton(actionChoisirCouleur, actionChoisirCouleur.NOM_ACTION);
		
		
		
		// Création ToggleButton ActionChoisirModeRemplissage
		ButtonGroup boutonGroupeRemplissage = new ButtonGroup();
		ActionChoisirModeRemplissage actionAucune = new ActionChoisirModeRemplissage(this.panneauDessin , Remplissage.AUCUNE);
		ActionChoisirModeRemplissage actionUniforme = new ActionChoisirModeRemplissage(this.panneauDessin , Remplissage.UNIFORME);
		ActionChoisirModeRemplissage actionDifferent = new ActionChoisirModeRemplissage(this.panneauDessin , Remplissage.DIFFERENT);
		ActionChoisirModeRemplissage actionDegrade = new ActionChoisirModeRemplissage(this.panneauDessin , Remplissage.DEGRADE);
		JToggleButton boutonAucune = new JToggleButton(actionAucune);
		JToggleButton boutonUniforme = new JToggleButton(actionUniforme);
		JToggleButton boutonDifferent = new JToggleButton(actionDifferent);
		JToggleButton boutonDegrade = new JToggleButton(actionDegrade);
		boutonGroupeRemplissage.add(boutonAucune);
		boutonGroupeRemplissage.add(boutonUniforme);
		boutonGroupeRemplissage.add(boutonDifferent);
		boutonGroupeRemplissage.add(boutonDegrade);
		
		this.add(boutonAucune);
		this.add(boutonUniforme);
		this.add(boutonDifferent);
		this.add(boutonDegrade);
		boutonAucune.setSelected(getFocusTraversalKeysEnabled());
		
		
		// Création Button restaurerForme
		ActionAnnulerSuppressionForme actionRestaurer = new ActionAnnulerSuppressionForme(this.panneauDessin);
		JButton boutonRestaurer = new JButton(actionRestaurer);
		boutonRestaurer.setName(ActionAnnulerSuppressionForme.NOM_ACTION);
		this.add(boutonRestaurer);
	}
	
	private void ajouteBoutonForme(AbstractAction action , ButtonGroup groupe , String nom)
	{
		JToggleButton bouton = new JToggleButton(action);
		bouton.setName(nom);
		groupe.add(bouton);
		this.add(bouton);
	}
	
	private void ajouterBouton(AbstractAction action , String nom)
	{
		JButton bouton = new JButton(action);
		bouton.setName(nom);
		this.add(bouton);
	}
}
