public class PrintAll {

    private String[][] rub;

    public PrintAll(String[][] r){
        this.rub = r;
    }

    public void stampa(){
        System.out.println("Rubrica");
        for(int i = 0;i < rub.length;i++){
            if (rub[i][1] != "0") {
                for (int j = 0; j < rub[1].length; j++) {
                    if (rub[i][j] != "0")
                        System.out.println(rub[i][j]);
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
