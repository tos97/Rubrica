import java.util.Scanner;
import java.util.UUID;

public class Menu extends Rubrica{

    private static Menu istance = null;
    //Scanner sc = new Scanner(System.in);
    private boolean fine = false;
    private String id = "",nom = "",cog = "",eta = "",email = "",tel = "";

    private Menu(){}

    public static Menu getIstance(){
            if(istance == null) {
                istance = new Menu();
            }
            return istance;
    }

    public void start(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nMENU\n 0) Uscita\n 1) Add\n 2) Delete\n 3) Update\n 4) Search\n 5) Print All\n 6) Delete All\n 7) Salva tramite json\n 8) print All in Json\n 9) Trasforma dati inseriti in Json (vecchio)\n 10) Trasforma dati inseriti in Json (nuovo)\n 11) Import Json da File()\n 12) Export in file");
        try {
            int n = scan.nextInt();
            System.out.println();
            switch (n) {
                case 0: System.out.println("Fine Esercizio"); fine = true; break;
                case 1: aggiungi();break;
                case 2: cancella();break;
                case 3: modifica();break;
                case 4: cerca();break;
                case 5: printAll();break;
                case 6: clear();break;
                case 7: importJson(); break;
                case 8: exportJson(); break;
                case 9: exportJsonSingolo(); break;
                case 10: exportJsonSingoloNuovo(); break;
                case 11: importJsonFile(); break;
                case 12: exportJsonFile(); break;
                default: System.out.println("ERRORE inserire un numero tra 0 a 7");
            }
        }
        catch (Exception e){
            System.out.println("\nAttenzione devi inserire un numero");
        }
        if (!fine)
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

    /* vecchio metodo di importJson
    public void importJson(){
        int contatore = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il json da salvare:");
        String stringJson = scanner.next();
        String[] stringSplit = stringJson.split(Pattern.quote("{"));
        for (int i = 1;i < stringSplit.length;i++){
            if (stringSplit[i].contains("["))
                System.out.println();
            else{
                String[] stringSplitvirgola = stringSplit[i].split(",");
                for (int j = 0;j < stringSplitvirgola.length;j++){
                    String[] stringSplitpunti = stringSplitvirgola[j].split(":");
                    if (stringSplitpunti[0].equals("\"ID\""))
                        id = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-1);
                    if (stringSplitpunti[0].equals("\"Nome\""))
                        nom = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-1);
                    if (stringSplitpunti[0].equals("\"Cognome\""))
                        cog = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-1);
                    if (stringSplitpunti[0].equals("\"Età\""))
                        eta = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-1);
                    if (stringSplitpunti[0].equals("\"Telefono\""))
                        tel = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-1);
                    if (stringSplitpunti[0].equals("\"Email\"")) {
                        if (stringSplit.length > 2 && contatore == (stringSplit.length-1))
                            email = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-4);
                        else{
                            email = stringSplitpunti[1].substring(1,stringSplitpunti[1].length()-2);
                        }
                    }
                }
                add(id,nom,cog,eta,tel,email);
            }
            contatore++;
        }
    }*/
    public void importJson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il json da salvare:");
        String stringJson = scanner.next();
        addAllJson(stringJson);
    }

    public void exportJsonSingolo(){
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

        System.out.print("{\"ID\":\"" + UUID.randomUUID().toString() + "\",");
        System.out.print("\"Nome\":\"" + nom + "\",");
        System.out.print("\"Cognome\":\"" + cog + "\",");
        System.out.print("\"Età\":\"" + eta + "\",");
        System.out.print("\"Telefono\":\"" + tel + "\",");
        System.out.print("\"Email\":\"" + email + "\"}\n");
    }

    public void exportJsonSingoloNuovo(){
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

        System.out.print("[{\"user\":{");
        System.out.print("\"nome\":\"" + nom + "\",");
        System.out.print("\"surname\":\"" + cog + "\",");
        System.out.print("\"age\":\"" + eta + "\"},");
        System.out.print("\"numero\":\"" + tel + "\",");
        System.out.print("\"email\":\"" + email + "\"}]\n");
    }

    public void importJsonFile(){
        Scanner scan = new Scanner(System.in);
        System.out.println("scrivi il nome del file dai cui prelevare la rubrica");
        addAllJson(readFile(scan.next()));
    }

    public void exportJsonFile(){
        Scanner scan = new Scanner(System.in);
        System.out.println("scrivi il nome del file su cui salvare la rubrica");
        writeFile(scan.next(),exportJson(""));
    }
}
