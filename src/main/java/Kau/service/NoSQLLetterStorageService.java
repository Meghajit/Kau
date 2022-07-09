package Kau.service;

import Kau.data.letter.Letter;

import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoSQLLetterStorageService implements Closeable {
    private final ExecutorService threadPool;

    public NoSQLLetterStorageService() {
        this.threadPool = Executors.newFixedThreadPool(5);
    }

    synchronized public Future<Boolean> persistLetterToNoSQL(Letter letter) {
        Callable<Boolean> callable = () -> {
            /* save the letter to DB and return some confirmation value if saved successfully */
            System.out.println("NoSQLLetterStorageService.class:: Saved to NoSQL successfully ------>" + letter.toString());
            return true;
        };
        return threadPool.submit(callable);
    }

    @Override
    public void close() {
        threadPool.shutdown();
    }
}
