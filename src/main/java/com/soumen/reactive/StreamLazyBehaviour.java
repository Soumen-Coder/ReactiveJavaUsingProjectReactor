package com.soumen.reactive;

import java.util.stream.Stream;

public class StreamLazyBehaviour {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1)
                .map(i ->{
                    //creating a Time Consuming operation
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return i*2;

                });

        //System.out.println(integerStream); // it doesn't do anything, it's lazy, just prints the toString method, cannot see any operations
        //You have to use a terminal operation to make stream functional

        integerStream.forEach(System.out::println); // now its blocking and waits for 2ms and print 2 and then exits

    }
}
