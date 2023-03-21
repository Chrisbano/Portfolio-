import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVGameData extends GameData{
    
    public CSVGameData(String gamedata, String saveData){
        loadGameData(gamedata);
        loadSaveData(saveData);
        
        
}

public void loadGameData(String gamedata){
    Scanner file = readFile(gamedata);
    while(file.hasNext()){
        String line = file.nextLine(); 
        String[] arr = line.split(",");
        if(arr[0].equalsIgnoreCase("MOB")){
            MOB m = new MOB(arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), DiceType.valueOf(arr[5])); 
            monsters.add(m);
    }
        if(arr[0].equalsIgnoreCase("Fortune")){
            if(!arr[5].contains("-")){
                Fortune f = new Fortune(arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), DiceType.valueOf(arr[5])); 
                fortunes.add(f);   
            }
            else{
                Fortune f = new Fortune(arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
                fortunes.add(f);
            }

        }
    }

}

public void loadSaveData(String saveData){
    int counter = 0;
        Scanner file = readFile(saveData);
        if(file == null) return;
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            line.useDelimiter(","); 
            Knight knight = new Knight(
                    ++counter,
                    line.next().trim(),
                    line.nextInt(),
                    line.nextInt(),
                    line.nextInt(),
                    DiceType.valueOf(line.next()),
                    line.nextInt());
            knights.add(knight);
        }
}

private Scanner readFile(String filename){
    try{
        FileInputStream file = new FileInputStream(filename);
        Scanner input = new Scanner(file);
        return input;
    }catch (FileNotFoundException ex){
        System.out.println("File: " + filename + " not found.");
        System.out.println(ex);
        return null;
    }  
}

public void save(String filename){
    try(PrintWriter f = new PrintWriter(filename)){
        for(Knight knight : knights){
            f.println(knight.toCSV());
        }
    }catch(Exception ex){
        System.out.println("Error:  " + ex);
    }
}
}