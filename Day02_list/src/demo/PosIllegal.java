package demo;

import java.util.Random;

public class PosIllegal extends RuntimeException {
    public PosIllegal() {

    }

    public PosIllegal(String message) {
        super(message);
    }
}
