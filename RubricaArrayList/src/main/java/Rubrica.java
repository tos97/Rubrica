import Interfacce.GestioneRubrica;
import Models.Account;
import Models.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class Rubrica extends MyFiles implements GestioneRubrica {
    private ArrayList<Account> rubrica = new ArrayList<Account>();

    public Rubrica(int n) {
        rubrica.add(new Account(new User("Bendetto", "tosiani", "23"), "3312341300", "benedetto.tosiani@edu.unife.it"));
        rubrica.add(new Account(new User("Giorgio", "Vanni", "57"), "3339196342", ""));
    }

    public Rubrica() {}

    /**
     * Nell'add di caricano i nuovi elementi nella rubrica
     * @param n indica il nome da salvare (obbligatoriamente pieno)
     * @param c indica il cognome
     * @param a indica l'età
     * @param e indica l'email
     * @param t indica il numero di telefono
     */
    @Override
    public void add(String n, String c, String a, String e, String t) {
        rubrica.add(new Account(new User(n, c, a), t, e));
    }

    public void add(String d,String n, String c, String a, String t, String e) {
        rubrica.add(new Account(new User(n,c,a,d), t, e));
    }

    /**
     * Rimuove un oggetto
     * @param index posizione dell'elemento da eliminare
     */
    @Override
    public void remove(int index) {
        rubrica.remove(index);
    }

    /**
     *Controlla se a questo indice c'è un trovamento
     * @param s stringa cercata
     * @param i indice analizzato
     * @return
     */
    @Override
    public boolean findIndex(String s, int i) {
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

    @Override
    public void clear() {
        rubrica.clear();
    }

    @Override
    public int getSize() {
        return rubrica.size();
    }

    @Override
    public void printAll() {
        System.out.println("Rubrica:");
        for(Account persona: rubrica){
            System.out.println("ID: " + persona.getUser().getId());
            System.out.println("Nome: " + persona.getUser().getNome());
            System.out.println("Cognome: " + persona.getUser().getSurname());
            System.out.println("Età: " + persona.getUser().getAge());
            System.out.println("Telefono: " + persona.getNumero());
            System.out.println("Email: " + persona.getEmail());
            System.out.println();
        }
    }

    @Override
    public void print(int i) {
        System.out.println("ID: " + rubrica.get(i).getUser().getId());
        System.out.println("Nome: " + rubrica.get(i).getUser().getNome());
        System.out.println("Cognome: " + rubrica.get(i).getUser().getSurname());
        System.out.println("Età: " + rubrica.get(i).getUser().getAge());
        System.out.println("Telefono: " + rubrica.get(i).getNumero());
        System.out.println("Email: " + rubrica.get(i).getEmail());
        System.out.println();
    }

    public void print(ArrayList<Account> acc) {
        for(Account persona: acc){
            System.out.println("ID: " + persona.getUser().getId());
            System.out.println("Nome: " + persona.getUser().getNome());
            System.out.println("Cognome: " + persona.getUser().getSurname());
            System.out.println("Età: " + persona.getUser().getAge());
            System.out.println("Telefono: " + persona.getNumero());
            System.out.println("Email: " + persona.getEmail());
            System.out.println();
        }
    }

    /**
     * trova l'indice che contiene una stringa
     * @param s stringa da trovare
     * @return l'indice al quale si trova o -1 se non trova nulla
     */
    @Override
    public int searchIndex(String s) {
        for(int i = 0;i < getSize();i++) {
            if (findIndex(s, i) == true)
                return i;
        }
        return -1;
    }

    /**
     * trova la stringa
     * @param s stringa da cercare
     * @return ha come risultato l'ultima posizione contenete l'indice e quanti riscontri ha
     */
    @Override
    public int[] search(String s) {
        int[] c = new int[2];
        for(int i = 0;i < getSize();i++) {
            if (findIndex(s, i) == true) {
                c[0]++;
                c[1] = i;
            }
        }
        return c;
    }

    /**
     * trova e stampa il giusto contatto
     * @param s stringa sìda cercare
     */
    @Override
    public void searchStampa(String s) {
        int c = 0;
        for(int i = 0;i < getSize();i++) {
            if (findIndex(s, i) == true){
                print(i);
                System.out.println();
            }
        }
    }

    /**
     * Modifica il nome
     * @param i indice da modificare
     * @param s stringa modificata da inserire
     */
    @Override
    public void modName(int i, String s) {
        rubrica.get(i).getUser().setNome(s);
    }

    /**
     * Modifica il cognome
     * @param i indice da modificare
     * @param s stringa modificata da inserire
     */
    @Override
    public void modSurname(int i, String s) {
        rubrica.get(i).getUser().setSurname(s);
    }

    /**
     * Modifica l'età
     * @param i indice da modificare
     * @param s stringa modificata da inserire
     */
    @Override
    public void modEta(int i, String s) {
        rubrica.get(i).getUser().setAge(s);
    }

    /**
     * Modifica il numero di telefono
     * @param i indice da modificare
     * @param s stringa modificata da inserire
     */
    @Override
    public void modTel(int i, String s) {
        rubrica.get(i).setNumero(s);
    }

    /**
     * Modifica l'email
     * @param i indice da modificare
     * @param s stringa modificata da inserire
     */
    @Override
    public void modEmail(int i, String s) {
        rubrica.get(i).setEmail(s);
    }

    /* vecchio metodo di exportJson
    public void exportJson(){
        System.out.println("Rubrica Json:");
        System.out.print("{rubrica:[");
        for(int i = 0;i < getSize();i++){
            System.out.print("{\"ID\":\"" + rubrica.get(i).getUser().getId() + "\",");
            System.out.print("\"Nome\":\"" + rubrica.get(i).getUser().getNome() + "\",");
            System.out.print("\"Cognome\":\"" + rubrica.get(i).getUser().getSurname() + "\",");
            System.out.print("\"Età\":\"" + rubrica.get(i).getUser().getAge() + "\",");
            System.out.print("\"Telefono\":\"" + rubrica.get(i).getNumero() + "\",");
            if (i == (getSize()-1))
                System.out.print("\"Email\":\"" + rubrica.get(i).getEmail() + "\"}");
            else{
                System.out.print("\"Email\":\"" + rubrica.get(i).getEmail() + "\"},");
            }
        }
        System.out.println("]}");
    }*/
    /*public String exportJson(){
        return new Gson().toJson(rubrica);
    }*/
    public void exportJson(){
        System.out.println(new Gson().toJson(rubrica));
    }

    public String exportJson(String nome){
        return new Gson().toJson(rubrica).toString();
    }

    public void addAllJson(String json){
        rubrica.addAll(Arrays.asList(new Gson().fromJson(json, Account[].class)));
    }

    public ArrayList<Account> getRubrica(){
        return rubrica;
    }
}
