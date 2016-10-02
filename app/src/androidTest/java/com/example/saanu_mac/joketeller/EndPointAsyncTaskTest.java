package com.example.saanu_mac.joketeller;

import android.test.AndroidTestCase;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Saanu_mac on 9/28/16.
 */
public class EndPointAsyncTaskTest extends AndroidTestCase implements EPAsyncResponseListener{
    CountDownLatch signal;

    public void setUp() throws Exception {
        super.setUp();

        super.setUp();
        signal = new CountDownLatch(1);
        EndPointAsyncTask endpointsAsyncTask = new EndPointAsyncTask();
        endpointsAsyncTask.execute(this);

        signal.await(30, TimeUnit.SECONDS);

    }

    public void tearDown() throws Exception {

    }

    @Override
    public void getJokesfromEndpoint(String joke) {

        assertNotNull("The Joke is null", joke);
        assertFalse("Joke is empty", joke.isEmpty());
    }
}