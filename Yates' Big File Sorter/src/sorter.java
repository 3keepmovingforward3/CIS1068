import java.io.*;
import java.util.Arrays;

public class sorter {
    public static void main(String[] args)throws IOException{
        reading();
        mergeSortController();
    }

    private static void reading() throws IOException{
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
        
        int tempFileNumberingOuter = 0, tempFileNumberingInner=1, tempFileNumberingRead = 0;
        
        do{
        File newTempFile = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_"+tempFileNumberingInner+"_" + tempFileNumberingOuter + ".txt");
        

        File fileNameA = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumberingRead + ".txt");
        String strFileNameA = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumberingRead + ".txt";
        FileReader fileReaderA = new FileReader(fileNameA);
        reader rA = new reader(strFileNameA);

        tempFileNumberingRead++;

        File fileNameB = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumberingRead + ".txt");
        FileReader fileReaderB = new FileReader(fileNameB);
        String strFileNameB = "/Users/bblouin/Documents/GitHub/CIS1068/Yates' " +
                "Big File Sorter/src/temp_0_" + tempFileNumberingRead + ".txt";
        reader rB = new reader(strFileNameB);




        BufferedReader brA = new BufferedReader(fileReaderA);
        BufferedReader brB = new BufferedReader(fileReaderB);
        String[] stringList = new String[2];

        FileWriter fw = new FileWriter(newTempFile);
        BufferedWriter bw = new BufferedWriter(fw);

        int t = rA.getTotalLines()+ rB.getTotalLines();

        for(int i = 0;i<(rA.getTotalLines()+ rB.getTotalLines());i=i+2) {
            stringList[0] = brA.readLine();
            stringList[1] = brB.readLine();
            Arrays.sort(stringList,0,1);
            bw.write(stringList[0]);
            bw.newLine();
            bw.write(stringList[1]);
        }
        //rA.makeTempFiles(bw,stringList);
        brA.close();
        brB.close();
        bw.close();
        tempFileNumberingOuter++;
        tempFileNumberingRead++;
        }while(tempFileNumberingRead<=19);
    
}
}
