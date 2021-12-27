import Corpus.Sentence;
import Deasciifier.Deasciifier;
import Deasciifier.SimpleDeasciifier;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;

import java.util.*;

public class Deasciify {
    private Hashtable<String, String> deasciifiedHash;
    private Deasciifier deasciifier;

    public Deasciify(){
        FsmMorphologicalAnalyzer fsm = new FsmMorphologicalAnalyzer();
        deasciifier = new SimpleDeasciifier(fsm);
        deasciifiedHash = new Hashtable<>();
    }

    public void deasciify(ArrayList<String> inputList, int size){
        Sentence sentence;
        Sentence deasciified;

        //until the size of input list
        for (int i=0; i<size; i++) {
            sentence = new Sentence(inputList.get(i));
            deasciified = deasciifier.deasciify(sentence);
//            String listString = "";

                if (!deasciified.toString().equals(inputList.get(i))) {
                deasciifiedHash.put(inputList.get(i), deasciified.toString());
//                ArrayList<String> tempList = new ArrayList<>();
//                tempList.add(deasciified.toString());

                //while there are more than one deasciified words
                //add to tempList
                int count = 0;
                while(true){
                    deasciified = deasciifier.deasciify(new Sentence(sentence.toString()));
//                    if (!tempList.contains(deasciified.toString()))
//                        tempList.add(deasciified.toString());
                    if (!deasciifiedHash.containsValue(deasciified.toString()))
                        deasciifiedHash.put(inputList.get(i), deasciified.toString());
                    else {
                        count++;
                        if (count==5)
                            break;
                    }

                }

//               //convert tempList to simple String
//                for (String s : tempList) listString += s + " ";

                //adding to hashtable against the provided key
                //value word1 word2 word3 ...
//                deasciifiedHash.put(inputList.get(i), listString);
                System.out.println(i + ":" + inputList.get(i) + " - " + deasciifiedHash.get(inputList.get(i)));
            }
//            else {
//                System.out.println(i + ":" + deasciifiedHash.get(inputList.get(i)));
//            }
        }
    }

    public void getValues(){

        Set<String> keysSet = deasciifiedHash.keySet();
        for (String key: keysSet){
            System.out.println(deasciifiedHash.get(key));
        }

    }

    public Hashtable<String, String> getDeasciifiedHash() {
        return deasciifiedHash;
    }


}
