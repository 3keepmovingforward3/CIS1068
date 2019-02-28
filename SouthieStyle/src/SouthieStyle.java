import java.io.*;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class SouthieStyle {

    public static void main(String[] args) {
        String regexYah = "(?<=ee|i)r\\b"; //case sensitive positive lookbehind "ee" or "i" ending word boundary, "r" replace
        String regexWah = "(?<=oo)r\\b"; //case sensitive positive lookbehind "oo" ending word boundary, "r" replace
        String regexRhotic = "(?i)(?<=:a|e|i|o|u)r"; //case insensitive positive lookbehind vowel word boundary, "r" replace
        String regexNonRhotic = "(?<=\\w)a\\b";
        String regexVery = "(?i)\\b(very)\\b"; // literal word bounded case insensitive "very", "wicked" replace

        Path path = Paths.get("/Users/bblouin/Documents/GitHub/CIS1068/SouthieStyle/src/jaws.txt");
        regexFindAndReplace(path, regexVery, "wicked");
        regexFindAndReplace(path, regexYah,"yah");
        regexFindAndReplace(path, regexWah,"wah");
        regexFindAndReplace(path, regexRhotic,"h");
        regexFindAndReplace(path, regexNonRhotic, "ar");


        System.out.println("Find and replace done");
    }

    private static void regexFindAndReplace(Path path, String regex, String replacement){
        try{
            Stream<String> lines = Files.lines(path);
            List<String> replaced = lines.map(line -> line.replaceAll(regex,replacement)).collect(Collectors.toList());
            Files.write(path,replaced);
            lines.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


}
