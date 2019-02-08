/*
 * Author: Andrii Semchenko
 * Created at Feb 2019
 */
package site.asem;

/**
 * Is used to concatenate parts of sentence.
 */
public class Model {
    /*
     * Concatenates strings and separates them with a delimiter
     */
    private static char DEFAULT_DELIMITER = ' ';
    private StringBuilder sentence = new StringBuilder();
    private char delimiter;

    public Model() {
        delimiter = DEFAULT_DELIMITER;
    }

    public Model(char delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Concatenate string with previously added ones using a delimiter
     *
     * @param words string to be concatenated
     */
    public void append(String words) {
        sentence.append(words);
        sentence.append(delimiter);
    }

    /**
     * Is used to get final string
     *
     * @return final string
     */
    public String getSentence() {
        return sentence.toString();
    }
}
