import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class FileReader {

    private ArrayList<String> fileList;

    public FileReader(){}


    public FileReader(File file){

        fileList = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                fileList.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getFileList() {
        return fileList;
    }

    public Hashtable<String, String> getFileHashtables(File file){

        Hashtable<String, String> hash = new Hashtable<>();

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String temp = scanner.nextLine();
                String[] splited = temp.split(" ");
                hash.put(splited[0], splited[1]);
            }

        }
        catch (Exception e){}

        return hash;
    }

    public Hashtable<String, String> mergeHashtables(Hashtable<String, String> map1, Hashtable<String, String>map2) {
        map2.forEach(
                (key, value) -> map1.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2)
        );
        return map1;
    }

}
