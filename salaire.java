// exercice7;
import java.util.Scanner;

public class salaire {

    public static void main(String[] args) {

        personel listeEntreprise = new personel();
        listeEntreprise.ajout(new Vendeur("Pierre",  "Business", 45, "1995", 30000));
        listeEntreprise.ajout(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        listeEntreprise.ajout(new Producteur("Yves", "Bosseur", 28, "1998", 1000));
        listeEntreprise.ajout(new Manutention("Jeanne", "Stocketout", 32, "1998", 45));
        listeEntreprise.ajout(new ProducteurRisque("Jean", "Flippe", 28, "2000", 1000));
        listeEntreprise.ajout(new ManutentionRisques("Al", "Abordage", 30, "2001", 45));

        int menu = 0;

        while (menu != 5) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Menu principal : Que voulez vous faire ? ");
            System.out.println("1: afficher liste employes");
            System.out.println("2: Calculer salaire moyen");
            System.out.println("3: Afficher les salaires");
            System.out.println("4: Ajouter un employe");
            System.out.println("5: Quitter");

            menu = sc.nextInt();

            switch (menu)
            {
                case 1:
                    listeEntreprise.afficheListeEmployes();
                    break;
                case 2:
                    listeEntreprise.calculSalaireMoyen();
                    break;
                case 3:
                    listeEntreprise.afficherSalaires();
                    break;
                case 4:
                    listeEntreprise.ajouterEmploye();
                    break;
                default:
                    System.out.println("Au revoir");
            }


        }

    }


}


class personel {

    private Employe[] listeEmployes = new Employe[15];
    private int compteur = 0;

    public void ajout (Employe employe){
        listeEmployes[compteur]= employe;
        compteur++;

    }


    public void afficherSalaires (){
        for (int i=0; i<compteur; i++){
            System.out.println(listeEmployes[i].getNomretournant() + " gagne " + listeEmployes[i].salaire );
        }
    }

    public void calculSalaireMoyen (){
        int somme=0;
        for (int i=0; i<compteur; i++){
            somme = somme + listeEmployes[i].salaire;
        }

        System.out.println("Le salaire moyen est: " + somme/compteur);

    }


    public void ajouterEmploye (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom de l'employe:");
        String nom = sc.nextLine();

        System.out.println("Veuillez saisir le prenom de l'employe:");
        String prenom = sc.nextLine();

        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez saisir l'age de l'employe:");
        int age = scan.nextInt();

        System.out.println("Veuillez saisir la date d'entree de l'employe:");
        String date = sc.nextLine();

        System.out.println("Veuillez saisir la base de calcul du salaire de l'employe:");
        int base = scan.nextInt();

        System.out.println("Quel est le type de l'employe ? (1: vendeur, 2: representant, 3: producteur, 4: manutention, 5: producteur a risques, 6: manutention a risque)");
        int choix = scan.nextInt();

        switch (choix)
        {
            case 1:
                listeEmployes[compteur]= new Vendeur(nom, prenom, age, date, base);
                break;
            case 2:
                listeEmployes[compteur]= new Representant(nom, prenom, age, date, base);
                break;
            case 3:
                listeEmployes[compteur]= new Producteur(nom, prenom, age, date, base);
                break;
            case 4:
                listeEmployes[compteur]= new Manutention(nom, prenom, age, date, base);
                break;
            case 5:
                listeEmployes[compteur]= new ProducteurRisque(nom, prenom, age, date, base);
                break;
            case 6:
                listeEmployes[compteur]= new ManutentionRisques(nom, prenom, age, date, base);
                break;
            default:
                System.out.println("Ajout Impossible, type inconnu");
        }

        compteur++;
    }
    

    public void afficheListeEmployes() {
         System.out.println("Les "+ compteur + " employes sont: ");

        for (int i = 0; i < compteur; i++) {
            System.out.println(listeEmployes[i].getNomretournant());
        }

    }


}



abstract class Employe{
    String nom;
    String prenom;
    Integer age;
    String dateEntree;
    int baseCalcul;
    int salaire;


    abstract void calculerSalaire();

    public Employe(String prenom, String nom, int age, String date, int baseCalcul){
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.dateEntree = date;
        this.baseCalcul=baseCalcul;
        calculerSalaire();
    }

    public String getNomretournant () {
        return (String) ( getType() + " " + prenom + " " + nom);
    }

    public String getType(){
        return "l'employe";
    }

}


class Vendeur extends Employe{


    @Override
    void calculerSalaire() {
        salaire = (((baseCalcul * 20)/100) + 400);
    }


    public Vendeur (String prenom, String nom, int age, String date, int base) {
        super(prenom, nom, age,date, base);
        calculerSalaire();
    }

    @Override
    public String getType() {
        return "Le vendeur";
    }
}

class Representant extends Employe{


    @Override
    void calculerSalaire() {
        salaire = ((baseCalcul * 20)/100) + 800;
    }

    public Representant (String prenom, String nom, int age, String date, int base) {
        super(prenom, nom, age,date, base);
        calculerSalaire();
    }

    @Override
    public String getType() {
        return "Le representant";
    }
}

class Producteur extends Employe{


    @Override
    void calculerSalaire() { salaire = (baseCalcul*5);
    }

    public Producteur (String prenom, String nom, int age, String date, int base) {
        super(prenom, nom, age,date,base);
        calculerSalaire();
    }

    @Override
    public String getType() {
        return "Le Producteur";
    }
}


class Manutention extends Employe{


    @Override
    void calculerSalaire() {
        salaire = (baseCalcul*65);
    }

    public Manutention (String prenom, String nom, int age, String date, int base) {
        super(prenom, nom, age,date, base);
        calculerSalaire();
    }

    @Override
    public String getType() {
        return "Le manutenteur";
    }
}


class ProducteurRisque extends Producteur{


    @Override
    void calculerSalaire() {
        salaire = ((baseCalcul * 5) + 200);
    }

    public ProducteurRisque (String prenom, String nom, int age, String date, int base) {
        super(prenom, nom, age,date, base);
        calculerSalaire();
    }

    @Override
    public String getType() {
        return "Le Producteur à risques";
    }
}


class ManutentionRisques extends Manutention{



    @Override
    void calculerSalaire() {
        salaire = (baseCalcul*65 + 200);
    }

    public ManutentionRisques (String prenom, String nom, int age, String date, int base) {
        super(prenom, nom, age,date, base);
        calculerSalaire();
    }

    @Override
    public String getType() {
        return "Le manutenteur a risques";
    }
}
