package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.AgeException;
import TahelAbudi_DvirZakaim.exceptions.GeneralException;
import TahelAbudi_DvirZakaim.exceptions.NameException;

import java.util.Arrays;
import java.util.Random;

public class Manager {

    private final String name;
    private final String city;
    private final String street;
    private final String number;

    private Penguins[] penguinsPack;
    private int penguinsCount;

    private Lion[] lionsPack;
    private int lionCount;

    private AquariumFish[] aquariumFishPack;
    private int aquariumFishCount;

    private int numOfUniqueColors;

    //constructor
    public Manager(String name, String city, String street, String number) throws GeneralException {
        this.name = name;
        this.city = city;
        this.street = street;
        this. number = number;

        setLion();
        setPenguin();
        setAquariumFish();
    }

    // ========== PENGUIN ==========

    private void setPenguin() throws GeneralException {
        penguinsPack = new Penguins[1];
        penguinsCount = 0;

        createPenguin(15, Penguins.leaderHeight, "Rossi", true); // leader
        createPenguin(12, 180, "Moss", false);
        createPenguin(11, 175, "Simon", false);
    }

    public void createPenguin(int age, float height, String name, boolean leader) throws GeneralException {
        Penguins penguin = new Penguins(age, height, name, leader);
        addPenguin(penguin);
    }

    public void addPenguin(Penguins penguin) {
        if (penguinsCount >= penguinsPack.length) {
            penguinsPack = Arrays.copyOf(penguinsPack, penguinsPack.length * 2);
        }

        int place;
        for (place = 0; place < penguinsCount; place++) {
            if (penguin.getHeight() > penguinsPack[place].getHeight()){
                break;
            }
        }

        if (penguinsCount - place >= 0) System.arraycopy(penguinsPack, place, penguinsPack, place + 1, penguinsCount - place);
        penguinsPack[place] = penguin;
        penguinsCount++;
    }

    public String getPenguinList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < penguinsCount - 1; i++) {
            sb.append(penguinsPack[i].toString());
            sb.append(",\n");
        }
        sb.append(penguinsPack[penguinsCount - 1].toString());

        return sb.toString();
    }

    // ========== LION ==========

    private void setLion() {
        lionsPack = new Lion[1];
        lionCount = 0;

        createLion("Mufasa", 26, 50, "male");
        createLion("Simba", 15, 30, "male");
        createLion("Nala", 15, 25, "female");
        createLion("Sarabi", 26, 40, "female");
    }

    public void createLion(String name, int age, float weight, String gender) {
        Lion lion = new Lion(name, age, weight, gender);
        addLion(lion);
    }

    private void addLion(Lion lion) {
        if (lionCount >= lionsPack.length) {
            lionsPack = Arrays.copyOf(lionsPack, lionsPack.length * 2);
        }
        lionsPack[lionCount++] = lion;
    }

    public String getLionList() {
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < lionCount - 1; i++) {
            sb1.append(lionsPack[i].toString());
            sb1.append(",\n");
        }
        sb1.append(lionsPack[lionCount - 1].toString());

        return sb1.toString();
    }

    // ========== AQUARIUM FISH ==========

    private void setAquariumFish() {
        aquariumFishPack = new AquariumFish[1];
        addRandomFish(10);
    }

    private void addRandomFish(int amount) {
        Random r = new Random();
        int age, patternSize = AquariumFish.patternArr.length, colorSize = AquariumFish.colorsArr.length;
        String[] fishColor;
        String fishPattern;
        float length;
        int colorRandomNumber, patternRandomNumber;

        for (int i = 0; i < amount; i++) {
            age = r.nextInt(15) + 1;
            length = r.nextFloat(10) + 1;
            colorRandomNumber = r.nextInt(colorSize);
            fishColor = new String[]{AquariumFish.colorsArr[colorRandomNumber]};
            patternRandomNumber = r.nextInt(patternSize);
            fishPattern = AquariumFish.patternArr[patternRandomNumber];
            createFish(age, fishColor, length, fishPattern);
        }
    }

    public void createFish(int age, String[] userColors, float length, String userPattern) {
        AquariumFish fish = new AquariumFish(length, age, userColors, userPattern);
        addFish(fish);
    }

    private void addFish(AquariumFish fish) {
        if (aquariumFishCount >= aquariumFishPack.length) {
            aquariumFishPack = Arrays.copyOf(aquariumFishPack, aquariumFishPack.length * 2);
        }
        aquariumFishPack[aquariumFishCount++] = fish;
    }

    public String getAquariumFishList() {
        StringBuilder sb = new StringBuilder();
        String[] uniqueColors = new String[1];

        for (int i = 0; i < aquariumFishCount - 1; i++) {
            sb.append(aquariumFishPack[i].toString());
            sb.append(",\n");
        }
        sb.append(aquariumFishPack[aquariumFishCount - 1].toString());
        sb.append("\nThere are ").append(aquariumFishCount).append(" fishes in the aquarium\n");

        for (int i = 0; i < aquariumFishCount; i++) {
            String[] fishColors = aquariumFishPack[i].getColors();
            for (String color : fishColors) {
                uniqueColors = isUniqueColor(uniqueColors, color);
            }
        }

        uniqueColors = Arrays.copyOf(uniqueColors, numOfUniqueColors);
        sb.append(Arrays.toString(uniqueColors));

        return sb.toString();
    }

    public String[] isUniqueColor(String[] uniqueColors, String color) {
        if (Arrays.toString(uniqueColors).toLowerCase().contains(color.toLowerCase())) {
            return uniqueColors;
        }
        if (numOfUniqueColors >= uniqueColors.length) {
            uniqueColors = Arrays.copyOf(uniqueColors, uniqueColors.length * 2);
        }
        uniqueColors[numOfUniqueColors++] = color;
        return uniqueColors;
    }

    public String feedAllAnimals() {
        float lionsMeals = 0, fishMeals = 0;
        int penguinsMeal = penguinsCount;
        StringBuilder sb = new StringBuilder();

        for (Lion lion: lionsPack) {
            if (lion == null){
                break;
            }
            lionsMeals += lion.mealCalculate();
        }

        for (AquariumFish fish : aquariumFishPack) {
            if (fish == null) {
                break;
            }
            fishMeals += fish.mealCalculateFish();
        }

        sb.append("The lions ate: ").append(lionsMeals).append(" kg of meat\n");
        sb.append("The fishes ate: ").append(fishMeals).append(" meals\n");
        sb.append("The penguins ate: ").append(penguinsMeal).append(" fishes");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The Zoo name is: ").append(name).append("\n");
        sb.append("The zoo address is: ").append(city).append(", ").append(number).append(", ").append(street).append("\n");
        sb.append("Lions: ").append(lionCount).append("\n");
        sb.append("Penguins: ").append(penguinsCount).append("\n");
        sb.append("AquariumFish: ").append(aquariumFishCount).append("\n");
        return sb.toString();
    }

    //---------- FISH INPUT VALIDATION ----------

    public boolean isValidFishAge(int age) {
        return AquariumFish.isValidAge(age);
    }

    public boolean isValidFishColor(String userColor) {
        return AquariumFish.isValidColor(userColor);
    }

    public boolean isValidFishLength(float length) {
        return AquariumFish.isValidLength(length);
    }

    public boolean isValidFishPattern(String userPattern) {
        return AquariumFish.isValidPattern(userPattern);
    }

    public boolean canAddFishColor(int numOfUserColors) {
        return numOfUserColors < AquariumFish.colorsArr.length;
    }

    //---------- LION INPUT VALIDATION ----------

    public boolean isValidLionName(String name) {
        return Lion.isValidName(name);
    }

//    public boolean isValidLionAge(int age) throws AgeException {
//        return main.isValidAge(age);
//    }

    public boolean isValidLionWeight(float weight) {
        return Lion.isValidLionWeight(weight);
    }

    public boolean isValidLionGender(String gender) {
        return Lion.isValidGender(gender);
    }

    //---------- penguin input validation ----------


//    public boolean isValidPenguinAge(int age) {
//        return main.isValidAge(age);
//    }

    public boolean isValidPenguinHeight(float height, boolean leader) {
        return Penguins.isValidPenguinHeight(height, leader);
    }
}