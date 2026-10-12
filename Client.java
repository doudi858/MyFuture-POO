public class Client {
    private String cin;
    private String nom;
    private String prenom;
    private String telephone;

    public Client(String cin, String nom, String prenom, String telephone) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public void afficherClient() {
        System.out.println("[CIN: " + cin + "] Nom & Prénom: " + nom + " " + prenom + " | Tél: " + telephone);
    }

    // Méthode main de test pour exécuter "java Client"
    public static void main(String[] args) {
        Client c = new Client("07123456", "Ben Salah", "Sonia", "98765432");
        c.afficherClient();
    }
}