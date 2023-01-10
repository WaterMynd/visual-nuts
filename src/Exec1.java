
/* Write or describe an algorithm that prints the whole integer numbers to the console, start
from the number 1, and print all numbers going up to the number 100.
However, when the number is divisible by 3, do not print the number, but print the word
'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all
numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.
How will you keep this code safe from bugs? Show how you would guarantee that this code
keeps working when developers start making small feature adjustments. (Maybe we would
want to print the first 500 numbers, ...).
*/

/**
 * Class that contains the methods of exercise 1
 */
public class Exec1 {

    /**
     * @param number - number to be used
     * @return the text for the number
     */
    public static String getTextForNumber(int number){
        String text;

        if (number % 3 == 0){
            if(number % 5 == 0) {
                text = "Visual Nuts";
            } else {
                text = "Visual";
            }
        } else if(number % 5 == 0) {
            text = "Nuts";
        } else {
            text = "" + number;
        }
        return text;
    }


    /**
     * Prints the numbers
     *
     * @param max - max number to print
     */
    public static void writeNumbers(int max) {
        int i;
        String text;

        for (i = 1; i < max + 1; i++){
            text = getTextForNumber(i);
            System.out.println(text);
        }
    }
}
