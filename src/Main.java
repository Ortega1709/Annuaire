import classes.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // linked list
        LinkedList<Annuaire> annuaires = new LinkedList<>();

        // show all annuaire in linkedList
        allAnnuaires(annuaires);
    }

    // fonction show all annuaire in LinkedList annuaires ...
    public static void allAnnuaires(LinkedList<Annuaire> annuaires){
        System.out.println("*****************ANNUAIRES******************\n");

        for (int i = 0; i < annuaires.size(); i++) {
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

    // fonction add annuaire in annuaires

}
