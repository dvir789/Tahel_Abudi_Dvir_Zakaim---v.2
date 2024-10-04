package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Manager {

    private final String name;
    private final String city;
    private final String street;
    private final String number;

    private Animal[] animalsPack;
    private int animalsCount;


    //constructor
    public Manager(String name, String city, String street, String number) {
        this.name = name;
        this.city = city;
        this.street = street;
        this. number = number;

        setAnimalsPack();
    }


//     ========== Animals ==========
    private void setAnimalsPack() {
        animalsPack = new Animal[1];
        animalsCount = 0;

        setLion();
        setTiger();
        setPenguin();
        setAquariumFish();
    }

    private void addAnimal (Animal animal) {
        if (animalsCount >= animalsPack.length) {
            animalsPack = Arrays.copyOf(animalsPack, animalsPack.length * 2);
        }
        animalsPack[animalsCount++] = animal;
    }

    private Map<String, Float> getAnimalFeed() {
        Map<String, Float> zooFeed = new HashMap<>();

        for (int i = 0; i < animalsCount; i++) {
            String animalType = animalsPack[i].getClass().getSimpleName();
            float mealCalculator = animalsPack[i].mealCalculate();

            if (zooFeed.containsKey(animalType)) {
                zooFeed.compute(animalType, (k, feed) -> (feed == null) ? mealCalculator : feed + mealCalculator);
            } else {
                zooFeed.put(animalType, mealCalculator);
            }
        }
        return zooFeed;
    }

    private Map<String, Integer> getAnimalCount() {
        Map<String, Integer> zooCount = new HashMap<>();

        for (int i = 0; i < animalsCount; i++) {
            String animalType = animalsPack[i].getClass().getSimpleName();

            if (zooCount.containsKey(animalType)) {
                zooCount.compute(animalType, (k, count) -> (count == null) ? 1 : count + 1);
            } else {
                zooCount.put(animalType, 1);
            }
        }
        return zooCount;
    }

    public String feedAllAnimals() {
        Map<String, Float> zooFeed = getAnimalFeed();
        StringBuilder sb = new StringBuilder();

        sb.append("The Lions ate: ").append(zooFeed.get("Lion")).append(" kg of meat\n");
        sb.append("The Tigers ate: ").append(zooFeed.get("Tiger")).append(" kg of meat\n");
        sb.append("The Penguins ate: ").append(zooFeed.get("Penguins")).append(" fishes\n");
        sb.append("The Ornamental fish ate: ").append(zooFeed.get("OrnamentalFish")).append(" meals\n");
        sb.append("The Clown fish ate: ").append(zooFeed.get("ClownFish")).append(" meals\n");
        sb.append("The Gold fish ate: ").append(zooFeed.get("GoldFish")).append(" meals\n");

        return sb.toString();
    }

    public String makeNoise() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < animalsCount - 1; i++) {
            sb.append(animalsPack[i].makeNoise());
            sb.append(", ");
        }
        sb.append(animalsPack[animalsCount - 1].makeNoise());
        return sb.toString();
    }

    // ========== PENGUIN ==========

    private void setPenguin() {
        createPenguin(15, Penguins.leaderHeight, "Rossi", true); // leader
        createPenguin(12, 180, "Moss", false);
        createPenguin(11, 175, "Simon", false);
    }

    public void createPenguin(int age, float height, String name, boolean leader) {
        try {
            Penguins penguin = new Penguins(age, height, name, leader);
            addAnimal(penguin);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getPenguinList() {
        StringBuilder sb = new StringBuilder();

        Penguins[] penguins = getSortedPenguins();
        int numOfPenguins = penguins.length;

        sb.append(numOfPenguins).append("\n");
        for (int i = 0; i < numOfPenguins - 1; i++) {
            sb.append(penguins[i].toString());
            sb.append(",\n");
        }

        sb.append(penguins[numOfPenguins - 1].toString());

        return sb.toString();
    }

    private Penguins[] getSortedPenguins() {
        Penguins[] penguins = new Penguins[animalsCount];
        int place;
        int numOfPenguins = 0;

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof Penguins) {
                Penguins penguin = (Penguins) animalsPack[i];

                for (place = 0; place < numOfPenguins; place++) {
                    if (penguin.getHeight() > penguins[place].getHeight()) {
                        break;
                    }
                }
                if (numOfPenguins - place >= 0) {
                    System.arraycopy(penguins, place, penguins, place + 1, numOfPenguins - place);
                }
                penguins[place] = penguin;
                numOfPenguins++;
            }
        }
        return Arrays.copyOf(penguins, numOfPenguins);
    }

    // ========== LION ==========

    private void setLion() {
        createLion("Mufasa", 26, 50, "male");
        createLion("Simba", 15, 30, "male");
        createLion("Nala", 15, 25, "female");
        createLion("Sarabi", 26, 40, "female");
    }

    public void createLion(String name, int age, float weight, String gender) {
        try {
            Lion lion = new Lion(name, age, weight, gender);
            addAnimal(lion);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());;
        }
    }

    public String getLionList() {
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof Lion) {
                sb1.append(animalsPack[i].toString()).append("\n");
            }
        }

        return sb1.toString();
    }

    // ========== TIGER ==========

    private void setTiger() {
        createTiger("Mufasa", 26, 50, "male");
        createTiger("Simba", 15, 30, "male");
        createTiger("Nala", 15, 25, "female");
        createTiger("Sarabi", 26, 40, "female");
    }

    public void createTiger(String name, int age, float weight, String gender) {
        try {
            Tiger tiger = new Tiger(name, age, weight, gender);
            addAnimal(tiger);
        } catch (GeneralException e) {
            System.out.println(e.getMessage());;
        }
    }

    public String getTigerList() {
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof Tiger) {
                sb1.append(animalsPack[i].toString()).append("\n");
            }
        }

        return sb1.toString();
    }

    // ========== AQUARIUM FISH ==========

    private void setAquariumFish() {
        addRandomFish(10);
    }

    private void addRandomFish(int amount) {
        Random r = new Random();

        Map<String, String[]> colorsArray = getFishColors();
        Map<String, String[]> patternArray = getFishPattern();
        int age, typeSize = AquariumFish.Type.length;
        String[] fishColor;
        String fishPattern;
        String fishType;
        float length;

        int colorRandomNumber, patternRandomNumber, typeRandomNumber;

        for (int i = 0; i < amount; i++) {
            age = r.nextInt(15) + 1;
            length = r.nextFloat(10) + 1;
            typeRandomNumber = r.nextInt(typeSize);
            fishType = AquariumFish.Type[typeRandomNumber].toLowerCase();

            colorRandomNumber = r.nextInt(colorsArray.get(fishType).length);
            fishColor = new String[]{colorsArray.get(fishType)[colorRandomNumber]};

            patternRandomNumber = r.nextInt(patternArray.get(fishType).length);
            fishPattern = patternArray.get(fishType)[patternRandomNumber];

            try {
                createFish(age, length, fishType, fishColor, fishPattern);
            } catch (GeneralException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createFish(int age, float length, String type, String[] colors, String pattern) throws GeneralException{
        AquariumFish fish = switch (type.toLowerCase()) {
            case "gold fish" -> new GoldFish(age, length, colors, pattern);
            case "clown fish" -> new ClownFish(age, length, colors, pattern);
            case "ornamental fish" -> new OrnamentalFish(age, length, colors, pattern);
            default -> null;
        };

        if (fish != null) {
            addAnimal(fish);
        }
    }

    public Map<String, String[]> getFishColors() {
        Map<String, String[]> colorsArray = new HashMap<>();

        colorsArray.put("gold fish", GoldFish.validColors);
        colorsArray.put("clown fish", ClownFish.validColors);
        colorsArray.put("ornamental fish", AquariumFish.colorsArr);

        return colorsArray;
    }

    public Map<String, String[]> getFishPattern() {
        Map<String, String[]> patternArray = new HashMap<>();

        patternArray.put("gold fish", GoldFish.validPattern);
        patternArray.put("clown fish", ClownFish.validPattern);
        patternArray.put("ornamental fish", AquariumFish.patternArr);

        return patternArray;
    }

    public String getAquariumFishList() {
        StringBuilder sb = new StringBuilder();
        //count how many colors exist in the aquarium
        Map<String, Integer> colorsCount = getFishColorsCount();
        String[] uniqueColors = getUniqueColors(colorsCount);
        AquariumFish[] fishArray = getFishArray();

        for (int i = 0; i < fishArray.length - 1; i++) {
            sb.append(fishArray[i].toString());
            sb.append(",\n");
        }

        sb.append(fishArray[fishArray.length - 1].toString());
        sb.append("\nthe colors in the aquarium: ").append(colorsCount.keySet());
        sb.append("\nThere are ").append(fishArray.length).append(" fishes in the aquarium\n");
        sb.append("The most frequent color is: ").append(uniqueColors[0]);
        //if there is no second most frequent color it won't print another message
        if (uniqueColors[1] != null) {
            sb.append("\nThe second most frequent color is: ").append(uniqueColors[1]);
        }
        return sb.toString();
    }

    private String[] getUniqueColors(Map<String, Integer> colorsCount) {
        String[] uniqueColors = new String[2];

        int max = 0;

        for (String key : colorsCount.keySet()) {
            int value = colorsCount.get(key);
            if (value >= max) {
                uniqueColors[1] = uniqueColors[0];
                max = value;
                uniqueColors[0] = key;
            }
        }
        return uniqueColors;
    }

    private Map<String, Integer> getFishColorsCount() {
        Map<String, Integer> fishColorsCount = new HashMap<>();
        // counting the colors of the fish
        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof AquariumFish fish) {
                String[] fishColors = fish.getColors();

                for (String color : fishColors) {
                    if (fishColorsCount.containsKey(color)) {
                        fishColorsCount.compute(color, (k, v) -> (v == null) ? 1 : v + 1);
                    } else {
                        fishColorsCount.put(color, 1);
                    }
                }
            }
        }
        return fishColorsCount;
    }

    private AquariumFish[] getFishArray() {
        AquariumFish[] fishArray = new AquariumFish[animalsCount];
        int fishCount = 0;

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof AquariumFish) {
                fishArray[fishCount++] = (AquariumFish) animalsPack[i];
            }
        }
        return Arrays.copyOf(fishArray, fishCount);
    }

    @Override
    public String toString() {
        Map<String, Integer> zooCount = getAnimalCount();
        StringBuilder sb = new StringBuilder();

        sb.append("The Zoo name is: ").append(name).append("\n");
        sb.append("The zoo address is: ").append(city).append(", ")
                .append(number).append(", ").append(street).append("\n");

        sb.append("Lions: ").append(zooCount.get("Lion")).append("\n");
        sb.append("Tigers: ").append(zooCount.get("Tiger")).append("\n");
        sb.append("Penguins: ").append(zooCount.get("Penguins")).append("\n");
        sb.append("Ornamental fish: ").append(zooCount.get("OrnamentalFish")).append("\n");
        sb.append("Gold fish: ").append(zooCount.get("GoldFish")).append("\n");
        sb.append("Clown fish: ").append(zooCount.get("ClownFish")).append("\n");

        return sb.toString();
    }

    //---------- FISH INPUT VALIDATION ----------

    public void validateFishColor(String type, String userColor) throws ColorException {
        switch (type) {
            case "gold fish" -> GoldFish.validateColor(userColor);
            case "clown fish" -> ClownFish.validateColor(userColor);
            case "ornamental fish" -> AquariumFish.validateColor(userColor);
        }
    }

    public void validateFishLength(float length) throws LengthException {
        AquariumFish.validateLength(length);
    }

    public void validateFishPattern(String userPattern) throws PatternException {
        AquariumFish.validatePattern(userPattern);
    }

    public void validateFishType(String userType) throws TypeException {
        AquariumFish.validateType(userType);
    }

    //---------- LION INPUT VALIDATION ----------

    public void validatePredatorWeight(float weight) throws PredatorWeightException {
        Lion.validateWeight(weight);
    }

    public void validateLionGender(String gender) throws LionGenderException {
        Lion.validateGender(gender);
    }

    //---------- penguin input validation ----------

    public void validatePenguinHeight(float height, boolean isLeader) throws PenguinHeightException {
        Penguins.validateHeight(height, isLeader);
    }

}