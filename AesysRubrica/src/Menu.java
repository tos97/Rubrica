import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    private int n;
    private String nom,email,tel,ind;
    private String[][] rub = new String[10][4];

    public Menu(){
        rub[0][0] = "NOME";
        rub[0][1] = "EMAIL";
        rub[0][2] = "TELEFONO";
        rub[0][3] = "INDIRIZZO";

        rub[1][0] = "Giorgio Vanni";
        rub[1][1] = "giorgioMusicista@gmail.com";
        rub[1][2] = "3339196342";
        rub[1][3] = "0";

        rub[2][0] = "Benedetto Tosiani";
        rub[2][1] = "benedetto.tosiani@edu.unife.it";
        rub[2][2] = "3312341300";
        rub[2][3] = "Montebello 111";

        for(int i = 3;i < rub.length;i++){
            for(int j = 0;j < rub[1].length;j++){
                rub[i][j] = "0";
            }
        }
    }

    public void aggiungi(){
        do {
            System.out.print("Scrivi Nome: ");
            nom = sc.nextLine();
            if (nom == "\n")
                System.out.println("ERRORE\nci deve essere il nome obbligatorio");
        } while(nom == "\n");
        System.out.print("Scrivi Email: ");
        email = sc.nextLine();
        System.out.print("Scrivi Numero di Telefono: ");
        tel = sc.nextLine();
        System.out.print("Scrivi Indirizzo: ");
        ind = sc.nextLine();
        //Add nuovo = new Add(rub,nom,email,tel,ind);
        System.out.println(nom);
        System.out.println(email);
        System.out.println(tel);
        System.out.println(ind);
    }

    public void stampa(){
        PrintAll print = new PrintAll(rub);
        print.stampa();
    }

    public void cancella(){
        Search ric = new Search(rub);
        Delete del = new Delete(rub);
        String s;
        System.out.println("Scrivi cosa cercare:");
        s = sc.nextLine();
        int[] trovati = ric.cerca(s);
        int c = 0;
        for(int i = 0;i < rub.length;i++) {
            if (trovati[i] != 0)
                c++;
        }
        if(c > 1 || c == 0) {
            System.err.println("ATTENZIONE");
            if (c == 0) {
                System.out.println("Nessun elemento trovato");
                System.out.println("controlla tra questi elementi salvati quello da cancellare");
                PrintAll print = new PrintAll(rub);
                print.stampa();
            }
            if (c > 1) {
                System.out.println("Troppi elementi trovati a questa ricerca si più specifico");
                System.out.println("controlla tra questi elementi trovati quello da cancellare");
                for(int i = 0;i < rub.length;i++) {
                    if(trovati[i] != 0)
                        for (int j = 0; j < rub[1].length; j++) {
                            System.out.println(rub[i][j]);
                        }
                }
            }
        }
        if (c == 1)
            for(int i = 0;i < rub.length;i++) {
                if (trovati[i] != 0){
                    Delete canc = new Delete(rub);
                    canc.cancella(i);
                }
            }
    }

    public void cerca(){
        Search ric = new Search(rub);
        String s;
        System.out.println("Scrivi cosa cercare:");
        s = sc.nextLine();
        int[] trovati = ric.cerca(s);
        int c = 0;
        for(int i = 0;i < rub.length;i++){
            if(trovati[i] == 0)
                if (c == 0 && i == (rub.length - 1))
                    System.err.println("Non Trovato");
            else{
                if (c == 0)
                    System.out.println("Trovato");
                c++;
                for (int j = 0; j < rub[1].length; j++) {
                    System.out.println(rub[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
