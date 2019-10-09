package Tp1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean fin = false;
        Graphe graphe = new Graphe();

        while (!fin) {
            System.out.println(" Commandes :");
            System.out.println("1- creer noeud");
            System.out.println("2- creer arc");
            System.out.println("3- afficher liste sommet");
            System.out.println("4- afficher liste arc");
            System.out.println("5- supprimer noeud");
            System.out.println("6- finir");
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez saisir votre choix :");
            int value = sc.nextInt();
            switch (value) {
                case 1:
                    Scanner sc2 = new Scanner(System.in);
                    Scanner sc3 = new Scanner(System.in);
                    Sommet nouveau;
                    System.out.println("Veuillez saisir un nom :");
                    String nom = sc2.nextLine();
                    System.out.println("Veuillez saisir une couleur :");
                    String couleur = sc3.nextLine();
                    graphe.ajouterSommet(nouveau = new Sommet(nom, couleur));
                    break;

                case 2:
                    Arc nouveauArc;
                    if(graphe.A.size()>=2) {
                        Sommet noeud1 = graphe.selectionnerSommet();
                        Sommet noeud2 = graphe.selectionnerSommet();
                        graphe.A.add(nouveauArc = new Arc(noeud1, noeud2));
                        System.out.println("arc ajouté");

                    }else {
                        System.out.println("le graphe ne contient pas assez de sommet");
                    }
                    break;

                case 3:
                    graphe.afficherListeSommet();
                    break;

                case 4:
                    graphe.afficherListeArc();
                    break;

                case 5:
                    Sommet sommet6 = graphe.selectionnerSommet();
                    graphe.effaceSommet(sommet6);
                    break;
                case 6:
                    fin = true;
                    System.out.println("aurevoir");
                    break;


                default:
                    System.out.println("erreur");
            }

        }

    }
}
