import java.io.*;
import java.util.Arrays;

public class sorter {
    public static void main(String[] args){
        int totalLines = 149035;
        int linesPerFile = totalLines/20;
        String fileName = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' Big File Sorter/src/Aesop_Shakespeare_Shelley_Twain.txt";
        int j = 0, k = 0, l = 0;

        try {
            int h = 0;

            while(h<2) {

               File file = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' Big File Sorter/src/temp-" + l + "file.txt");
               FileWriter fw = new FileWriter(file);
               BufferedWriter bw = new BufferedWriter(fw);

               FileReader fileReader = new FileReader(fileName);
               String[] stringList = new String[linesPerFile];
               BufferedReader br = new BufferedReader(fileReader);

               for (; j < linesPerFile; j++) {
                       stringList[j] = br.readLine();
                   }
                   Arrays.sort(stringList);

                   for (; k < linesPerFile; k++) {
                       if (!stringList[k].equals("")) {
                           bw.write(stringList[k].trim());
                           bw.newLine();
                       }
                   }
                   k=0;
                   l++;
                   h++;
           }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
