package exercice5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Exo5 {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir le fichier source:");
        String entree = scan.nextLine();


        System.out.println("Veuillez saisir le fichier cible:");
        String sortie = scan.nextLine();

        Path source = Paths.get(entree);
        Path cible = Paths.get(sortie);
        try {
            Files.copy(source, cible, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) { e.printStackTrace();  }


    }
}
