import java.util.Scanner;

public class Menu extends Rubrica{

    Scanner sc = new Scanner(System.in);
    private int n;
    private String nom,cog,eta,email,tel;

    public Menu() {
        super();
    }

    public void start() {
        System.out.println("MENU\n 0) Uscita\n 1) Add\n 2) Delete\n 3) Update\n 3) Search\n 4) PrintAll\n 5) Delete All");
        n = sc.nextInt();
        System.out.println();
        switch (n) {
            case 0: System.out.println("Fine Esercizio"); break;
            case 1: aggiungi(); break;
            case 2: System.out.println("non pronto"); break;
            case 3: System.out.println("non pronto2"); break;
            case 4: printAll(); break;
            case 5: clear(); break;
            default: System.out.println("ERRORE inserire un numero tra 0 a 4");
        }
        if (n != 0)
            start();
    }

    public void aggiungi(){
        do{
            System.out.print("Scrivi Nome (obbligatorio): ");
            nom = sc.nextLine();
            if (nom.length() <= 0)
                System.out.println("ERRORE\nci deve essere il nome obbligatorio");
        } while(nom.length() <= 0);
        System.out.print("Scrivi cognome: ");
        cog = sc.nextLine();
        System.out.print("Scrivi Eta: ");
        eta = sc.nextLine();
        do {
            System.out.print("Scrivi Email: ");
            email = sc.nextLine();
            System.out.print("Scrivi Numero di Telefono: ");
            tel = sc.nextLine();
            if (email.length() <= 0 && tel.length() <= 0)
                System.out.println("ERRORE\nci deve essere almeno il numero o l'email");
        } while(email.length() <= 0 && tel.length() <= 0);
        add(nom,cog,eta,tel,email);
    }
}
