package com.soumen.reactive.utilities;

import java.util.function.Consumer;


//This Utility class will help in providing functionality for onNext(), onError() and onComplete() methods
public class Utility {

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received :- " + o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("Error :- " + e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }
}
