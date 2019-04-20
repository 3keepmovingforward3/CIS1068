import java.io.*;

public class sorter {
    public static void main(String[] args) throws IOException{
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
}
