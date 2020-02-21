package homework.translator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        Dictionary dictionary = new Dictionary();
       // dictionary.printDictionaries();
     //   dictionary.addNewLanguage("rus","ukr");
      //  dictionary.writeToDictionary("rus_ukr");
        dictionary.addNewLanguage("rus","eng");
      //  dictionary.writeToDictionary("rus_eng");
        dictionary.addNewLanguage("eng","ukr");
    //    dictionary.writeToDictionary("eng_ukr");

        dictionary.printDictionaries("eng_ukr");


        //dictionary.addNewWords("eng_rus", "buy", "купить");
        dictionary.addNewWords("rus_eng", "buy", "купить");
        dictionary.addNewWords("eng_ukr", "dd", "ff");
        dictionary.addNewWords("eng_ukr", "aa", "bb");

       // dictionary.printDictionaries();


        System.out.println("Translate word:");
        dictionary.translateWord("dd", "eng", "ukr");

        dictionary.identifyLanguage("dd");

    }
}
