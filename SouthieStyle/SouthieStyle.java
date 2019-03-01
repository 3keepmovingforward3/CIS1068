/*
 * Benjamin Blouin
 * CIS 1068
 * Dr. Fiore
 * Thanks to https://www.regular-expressions.info 
 * 
 */

import java.io.*;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class SouthieStyle {

	static final String FILENAME = "2600-0.txt";
    
	public static void main(String[] args) {
    	//case sensitive positive look-behind "ee" or "i" ending word boundary, "r" replace
    	//
    	String regexYah = "(?<=ee|i)r\\b"; 
    	
    	//case sensitive positive look-behind "oo" ending word boundary, "r" replace
    	//
        String regexWah = "(?<=oo)r\\b"; 
        
        //case insensitive positive look-behind vowel word boundary, "r" replace
        //
        String regexRhotic = "(?i)(?<=a|e|i|o|u|á-ï|ò-ö|ø-ü)r"; 
        
        //case sensitive positive look-behind word-character ending "a" word-boundary, replace "ar"
        //
        String regexNonRhotic = "(?<=\\w)a\\b";
        
        //literal word bounded case insensitive "very", "wicked" replace
        //
        String regexVery = "(?i)\\b(very)\\b"; 

        // i/o class path object NIO class paths.get absolute path of file
        //
        Path path = Paths.get("./"+FILENAME);
        
        
        regexFindAndReplace(path, regexVery, "wicked");
        regexFindAndReplace(path, regexYah,"yah");
        regexFindAndReplace(path, regexWah,"wah");
        regexFindAndReplace(path, regexRhotic,"h");
        regexFindAndReplace(path, regexNonRhotic, "ar");
        
    }

    private static void regexFindAndReplace(Path path, String regex, String replacement){
        // try with resource Stream of strings of file lines at path
    	try(Stream<String> lines = Files.lines(path);){
            List<String> replaced = lines.map(line -> line.replaceAll(regex,replacement)).collect(Collectors.toList());
            Files.write(path,replaced);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


}
