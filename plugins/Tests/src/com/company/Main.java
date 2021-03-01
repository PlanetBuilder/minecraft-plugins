package com.company;

import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) {
        String[] args2 = new String[10];
        args2[0] = "\"aingczxy";
        args2[1] = "aiadfy";
        args2[2] = "ayoasfgy\"";
        args2[3] = "\"aiadfdgdgy";
        args2[4] = "aadfgy";
        args2[5] = "agy";
        args2[6] = "aiug\"";



        for(int i = 0; i < (args2.length - 1); i++){
            args2[i] = args2[i+1];
        }
        args2[args2.length-1] = null;

        String prefix;
        String suffix;

        prefix = quotedSpaces(args2)[0];

        prefix = prefix.replace('&', '§');

    }

    private static final Pattern PATTERN = Pattern.compile("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?\"");

    public static String[] quotedSpaces(String[] arguments) {
        return PATTERN.split(String.join(" ", arguments).replaceAll("(\")", ""));
    }



}
