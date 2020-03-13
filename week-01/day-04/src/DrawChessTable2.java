public class DrawChessTable2 {
    public static void main(String[] args) {
        // Crate a program that draws a chess table like this
//
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
//

       int n = 10;
        for (int i = 0; i <n ; i++) {
            String line = "";
            if (i % 2 == 0){
                for (int j = 0; j <n/2 ; j++) {
                    line += "% ";
                }
            }else{
                for (int j = 0; j <n/2 ; j++) {
                    line += " %";
                }
            }
            System.out.println(line);

        }

    }
}
