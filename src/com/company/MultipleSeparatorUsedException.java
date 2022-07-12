package com.company;

public class MultipleSeparatorUsedException extends Throwable {
    public MultipleSeparatorUsedException() {
        super("More than one separators found in data entry");
    }
}
