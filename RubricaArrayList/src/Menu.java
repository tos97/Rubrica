import java.util.Scanner;

public class Menu extends Rubrica{

    Scanner sc = new Scanner(System.in);
    private int n;
    private String nom,cog,eta,email,tel;

    public Menu() {super();
    }

    public void start() {
        System.out.println("\nMENU\n 0) Uscita\n 1) Add\n 2) Delete\n 3) Update\n 4) Search\n 5) PrintAll\n 6) Delete All");
        n = sc.nextInt();
        System.out.println();
        switch (n) {
            case 0: System.out.println("Fine Esercizio"); break;
            case 1: aggiungi(); break;
            case 2: cancella(); break;
            case 3: modifica(); break;
            case 4: cerca(); break;
            case 5: printAll(); break;
            case 6: clear(); break;
            default: System.out.println("ERRORE inserire un numero tra 0 a 4");
        }
        if (n != 0)
            start();
    }

    public void aggiungi(){
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Scrivi Nome (obbligatorio): ");
            nom = scan.nextLine();
            if (nom.length() <= 0)
                System.out.println("ERRORE\nci deve essere il nome obbligatorio");
        } while(nom.length() <= 0);
        System.out.print("Scrivi cognome: ");
        cog = scan.nextLine();
        System.out.print("Scrivi Eta: ");
        eta = scan.nextLine();
        do {
            System.out.print("Scrivi Email: ");
            email = scan.nextLine();
            System.out.print("Scrivi Numero di Telefono: ");
            tel = scan.nextLine();
            if (email.length() <= 0 && tel.length() <= 0)
                System.out.println("ERRORE\nci deve essere almeno il numero o l'email");
        } while(email.length() <= 0 && tel.length() <= 0);
        add(nom,cog,eta,tel,email);
    }

    public void cerca(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Scrivi cosa cercare: ");
        String s = scan.nextLine();
        int[] c = search(s);
        if(c[0] == 0)
            System.err.println("Non ci sono riferimenti alla ricerca effettuata");
        else{
            System.out.println("Trovato:");
            searchStampa(s);
        }
    }

    public void cancella(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Scrivi quello che vuoi cancellare:");
        String parola = scan.nextLine();
        int[] c = search(parola);
        if(c[0] > 1 || c[0] == 0) {
            System.err.println("ATTENZIONE");
            if (c[0] == 0) {
                System.out.println("Nessun elemento trovato");
                System.out.println("controlla tra questi elementi salvati quello da cancellare");
                printAll();
            }
            if (c[0] > 1) {
                System.out.println("Troppi elementi trovati a questa ricerca si più specifico");
                System.out.println("controlla tra questi elementi trovati quello da cancellare");
                searchStampa(parola);
            }
        }
        if (c[0] == 1) {
            System.out.println("vuoi cancellare questo elemento (y o n):");
            print(c[1]);
            char r = scan.next().charAt(0);
            if(r == 'y')
                remove(c[1]);
        }
    }

    public void modifica(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Scrivi il nome del contatto da modificare: ");
        String n = scan.nextLine();
        int[] c = search(n);
        if(c[0] == 0)
            System.err.println("ATTENZIONE\nNessun contatto con questo nome trovato");
        else{
            System.out.println("\nContatto trovato:");
            print(c[1]);
            System.out.println("\nModifica da effettuare:");
            n = scan.nextLine();
            System.out.println("\n 1) Nome\n 2) Cognome\n 3) età\n 4) Numero di telefono\n 5) Email");
            int r = scan.nextInt();
            switch (r){
                case 1: modName(c[1],n); break;
                case 2: modSurname(c[1],n); break;
                case 3: modEta(c[1],n); break;
                case 4: modTel(c[1],n); break;
                case 5: modEmail(c[1],n); break;
                default: System.out.println("Fuori range di selezione");
            }
        }
    }
}
