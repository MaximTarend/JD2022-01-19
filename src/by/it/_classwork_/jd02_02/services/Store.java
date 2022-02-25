package by.it._classwork_.jd02_02.services;

import by.it._classwork_.jd02_02.utils.RandomData;
import by.it._classwork_.jd02_02.utils.Sleeper;
import by.it._classwork_.jd02_02.entity.Customer;
import by.it._classwork_.jd02_02.exceptions.StoreException;

import java.util.ArrayList;
import java.util.List;

public class Store extends Thread {
    @Override
    public void run() {
        System.out.println("Store opened");
        int number = 0;
        List<Thread> threads = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count = RandomData.get(2);
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer(++number);
                CustomerWorker customerWorker = new CustomerWorker(this, customer);
                threads.add(customerWorker);
                customerWorker.start();
            }
            Sleeper.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new StoreException(e);
            }
        }
        System.out.println("Store closed");
    }
}
