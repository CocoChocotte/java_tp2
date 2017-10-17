import java.io.File;
import java.util.Scanner;



public class Exo3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir un chemin d'acces:");
        String entree = scan.nextLine();

        String[] fichiers = new java.io.File(entree).list( );


        for (int i = 0; i < fichiers.length; i++) {
            if ( fichiers[i].endsWith(".txt") | fichiers[i].endsWith(".php") | fichiers[i].endsWith(".py") ){
                System.out.println(fichiers[i]);
            }
        }
    }


}


