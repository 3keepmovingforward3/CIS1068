import java.io.*;
import java.util.Arrays;

public class sorter {
    public static void main(String[] args) throws IOException{
        final int totalLines = 149035;
        int linesPerFile = totalLines/20;
        String fileName = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/Aesop_Shakespeare_Shelley_Twain.txt";
        int j = 0, k = 0, l = 0, h=0;


        FileReader fileReader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fileReader);

        while(h<20) {

            File file = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                    "Big File Sorter/src/temp_" + l + "_file.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            String[] stringList = new String[linesPerFile];


            for (j=0; j < linesPerFile; j++) {
                stringList[j] = br.readLine();
            }
            br.mark(0);
            Arrays.sort(stringList);

            for (k=0; k < linesPerFile; k++) {
                if (!stringList[k].equals("")) {
                    bw.write(stringList[k].trim());
                    bw.newLine();
                }

            }
            l++;
            h++;
        }

    }
}
