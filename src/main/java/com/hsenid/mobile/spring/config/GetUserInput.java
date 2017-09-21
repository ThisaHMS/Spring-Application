package com.hsenid.mobile.spring.config;

import java.util.Scanner;

/**
 * Created by hsenid on 9/21/17.
 */

public class GetUserInput {

    static final Scanner SCANNER = new Scanner(System.in);

    public static Scanner getScanner(){
        return SCANNER;
    }
}
