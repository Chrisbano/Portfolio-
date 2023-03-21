import java.lang.NullPointerException;

public class Knight extends MOB{
    private Fortune activeFortune;
    protected final int id;
    protected int xp;

    public Knight(int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp){
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }


    public void addXP(int xp){
        this.xp += xp;
    }

    public Fortune getActiveFortune(){
        return activeFortune;
    }
@Override
    public int getArmor(){
        try{
            return super.getArmor() + getActiveFortune().getArmor();
        }
        catch(NullPointerException ex){
            return super.getArmor();
        }
    }
@Override
    public DiceType getDamageDie(){
        try{
            return activeFortune.getDamageDie();
        }
        catch(NullPointerException ex){
            return super.damageDie;
        }
        
    }
@Override
    public int getHitModifier(){
    
        try{
            return hitModifier + getActiveFortune().getHitModifier();
        }
        catch(NullPointerException ex){
            return 0;
        }
            
    }

    public Integer getId(){
        return id;
    }
//catch
@Override
    public int getMaxHP(){
        try{
            return maxHP + getActiveFortune().getMaxHP();
        }
        catch(NullPointerException ex){
            return super.getMaxHP();
        }
    }
///catch 
    public int getXP(){
        return xp;
    }

    public void setActiveFortune(Fortune activeFortune){
        this.activeFortune = activeFortune;
    }

    
    public String toString(){
        return "+============================+\n" +
            String.format("| %-27s|\n", getName()) +
            String.format("| id: %-23d|\n", getId()) +
            String.format("|%-28s|\n", "") +
            String.format("| Health: %-6d XP: %-8d|\n", getHP(), getXP()) +
            String.format("|  Power: %-6s Armor: %-5d|\n", getDamageDie(), getArmor()) +
            String.format("|%-28s|\n", "") +
             "+============================+\n";
    }

    public String toCSV(){
        return String.format("%s.%d,%d,%d,%s,%d", getName(), getMaxHP(), getHitModifier(), getDamageDie(), getXP());
    }
    public static void main(String args[]){
        
    }
}
