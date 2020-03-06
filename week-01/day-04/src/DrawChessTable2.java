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

       /* for (int i = 1; i < 9; i++) {
            System.out.println();
            for (int j = 1; j < 9; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (j % 2 != 0) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }


*/
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
