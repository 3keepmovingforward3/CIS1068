import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class tempFileMaker {
    private int numberOfLinesPerTempFile;
    private int maxLineNumber;
    private File file;
    private FileReader fr;
    private LineNumberReader lnr;

    public tempFileMaker(File file, FileReader fr, LineNumberReader lnr) {
        this.file = file;
        this.fr = fr;
        this.lnr = lnr;

        int lineNumber=0;
        try {
            while (lnr.readLine() != null) {
                lineNumber++;
            }
            lnr.close();
        }catch (IOException e) {e.printStackTrace();}
        this.maxLineNumber =lineNumber;

    }

    public int getNumberOfLinesPerFile() {
        return numberOfLinesPerTempFile;
    }

    public void setNumberOfLinesPerFile(int numberOfLinesPerFile) {
        this.numberOfLinesPerTempFile = numberOfLinesPerFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileReader getFr() {
        return fr;
    }

    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    public LineNumberReader getLnr() {
        return lnr;
    }

    public void setLnr(LineNumberReader lnr) {
        this.lnr = lnr;
    }

    public int getNumberOfLinesPerTempFile() {
        return numberOfLinesPerTempFile;
    }

    private void setNumberOfLinesPerTempFile(int numberOfLinesPerTempFile) {
        this.numberOfLinesPerTempFile = numberOfLinesPerTempFile;
    }

    public int getLineNumber() {

        return maxLineNumber;
    }

    private void setLineNumber(int lineNumber) {
        this.maxLineNumber = lineNumber;
    }

}
