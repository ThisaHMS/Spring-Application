package com.hsenid.mobile.spring.view;

import com.hsenid.mobile.spring.config.GetUserInput;
import com.hsenid.mobile.spring.controller.DbController;

/**
 * Created by hsenid on 9/21/17.
 */

public class CommandLineInterface implements UserInterface {

    DbController controller = new DbController();

    @Override
    public void loadUi() {
        display();
    }
    public void display() {
        int option = mainMenu();

        if(option == 1) {
            addNewBook();
        }else if (option == 2){
            addNewAuthor();
        }else if (option == 3){
            viewBook();
        }else if (option == 4){
            viewAuthor();
        }else if (option == 5){
            lendBook();
        }else if (option == 6){
            returnBook();
        }else if (option == 7){
            System.exit(0);
        }
    }


    public int mainMenu() {
        System.out.println("\n\n\n##########Librayry Management#########\n");
        System.out.println("1. Add new book");
        System.out.println("2. Add new author");
        System.out.println("3. View books");
        System.out.println("4. View authors");
        System.out.println("5. Lend book");
        System.out.println("6. Return book");
        System.out.println("7. Exit");

        return Integer.parseInt(GetUserInput.getScanner().next());
    }

    public void addNewAuthor(){
        System.out.print("Enter author id : ");
        Integer id = GetUserInput.getScanner().nextInt();
        System.out.print("Enter Author name : ");
        String name = GetUserInput.getScanner().next();

        try{
            controller.insertData(new Object[]{id , name});
        }catch (Exception e) {

        }

        display();
    }

    public void addNewBook(){
        System.out.print("Enter book id : ");
        Integer id = GetUserInput.getScanner().nextInt();
        System.out.print("Enter book name : ");
        String name = GetUserInput.getScanner().next();

        System.out.print("Enter author id : ");
        Integer author = GetUserInput.getScanner().nextInt();

        try {
            controller.insertData(new Object[]{id , name , author});
        }catch (Exception e) {
            System.out.print(e);
        }

        display();
    }

    public void viewBook() {

        try{

        }catch (Exception e) {
            controller.selectData(true);
        }

        display();
    }

    public void viewAuthor(){

        controller.selectData(false);
        display();
    }

    private void lendBook() {

        controller.selectData(true);
        System.out.print("Enter the book id number to lend : ");
        Integer bookId = GetUserInput.getScanner().nextInt();

        boolean availability = controller.checkAvailability(bookId);

        if (availability) {
            System.out.println("You can lend the book...");
            controller.updateData(bookId , "false");
            display();
        }else {
            System.out.println("Sorry the book is not available...");
            display();
        }
    }

    private void returnBook() {

        controller.selectData(true);

    }
}
