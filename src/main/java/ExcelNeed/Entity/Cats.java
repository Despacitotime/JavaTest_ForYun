package ExcelNeed.Entity;

import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author xxx
 * @date 2020/10/21 16:10
 */
public class Cats {
    private List<Cat> cats;
    private Integer num;

    @Override
    public String toString() {
        return "Cats{" +
                "cats=" + cats +
                ", num=" + num +
                '}';
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
