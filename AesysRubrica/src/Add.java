public class Add {

    private String nom,email,tel,ind;
    private String[][] rub;

    public Add(String[][] r,String n,String e,String t,String i){
        this.nom = n;
        this.email = e;
        this.tel = t;
        this.ind = i;
        this.rub = r;
    }

    public void caricare(){
        int n = 0;
        for(int i = 0;i < rub.length || n!=0;i++){
            if (rub[i][1] == "0"){
                rub[i][0] = nom;
                rub[i][1] = email;
                rub[i][2] = email;
                rub[i][3] = ind;
                n++;
            }
        }
        if (n != 0)
            System.out.println("Caricato");
        else{
            System.err.println("ERRORE");
        }
    }
}
