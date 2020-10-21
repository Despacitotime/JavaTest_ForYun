package ExcelNeed.Entity;

import java.util.List;

/**
 * @author xxx
 * @date 2020/10/21 16:10
 */
public class Cats {
    private List<Cat> cats;

    @Override
    public String toString() {
        return "Cats{" +
                "cats=" + cats +
                '}';
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
