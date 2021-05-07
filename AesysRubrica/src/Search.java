public class Search {
    private String[][] rub;

    public Search(String[][] r){
        this.rub = r;
    }

    public int[] cerca(String s){
        int[] trovati = new int[rub.length];
        for(int i = 0;i < rub.length;i++){
            trovati[i] = 0;
        }
        for(int i = 0;i < rub.length;i++){
            for (int j = 0; j < rub[1].length; j++) {
                if (s.compareTo(rub[i][j]) == 0 || s.compareTo(rub[i][j]) > 0)
                    trovati[i]++;
            }
        }
        return trovati;
    }

}
