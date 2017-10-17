import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

    public class Exo6 {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);

            System.out.println("Veuillez saisir l'url de l'image en jpg :");
            String url = scan.nextLine();

            System.out.println("Quel nom voulez vous donner à votre image ? ");
            String nom = scan.nextLine();

            try {
                BufferedImage image =  ImageIO.read(new URL(url));
                ImageIO.write(image, "jpg", new File("./"+nom+".jpg"));

            } catch (IOException e) { e.printStackTrace(); }
        }
    }

