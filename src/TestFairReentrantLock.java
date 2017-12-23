import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:可重入锁的公平锁
 *
 * @author qinaoyun
 *         Date: 2017-12-23
 *         Time: 16:48
 */
public class TestFairReentrantLock extends Thread {
    private static ReentrantLock lock = new ReentrantLock(true); //参数为true表示为公平锁，请对比输出结果

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestFairReentrantLock rl = new TestFairReentrantLock();
        Thread th1 = new Thread(rl);
        Thread th2 = new Thread(rl);
        th1.start();
        th2.start();
    }
}
