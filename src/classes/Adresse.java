package classes;

public class Adresse {
    private int numeroAvenue;
    private String nomAvenue;
    private String nomProvince;
    private String nomPays;

    public Adresse(int numeroAvenue, String nomAvenue, String nomProvince, String nomPays){
        this.numeroAvenue = numeroAvenue;
        this.nomAvenue = nomAvenue;
        this.nomProvince = nomProvince;
        this.nomPays = nomPays;
    }

    /* getters and setters */
    public int getNumeroAvenue() {
        return numeroAvenue;
    }

    public void setNumeroAvenue(int numeroAvenue) {
        this.numeroAvenue = numeroAvenue;
    }

    public String getNomAvenue() {
        return nomAvenue;
    }

    public void setNomAvenue(String nomAvenue) {
        this.nomAvenue = nomAvenue;
    }

    public String getNomProvince() {
        return nomProvince;
    }

    public void setNomProvince(String nomProvince) {
        this.nomProvince = nomProvince;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
}
