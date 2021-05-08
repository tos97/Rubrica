import java.util.Scanner;

public class Menu extends Rubrica{

    Scanner sc = new Scanner(System.in);
    private int n;
    private String nom,cog,eta,email,tel;

    public Menu() {
        super();
    }

    public void start() {
        System.out.println("MENU\n 0) Uscita\n 1) Add\n 2) Delete\n 3) Update\n 4) Search\n 5) PrintAll\n 6) Delete All");
        n = sc.nextInt();
        System.out.println();
        switch (n) {
            case 0: System.out.println("Fine Esercizio"); break;
            case 1: aggiungi(); break;
            case 2: cancella(); break;
            case 3: System.out.println("non pronto2"); break;
            case 4: cerca(); break;
            case 5: printAll(); break;
            case 6: clear(); break;
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

    public void cerca(){
        System.out.print("Scrivi cosa cercare:");
        String s = sc.nextLine();
        int c = search(s);
        if(c == 0)
            System.err.println("\nNon ci sono riferimenti alla ricerca effettuata");
        else{
            System.out.println("Trovato:");
            searchStampa(s);
        }
    }

    public void cancella(){
        System.out.println("Scrivi cosa cercare:");
        String s = sc.nextLine();
        int c = search(s);
        if(c > 1 || c == 0) {
            System.err.println("ATTENZIONE");
            if (c == 0) {
                System.out.println("Nessun elemento trovato");
                System.out.println("controlla tra questi elementi salvati quello da cancellare");
                printAll();
            }
            if (c > 1) {
                System.out.println("Troppi elementi trovati a questa ricerca si più specifico");
                System.out.println("controlla tra questi elementi trovati quello da cancellare");
                searchStampa(s);
            }
        }
        if (c == 1)
            for(int i = 0;i < getSize();i++) {
                if (findIndex(s, i) == true){
                    remove(i);
                }
            }
    }
}
