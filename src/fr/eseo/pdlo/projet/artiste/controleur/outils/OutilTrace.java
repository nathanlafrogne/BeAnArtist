package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Trace;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueTrace;

public class OutilTrace extends OutilForme
{
    private ArrayList<Coordonnees> points;
    public static final String NOM = "Trace";

    protected VueForme creerVueForme()
    {
        Trace trace = new Trace(this.points.get(0),this.points.get(1));
        if(this.points.size()!=2)
        	this.getPanneauDessin().removeLast();
        for (int k = 2 ; k < this.points.size() ; k++)
            trace.ajouterPoint(this.points.get(k));
        trace.setCouleur(this.getPanneauDessin().getCouleurCourante());
        VueTrace vueTrace = new VueTrace(trace);
        super.getPanneauDessin().ajouterVueForme(vueTrace);
        this.getPanneauDessin().repaint();
        return vueTrace;
    }

    public void mouseDragged(MouseEvent event)
    {
        this.points.add(new Coordonnees(event.getX() , event.getY()));
        this.creerVueForme();
    }

    public void mousePressed(MouseEvent event)
    {
        this.points = new ArrayList<Coordonnees>();
        super.setDebut(new Coordonnees(event.getX(),event.getY()));
        this.points.add(super.getDebut());
    }

    public void mouseReleased(MouseEvent event)
    {
        super.setFin(new Coordonnees(event.getX(),event.getY()));
        this.creerVueForme();
    }

    public String getNom()
	{
		return this.NOM;
	}
}
