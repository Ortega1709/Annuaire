import classes.*;

import java.net.IDN;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        /* linked list */
        LinkedList<Annuaire> annuaires = new LinkedList<>();

        /* annuaire 1 */
        Annuaire annuaire = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire1 = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire2 = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire3 = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire4 =  new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire5 = new Annuaire(
                "Kabwe Mulunda",
                "Ortega",
                "0996875512",
                new Adresse(
                        1,
                        "Depot",
                        "Haut-Katanga",
                        "RDC"));

        /* add annuaire in LinkedList */
        addAnnuaires(annuaires,annuaire);
        addAnnuaires(annuaires,annuaire1);
        addAnnuaires(annuaires,annuaire2);
        addAnnuaires(annuaires,annuaire3);
        addAnnuaires(annuaires,annuaire4);

        /* show all annuaire in LinkedList */
        showAllAnnuaires(annuaires);
        //findAnnuaire(annuaires,2);

        deleteAnnuaire(annuaires,1);
        deleteAnnuaire(annuaires,2);
        deleteAnnuaire(annuaires,3);
        showAllAnnuaires(annuaires);

    }

    /* fonction show all annuaire in LinkedList annuaires ...*/
    public static void showAllAnnuaires(LinkedList<Annuaire> annuaires){
        System.out.println("*****************ANNUAIRES******************\n");
        for (int i = 0; i < annuaires.size(); i++) {
            int ID = (int) i+1;
            System.out.println("ID: "+ ID);
            System.out.println("Nom: "+annuaires.get(i).getNom());
            System.out.println("Prenom: "+annuaires.get(i).getPrenom());
            System.out.println("Numero: "+annuaires.get(i).getNumero());
            System.out.println("Numero Avenue: "+annuaires.get(i).getAdresse().getNumeroAvenue());
            System.out.println("Avenue: "+annuaires.get(i).getAdresse().getNomAvenue());
            System.out.println("Province: "+annuaires.get(i).getAdresse().getNomProvince());
            System.out.println("Pays: "+annuaires.get(i).getAdresse().getNomPays());
            System.out.println("\n*********************************************");
        }
    }

    /* fonction add annuaire in annuaires ...*/
    public static void addAnnuaires(LinkedList<Annuaire> annuaires,Annuaire annuaire){
        annuaires.add(annuaires.size(),annuaire);
    }

    /* fonction to find annuaire with id ...*/
    public static void findAnnuaire(LinkedList<Annuaire> annuaires,int id){
        for (int i = 0; i < annuaires.size(); i++) {
            if (id == (int) i+1){
                int ID = (int) i+1;
                System.out.println("ID: "+ ID);
                System.out.println("Nom: "+annuaires.get(i).getNom());
                System.out.println("Prenom: "+annuaires.get(i).getPrenom());
                System.out.println("Numero: "+annuaires.get(i).getNumero());
                System.out.println("Numero Avenue: "+annuaires.get(i).getAdresse().getNumeroAvenue());
                System.out.println("Avenue: "+annuaires.get(i).getAdresse().getNomAvenue());
                System.out.println("Province: "+annuaires.get(i).getAdresse().getNomProvince());
                System.out.println("Pays: "+annuaires.get(i).getAdresse().getNomPays());
                System.out.println("\n*********************************************");
            }
        }
    }

    /* fonction update annuaire with id */
    public static void updateAnnuaire(LinkedList<Annuaire> annuaires, Annuaire annuaire, int id){
        for (int i = 0; i < annuaires.size(); i++) {
            if (i == id-1){
                annuaires.remove(i);
                annuaires.add(i,annuaire);
            }
        }
    }

    public static void deleteAnnuaire(LinkedList<Annuaire> annuaires, int id){
        for (int i = 0; i < annuaires.size(); i++) {
            if (i == id-1){
                annuaires.remove(i);
            }
        }
    }

}
