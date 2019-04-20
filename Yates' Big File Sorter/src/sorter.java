import java.io.*;
import java.util.Arrays;

public class sorter {
    public static void main(String[] args)throws IOException{
        reading();
        mergeSortController();
    }

    private static void reading()throws IOException{
        String fileName = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/Aesop_Shakespeare_Shelley_Twain.txt";
        int h, tempFileNumbering = 0;

        reader r = new reader(fileName);
        FileReader fileReader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fileReader);

        for(h=0;h<20;h++) {

            File file = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                    "Big File Sorter/src/temp_0_" + tempFileNumbering + ".txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            String[] stringList =r.makeStringArray(br); //already sorted

            r.makeTempFiles(bw,stringList);

            tempFileNumbering++;

        }
        br.close();
        fileReader.close();
    }

    private static void mergeSortController()throws IOException{
        int h, tempFileNumbering = 0;
        File fileNameA = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumbering + ".txt");
        String strFileNameA = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumbering + ".txt";
        FileReader fileReaderA = new FileReader(fileNameA);
        reader rA = new reader(strFileNameA);

        tempFileNumbering++;

        File fileNameB = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumbering + ".txt");
        FileReader fileReaderB = new FileReader(fileNameB);
        String strFileNameB = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumbering + ".txt";
        reader rB = new reader(strFileNameA);

        BufferedReader brA = new BufferedReader(fileReaderA);
        BufferedReader brB = new BufferedReader(fileReaderB);
        String[] stringList = new String[rA.getTotalLines()+rB.getTotalLines()];

        for(int i = 0;i<(rA.getTotalLines()+ rB.getTotalLines());i=i+2) {
            stringList[i] = brA.readLine();
            stringList[i + 1] = brB.readLine();
            Arrays.sort(stringList,i,i+1);
        }


        File newTemp = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_1_0.txt");
        FileWriter fw = new FileWriter(newTemp);
        BufferedWriter bw = new BufferedWriter(fw);
        rA.makeTempFiles(bw,stringList);

    }
}
