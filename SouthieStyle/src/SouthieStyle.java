import java.util.regex.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class SouthieStyle {

    public static void main(String[] args) {
        String regexYah = "(?<=ee|i)r\b"; //case sensitive positive lookbehind ending word boundary
        String regexWah = "(?<=oo)r\b"; //case sensitive positive lookbehind ending word boundary
        Pattern regexRhotic = Pattern.compile("[?i:aeiou](r)");
        Pattern regexNonRhotic = Pattern.compile("[^\\s](?i:a)\\b");
        Pattern regexVery = Pattern.compile("\\b(?i:very)\\b");



            Path path = Paths.get("/Users/bblouin/Documents/GitHub/CIS1068/SouthieStyle/src/jaws.txt");

        try{
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines.map(line -> line.replaceAll(regexYah,"yah")).collect(Collectors.toList());
            Files.write(path,replaced);
            lines.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Find and replace done");
    }



}
