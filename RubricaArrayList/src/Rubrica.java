import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Account> rubrica = new ArrayList<Account>();

    public Rubrica() {
        rubrica.add(new Account(new User("Bendetto", "tosiani", "23"), "3312341300", "benedetto.tosiani@edu.unife.it"));
        rubrica.add(new Account(new User("Giorgio", "Vanni", "57"), "3339196342", ""));
    }

    public void add(String n,String c,String a,String e,String t){
        rubrica.add(new Account(new User(n, c, a), t, e));
    }

    public void remove(int index){
        rubrica.remove(index);
    }

    public boolean findIndex(String s, int i){
        boolean n,c,a,t,e;
        n = rubrica.get(i).getUser().getNome().contains(s);
        c = rubrica.get(i).getUser().getSurname().contains(s);
        a = rubrica.get(i).getUser().getAge().contains(s);
        t = rubrica.get(i).getNumero().contains(s);
        e = rubrica.get(i).getEmail().contains(s);
        if(n == true || c == true || a == true || t == true || e == true)
            return true;
        return false;
    }

    public void clear(){
        rubrica.clear();
    }

    public int getSize(){
        return rubrica.size();
    }

    public void printAll(){
        System.out.println("Rubrica:");
        for(int i = 0;i < getSize();i++){
            System.out.println("Nome: " + rubrica.get(i).getUser().getNome());
            System.out.println("Cognome: " + rubrica.get(i).getUser().getSurname());
            System.out.println("Età: " + rubrica.get(i).getUser().getAge());
            System.out.println("Telefono: " + rubrica.get(i).getNumero());
            System.out.println("Email: " + rubrica.get(i).getEmail());
            System.out.println();
        }
    }

    public void print(int i){
        System.out.println("Nome: " + rubrica.get(i).getUser().getNome());
        System.out.println("Cognome: " + rubrica.get(i).getUser().getSurname());
        System.out.println("Età: " + rubrica.get(i).getUser().getAge());
        System.out.println("Telefono: " + rubrica.get(i).getNumero());
        System.out.println("Email: " + rubrica.get(i).getEmail());
        System.out.println();
    }

    public int searchIndex(String s){
        for(int i = 0;i < getSize();i++) {
            if (findIndex(s, i) == true)
                return i;
        }
        return -1;
    }

    public int[] search(String s){
        int[] c = new int[2];
        for(int i = 0;i < getSize();i++) {
            if (findIndex(s, i) == true) {
                c[0]++;
                c[1] = i;
            }
        }
        return c;
    }

    public void searchStampa(String s){
        int c = 0;
        for(int i = 0;i < getSize();i++) {
            if (findIndex(s, i) == true){
                print(i);
                System.out.println();
            }
        }
    }

    public void modName(int i, String s){
        rubrica.get(i).getUser().setNome(s);
    }
    public void modSurname(int i, String s){
        rubrica.get(i).getUser().setSurname(s);
    }
    public void modEta(int i, String s){
        rubrica.get(i).getUser().setAge(s);
    }
    public void modTel(int i, String s){
        rubrica.get(i).setNumero(s);
    }
    public void modEmail(int i, String s){
        rubrica.get(i).setEmail(s);
    }
}
