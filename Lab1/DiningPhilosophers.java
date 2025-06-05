package src.HM2_1; import java.util.concurrent.Semaphore;


class Philosopher extends Thread {
    private final int id;
    private final Semaphore leftFork;
    private final Semaphore rightFork;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " Thinking...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " eating...");
        Thread.sleep((long) (Math.random() * 1000));
    }
    //запускаем цикл еды и думания
    @Override
    public void run() {
        try {
            while (true) {

                think();


                leftFork.acquire();
                System.out.println("Philosopher " + id + " took left fork.");


                rightFork.acquire();
                System.out.println("Philosopher " + id + " took right fork.");

                eat();


                rightFork.release();
                System.out.println("Philosopher " + id + " put right fork.");
                leftFork.release();
                System.out.println("Philosopher " + id + " put left fork.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
//Здесь создадим Семафоры на каждую вилку и зададим философов
public class DiningPhilosophers {
    public static void main(String[] args) {
        int n = 5;
        Semaphore[] forks = new Semaphore[n];

        for (int i = 0; i < n; i++) {
            forks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[n];
        for (int i = 0; i < n; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % n]);
            philosophers[i].start();
        }
    }
}
