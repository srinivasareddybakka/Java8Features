package java8.executiveservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutiveServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> resutl1 = executorService.submit(() -> method1(x));
        Future<Integer> result2 = executorService.submit(() -> method1(x));
        System.out.println(" results " + resutl1.get() + " " + result2.get());
        executorService.shutdown();

    }

    public static int method1(int x) {
        return x;
    }

    private static class Result {
        private int left;
        private int right;
    }
}
