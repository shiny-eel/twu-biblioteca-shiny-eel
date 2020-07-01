package com.twu.biblioteca;

import java.util.concurrent.CountDownLatch;

public class BlockingListener implements ReaderListener {

    private CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void onReadEvent() {
        latch.countDown();
    }

    public void waitForReader() throws InterruptedException {
        latch.await();
    }
}
