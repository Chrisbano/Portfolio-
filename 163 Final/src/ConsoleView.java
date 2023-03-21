import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView{
    private final Scanner in = new Scanner(System.in);

    public ConsoleView() {

    }

    public void splashScreen() {
        System.out.println(
                "" +
                        "*--------------------*\n" +
                        "*                    *\n" +
                        "*       KNIGHT       *\n" +
                        "*        FIGHT!      *\n" +
                        "*                    *\n" +
                        "*   lets get this    *\n" +
                        "*                    *\n" +
                        "*                    *\n" +
                        "*--------------------*\n"
        );
    }

    public void endGame(){
        System.out.println("Thank you for playing!");
    }

    public String displayMainMenu(){
        String command;
        System.out.println("What would you like to do? ");
        command = in.nextLine();
        return command;
    }

    public void printHelp(){
        System.out.println("Unsure what to do, here are some options:");
        System.out.println("\tls or list all  - listing the knights");
        System.out.println("\tlist active  - list the active knights knights only");
        System.out.println("\tshow name or id - show the knight details card");
        System.out.println("\tset active name or id - set knight as active (note: only 4 knights can be active) ");
        System.out.println("\tremove active name or id - remove a knight from active status (heals knight)");
        System.out.println("\texplore or adventure or quest - find random monsters to fight");
        System.out.println("\tsave filename - save the game to the file name (default: saveData.csv)");
        System.out.println("\t exit or goodbye - to leave the game");
        System.out.println("Game rules: You can have four active knights. As long as they are active, they won't heal, ");
        System.out.println("but they can gain XP by going on adventures.");
        System.out.println("When you make a knight inactive, they will heal. How many monsters can you defeat ");
        System.out.println("before, you have to heal?\n");
    }

    public void listKnights (List<Knight> knights) {
        if(knights.isEmpty()){
            System.out.println("No knights to list!\n");
        }
        else{
            for(int i = 0; i < knights.size(); i++){
                System.out.println(String.format("%d: %s", knights.get(i).getId(), knights.get(i).getName()));
            }
        }
    }

    public void knightNotFound(){
        System.out.println("Knight not found!");
    }

    public void showKnight(Knight knight){
        System.out.println(knight.toString() + "\n");
    }

    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at one time.");
    }

    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights){
        System.out.println();
        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.printf("%-27s %s%n", "Knights", "Foes");
        int end = Math.max(monsters.size(), activeKnights.size());
        for(int i = 0; i < end; i++){
            if( i < monsters.size() && i < activeKnights.size()){
                System.out.printf("%-27s %s%n", activeKnights.get(i).getName());
            }
            if(i < activeKnights.size()){
                System.out.printf("%s%n", activeKnights.get(i).getName());
            }
        }
        System.out.println();}

    public void printBattleText(MOB dead){
        System.out.println(dead.getName() + "was defeated!");
    }

    public void printFortunes(List<Knight> activeKnights){
        System.out.println("For this quest, our knights drew the following fortunes!");
        for(int i = 0; i < activeKnights.size(); i++){
            System.out.println(activeKnights.get(i).getName() + " drew");
            System.out.println(activeKnights.get(i).getActiveFortune());
        }

    }

    public boolean checkContinue(){
        System.out.println("Would you like to continue on your quest (y/n)? ");
        if(in.nextLine().equals("y") || in.nextLine().equals("yes")){
            return true;
        }
        else{
            return false;
        }
    }

    public void printDefeated(){
        System.out.println("All active knights have been defeated!");
    }




}
