import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author qinaoyun
 *         Date: 2017-12-23
 *         Time: 11:46
 */
public class TestVolatile {
    /*volatile*/ int count = 0;

    synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        TestVolatile t = new TestVolatile();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);


    }
}
