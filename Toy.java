import java.util.Objects;

public class Toy {
    int id;
    String name;
    int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeigth() {
        return weight;
    }

    @Override
    public String toString() {
        return "ID: " + id + " name: " + name + " weight" + weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Toy toy = (Toy) obj;
        return weight == toy.weight && Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}