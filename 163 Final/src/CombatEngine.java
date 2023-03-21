import java.util.List;
import java.util.Random;

public class CombatEngine extends Object{
    private final GameData data;
    private final GameView view;

    public CombatEngine(GameData data, GameView  view){
        this.data = data;
        this.view = view;
    }
    public void initialize() {
        for(int i = 0; i < data.getActiveKnights().size(); i++){
            data.getActiveKnights().get(i).setActiveFortune(data.getRandomFortune());
        }
        view.printFortunes(data.getActiveKnights());
        System.out.println("\n");
    }
    
    public void clear(){
        for(int i = 0; i < data.getKnights().size(); i++){
            data.getKnights().get(i).setActiveFortune(null);
        }
    }

}
