import classes.*;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        // linked list
        LinkedList<Annuaire> annuaires = new LinkedList<>();

        // three object adresse
        Adresse adresse = new Adresse(33,"Depot","Haut-Katanga","RDC");
        Adresse adresse1 = new Adresse(22,"Biayi","Haut-Katanga","RDC");
        Adresse adresse2 = new Adresse(45,"Kambove","Haut-Katanga","RDC");

        // three object annuaire
        Annuaire annuaire = new Annuaire("Kabwe Mulunda","Ortega","0996875512",adresse);
        Annuaire annuaire1 = new Annuaire("Kalombo Mutshi","Jonathan","0828547535",adresse1);
        Annuaire annuaire2 = new Annuaire("Kamba Lamu","Didier","0828585475",adresse2);

        // insertion in linkedList annuaires
        annuaires.add(0,annuaire);
        annuaires.add(1,annuaire1);
        annuaires.add(2,annuaire2);

        // show all annuaire in linkedList
        for (int i = 0; i < annuaires.size(); i++) {
            System.out.println("Nom: "+annuaires.get(i).getNom());
            System.out.println("Prenom: "+annuaires.get(i).getPrenom());
            System.out.println("Numero: "+annuaires.get(i).getNumero());
            System.out.println("Numero Avenue: "+annuaires.get(i).getAdresse().getNumeroAvenue());
            System.out.println("Avenue: "+annuaires.get(i).getAdresse().getNomAvenue());
            System.out.println("Province: "+annuaires.get(i).getAdresse().getNomProvince());
            System.out.println("Pays: "+annuaires.get(i).getAdresse().getNomPays());
            System.out.println("\n***********************************************");
        }
    }
}
