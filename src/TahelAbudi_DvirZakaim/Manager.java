package TahelAbudi_DvirZakaim;

import TahelAbudi_DvirZakaim.exceptions.*;

import java.util.*;

public class Manager {

    private final String name;
    private final String city;
    private final String street;
    private final String number;

    private Animal[] animalsPack;
    private int animalsCount;

    //constructor
    public Manager(String name, String city, String street, String number) throws GeneralException {
        this.name = name;
        this.city = city;
        this.street = street;
        this.number = number;

        setAnimalsPack();
    }

    //     ========== Animals ==========
    private void setAnimalsPack() throws GeneralException {
        animalsPack = new Animal[1];
        animalsCount = 0;

        setLion();
        setTiger();
        setPenguin();
        setAquariumFish();
    }

    private void addAnimal(Animal animal) {
        if (animalsCount >= animalsPack.length) {
            animalsPack = Arrays.copyOf(animalsPack, animalsPack.length * 2);
        }
        animalsPack[animalsCount++] = animal;
    }

    private float getAnimalFeed(String type) {
        float totalAmountFed = 0;

        for (int i = 0; i < animalsCount; i++) {
            String animalType = animalsPack[i].getClass().getSimpleName();
            if (!type.equals(animalType)) {
                continue;
            }
            totalAmountFed += animalsPack[i].mealCalculate();
        }

        return totalAmountFed;
    }

    private int getAnimalCountByType(String type) {
        int totalCount = 0;

        for (int i = 0; i < animalsCount; i++) {
            String animalType = animalsPack[i].getClass().getSimpleName();
            if (!type.equals(animalType)) {
                continue;
            }
            totalCount++;
        }
        return totalCount;
    }

    public String feedAllAnimals() {
        for (int i = 0; i < animalsCount; i++) {
            animalsPack[i].feed();
        }

        StringBuilder sb = new StringBuilder();

        sb.append("The Lions ate: ").append(getAnimalFeed(Lion.class.getSimpleName())).append(" kg of meat\n");
        sb.append("The Tigers ate: ").append(getAnimalFeed(Tiger.class.getSimpleName())).append(" kg of meat\n");
        sb.append("The Penguins ate: ").append(getAnimalFeed(Penguins.class.getSimpleName())).append(" fishes\n");
        sb.append("The Ornamental fish ate: ").append(getAnimalFeed(OrnamentalFish.class.getSimpleName())).append(" meals\n");
        sb.append("The Clown fish ate: ").append(getAnimalFeed(ClownFish.class.getSimpleName())).append(" meals\n");
        sb.append("The Gold fish ate: ").append(getAnimalFeed(GoldFish.class.getSimpleName())).append(" meals\n");

        return sb.toString();
    }

    public String makeNoise() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < animalsCount - 1; i++) {
            sb.append(animalsPack[i].makeNoise()).append(", ");
        }
        if (animalsCount > 0) {
            sb.append(animalsPack[animalsCount - 1].makeNoise());
        } else {
            sb.setLength(0);
        }

        return sb.toString();
    }

    public void removeAnimals() {
        Animal[] updatedAnimalPack = new Animal[animalsPack.length];
        int index = 0;

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] != null) {
                updatedAnimalPack[index++] = animalsPack[i];
            }
        }
        animalsCount = index;

        System.arraycopy(updatedAnimalPack, 0, animalsPack, 0, animalsPack.length);
        makePenguinsLeader(); // if penguins has no leader after removal, make new leader.
    }

    public String ageOneYear() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("The animals that died:\n");
        boolean isAnimalDied = false;

        for (int i = animalsCount - 1; i >= 0; i--) {
            if (animalsPack[i].ageOneYear()) {
                sb1.append(animalsPack[i].toString()).append("\n");
                animalsPack[i] = null;
                isAnimalDied = true;
            }
        }
        removeAnimals();
        if (!isAnimalDied) {
            sb1.setLength(0);
        }

        return sb1.toString();
    }

    // ========== PENGUIN ==========

    private void setPenguin() throws GeneralException {
        createPenguin(5, Penguins.leaderHeight, "Rossi", true); // leader
        createPenguin(4, 180, "Moss", false);
        createPenguin(3, 175, "Simon", false);
    }

    public void createPenguin(int age, float height, String name, boolean leader) throws GeneralException {
        Penguins penguin = new Penguins(age, height, name, leader);
        addAnimal(penguin);
        makePenguinsLeader(); // if the leader dies, make the highest penguin the leader,
                              // if we have 0 penguins, reset the leader height
    }

    public String getPenguinList(Comparator<Penguins> comparator) {
        StringBuilder sb = new StringBuilder();

        Penguins[] penguins = getSortedPenguinsArray(comparator);
        int numOfPenguins = penguins.length;

        sb.append("Penguins: ").append(numOfPenguins).append("\n");
        for (int i = 0; i < numOfPenguins - 1; i++) {
            sb.append(penguins[i].toString());
            sb.append(",\n");
        }

        if (numOfPenguins > 0) {
            sb.append(penguins[numOfPenguins - 1].toString());
        }

        return sb.toString();
    }
    //get sorted Penguins Array by comparator, if the method gets "null" it will use the Penguin's compareTo method

    private Penguins[] getSortedPenguinsArray(Comparator<Penguins> comparator) {
        Penguins[] penguins = new Penguins[animalsCount];
        int numOfPenguins = 0;

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof Penguins penguin) {

                penguins[numOfPenguins] = penguin;
                numOfPenguins++;
            }
        }
        Penguins[] actualPenguins = Arrays.copyOf(penguins, numOfPenguins);
        if (comparator != null) {
            Arrays.sort(actualPenguins, comparator);
        } else {
            Arrays.sort(actualPenguins);
        }

        return actualPenguins;
    }

    private void makePenguinsLeader() {
        Penguins[] penguins = getSortedPenguinsArray(null);
        if (penguins.length > 0 ) {
            if (!penguins[0].isLeader()) {
                penguins[0].setLeader();
            }
        } else {
            Penguins.resetLeaderHeight();
        }
    }

    // ========== LION ==========

    private void setLion() throws GeneralException {
        createLion("Mufasa", 10, 50, "male");
        createLion("Simba", 14, 30, "male");
        createLion("Nala", 15, 25, "female");
        createLion("Sarabi", 9, 40, "female");
    }

    public void createLion(String name, int age, float weight, String gender) throws GeneralException {
        Lion lion = new Lion(name, age, weight, gender);
        addAnimal(lion);
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

    private void setTiger() throws GeneralException {
        createTiger("Mufasa", 2, 50, "male");
        createTiger("Simba", 1, 30, "male");
        createTiger("Nala", 3, 25, "female");
        createTiger("Sarabi", 5, 40, "female");
    }

    public void createTiger(String name, int age, float weight, String gender) throws GeneralException {
        Tiger tiger = new Tiger(name, age, weight, gender);
        addAnimal(tiger);
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

    private void setAquariumFish() throws GeneralException {
        addRandomFish(10);
    }

    private void addRandomFish(int amount) throws GeneralException {
        Random r = new Random();

        int age, typeSize = AquariumFish.Type.length;
        String[] fishColor;
        String fishPattern;
        String fishType;
        float length;

        int colorRandomNumber, patternRandomNumber, typeRandomNumber;

        for (int i = 0; i < amount; i++) {
            age = r.nextInt(7) + 1;
            length = r.nextFloat(10) + 1;
            typeRandomNumber = r.nextInt(typeSize);
            fishType = AquariumFish.Type[typeRandomNumber].toLowerCase();

            String[] colors = getFishAvailableColors(fishType);
            colorRandomNumber = r.nextInt(colors.length);
            fishColor = new String[]{colors[colorRandomNumber]};

            String[] patterns = getFishPattern(fishType);
            patternRandomNumber = r.nextInt(patterns.length);
            fishPattern = patterns[patternRandomNumber];

            createFish(age, length, fishType, fishColor, fishPattern);
        }
    }

    public String[] getFishAvailableColors(String type) throws TypeException {
        switch (type) {
            case "gold fish" -> {
                return GoldFish.getAvailableColors();
            }
            case "clown fish" -> {
                return ClownFish.getAvailableColors();
            }
            case "ornamental fish" -> {
                return OrnamentalFish.getAvailableColors();
            }
        }
        throw new TypeException();
    }

    public int getFishLifeExpectancy(String type) throws TypeException {
        switch (type) {
            case "gold fish" -> {
                return GoldFish.lifeExpectancy;
            }
            case "clown fish" -> {
                return ClownFish.lifeExpectancy;
            }
            case "ornamental fish" -> {
                return OrnamentalFish.lifeExpectancy;
            }
        }
        throw new TypeException();
    }

    public String[] getFishPattern(String type) throws TypeException {
        switch (type) {
            case "gold fish" -> {
                return GoldFish.getAvailablePattern();
            }
            case "clown fish" -> {
                return ClownFish.getAvailablePattern();
            }
            case "ornamental fish" -> {
                return OrnamentalFish.getAvailablePattern();
            }
        }
        throw new TypeException();
    }

    public void createFish(int age, float length, String type, String[] colors, String pattern) throws GeneralException {
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

    public String getAquariumFishList() {
        StringBuilder sb = new StringBuilder();
        //count how many colors exist in the aquarium
        String[] fishColors = getFishColors();
        int[] uniqueColors = getUniqueColors(getFishColorsCount(fishColors));
        AquariumFish[] fishArray = getFishArray();

        for (int i = 0; i < fishArray.length - 1; i++) {
            sb.append(fishArray[i].toString());
            sb.append(",\n");
        }

        sb.append(fishArray[fishArray.length - 1].toString());
        sb.append("\nthe colors in the aquarium: ").append(Arrays.toString(fishColors));
        sb.append("\nThere are ").append(fishArray.length).append(" fishes in the aquarium\n");
        sb.append("The most frequent color is: ").append(fishColors[uniqueColors[0]]);
        //if there is no second most frequent color it won't print another message
        if (uniqueColors[1] != -1) {
            sb.append("\nThe second most frequent color is: ").append(fishColors[uniqueColors[1]]);
        }
        return sb.toString();
    }

    private int[] getUniqueColors(int[] fishColorCount) {
        int[] uniqueColors = {-1, -1};

        int max1 = 0, max2 = 0;
        for (int i = 0; i < fishColorCount.length; i++) {
            if (fishColorCount[i] >= max1) {
                max1 = fishColorCount[i];

                uniqueColors[0] = i;
            } else if (fishColorCount[i] >= max2) {
                max2 = fishColorCount[i];
                uniqueColors[1] = i;
            }
        }
        return uniqueColors;
    }

    private String[] getFishColors() {
        String[] fishColors = new String[1];
        int numOfFishColors = 0;

        boolean addColor;
        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof AquariumFish fish) {
                String[] currentFishColors = fish.getColors();
                for (int j = 0; j < currentFishColors.length; j++) {
                    addColor = true;
                    for (int k = 0; k < numOfFishColors; k++) {
                        if (Objects.equals(fishColors[k], currentFishColors[j])) {
                            addColor = false;
                            break;
                        }
                    }
                    if (addColor) {
                        if (numOfFishColors >= fishColors.length) {
                            fishColors = Arrays.copyOf(fishColors, fishColors.length * 2);
                        }
                        fishColors[numOfFishColors++] = currentFishColors[j];
                    }
                }
            }
        }
        return Arrays.copyOf(fishColors, numOfFishColors);
    }

    private int[] getFishColorsCount(String[] fishColors) {
        int[] fishColorsCount = new int[fishColors.length];

        for (int i = 0; i < animalsCount; i++) {
            if (animalsPack[i] instanceof AquariumFish fish) {
                String[] currentFishColors = fish.getColors();
                for (int j = 0; j < currentFishColors.length; j++) {
                    for (int k = 0; k < fishColors.length; k++) {
                        if (Objects.equals(fishColors[k], currentFishColors[j])) {
                            fishColorsCount[k]++;
                            break;
                        }
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
        StringBuilder sb = new StringBuilder();

        sb.append("The Zoo name is: ").append(name).append("\n");
        sb.append("The zoo address is: ").append(city).append(", ")
                .append(number).append(", ").append(street).append("\n");

        sb.append("Lions: ").append(getAnimalCountByType("Lion")).append("\n");
        sb.append("Tigers: ").append(getAnimalCountByType("Tiger")).append("\n");
        sb.append("Penguins: ").append(getAnimalCountByType("Penguins")).append("\n");
        sb.append("Ornamental fish: ").append(getAnimalCountByType("OrnamentalFish")).append("\n");
        sb.append("Gold fish: ").append(getAnimalCountByType("GoldFish")).append("\n");
        sb.append("Clown fish: ").append(getAnimalCountByType("ClownFish")).append("\n");

        return sb.toString();
    }

    //---------- FISH INPUT VALIDATION ----------

    public void validateFishColor(String type, String userColor) throws ColorException {
        switch (type) {
            case "gold fish" -> GoldFish.validateColor(userColor);
            case "clown fish" -> ClownFish.validateColor(userColor);
            case "ornamental fish" -> OrnamentalFish.validateColor(userColor);
        }
    }

    public void validateFishLength(float length) throws LengthException {
        AquariumFish.validateLength(length);
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