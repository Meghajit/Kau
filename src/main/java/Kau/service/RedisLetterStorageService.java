package Kau.service;

import Kau.data.letter.Letter;

import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RedisLetterStorageService implements Closeable {
    private final ExecutorService threadPool;


    public RedisLetterStorageService() {
        this.threadPool = Executors.newFixedThreadPool(5);
    }

    synchronized public Future<Boolean> persistLetterToRedis(Letter letter) {
        Callable<Boolean> callable = () -> {
            /* save the letter to redis and return some confirmation value if saved successfully */
            System.out.println("RedisLetterStorageService.class:: Saved to redis successfully ------>" + letter.toString());
            return true;
        };
        return threadPool.submit(callable);
    }

    @Override
    synchronized public void close() {
        threadPool.shutdown();
    }
}
