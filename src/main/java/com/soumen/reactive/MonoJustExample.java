package com.soumen.reactive;

import reactor.core.publisher.Mono;

public class MonoJustExample {
    public static void main(String[] args) {

        Mono<Integer> monoInteger = Mono.just(1);

        System.out.println(monoInteger); // Prints the toString() method of Mono, and we don't get 1 back

        //You have to subscribe in order to get back the data
        monoInteger.subscribe(i -> System.out.println("Received :- "+i));
    }
}
