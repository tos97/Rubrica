import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    private int n;
    private String nom,email,tel,ind;
    private String[][] rub = new String[5][4];

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
        System.out.print("Scrivi Nome: ");
        nom = sc.nextLine();
        if (nom == null)
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
        int i;
        System.out.println("Scrivi cosa cercare:");
        s = sc.nextLine();
        if((i = ric.cerca(s)) == 0)
            System.err.println("Non Trovato");
        else{
                rub =del.cancella(i);
            }
    }

    public void cerca(){
        Search ric = new Search(rub);
        String s;
        int i;
        System.out.println("Scrivi cosa cercare:");
        s = sc.nextLine();
        if((i = ric.cerca(s)) == 0)
            System.err.println("Non Trovato");
        else{
            System.out.println("Trovato");
            for (int j = 0; j < rub[1].length; j++) {
                System.out.println(rub[i][j]);
            }
            System.out.println();
        }
    }
}
