import java.util.concurrent.*;

/**
 * Description:
 *
 * @author qinaoyun
 *         Date: 2017-12-26
 *         Time: 19:19
 */
public class T06_Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        }); //new Callable () { Integer call();}

        new Thread(task).start();

        System.out.println(task.get()); //阻塞

        //*******************************
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        System.out.println(f.get());
        System.out.println(f.isDone());

    }
}

