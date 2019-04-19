import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class sorter {
    public static void main(String[] args){
        int totalLines = 149035;
        int linesPerFile = totalLines/20;
        String fileName = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' Big File Sorter/src/Aesop_Shakespeare_Shelley_Twain.txt";

        try {
            int i=0, j=0, k = 0;

            FileReader fileReader = new FileReader(fileName);
            String[] stringList = new String[linesPerFile];
            BufferedReader br = new BufferedReader(fileReader);

            while(i<=1) {

                for (; j < linesPerFile; j++) {
                    stringList[j] = (br.readLine());
                }

                Arrays.sort(stringList);

                for (; k < linesPerFile; k++) {
                    System.out.println(stringList[k]);
                }

                i++;
            }













        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
