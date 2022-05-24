package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class PanneauBarreEtat extends javax.swing.JPanel implements MouseMotionListener
{
	private JLabel valeurX;
	private JLabel valeurY;
	private JLabel nomOutilCourant;
	private PanneauDessin panneauDessin;
	private JLabel modeRemplissage;
	private JLabel nbFormes;
	
	public PanneauBarreEtat(PanneauDessin panneauDessin)
	{
		this.panneauDessin = panneauDessin;
		this.panneauDessin.addMouseMotionListener(this);
		this.valeurX = new JLabel("x: 0");
		this.valeurY = new JLabel("y: 0" );
		if(this.panneauDessin.getVueFormes() == null)
			this.nbFormes = new JLabel("  |   Nombre de formes : 0");
		else
			this.nbFormes = new JLabel("  |   Nombre de formes : " + this.panneauDessin.getVueFormes().size());
		if(this.panneauDessin.getOutilCourant() == null)
			this.nomOutilCourant = new JLabel("  |   Pas d'outil sélectionné");
		else
			this.nomOutilCourant = new JLabel("  |   Outil courant : " + this.panneauDessin.getOutilCourant().getNom());
		this.modeRemplissage = new JLabel("  |   Mode remplissage courant : " + this.panneauDessin.getModeRemplissageCourant().getMode());
		this.add(new JLabel("Position souris : "));
		this.add(valeurX);
		this.add(valeurY);
		this.add(nomOutilCourant);
		this.add(modeRemplissage);
		this.add(nbFormes);
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
		this.valeurX.setText("x: " + coords.getAbscisse());
		this.valeurY.setText("y: " + coords.getOrdonnee());
		if(this.panneauDessin.getOutilCourant() == null)
			this.nomOutilCourant.setText("  |   Pas d'outil sélectionné");
		else
			this.nomOutilCourant.setText("  |   Outil courant : " + this.panneauDessin.getOutilCourant().getNom());
		this.modeRemplissage.setText("  |   Mode remplissage courant : " + this.panneauDessin.getModeRemplissageCourant().getMode());
		if(this.panneauDessin.getVueFormes() == null)
			this.nbFormes.setText("  |   Nombre de formes : 0");
		else
			this.nbFormes.setText("  |   Nombre de formes : " + this.panneauDessin.getVueFormes().size());
	}

}
