package com.hsenid.mobile.spring.view;

/**
 * Created by hsenid on 9/21/17.
 */

public class UiFactory {

    public static UserInterface create() {
        return new CommandLineInterface();
    }
}
