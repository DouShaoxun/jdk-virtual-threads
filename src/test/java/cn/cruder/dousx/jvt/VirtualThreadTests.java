package cn.cruder.dousx.jvt;

import org.junit.jupiter.api.Test;

public class VirtualThreadTests {

    @Test
    void ofVirtualTest() {
        // 127ms
        TestUtil.contrastTest(true);
    }
    @Test
    void ofPlatformTest() {
        // 5706ms
        TestUtil.contrastTest(false);
    }
}
