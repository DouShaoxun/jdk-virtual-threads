package cn.cruder.dousx.jvt;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class VirtualThreadTests {
    @Test
    void ofVirtualTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final var k = i;
            Thread.ofVirtual().name(String.format("vt-%s", k))
                    .start(() -> {
                        try {
                            TimeUnit.MILLISECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName() + " " + k);
                    });
        }
        TimeUnit.SECONDS.sleep(1);

    }
}
