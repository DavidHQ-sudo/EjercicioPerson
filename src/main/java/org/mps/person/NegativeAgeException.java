package org.mps.person;

public class NegativeAgeException extends RuntimeException{

    public NegativeAgeException(String s) {
        super(s);
    }
}
