import java.util.Scanner;

public class Exo2 {

        public static void main(String[] args) {

           Scanner scan = new Scanner(System.in);
           System.out.println("Veuillez saisir un chemin d'acces:");
           String entree = scan.nextLine();

           String[] fichiers = new java.io.File(entree).list( );

           for (int i=0; i<fichiers.length; i++)
                {
                    System.out.println(fichiers[i]);
                }

        }

    }

