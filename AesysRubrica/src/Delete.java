public class Delete {
    private String[][] rub;

    public Delete(String[][] r){
        this.rub = r;
    }

    public String[][] cancella(int trovato){

        for(int i = 0;i < rub[1].length;i++){
            rub[trovato][i] = "0";
        }
        return rub;
    }
}
