package poc.corejava.threads;

import java.util.concurrent.BlockingQueue;

/**
 * implements the producer consumer problem using wait notify mechanism. The other approach is to use a {@link BlockingQueue} <br>
 * Basically, there is a chef and there is a waiter. Chef produces food plate by plate. Waiter serves plate by plate. So, if there is nothing to serve, waiter
 * waits. When its gets the picks the food for serving, it notifies chef that there is no food to serve. Chef produces a plate a food and waits till its picked
 * up for serving.
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {

    }

}

