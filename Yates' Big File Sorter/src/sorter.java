import java.io.*;

public class sorter {
    public static void main(String[] args){
        String fileName = "Aesop_Shakespeare_Shelley_Twain.txt";

        try{

            File file = new File("/Users/bblouin/Documents/GitHub/CIS1068/Yates' Big File Sorter/src/Aesop_Shakespeare_Shelley_Twain.txt");
            FileReader fr = new FileReader(file);
            LineNumberReader lnr = new LineNumberReader(fr);
            tempFileMaker t = new tempFileMaker(file,fr,lnr);
            System.out.println(t.getLineNumber());
            if(file.exists()){
                int tempFileNumber = 0;
                File temp = File.createTempFile("temp_"+tempFileNumber+"_name", ".txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(temp));


                int linenumber = 0;


            }else{
                System.out.println("File does not exists!");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
