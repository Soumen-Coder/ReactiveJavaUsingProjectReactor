package com.soumen.reactive;

import com.soumen.reactive.utilities.Utility;
import reactor.core.publisher.Mono;

public class MonoBuildPipelineVsExecutePipeline {
    public static void main(String[] args) {
        getName(); //This only builds the pipeline and doesn't execute, hence it is not time taking and that's why Mono should be lazily loaded
        getName().subscribe(
                Utility.onNext()
        ); // This build and execute the pipeline, it is time taking operation since there's a thread.sleep inside the mono to make it a time-consuming operation
        getName(); //This only builds the pipeline and doesn't execute, hence it is not time taking and that's why Mono should be lazily loaded
    }

    //Building the pipeline
    public static Mono<String> getName(){
        System.out.println("Entered getName()");
        return Mono.fromSupplier(() -> {
                    System.out.println(" Generating Name!!!");
                    Utility.sleepSeconds(3);
                    return Utility.faker().name().fullName();
                }).map(String::toUpperCase);
    }
}
