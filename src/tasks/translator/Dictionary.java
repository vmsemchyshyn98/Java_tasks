package homework.translator;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static final Path path = Paths.get("./", "translator");

    private Map<String, Map<String, String>> dictionary;
    private String text;

    public Dictionary() {
        this.dictionary = new HashMap<>();
        this.text= "";
    }

    public String readDictionary(String dictionary) throws IOException {
        return new String(Files.readAllBytes(Paths.get("./translator", dictionary + ".txt")));
    }


/*
    public Map devideOnPairsOfWords(String language) throws IOException {

        Map<String, String> map = new HashMap<>();

        Stream<String> words = Files.lines(Paths.get("./", "translator", language + ".txt"));
        words.forEach(word -> {
            String[] w = word.split(":");
            map.putIfAbsent(w[0], w[1]);
        });
        return map;
    }
*/
    //   void addLanguage() throws IOException {
    //     dictionary.put("eng_rus", Map.of());
    //  dictionary.put("eng_ukr", devideOnPairsOfWords("eng_ukr"));
    //  dictionary.put("ukr_eng", devideOnPairsOfWords("ukr_eng"));

//    }

    void addNewLanguage(String fromLanguage, String toLanguage) throws IOException {
        dictionary.put(fromLanguage + "_" + toLanguage, new HashMap<>());
        Path path=Paths.get("./", "translator", fromLanguage+"_"+toLanguage+".txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
    }

    public String updateDitionary(String language){

        for (Map.Entry<String, Map<String, String>> item : dictionary.entrySet()) {
            if (language.equals(item.getKey())) {
                text += "\n" + item.getValue();
            }
        }
            return text;
    }


    public String printDictionaries(String language) {
       // String words = "";


        for (Map.Entry<String, Map<String, String>> item : dictionary.entrySet()) {
            if(language.equals(item.getKey()))
             text+= "\n"  + item.getValue();

    //        System.out.println(item.getKey() + "  " + item.getValue());
        }
        String result = text.replace("=", ":");

        return result;
    }

    void addNewWords(String language, String word, String translatedWord) throws IOException {
        dictionary.put(language, Map.of(word, translatedWord));
        Path path=Paths.get("./", "translator", language+".txt");
        Files.write(path,Map.of(word,translatedWord).toString().getBytes(),StandardOpenOption.APPEND);
    }

    void translateWord(String word, String fromLanguage, String toLanguage) {
        boolean isSearchedWord = dictionary.entrySet().stream()
                .anyMatch(entry -> entry.getKey().equals(fromLanguage + "_" + toLanguage) &&
                        entry.getValue().containsKey(word));
        for (Map.Entry<String, Map<String, String>> item : dictionary.entrySet()) {
            if (isSearchedWord) {
                System.out.println(item.getKey() + " - " + item.getValue().get(word));
            }
        }
    }

    /*

                 dictionary
                         .entrySet()
                         .stream()
                         .filter(entry -> entry.equals(fromLanguage + "_" + toLanguage))
                         .findFirst()
                         .get().getValue().get(word);


     */

    void identifyLanguage(String word) {
        String key = "";
        String language = "";
        for (Map.Entry<String, Map<String, String>> item : dictionary.entrySet()) {
            if (item.getValue().containsKey(word)) {
                key = item.getKey();
                //     System.out.println("Key: " + item.getKey());//eng_rus, eng_ukr
            }
        }
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == '_') {
                break;
            }
            language += key.charAt(i);
        }
        System.out.println("Identified language: " + language);
    }

}


