import Corpus.Sentence;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import SpellChecker.SpellChecker;
import SpellChecker.SimpleSpellChecker;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;


public class SpellCorrect {

    private Hashtable<String, String> spellCorrectedHash;
    private Hashtable<String, String> deasciifiedHash;
    private SpellChecker spellChecker;

    public SpellCorrect(){
        deasciifiedHash = new Hashtable<>();
        spellCorrectedHash = new Hashtable<>();
        FsmMorphologicalAnalyzer fsm = new FsmMorphologicalAnalyzer();
        spellChecker = new SimpleSpellChecker(fsm);


//        Sentence sentence = new Sentence("Dıktor olaç yazdı");
//        Sentence corrected = spellChecker.spellCheck(sentence);
//        System.out.println(corrected);
    }

    public void correctSpellings(Hashtable<String, String> deasciifiedHash) {

        Sentence sentence;
        Sentence corrected;

        this.deasciifiedHash = deasciifiedHash;
        Set<String> deasciifiedKeys = deasciifiedHash.keySet();

        for (String key : deasciifiedKeys) {
            sentence = new Sentence(deasciifiedHash.get(key));
            corrected = spellChecker.spellCheck(sentence);
            String listString = "";

            //if the word passed and corrected are not same
            if (!corrected.toString().equals(deasciifiedHash.get(key))) {
                spellCorrectedHash.put(key, corrected.toString());
//                ArrayList<String> tempList = new ArrayList<>();
//                tempList.add(corrected.toString());

                //while there are more than one spell corrected words
                //add to tempList
                int count = 0;
                while (true) {
                    corrected = spellChecker.spellCheck(sentence);
//                    if (!tempList.contains(corrected.toString()))
//                        tempList.add(corrected.toString());
                    if (!spellCorrectedHash.containsValue(deasciifiedHash.get(key)))
                        spellCorrectedHash.put(key, corrected.toString());
                    else {
                        count++;
                        if (count == 5)
                            break;
                    }
                }

                //convert tempList to simple String
//                for (String s : tempList) listString += s + " ";

                //adding to hashtable against the provided key
                //value word1 word2 word3 ...
//                spellCorrectedHash.put(key, listString);
                System.out.println(key + " - " + spellCorrectedHash.get(key));

            }
            else {
                System.out.println("pass");
            }
        }
    }

    public Hashtable<String, String> getSpellCorrectedHash() {
        return spellCorrectedHash;
    }
}
