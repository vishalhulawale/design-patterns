/**
 * Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already existing.
 * So this pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs.
 * This pattern uses java cloning to copy the object.
 */

class Rocket implements Cloneable {
    private final double height;
    private final double range;

    public Rocket(double height, double range) {
        this.height = height;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Height: " + this.height + " Range: " + this.range;
    }

    @Override
    public Rocket clone() {
        try {
            return (Rocket) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported");
        }
    }
}

public class Prototype {

    public static void main(String[] args) {
        Rocket r1 = new Rocket(111d, 225d);
        System.out.println(r1);
        Rocket r2 = r1.clone();
        System.out.println(r2);
        System.out.println(r1.equals(r2));
    }

}
