public class Client {
    public static void main(String[] args) {
        private String cin;
        private String nom;
        private String prenom;
        private String telephone;
   
    // Constructeur
    public Client(String cin, String nom, String prenom,
                  String telephone) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    // Getters
    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    // Setters
    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Afficher les informations du client
    public void afficherClient() {
        System.out.println( "[CIN: " + cin + "] Nom & Prénom: "+ nom + " " + prenom + " | Tél: " + telephone);
    }
}
public class CompteBancaire {

    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private static int nombreComptes = 0;

    // Constructeur
    public CompteBancaire(String numeroCompte,
                          double soldeInitial,
                          Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.titulaire = titulaire;
        nombreComptes++;
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public static int getNombreComptes() {
        return nombreComptes;
    }

    // Setter du titulaire
    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    // Déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Depot de " + montant
                    + " TND effectue sur le compte "
                    + numeroCompte + ".");
        } else {
            System.out.println("Montant invalide.");
        }
    }

    // Retirer de l'argent
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant
                    + " TND effectue sur le compte "
                    + numeroCompte + ".");
        } else {
            System.out.println("Echec : Solde insuffisant sur le compte "
                    + numeroCompte + " (Solde actuel : "
                    + solde + " TND).");
        }
    }

    // Effectuer un virement vers un autre compte
    public void virement(CompteBancaire destination,
                         double montant) {
        System.out.println("\nTentative de virement de "
                + montant + " TND vers le compte "
                + destination.getNumeroCompte() + "...");

        if (montant > 0 && montant <= solde) {
            retirer(montant);
            destination.deposer(montant);
            System.out.println("Virement reussi !");
        } else {
            System.out.println("Virement impossible : montant invalide "
                    + "ou solde insuffisant.");
        }
    }

    // Afficher les détails
    public void afficherDetails() {
        System.out.println("Compte N° : " + numeroCompte);
        titulaire.afficherClient();
        System.out.println("Solde Actuel : " + solde + " TND");
    }
}
public class MainApp {

    public static void main(String[] args) {

        // 1. Creation des clients
        Client c1 = new Client(
                "07123456", "Ben Salah", "Sonia", "98765432");

        Client c2 = new Client(
                "09876543", "Kacem", "Ahmed", "50112233");

        // 2. Creation des comptes bancaires
        CompteBancaire compte1 =
                new CompteBancaire("CB-1001", 500.0, c1);

        CompteBancaire compte2 =
                new CompteBancaire("CB-1002", 1500.0, c2);

        // 3. Affichage initial des comptes
        compte1.afficherDetails();
        compte2.afficherDetails();

        // 4. Test des depots et retraits
        compte1.deposer(200.0);
        compte1.retirer(1000.0);
        compte1.retirer(300.0);

        // 5. Test du virement
        compte2.virement(compte1, 500.0);

        // 6. Etat final et statistiques
        System.out.println("\n--- Etat final ---");
        compte1.afficherDetails();
        compte2.afficherDetails();

        System.out.println("\nNombre total de comptes crees : "
                + CompteBancaire.getNombreComptes());
    }
}


