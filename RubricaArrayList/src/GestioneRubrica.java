public interface GestioneRubrica {
    void add(String n,String c,String a,String e,String t);
    void remove(int index);
    boolean findIndex(String s, int i);
    void clear();
    int getSize();
    void printAll();
    void print(int i);
    int searchIndex(String s);
    int[] search(String s);
    void searchStampa(String s);
    void modName(int i, String s);
    void modSurname(int i, String s);
    void modEta(int i, String s);
    void modTel(int i, String s);
    void modEmail(int i, String s);
}
