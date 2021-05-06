public class Search {
    private String[][] rub;

    public Search(String[][] r){
        this.rub = r;
    }

    public int cerca(String s){
        for(int i = 0;i < rub.length;i++){
            for (int j = 0; j < rub[1].length; j++) {
                if (s.compareTo(rub[i][j]) == 0 || s.compareTo(rub[i][j]) > 0)
                    return i;
            }
        }
        return 0;
    }

}
