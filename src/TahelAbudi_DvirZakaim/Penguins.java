package TahelAbudi_DvirZakaim;


import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;
import TahelAbudi_DvirZakaim.exceptions.PenguinHeightException;

public class Penguins extends Animal implements Comparable<Penguins>, Leaderable{

    private float height;
    private String name;
    private boolean isLeader;
    public static float leaderHeight = 200;
    private final float Meal = 1;
    public static final int lifeExpectancy = 6;

    //constructor
    public Penguins(int age, float height, String name, boolean leader) throws GeneralException {
        super(age, lifeExpectancy);
        setHeight(height, leader);
        setName(name);
        this.isLeader = leader;
    }

    public void setName(String name) throws NameException {
        Validation.validateName(name);
        this.name = name;
    }

    public void setHeight(float height, boolean isLeader) throws PenguinHeightException {
        validateHeight(height, isLeader);
        this.height = height;
    }

    public static void resetLeaderHeight() {
        leaderHeight = 200;
    }

    // if leader - check for height higher then 0, else check for validation
    public static void validateHeight(float height, boolean isLeader) throws PenguinHeightException {
        if (height <= 0 || (height >= leaderHeight) && !isLeader) {
            throw new PenguinHeightException();
        }
    }

    public float getHeight() { return this.height; }

    public String getName() {
        return name;
    }

    @Override
    public String makeNoise() {
        return "squack";
    }

    @Override
    public float mealCalculate() {
        return isLeader ? leaderMealAmount() * Meal : Meal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Penguin: ").append(name).append(" at age: ").append(age).append(" with height: ").append(height);
        if (isLeader) {
            sb.append(leaderMessage());
        }
        return sb.toString();
    }

    //comparing by height (high to low)
    @Override
    public int compareTo(Penguins o) {
        if (o == null)
            return 1;
        return (int) ((o.getHeight() - height) * 100);
    }

    @Override
    public void setLeader() {
        this.isLeader = true;
        leaderHeight = this.height;
    }

    @Override
    public boolean isLeader() {
        return isLeader;
    }

}