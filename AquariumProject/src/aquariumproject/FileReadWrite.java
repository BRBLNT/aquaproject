package aquariumproject;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class FileReadWrite {
    private static ArrayList<String> fishData = new ArrayList<>();
    private static ArrayList<String> userFishData = new ArrayList<>();
    
    public FileReadWrite(){
        readFile();
    }
    
    public void writeData(ArrayList<Fish> fish){
        try {
            RandomAccessFile writer = new RandomAccessFile("user.dat","rw");
            //writer.seek(writer.length());
           
            for (Fish temp : fish) {
                writer.writeBytes(temp.toString()+"\n");
            }
        } catch (IOException exc) {
            System.out.println("Hiba: "+exc);
        }
    }
    
    public ArrayList<String> getFishData() {
        return fishData;
    }
    
    public ArrayList<String> getUserFishData() {
        return userFishData;
    }
    
    private static void readFile(){
        try{
            RandomAccessFile fileRead = new RandomAccessFile("fish.dat","r");
            for (String line = fileRead.readLine(); line != null ; line = fileRead.readLine()) {
                fishData.add(line);
            }
            fileRead.close();
        }
        catch(IOException exc){System.out.println("Hiba: "+exc);}
        try{
            RandomAccessFile fileRead = new RandomAccessFile("user.dat","r");
            for (String line = fileRead.readLine(); line != null ; line = fileRead.readLine()) {
                userFishData.add(line);
            }
            fileRead.close();
        }
        catch(IOException exc){System.out.println("Hiba: "+exc);}
    }
}
