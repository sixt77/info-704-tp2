package Tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class Graphe {
    public ArrayList<Sommet> G;
    public ArrayList<Arc> A;
    public Graphe() {
        this.G = new ArrayList();
        this.A = new ArrayList();
    }
    public void ajouterSommet(Sommet sommet) {
        if(chercherSommet(sommet.nom) == -1) {
            this.G.add(sommet);
        }else {
            System.out.println("ce noeud existe déja");
        }
        System.out.println(this.G.size());
    }

    public void ajouterArc(Arc arc) {
        this.A.add(arc);
    }

    public int chercherSommet(String nom) {
        boolean find = false;
        int rank = 0;
        for(int i=0; i<this.G.size(); i++) {
            if(this.G.get(i).nom.equals(nom)) {
                find = true;
                rank = i;
            }
        }
        if(find) {
            return rank;
        }else {
            return -1;
        }
    }

    public void afficherListeSommet() {
        if(this.G.size() > 0) {
            System.out.println("liste des sommets : ");
            for(int i=0; i<this.G.size(); i++) {
                System.out.println(this.G.get(i).nom);
            }
        }else {
            System.out.println("liste vide");
        }
    }
    public static void afficherListeSommet(Graphe G) {
        if(G.G.size() > 0) {
            System.out.println("liste des sommets : ");
            for(int i=0; i<G.G.size(); i++) {
                if(G.G.get(i).couleur != null){
                    System.out.println("nom : "+G.G.get(i).nom+" couleur : "+G.G.get(i).couleur);
                }else{
                    System.out.println(G.G.get(i).nom);
                }

            }
        }else {
            System.out.println("liste vide");
        }
    }


    public void afficherListeArc() {
        if(this.A.size() > 0) {
            System.out.println("liste des Arc : ");
            for(int i=0; i<this.A.size(); i++) {
                System.out.println(this.A.get(i).S1.nom+" -> "+this.A.get(i).S2.nom);
            }
        }else {
            System.out.println("liste vide");
        }
    }

    public Sommet selectionnerSommet() {
        Boolean trouve1 = false;
        Scanner sc = new Scanner(System.in);
        Sommet sommet1 = null;
        while(trouve1 == false) {
            this.afficherListeSommet();
            System.out.println("Veuillez choisir un sommet :");
            String valeur1 = sc.nextLine();
            if(this.chercherSommet(valeur1) != -1) {
                sommet1 = this.G.get(this.chercherSommet(valeur1));
                trouve1 = true;
            }else {
                System.out.println("le sommet n'existe pas dans le graphe");
            }
        }
        return sommet1;
    }
    public void effaceSommet(Sommet sommet1){
        boolean delete;
        for(int i = 0; i <this.A.size(); i++){
            delete = false;
            if(this.A.get(i).S1.nom.equals(sommet1.nom)){
                delete = true;
            }
            if(this.A.get(i).S2.nom.equals(sommet1.nom)){
                delete = true;
            }
            if(delete){
                this.A.remove(this.A.get(i));
                i = i-1;
            }
        }
        for(int i = 0; i <this.G.size(); i++){
            if(this.G.get(i).nom.equals(sommet1.nom)){
                this.G.remove(i);
            }
        }
    }
    public boolean verifierCertificat(){
        boolean verif = true;
        for(int i = 0; i < this.A.size(); i++){
            if(this.A.get(i).S1.couleur.equals(this.A.get(i).S2.couleur)){
                verif = false;
            }
        }
        return verif;
    }
    public void genereEtTest(){
        int nbPossible = puissance(3, this.G.size());
        ArrayList<Graphe> grapheList = new ArrayList();
        for(int i = 0; i < nbPossible; i++){
            grapheList.add(this);
            for(int j = 0; j < grapheList.get(i).G.size()-1; j++){
                //cas classique
                grapheList.get(i).G.get(j).changerCouleur(Integer.toString((i/(Math.round(puissance(3,this.G.size()-j-1)))%3)+1));
            }
            //dernier sommet

            if((i + 1)% 3 == 0){
                grapheList.get(i).G.get(grapheList.get(i).G.size()-1).changerCouleur(Integer.toString(3));
            }else{
                grapheList.get(i).G.get(grapheList.get(i).G.size()-1).changerCouleur(Integer.toString((i + 1)%3));
            }
            afficherListeSommet(grapheList.get(i));
        }



    }
    public static int puissance(int v, int p){
        int initial = v;
        if(p != 0){
            for(int i = 1; i < p; i++){
                v = v * initial;
            }
        }else{
            v = 0;
        }
        return v;
    }
}
