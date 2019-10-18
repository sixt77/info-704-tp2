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
            System.out.println("7- graphe de test");
            System.out.println("8- verif");
            System.out.println("9- genere et test");
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
                    graphe.ajouterSommet(nouveau = new Sommet(nom));
                    break;

                case 2:
                    Arc nouveauArc;
                    if(graphe.G.size()>=2) {
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

                case 7:
                    //sommet
                    Sommet S1 = new Sommet("S1");
                    Sommet S2 = new Sommet("S2");
                    Sommet S3 = new Sommet("S3");
                    //sommet
                    graphe.ajouterSommet(S1);
                    graphe.ajouterSommet(S2);
                    graphe.ajouterSommet(S3);
                    //arc
                    graphe.ajouterArc(new Arc(S1, S2));
                    graphe.ajouterArc(new Arc(S2, S3));
                    //graphe.ajouterSommet(nouveau = new Sommet("S4"));
                    //graphe.ajouterSommet(nouveau = new Sommet("S5", couleur));
                    //graphe.ajouterSommet(nouveau = new Sommet("S6", couleur));
                    //graphe.ajouterSommet(nouveau = new Sommet("S7", couleur));
                    //graphe.ajouterSommet(nouveau = new Sommet("S8", couleur));
                    //graphe.ajouterSommet(nouveau = new Sommet("S9", couleur));
                    //graphe.ajouterSommet(nouveau = new Sommet("S10", couleur));
                    System.out.println("graphe de test généré");
                    break;

                case 8 :
                    if(graphe.verifierCertificat()){
                        System.out.println("solution valide");
                    }else{
                        System.out.println("solution invalide");
                    }
                    break;

                case 9 :
                    graphe.genereEtTest();
                    break;
                default:
                    System.out.println("erreur");
            }

        }

    }


}
