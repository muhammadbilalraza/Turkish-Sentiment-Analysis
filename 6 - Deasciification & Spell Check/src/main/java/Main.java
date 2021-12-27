import Corpus.Sentence;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import SpellChecker.SimpleSpellChecker;
import SpellChecker.SpellChecker;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        System.out.println(tempD.getDeasciifiedHash().size());
//        SpellCorrect spellCorrect = new SpellCorrect();
//        spellCorrect.correctSpellings(tempD.getDeasciifiedHash());


//        String file1 = "bp_english_words_deasciified.txt";
//        String file2 = "bp_turkish_words_deasciified.txt";
//        String file3 = "members_english_words_deasciified.txt";
//        String file4 = "members_turksih_words_deasciified.txt";
//
//        File file_1 = new File(file1);
//        File file_2 = new File(file2);
//        File file_3 = new File(file3);
//        File file_4 = new File(file4);

        String input = "input.txt";
        File file = new File(input);
        FileReader reader = new FileReader(file);
//        ArrayList<String> list = reader.getFileList();
        Hashtable<String, String> map1 = reader.getFileHashtables(file); ;
        System.out.println(map1.size());

        SpellCorrect spellCorrect = new SpellCorrect();
        spellCorrect.correctSpellings(map1);
        System.out.println(spellCorrect.getSpellCorrectedHash().size());

//        Set<String> set_map1 = map1.keySet();


//        FileReader fileReader1 = new FileReader(file_1);
//        FileReader fileReader2 = new FileReader(file_2);
//        FileReader fileReader3 = new FileReader(file_3);
//        FileReader fileReader4 = new FileReader(file_4);

//        System.out.println("All files read, successfully!");

//        ArrayList<String> list1 = fileReader1.getFileList();
//        ArrayList<String> list2 = fileReader2.getFileList();
//        ArrayList<String> list3 = fileReader3.getFileList();
//        ArrayList<String> list4 = fileReader4.getFileList();

//        System.out.println(list1.size());
//        System.out.println(list2.size());
//        System.out.println(list3.size());
//        System.out.println(list4.size());


//        System.out.println("Deasciifying File 1");
//        Deasciify deasciify1 = new Deasciify();
//        deasciify1.deasciify(list1, list1.size());

//        System.out.println("Deasciifying File 2");
//        Deasciify deasciify2 = new Deasciify();
//        deasciify2.deasciify(list2, list2.size());

//        System.out.println("Deasciifying File 3");
//        Deasciify deasciify3 = new Deasciify();
//        deasciify3.deasciify(list3, list3.size());

//        System.out.println("Deasciifying File 4");
//        Deasciify deasciify4 = new Deasciify();
//        deasciify4.deasciify(list4, list4.size());

//        Set<String> set1 = deasciify1.getDeasciifiedHash().keySet();
//        Set<String> set2 = deasciify2.getDeasciifiedHash().keySet();
//        Set<String> set3 = deasciify3.getDeasciifiedHash().keySet();
//        Set<String> set4 = deasciify4.getDeasciifiedHash().keySet();


//        System.out.println("Size 1: " + set1.size());
//        System.out.println("Size 2: " + set2.size());
//        System.out.println("Size 3: " + set3.size());
//        System.out.println("Size 4: " + set4.size());
//
//
//        Hashtable<String, String> map1 = deasciify1.getDeasciifiedHash();
//        Hashtable<String, String> map2 = deasciify2.getDeasciifiedHash();
//        Hashtable<String, String> map3 = deasciify3.getDeasciifiedHash();
//        Hashtable<String, String> map4 = deasciify4.getDeasciifiedHash();
//        System.out.println("ORIGNAL 1: " + map1.size());
//        System.out.println("ORIGNAL 2: " + map2.size());
//        System.out.println("ORIGNAL 3: " + map3.size());
//        System.out.println("ORIGNAL 4: " + map4.size());
//
//
//        map1 = deasciify1.mergeHashtables(map1, map2);
//        map1 = deasciify1.mergeHashtables(map1, map3);
//        map1 = deasciify1.mergeHashtables(map1, map4);
//
//
//        System.out.println("AFTER MERGE 1: " + map1.size());
//        System.out.println("AFTER MERGE 2: " + map2.size());
//        System.out.println("AFTER MERGE 3: " + map3.size());
//        System.out.println("AFTER MERGE 4: " + map4.size());



//        try {
//            FileWriter fileWriter = new FileWriter("corrected.txt");
//            for (String key : set_map1){
//                fileWriter.write(key + " " + map1.get(key) + "\n");
//            }
//            fileWriter.close();
//
//        }
//        catch (Exception e){
//
//        }


        //spell check
//        SpellCorrect spellCorrect1 = new SpellCorrect();
//        spellCorrect1.correctSpellings(deasciify1.getDeasciifiedHash());
//        spellCorrect1.correctSpellings(deasciify2.getDeasciifiedHash());
//        spellCorrect1.correctSpellings(deasciify3.getDeasciifiedHash());
//        spellCorrect1.correctSpellings(deasciify4.getDeasciifiedHash());




    }



}




