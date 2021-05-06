import java.util.Scanner;

public class RubricaHome {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int n;
        Menu m = new Menu();
        do {
            System.out.println("MENU\n 0) Uscita\n 1) Add\n 2) Delete\n 3) Search\n 4) PrintAll");
            n = sc.nextInt();
            System.out.println();
            switch (n){
                case 0: System.out.println("Fine Esercizio"); break;
                case 1: m.aggiungi(); break;
                case 2: m.cancella(); break;
                case 3: m.cerca(); break;
                case 4: m.stampa(); break;
                default: System.out.println("ERRORE inserire un numero tra 0 a 4");
            }
        } while(n != 0);
    }
}
