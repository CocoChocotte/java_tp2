package exercice4;
import java.io.*;
import java.util.Scanner;

public class Exo4 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir un chemin d'acces:");
        String entree = scan.nextLine();

        File f = new File (entree);


        try
        {
            FileWriter fw = new FileWriter (f);

            Scanner donneAjoute = new Scanner(System.in);
            System.out.println("Que voulez vous ajouter a votre fichier ? ");
            String ajout = donneAjoute.next();

           while (ajout.equals("quit") )
            {
                fw.write (String.valueOf (ajout));
                fw.write ("\r\n");
                ajout = donneAjoute.next();
            }

            fw.close();
        }
        catch (IOException exception)
        {
            System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
        }
    }

}
