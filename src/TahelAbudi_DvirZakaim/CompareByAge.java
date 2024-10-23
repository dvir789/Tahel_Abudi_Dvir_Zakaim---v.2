package TahelAbudi_DvirZakaim;

import java.util.Comparator;

public class CompareByAge implements Comparator<Penguins> {
    @Override
    public int compare(Penguins o1, Penguins o2) {
        return o1.age - o2.age;
    }
}
