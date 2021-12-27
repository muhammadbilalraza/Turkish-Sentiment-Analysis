import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class WriteReviews {

    public Hashtable<String, String> getDictionary(String dictionaryFileString) {
        
        Hashtable<String, String> dic = new Hashtable<>();

        ArrayList<String> list = new ArrayList<>();
        File file = new File(dictionaryFileString);
        try {
            Scanner scan = new Scanner(file, StandardCharsets.UTF_8);
            while (scan.hasNextLine())
                list.add(scan.nextLine());
            scan.close();
        } catch (IOException e) {e.printStackTrace();}

        for (String s : list){
            String[] temp = s.split(" ");
            dic.put(temp[0], temp[1]);
        }

        return dic;
    }

    public void testHash() {
        Hashtable<String, String> hash = getDictionary("D:\\OzU Semester 7\\CS401\\GitHub\\spellings correction\\sub folder\\to_use.txt");
        System.out.println(hash);  
    }


    public void correctFile(){
        ConvertToDictionary cd = new ConvertToDictionary();
        Hashtable<String, String> hash = cd.readFileToHashtable("bp_reviews_unique_dict_dictionary.txt");

//        Hashtable<String, String> hash = getDictionary("mr_misspellings_dictionary.txt");
        int totalCorrectedWords = 0;
        for (int i=1; i<=4110; i++){
            String dir = String.format("D:\\OzU Semester 7\\CS401\\GitHub\\Turkish Sentiment Analysis\\Split Reviews\\Beyazperde.com Reviews\\Split Files\\%d.txt", i);
            File file = new File(dir);
            ArrayList<String> sentences = new ArrayList<>();
            //Read file into sentences
            try {
                Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
                while (scanner.hasNextLine()) sentences.add(scanner.nextLine());
            } catch (IOException e) {e.printStackTrace();}
            //File read successful in sentences


            //Parsing over sentences
            ArrayList<String> loStentence = new ArrayList<>();
            for (String sentence : sentences) {
                ArrayList<String> Sentence = new ArrayList<>();
//                System.out.println(sentence);
                //Splitting sentence into array of words
                String[] words = sentence.split(" ");
                for (String word : words) {
//                System.out.println(word);
                    if (hash.containsKey(word.toLowerCase())) {
//                        System.out.print(i + " " + word + " ");
                        word = hash.get(word.toLowerCase());
                        totalCorrectedWords++;

//                        System.out.println(word);
                    }
                    Sentence.add(word);
                }
                //Convert it to single String
                //Add to the list of Sentences
                loStentence.add(ArrayListToString(Sentence));
            }
            //write list of sentences to file
            System.out.println(i + ": " + loStentence.size() + " Total: " + totalCorrectedWords);
            try (FileWriter fileWriter = new FileWriter(String.format("D:\\OzU Semester 7\\CS401\\GitHub\\Task4\\bp_spellings_corrected\\%d.txt", i), StandardCharsets.UTF_8)) {
                for (String sentence: loStentence)
                fileWriter.write(sentence);
            } catch (IOException e) {e.printStackTrace();}
        }
    }


    private String ArrayListToString(ArrayList<String> list){
        StringBuilder str = new StringBuilder();
        for (int i=0; i<list.size(); i++)
            if (i==list.size()-1)
                str.append(list.get(i)).append("\n");
            else
                str.append(list.get(i)).append(" ");
        return str.toString();
    }
}