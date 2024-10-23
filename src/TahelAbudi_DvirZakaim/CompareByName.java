package TahelAbudi_DvirZakaim;

import java.util.Comparator;

public class CompareByName implements Comparator<Penguins> {
    @Override
    public int compare(Penguins o1, Penguins o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
