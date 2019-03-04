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

	static final String FILENAME = "1513-0.txt";
    
	public static void main(String[] args) {
    	
		/*
    	 * Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
    	 * Assert that a starting position can be found for the regex below to make its match end at this position (positive look-behind) «(?<=ee|i)»
    	 * 		Match this alternative (attempting the next alternative only if this one fails) «ee»
    	 * 			Match the character string “ee” literally (case sensitive) «ee»
    	 * 		Or match this alternative (the entire group fails if this one fails to match) «i»
    	 * 			Match the character “i” literally (case sensitive) «i»
    	 * Match the character “r” literally (case sensitive) «r»
    	 * Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»
    	*/
    	//
    	String regexsyllabification = "(?<=ee|i)r\\b"; 
    	
    	/*
    	 * Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
    	 * Assert that a starting position can be found for the regex below to make its match end at this position (positive lookbehind) «(?<=oo)»
    	 * 		Match the character string “oo” literally (case sensitive) «oo»
    	 * Match the character “r” literally (case sensitive) «r»
    	 * Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»
    	 */
    	//
        String regexDipthong = "(?<=oo)r\\b"; 
        
        /*
         * Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
         * Use these options for the whole regular expression «(?i)»
         *    Case insensitive «i»
         *    Match this alternative (attempting the next alternative only if this one fails) «a»
         *    	Match the character “a” literally (case insensitive) «a»
         *    Or match this alternative (attempting the next alternative only if this one fails) «e»
         *    	Match the character “e” literally (case insensitive) «e»
         *    Or match this alternative (attempting the next alternative only if this one fails) «i»
         *    	Match the character “i” literally (case insensitive) «i»
         *    Or match this alternative (attempting the next alternative only if this one fails) «o»
         *    	Match the character “o” literally (case insensitive) «o»
         *    Or match this alternative (attempting the next alternative only if this one fails) «u»
         *    	Match the character “u” literally (case insensitive) «u»
         *    Or match this alternative (attempting the next alternative only if this one fails) «á-ï»
         *    	Match the character string “á-ï” literally (case insensitive) «á-ï»
         *    Or match this alternative (attempting the next alternative only if this one fails) «ò-ö»
         *    	Match the character string “ò-ö” literally (case insensitive) «ò-ö»
         *    Or match this alternative (the entire group fails if this one fails to match) «ø-ü»
         *    	Match the character string “ø-ü” literally (case insensitive) «ø-ü»
         * Match the character “r” literally (case insensitive) «r»
         */
        //
        String regexNonRhotic = "(?<=a|e|i|o|u|á-ï|ò-ö|ø-ü)r"; 
        String regexNonRhoticCapital = "(?i)(?<=a|e|i|o|u|á-ï|ò-ö|ø-ü)r"; 
        
        /*
         * Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
         * Assert that a starting position can be found for the regex below to make its match end at this position (positive lookbehind) «(?<=\w)»
         *    Match a single character that is a “word character” (ASCII letter, digit, or underscore only) «\w»
         * Match the character “a” literally (case sensitive) «a»
         * Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»
         */
        //
        String linkingR = "(?<=\\w)a\\b";
        
        /*
         * Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
         * Use these options for the whole regular expression «(?i)»
         *    Case insensitive «i»
         * Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»
         * Match the regex below and capture its match into backreference number 1 «(very)»
         *    Match the character string “very” literally (case insensitive) «very»
         * Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»
         */
        //
        String regexWickedAdverb = "(?i)\\b(very)\\b"; 

        // i/o class path object NIO class paths.get absolute path of file
        //
        Path path = Paths.get("./"+FILENAME);
        
        
        regexFindAndReplace(path, regexWickedAdverb, "wicked");
        regexFindAndReplace(path, regexsyllabification,"yah");
        regexFindAndReplace(path, regexDipthong,"wah");
        regexFindAndReplace(path, regexNonRhotic,"h");
        regexFindAndReplace(path, regexNonRhoticCapital, "H");
        regexFindAndReplace(path, linkingR, "ar");
        
    }

	/*
	 * Find and replace from text file method
	 * Arguments: Path path: relative path with filename
	 * 			  String regex: regex string to specify to be replaced snippet
	 * 			  String replacement: string to replace regex snippet
	 * Return:
	 * 
	 */
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
