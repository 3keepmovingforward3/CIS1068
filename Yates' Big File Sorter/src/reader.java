import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class reader {
    private String fileName;
    private int totalLines;
    private int linesPerFile;// = totalLines/20;
    int j, k, l = 0, h=0;

    reader(String fileName) {
        this.fileName = fileName;
        setTotalLines();
        setLinesPerFile();
    }

    private void setTotalLines() {
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);

            while (br.readLine() != null) this.totalLines++;

        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    int getTotalLines() {
        return totalLines;
    }

    private void setLinesPerFile(){
        this.linesPerFile=getTotalLines()/20;
    }

    String[] makeStringArray(BufferedReader br) {
        String[] stringList = new String[this.linesPerFile];
        try {
            for (j = 0; j < this.linesPerFile; j++) {
                stringList[j] = br.readLine();
            }
           //return stringList;
        }catch (IOException e){e.printStackTrace();}
        Arrays.sort(stringList);
        return stringList;
    }

    void makeTempFiles(BufferedWriter bw, String[] stringList){
        Arrays.sort(stringList);
        try{
            for (k=0; k < stringList.length; k++) {
                if (!stringList[k].equals("")) {
                    bw.write(stringList[k]);
                    bw.newLine();
                }
            }
            bw.close();
        }catch (IOException e){e.printStackTrace();}
    }
}
