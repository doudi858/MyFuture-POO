public class MainApp {
    
   public class CompteBancaire {
    // Attributs privés
    private String numerocompte;
    private double solde;
    private Client titulaire;

    // Attribut statique pour le compteur de comptes
    private static int nombreComptes = 0;

    // Constructeur
    public CompteBancaire(String numerocompte, double soldeInitial, Client titulaire) {
        this.numerocompte = numerocompte;
        this.solde = soldeInitial;
        this.titulaire = titulaire;
        nombreComptes++; // Incrémentation à chaque création d'un compte
    }

    // Getters et Setters
    public String getNumeroCompte() {
        return numerocompte;
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
            System.out.println("Dépôt de " + montant + " TND effectué sur le compte " + numerocompte + ".");
        } else {
            System.out.println("Erreur : Le montant du dépôt doit être supérieur à 0 !");
        }
    }

    // Retrait de solde
    public void retirer(double montant) {
        if (montant > 0 && montant <= this.solde) {
            this.solde -= montant;
            System.out.println("Retrait de " + montant + " TND effectué sur le compte " + numerocompte + ".");
        } else {
            System.out.println("Échec : Solde insuffisant sur le compte " + numerocompte + " (Solde actuel: " + this.solde + " TND).");
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
        System.out.println("Compte N°: " + numerocompte);
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
}