package com.soumen.reactive;

import com.soumen.reactive.utilities.Utility;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {
        //The consumer subscribed to the producer will get back the response
        userRepository(2).subscribe(
                Utility.onNext(),
                Utility.onError(),
                Utility.onComplete()
        );
    }


    //Image you have a Database repository which is a producer of Names of person based on userId
    public static Mono<String> userRepository(int userId){
        if(userId == 1){
            //return a name of a fake person using the faker object
            return Mono.just(Utility.faker().name().firstName());
        }else if(userId == 2){
            //If userId passed as 2, there's no data in repo, and you indicate it with Mono.empty()
            return Mono.empty(); //null
        }else{
            //If the passed value is not in the allowed range of userId, then error will be sent to the consumer
            return Mono.error(new RuntimeException("Not in range of allowed values"));
        }
    }
}
