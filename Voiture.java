import java.util.Scanner;

public class Voiture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sommeKilometrage = 0;

        for (int i = 1; i <= 2; i++) {
            System.out.println("\n--- Voiture " + i + " ---");

            System.out.print("Entrez la marque : ");
            String marque = sc.nextLine();

            System.out.print("Entrez la couleur : ");
            String couleur = sc.nextLine();

            System.out.print("Entrez le kilometrage : ");
            int kilometrage = sc.nextInt();
            sc.nextLine();

            afficherDetailsVoiture(marque, couleur, kilometrage);

            sommeKilometrage += kilometrage;
        }

        System.out.println("\nSomme des kilometrages : "
                + sommeKilometrage + " km");

        sc.close();
    }

    public static void afficherDetailsVoiture(
            String marque, String couleur, int kilometrage) {
        System.out.println("Marque : " + marque);
        System.out.println("Couleur : " + couleur);
        System.out.println("Kilometrage : " + kilometrage + " km");
    }
}