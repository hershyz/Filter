public class Main {

    static String[] dictionary = new String[]{"example", "words", "that", "will", "be", "flagged"};

    public static void main(String[] args) {

        run("exampl"); //Engine will flag 'exampl' even though it is not spelled correctly.
    }

    public static void run(String word) {

        word = word.toLowerCase();

        int i;
        for (i = 0; i < dictionary.length; i++) {

            if (dictionary[i].toLowerCase().equals(word.toLowerCase())) {
                System.out.println("FLAG: " + dictionary[i]);
                return;
            }
        }

        int j;
        for (j = 0; j < dictionary.length; j++) {

            String[] wordDeviations = findDeviations(dictionary[j].toLowerCase());

            int k;
            for (k = 0; k < wordDeviations.length; k++) {
                if (word.contains(wordDeviations[k]) && wordDeviations.length > 2) {
                    System.out.println("FLAG: " + dictionary[j]);
                    return;
                }
            }
        }
    }

    public static String[] findDeviations(String word) {

        String[] wordSplit = word.split("");
        String[] deviations = new String[word.length()];

        int i;
        for (i = 0; i < wordSplit.length; i++) {

            String currentWord = "";

            int j;
            for (j = 0; j < wordSplit.length; j++) {
                if (j != i) {
                    currentWord = currentWord + wordSplit[j];
                }
            }

            deviations[i] = currentWord;
        }

        return deviations;
    }
}
