public class MOB implements Attributes{
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private String name;

    MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie){
        this.name = name;
        this.maxHP = hp;
        this.damageDie = damageDie;
        this.hitModifier = hitModifier;
        this.armor = armor;
    }


    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
      
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public int getDamage(){
        return damage;
    }
    public void resetDamage(){
        damage = 0;
    }
    public void addDamage(int damage){
        this.damage += damage;
    }
    public String getName(){
        return name;
    }
    public int getHP(){
        return maxHP - damage;
    }
    

    public MOB copy(){
        return new MOB(this.name,this.maxHP,this.armor,this.hitModifier, this.damageDie);
    }

    public String toString(){
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }
    public static void main(String args[]){

    }
}
