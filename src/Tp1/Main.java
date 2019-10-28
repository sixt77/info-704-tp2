package Tp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            System.out.println("10- SBT");
            System.out.println("11- graphe from file");
            System.out.println("12- SAT");
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
                    Sommet S4 = new Sommet("S4");
                    Sommet S5 = new Sommet("S5");
                    Sommet S6 = new Sommet("S6");
                    Sommet S7 = new Sommet("S7");
                    Sommet S8 = new Sommet("S8");
                    Sommet S9 = new Sommet("S9");
                    Sommet S10 = new Sommet("S10");

                    graphe.ajouterSommet(S1);
                    graphe.ajouterSommet(S2);
                    graphe.ajouterSommet(S3);
                    graphe.ajouterSommet(S4);
                    graphe.ajouterSommet(S5);
                    graphe.ajouterSommet(S6);
                    graphe.ajouterSommet(S7);
                    graphe.ajouterSommet(S8);
                    graphe.ajouterSommet(S9);
                    graphe.ajouterSommet(S10);

                    //arc
                    graphe.ajouterArc(new Arc(S1, S2));
                    graphe.ajouterArc(new Arc(S1, S4));
                    graphe.ajouterArc(new Arc(S1, S6));
                    graphe.ajouterArc(new Arc(S2, S3));
                    graphe.ajouterArc(new Arc(S2, S9));
                    graphe.ajouterArc(new Arc(S3, S5));
                    graphe.ajouterArc(new Arc(S3, S8));
                    graphe.ajouterArc(new Arc(S4, S7));
                    graphe.ajouterArc(new Arc(S4, S8));
                    graphe.ajouterArc(new Arc(S5, S6));
                    graphe.ajouterArc(new Arc(S5, S7));
                    graphe.ajouterArc(new Arc(S6, S10));
                    graphe.ajouterArc(new Arc(S7, S9));
                    graphe.ajouterArc(new Arc(S8, S10));
                    graphe.ajouterArc(new Arc(S9, S10));



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

                case 10 :
                    graphe.solveBackTracking();
                    break;

                case 11 :
                    readFile();
                    break;

                case 12 :
                    graphe.SATClause();
                    break;

                default:
                    System.out.println("erreur");
            }

        }
    }
    public static void readFile(){
        BufferedReader objReader = null;
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader("C:\\Users\\sacha\\eclipse-workspace\\S2\\info-604 tp2\\test\\test.txt"));

            while ((strCurrentLine = objReader.readLine()) != null) {

                System.out.println(strCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }




}
