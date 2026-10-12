public class Client {
    // Attributs privés (Encapsulation)
    private String cin;
    private String nom;
    private String prenom;
    private String telephone;

    // Constructeur avec tous les paramètres
    public Client(String cin, String nom, String prenom, String telephone) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    // Getters et Setters
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Méthode d'affichage du client
    public void afficherClient() {
        System.out.println("[CIN: " + cin + "] Nom & Prénom: " + nom + " " + prenom + " | Tél: " + telephone);
    }
}
public class CompteBancaire {
    // Attributs privés
    private String numeroCompte;
    private double solde;
    private Client titulaire;

    // Attribut statique pour le compteur de comptes
    private static int nombreComptes = 0;

    // Constructeur
    public CompteBancaire(String numeroCompte, double soldeInitial, Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.titulaire = titulaire;
        nombreComptes++; // Incrémentation à chaque création d'un compte
    }

    // Getters et Setters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    // Méthode statique pour obtenir le nombre total de comptes
    public static int getNombreComptes() {
        return nombreComptes;
    }

    // Dépôt de solde
    public void deposer(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("Dépôt de " + montant + " TND effectué sur le compte " + numeroCompte + ".");
        } else {
            System.out.println("Erreur : Le montant du dépôt doit être supérieur à 0 !");
        }
    }

    // Retrait de solde
    public void retirer(double montant) {
        if (montant > 0 && montant <= this.solde) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + " TND effectué sur le compte " + numeroCompte + ".");
        } else {
            System.out.println("Échec : Solde insuffisant sur le compte " + numeroCompte + " (Solde actuel: " + this.solde + " TND).");
        }
    }

    // Virement bancaire
    public void virement(CompteBancaire destination, double montant) {
        System.out.println("Tentative de virement de " + montant + " TND vers le compte " + destination.getNumeroCompte() + "...");
        if (montant > 0 && montant <= this.solde) {
            this.retirer(montant);
            destination.deposer(montant);
            System.out.println("Virement réussi !");
        } else {
            System.out.println("Échec du virement : Solde insuffisant.");
        }
    }

    // Affichage des détails du compte
    public void afficherDetails() {
        System.out.println("Compte N°: " + numeroCompte);
        System.out.print("Titulaire: ");
        if (titulaire != null) {
            titulaire.afficherClient();
        } else {
            System.out.println("Aucun titulaire assigné.");
        }
        System.out.println("Solde Actuel: " + solde + " TND");
        System.out.println();
    }
}
public class MainApp {
    public static void main(String[] args) {
        // 1. Création des clients
        Client c1 = new Client("07123456", "Ben Salah", "Sonia", "98765432");
        Client c2 = new Client("09876543", "Kacem", "Ahmed", "50112233");

        // 2. Création des comptes bancaires
        CompteBancaire compte1 = new CompteBancaire("CB-1001", 500.0, c1);
        CompteBancaire compte2 = new CompteBancaire("CB-1002", 1500.0, c2);

        // 3. Affichage initial des comptes
        compte1.afficherDetails();
        compte2.afficherDetails();

        // 4. Test des dépôts et retraits
        compte1.deposer(200.0);           // Solde passe à 700.0
        compte1.retirer(1000.0);          // Doit échouer (solde insuffisant)
        compte1.retirer(300.0);           // Solde passe à 400.0

        System.out.println();

        // 5. Test du virement
        compte2.virement(compte1, 500.0);  // Virement de 500 TND de compte2 vers compte1

        System.out.println();

        // 6. État final et statistiques
        compte1.afficherDetails();
        compte2.afficherDetails();

        System.out.println("Nombre total de comptes créés: " + CompteBancaire.getNombreComptes());
    }
}