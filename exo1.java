import java.util.Scanner;
import java.io.File;


public class exo1 {


        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Veuillez saisir un chemin d'acces:");
            String entree = scan.nextLine();

            File f = new File(entree);
            System.out.println("Chemin absolu : " + f.getAbsolutePath());
            System.out.println("Est-ce un répertoire ? " + f.isDirectory());
            System.out.println("Est-ce un fichier ? " + f.isFile());


        }
    }
