import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random rand = new Random();
        int vettore[] = new int[10];

        System.out.println("Originale");
        for (int i = 0; i < vettore.length; i++) {
            int random = rand.nextInt(101 / 2) * 2 + 1;
            vettore[i] = random;
            System.out.println(vettore[i]);
        }

        System.out.println("Alternati");
        for (int i = 0; i < vettore.length - 1; i++) {
            int alternanza = vettore[i] + vettore[i + 1];
            vettore[i + 1] = alternanza;
            System.out.println(vettore[i]);
        }

    }
}
