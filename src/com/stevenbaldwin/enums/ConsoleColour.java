package com.stevenbaldwin.enums;
//  Created by Steven J Baldwin  on 2016-10-07.

import java.io.Serializable;

public enum ConsoleColour implements Serializable {

    BLUE("\u001B[34m"),RESET("\u001B[0m"),BLACK("\u001B[30m"),YELLOW("\u001B[33m"), RED("\u001B[31m"),GREEN("\u001B[32m"),PURPLE("\u001B[35m"),CYAN("\u001B[36m"),BOLD("\u001B[1m"),WHITE("\u001B[37m"),
    BACKGROUND_WHITE("\u001B[47m"),BACKGROUND_RED("\u001B[41m"),BACKGROUND_CYAN("\u001B[46m"),BACKGROUND_YELLOW("\u001B[43m"),BACKGROUND_GREEN("\u001B[42m"),
    BACKGROUND_BLACK("\u001B[49m");

    private final String colourCode;

    ConsoleColour(String colourCode){
        this.colourCode = colourCode;
    }


    @Override
    public String toString() {
        return this.colourCode;
    }
}
