import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestExo4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir un chemin d'acces:");
        String entree = scan.nextLine();
        File f = new File(entree);
        try {
            FileWriter fw = new FileWriter(f, true);
            Scanner donneAjoute = new Scanner(System.in);
            System.out.println("Que voulez vous ajouter a votre fichier ? ");
            String ajout = donneAjoute.nextLine();
            while (!ajout.equals("quit")) {
                fw.write(ajout);
                fw.write("\r\n");
                ajout = donneAjoute.nextLine();
            }

            fw.close();
        } catch (IOException exception) {
            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
        }
    }
}
