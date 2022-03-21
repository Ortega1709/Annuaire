import classes.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // linked list
        LinkedList<Annuaire> annuaires = new LinkedList<>();

        // annuaire 1
        Annuaire annuaire = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire1 = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire2 = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire3 = new Annuaire("","","",new Adresse(1,"","",""));
        Annuaire annuaire4 =  new Annuaire("","","",new Adresse(1,"","",""));

        // add annuaire in LinkedList
        addAnnuaires(annuaires,annuaire);
        addAnnuaires(annuaires,annuaire1);
        addAnnuaires(annuaires,annuaire2);
        addAnnuaires(annuaires,annuaire3);
        addAnnuaires(annuaires,annuaire4);

        // show all annuaire in LinkedList
        showAllAnnuaires(annuaires);
        findAnnuaire(annuaires,2);

    }

    // fonction show all annuaire in LinkedList annuaires ...
    public static void showAllAnnuaires(LinkedList<Annuaire> annuaires){
        System.out.println("*****************ANNUAIRES******************\n");
        for (int i = 0; i < annuaires.size(); i++) {
            System.out.println("ID: "+ (int) i+1);
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

    // fonction add annuaire in annuaires ...
    public static void addAnnuaires(LinkedList<Annuaire> annuaires,Annuaire annuaire){
        annuaires.add(annuaires.size(),annuaire);
    }

    // fonction to find annuaire with id ...
    public static void findAnnuaire(LinkedList<Annuaire> annuaires,int id){
        for (int i = 0; i < annuaires.size(); i++) {
            if (id == (int) i+1){
                System.out.println("ID: "+ (int) i+1);
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

}
