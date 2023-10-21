import java.util.PriorityQueue;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StoreToys {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.weight, t1.weight));
    private Random random = new Random();

    public static void main(String[] args) {
        StoreToys toyQueue = new StoreToys("1 Конструктор 2", "2 Робот 2", "3 Кукла 6");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            for (int i = 0; i < 10; i++) {
                int result = toyQueue.Get();
                writer.write(Integer.toString(result));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StoreToys(String... toyData) {
        for (String data : toyData) {
            String[] parts = data.split(" ");
            if (parts.length == 3) {
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int weight = Integer.parseInt(parts[2]);
                Toy toy = new Toy(id, name, weight);
                toyQueue.add(toy);
            }
        }
    }

    public int Get() {
        int totalWeight = toyQueue.stream().mapToInt(t -> t.weight).sum();
        int randomNumber = random.nextInt(totalWeight);
        int currentWeight = 0;
        for (Toy toy : toyQueue) {
            currentWeight += toy.weight;
            if (randomNumber < currentWeight) {
                return toy.id;
            }
        }
        return -1;
    }
}