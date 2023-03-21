import java.util.Scanner;

public class GameController {
    private final GameData data;
    private final GameView view;
    private final CombatEngine engine;

    public GameController(GameData data, GameView view, CombatEngine engine){
        this.data = data;
        this.view = view;
        this.engine = engine;
    }

    public void start(){
        Scanner scnr = new Scanner(System.in);

        while(processCommand(view.displayMainMenu())){

        }
        view.endGame();

    }

    
    
    private void processSetActive(String active){
        Knight currKnight = data.getKnight(active);
        if(currKnight == null){
            view.knightNotFound();
            
        }
        boolean kk = data.setActive(currKnight);
        if(!kk){
            view.setActiveFailed();
        }
    
    }
    
    private void processRemoveActive(String remove){
        Knight currKnight = data.getActive(remove);
        if(currKnight == null){
            view.knightNotFound();
        }
        data.removeActive(currKnight);
    
    }
    
    private void processShowKnight(String nameOrId){
        Knight currKnight = data.getKnight(nameOrId);
        if(currKnight == null){
            view.knightNotFound();
        }
        else{
            view.showKnight(currKnight);
        }
    }
    protected boolean processCommand(String command){
        if(command.contains("exit") || command.contains("bye")){
            return false;
        }
        else{
            if(command.contains("ls") || command.contains("list all")){
                view.listKnights(data.getKnights());
            }
            else if(command.contains("list active")){
                view.listKnights(data.getActiveKnights());
            }
            else if(command.startsWith("show")){
                processShowKnight(command.substring(command.indexOf("show") + 4).trim());
            }
            else if(command.startsWith("set active")){
                processSetActive(command.substring(command.indexOf("active") + 6).trim());
            }
            else if(command.startsWith("remove")){
                processRemoveActive(command.substring(command.indexOf("remove") + 6).trim());
            }
            else if(command.startsWith("save")){
                String filename = "savedata.csv";
                String tmp = command.substring(command.indexOf("save") + 4).trim();
                if(tmp.isEmpty()){
                    filename = tmp;
                }
                data.save(filename);
            }
            else if(command.contains("explore") || command.contains("adventure") || command.contains("quest")){
                engine.initialize();
                engine.clear();
         }
            else{
              view.printHelp();
            }
            return true;
            }
    
        }





}
