import java.util.Scanner;

public class AppBanque {

    Run | Debug
    public static void main(String[] args) {

        scanner sc = new scanner(system.in);

        int cin;
        String nom;
        String prenom;
        int ncompte;
        int choix;

        final float plafond PLAFOND RETRAIT = 500.00f;

        System.out.println(x: "Veuillez saisir CIN : ");
        cin = sc.nextInt();

        System.out.println(x: "Veuillez saisir le nom : ");
        nom = sc.nextLine();

        System.out.println(x: "Veuillez saisir le prénom : ");
        prenom = sc.nextLine();

        System.out.println(x: "Veuillez saisir le numéro de compte : ");
        ncompte = sc.nextInt();

        do {

            System.out.println(x: "1. Consulter compte");
            System.out.println(x: "2. Déposer montant");
            System.out.println(x: "3. Retirer montant");
            System.out.println(x: "4. Quitter");

            choix = sc.nextInt();

            switch (choix) {

                case 1:
                System.out.println(nom + " " + prenom + " " + cin);
                System.out.println(ncompte);
                System.out.println(x: "Solde");
                System.out.println(x: "Plafond");
                break;

            }
        }while (choix != 4)

        sc.close();
    }
}
