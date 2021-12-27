import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class ConvertToDictionary {

    public ArrayList<String> readFileToList(String fileToConvertName){
        ArrayList<String> list = new ArrayList<>();
        File file = new File(fileToConvertName);
        try {
            Scanner read = new Scanner(file);
            while(read.hasNextLine())
                list.add(read.nextLine());
            read.close();

        } catch (FileNotFoundException e) {e.printStackTrace();}

        return list;
    }

    public Hashtable<String, String> readFileToHashtable(String dictionaryFileName) {
        Hashtable<String, String> dic = new Hashtable<>();
        ArrayList<String> list = readFileToList(dictionaryFileName);

        for (String s : list){
            String[] temp = s.split(" ");
            dic.put(temp[0], temp[1]);
        }

        return dic;
    }

    public void makeDictionary(String dictionaryFileName, String fileToConvertName, String outputFileName){
        ArrayList<String> list = readFileToList(fileToConvertName);
        Hashtable<String, String> hash = readFileToHashtable(dictionaryFileName);
        Hashtable<String, String> dictionary = new Hashtable<>();
        ArrayList<String> unused = new ArrayList<>();

        for (String word: list){
            if(hash.containsKey(word.toLowerCase()))
                dictionary.put(word.toLowerCase(), hash.get(word.toLowerCase()));
            else unused.add(word);
        }

        writeHashTableToFile(outputFileName, dictionary);
        writeListToFile(outputFileName.replaceAll(".txt","_lmo.txt"), unused);

//        Set<String> set = hash.
        System.out.println("Dictionary size: " + dictionary.size());
        System.out.println("Less morphological words: " + unused.size());
    }

    public void writeHashTableToFile(String newFileName, Hashtable<String,String> hash) {

        Set<String> keysSet = hash.keySet();
        try {
            FileWriter fileWriter = new FileWriter(newFileName, StandardCharsets.UTF_8);
            int keyCount = 0;
            for (String key: keysSet) {
                System.out.println(++keyCount + ": " + key + " " + hash.get(key));
                fileWriter.write(key + " " + hash.get(key) + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    public void writeListToFile(String newFileName, ArrayList<String> list){
        try {
            FileWriter fileWriter = new FileWriter(newFileName, StandardCharsets.UTF_8);
            for (String key: list)
                fileWriter.write(key+ "\n");

            fileWriter.close();
        } catch (IOException e) {e.printStackTrace();}
    }



}
