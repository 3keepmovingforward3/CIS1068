/**
 * @author Benjamin Blouin
 * @version 1.1
 * Assignment 4
 * 2/13/2019
 * SomePracticeStringMethods
 *
 * I've include an update test bench
 * I also plan to resubmit after cleaning up codee
 */
package stringPractice1068;

public class SomePracticeStringMethods {
 static final String TEMPLE = "templ";
 private static final String[] strArrayTemple = TEMPLE.split("");
 static int i=0;
 static int j=0;

 /**
  * Removes intersection of String s and "temple"
  * @param s String
  * @return String rwith intersection
  */

 public static String withoutTULetters(String s) {
  return s.toLowerCase().replaceAll("([templ])", "");
 }

 /**
  * Finds first occurrence of intersection s and "temple"
  * @param s String
  * @param startPosition index to start parse
  * @return index of first intersection
  */
 public static int indexOfFirstTULetter(String s, int startPosition) {

  String[] strS = s.toLowerCase().split("");
  for (i = startPosition; i < strS.length; i++) {
   for (j = 0; j < strArrayTemple.length; j++) {
    if (strS[i].equals(strArrayTemple[j])) {
     return i;
    }
   }
  }
  return -1;
 }

 public static String appendIfMissing(String base, String suffix) {
  StringBuilder baseMine = new StringBuilder(base.toLowerCase());
  StringBuilder suffixMine = new StringBuilder(suffix.toLowerCase());

  if (baseMine.substring((baseMine.length() - suffixMine.length()), baseMine.length()).equals(suffixMine.toString())) {
   return baseMine.toString();
  }
  return baseMine.append(suffixMine).toString();
 }

 public static boolean allTempleLetters(String s) {
  int rtn = 0;

  String[] strS = s.toLowerCase().split("");
  for (i = 0; i < s.length(); i++) {
   for (j = 0; j < TEMPLE.length(); j++) {
    if (strS[i].equals(strArrayTemple[j])) {
     rtn++;
    }
   }

  }
  return rtn == s.length();
 }

 public static boolean noTempleLetters(String s) {
  String[] strS = s.toLowerCase().split("");

  for (i = 0; i < s.length(); i++) {
   for (j = 0; j < TEMPLE.length(); j++) {

    if (strS[i].equals(strArrayTemple[j])) {
     return false;
    }

   }
  }
  return true;
 }

 public static String reversed(String s) {
  return new StringBuilder(s).reverse().toString();
 }

 public static boolean sameInReverse(String s) { return s.equals(new StringBuilder(s).reverse().toString()); }

 public static boolean inTU(char c) {
  return TEMPLE.contains(String.valueOf(c).toLowerCase());

 }

 public static int indexOfFirstTULetter(String s) {
  String[] strS = s.toLowerCase().split("");
  for (i = 0; i < strS.length; i++) {
   for (j = 0; j < strArrayTemple.length; j++) {
    if (strS[i].equals(strArrayTemple[j])) {
     return i;
    }
   }
  }

  return -1;

 }

 public static int numOccurrences(String h, String n) {
  int lengthOfKey = n.length();
  if (!h.contains(n)) {
   return 0;
  } else {
   int index = 0;
   for (i = 0; i < h.length() - 1; i++) {
    if (h.substring(i, i + lengthOfKey).contains(n)) {
     index++;
    }
   }
   return index;
  }
 }

 public static int indexOfLastTULetter(String s) {
  int rtn = -1;
  for (i = 0; i < s.length(); i++) {
   for (j = 0; j < TEMPLE.length(); j++) {
    if (s.substring(i, i + 1).contains(strArrayTemple[j])) {rtn = i;}
   }
  }
  if (rtn != -1) {return rtn;}
  return -1;
 }

}