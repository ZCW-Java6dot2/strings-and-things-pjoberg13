package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        // StringBuilder str = new StringBuilder();
        Integer yzCount = 0;

        for(int i = 0; i < input.length(); i++) {
            if(i == input.length() - 1 && input.charAt(i) == 'y') {
                yzCount++;
                break;
            } else if(i == input.length() - 1 && input.charAt(i) == 'z') {
                yzCount++;
                break;
            }

            boolean b = !Character.isLetter(input.charAt(i + 1));
            if(input.charAt(i) == 'y' && b) {
                yzCount++;
            } else if(input.charAt(i) == 'z' && b) {
                yzCount++;
            } else {
                continue;
            }
        }
        return yzCount;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        Integer substringLength = remove.length();
        StringBuilder newStr = new StringBuilder();
        newStr.append(base);

        for(int i = 0; i <= newStr.length() - substringLength; i++) {
            if(newStr.substring(i, i+substringLength).equals(remove)) {
                newStr.delete(i, i+substringLength);
            }
        }
        return String.valueOf(newStr);
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        StringBuilder newStr = new StringBuilder();
        Integer notCount = 0;
        Integer isCount = 0;
        boolean b = false;
        newStr.append(input);

        //Counts the number of 'not's in string
        for(int i = 0; i <= newStr.length() - 3; i++) {
            if(newStr.substring(i, i+3).equals("not")) {
                notCount++;
            }
        }

        //Counts the number of 'is's in string
        for(int i = 0; i <= newStr.length() - 2; i++) {
            if(newStr.substring(i, i+2).equals("is")) {
                isCount++;
            }
        }

        if(notCount == isCount) {
            b = true;
        }

        return b;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'g' && input.charAt(i+1) != 'g') {
                if(input.charAt(i) == 'g' && input.charAt(i-1) != 'g') {
                    return false;
                }
            } else {
                continue;
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        Integer substringLength = 3;
        Integer tripleCount = 0;

        for(int i = 0; i <= (input.length() - substringLength); i++) {
            if(input.charAt(i+1) == input.charAt(i) && input.charAt(i+2) == input.charAt(i)) {
                tripleCount++;
            }
        }
        return tripleCount;
    }
}
