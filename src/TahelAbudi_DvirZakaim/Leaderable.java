package TahelAbudi_DvirZakaim;

public interface Leaderable {

    void setLeader(boolean isLeader);
//    boolean isLeader();
    float MEAL = 2;
    String MESSAGE = " I can lead the Group ";

    default String leaderMessage() {
        return MESSAGE;
    }

    default float leaderMealAmount() {
        return MEAL;
    }
}
