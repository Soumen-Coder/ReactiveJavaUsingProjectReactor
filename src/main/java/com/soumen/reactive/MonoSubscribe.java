package com.soumen.reactive;

import reactor.core.publisher.Mono;

public class MonoSubscribe {
    public static void main(String[] args) {

        //Publisher - Mono
        Mono<Integer> monoInteger = Mono.just("ReactiveJava")
                .map(String::length)
                .map(length -> length/0);

        // Option 1 to pass subscribe(), this will make the mono fetch the data but doesn't do anything - monoInteger.subscribe()

        //Option 2
        monoInteger.subscribe(
                item -> System.out.println("The Item passed is :-" +item),  // onNext accepts Consumer method
                err -> System.out.println(err.getMessage()),  //onError accepts Consumer<Throwable>
                () -> System.out.println("Completed")  //onComplete - Runnable - Just prints doesn't accepts anything
        );

        //If you just pass the onNext method and not the onError, You will get Nasty Exception.
    }
}
