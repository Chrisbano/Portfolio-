public class Fortune implements Attributes{
    public static Object activeFortune;
    private int armor;
    private final DiceType dtype;
    private final int hitModifier;
    private final int hpBonus;
    private final String name;

    
    

    public Fortune(String name, int hpBonus, int armor, int hitModifier){
        this(name, hpBonus, armor, hitModifier, null);
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type){
        this.armor = armor;
        this.name = name; 
        this.hpBonus = hpBonus;
        this.hitModifier = hitModifier;
        this.dtype = type;

    }

    public String toString(){
        return "+======================+\n" +
        String.format("|%-22s|%n", getName()) +
        String.format("|HP Bonus: %12s|%n", getMaxHP() < 0 ? getMaxHP() : "+" + getMaxHP()) +
        String.format("|AC Bonus: %12s|%n", getArmor() < 0 ? getArmor() : "+" + getArmor()) + 
        String.format("|Hit Bonus: %11s|%n", getHitModifier() < 0 ? getHitModifier() : "+" + getHitModifier()) +
        String.format("|Damage Adj: %10s|%n", getDamageDie() == null ? "-" : getDamageDie()) +
        "+======================+";
    }

    public String getName() {
        return name;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        return dtype;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }
    
    public static void main(String[] args){
        Fortune ftn = new Fortune("Merlin's Luck", 10, 5, 2, DiceType.D12);

        System.out.println("TESTING Armor in Fortune:  " + ftn.getArmor());

    }

}
