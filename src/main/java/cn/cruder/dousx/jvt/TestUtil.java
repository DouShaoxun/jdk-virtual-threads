package cn.cruder.dousx.jvt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class TestUtil {
    private TestUtil() {
    }

    public static void contrastTest(Boolean ofVirtual) {
        int count = 100_000;
        CountDownLatch downLatch = new CountDownLatch(count);
        Runnable runnable = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            downLatch.countDown();
        };
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            if (ofVirtual) {
                Thread.ofVirtual().name(String.format("vt-%s", i)).start(runnable);
            } else {
                Thread.ofPlatform().name(String.format("pf-%s", i)).start(runnable);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("elapsed time：%s ms%n", endTime - startTime);
    }
}
