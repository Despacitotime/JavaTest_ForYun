package ExcelNeed.Entity;

/**
 * @author xxx
 * @date 2020/10/21 13:47
 */
public class Cat {
    private Integer age;
    private String color;
    private Integer legs;

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", color='" + color + '\'' +
                ", legs=" + legs +
                '}';
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
