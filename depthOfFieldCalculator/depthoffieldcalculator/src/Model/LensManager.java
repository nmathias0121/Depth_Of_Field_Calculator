package Model;

import java.util.ArrayList;
import java.util.List;

public class LensManager {
    List<Lens> lens = new ArrayList<>();

    public LensManager(List<Lens> lens) {
        this.lens = lens;
    }

    public LensManager() {

    }


    public void add(Lens lens) {
        this.lens.add(lens);
    }

}
