package com.soumen.reactive;

import com.soumen.reactive.utilities.Utility;
import reactor.core.publisher.Mono;

// Never use a Mono.just because it is not lazy loading, Mono should always be lazily loaded
// You want to do something only when there is a request for it - use Mono.fromSupplier()
// Supplier is a FunctionalInterface which doesn't take anything as input but provides/supplies output
// Mono.just invokes the getName() even when it is not subscribed by a consumer which is wrong
// Callable can throw checked exceptions
public class MonoFromSupplier {
    public static void main(String[] args) {

        //Mono<String> mono = Mono.just(getName()); //Mono.just invokes the getName() even when it is not subscribed by a consumer which is wrong

        Mono<String> monoFromSupplier = Mono.fromSupplier(MonoFromSupplier::getName); //Mono.fromSupplier doesn't invoke getName() unless it is subscribed
        monoFromSupplier.subscribe(
                Utility.onNext()
        );

        // Callable also takes in nothing and gives back an output
        Mono<String> monoFromCallable = Mono.fromCallable(MonoFromSupplier::getName); // Mono.fromCallable doesn't invoke getName() unless it is subscribed
        monoFromCallable.subscribe(
                Utility.onNext()
        );
    }

    public static String getName(){
        System.out.println("Generating Name!!!");
        return Utility.faker().name().fullName();
    }
}
