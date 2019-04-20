import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class reader {
    int j, k, l = 0, h=0;
    private String fileName;
    private int totalLines;
    private int linesPerFile;// = totalLines/20;

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

        }catch(IOException e){e.printStackTrace();}
    }

    private int getTotalLines() {
        return totalLines;
    }

    private void setLinesPerFile(){
        this.linesPerFile=getTotalLines()/20;
    }

    int getLinesPerFile() {
        return linesPerFile;
    }

    String[] makeStringArray(BufferedReader br) {
        String[] stringList = new String[this.linesPerFile];
        try {
            for (j = 0; j < this.linesPerFile; j++) {
                stringList[j] = br.readLine();
                stringList[j].trim();
            }
           //return stringList;
        }catch (IOException e){e.printStackTrace();}
        Arrays.sort(stringList);
        return stringList;
    }

    void makeTempFiles(BufferedWriter bw, String[] stringList){
        Arrays.sort(stringList);
        try{
            for (k=0; k < this.linesPerFile; k++) {
                if (!stringList[k].equals("")) {
                    bw.write(stringList[k].trim());
                    bw.newLine();
                }
            }
            bw.close();
        }catch (IOException e){e.printStackTrace();}
    }
}
