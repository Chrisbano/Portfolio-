import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public abstract class GameData {

    abstract void loadSaveData(String filename) throws IOException;
    abstract void loadGameData(String filename) throws IOException;

    protected final List<Knight> activeKnights = new ArrayList<>();
    protected final List<Fortune> fortunes = new ArrayList<>();
    protected final List<Knight> knights = new ArrayList<>();
    protected static final int MAX_ACTIVE =4;
    protected final List<MOB> monsters = new ArrayList<MOB>();
    private static final Random random = new Random();


    public GameData(){

    }

    public List<Knight> getKnights(){
        return knights;
    }
    
    public List<Knight> getActiveKnights(){
        return activeKnights;
    }

    public Knight getActive(String nameOrId){
        return findKnight(nameOrId, activeKnights);
    }

    public Knight getKnight(String nameOrId){
        return findKnight(nameOrId, knights);
    }

    protected Knight findKnight(String nameOrId, List<Knight> list){
        for(int i = 0; i < list.size(); i++){
            Knight currentKnight = list.get(i);

            if(currentKnight.getId().toString().equals(nameOrId) || currentKnight.getName().toLowerCase().contains(nameOrId.toLowerCase())){
                return currentKnight;
            }
        }
        return null;
    }

    public boolean setActive(Knight currKnight){
        if(activeKnights.size() < MAX_ACTIVE){
            activeKnights.add(currKnight);
            return true;
        }
        return false;
    }

    public void removeActive(Knight currKnight){
        currKnight.resetDamage();

        activeKnights.remove(currKnight);
    }

    public List<MOB> getRandomMonster(){
        List<MOB> randomMonsters = new ArrayList<MOB>();

        if(monsters.size() <= activeKnights.size()){
            randomMonsters.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return randomMonsters;

    }

    public List<MOB> getRandomMonsters(long num){
        List<MOB> randMonsters = new ArrayList<MOB>();

        if(num > randMonsters.size()){
            randMonsters.add(monsters.get(random.nextInt(monsters.size())).copy());
        }
        return randMonsters;

    }
    public Fortune getRandomFortune(){
        int i = random.nextInt(fortunes.size());
        return fortunes.get(i);
    }

    public abstract void save(String filename);

}