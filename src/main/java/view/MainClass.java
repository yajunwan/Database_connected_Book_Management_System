/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import java.util.ArrayList;

import control.Operator;
import model.Book;
 
public class MainClass {   

    public MainClass(){
        Scanner input = new Scanner(System.in);
        mainPage();
        while(true){
            int choice = input.nextInt();
            if (choice == 4){
                System.out.println("Successfully exited the system, thanks for using");
                break;
            }

            switch(choice){
                case 1:addBook();
                break;
                case 2:deleteBook();
                break;
                case 3:findBook();
                break;
                default:
                System.out.println("Invalid input, choose again between 1-5");
                mainPage();
                continue;
            }
        }
    }
    private void mainPage(){
        System.out.println("Welcome to the book management system");
        System.out.println("Please enter a number from 1-4 to have the following actions:");
        System.out.println("Add a book to the library -- Enter 1");
        System.out.println("Delete a book from the library -- Enter 2");
        System.out.println("Find a book you want -- Enter 3");
        System.out.println("To exit the system -- Enter 4");
    }

    private void addBook(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the book");
        String bookname = input.nextLine();
        System.out.println("Please enter the name of the author");
        String author = input.nextLine();
        System.out.println("Please enter the price of the book");
        float price = input.nextFloat();
        System.out.println("Please enter the publish year of the book");
        int publishYear = input.nextInt();
        Operator op = new Operator();
        boolean isAdded = op.addBook(bookname, author, price, publishYear);
        if (isAdded){
           System.out.println("Successfully added the book!"); 
        }else{
           System.out.println("Failed to add the book!");
        }
        op.printAllbook();
        System.out.println("Enter 'yes' if you want to add another book, Enter 'no' if you want to back to the main page");
        String c = input.next();
        if ("yes".equals(c)){
            addBook();
        }else if ("no".equals(c)){
            mainPage();
        }
        input.close();
    }

    private void deleteBook(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Please enter in which way you want to delete the book: ");
            System.out.println("The index -- Enter 1");
            System.out.println("The name -- Enter 2");
            System.out.println("Back to main menu -- Enter 3");

            int choice = input.nextInt();
            int id = -1;
            String bookname = "";
            
            if (choice == 1){
                Operator op = new Operator();
                System.out.println("Please enter the index of the book you want to delete");
                int idx = input.nextInt();
                if (idx>-1){
                    boolean isDeleted = op.deleteBook(null, idx);
                    if (isDeleted){                   
                        System.out.println("The book has been successfully deleted!");
                        op.printAllbook();
                    }else{
                        System.out.println("Failed to delete the book");
                    }
                }else{
                    System.out.println("The information you entered is invalid, try again please.");
                }
            }else if(choice == 2){
                System.out.println("Please enter the name of the book you want to delete");
                bookname = input.nextLine();
                Operator op = new Operator();
                boolean isDeleted = op.deleteBook(bookname, id);
                if (!isDeleted){
                    System.out.println("There is no such book named "+bookname+" in the library");
                }else{
                    System.out.println("Successfully deleted the book");
                    op.printAllbook();
                }
            }else if(choice == 3){
                mainPage();
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
        input.close();
    }

    private void findBook(){
        Scanner input = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<>();
        while(true){
            String bookname = "";
            String author = "";
            float maxPrice = 0;
            float minPrice = 0;
            int year1 = 0;
            int year2 = 0;
            System.out.println("Please enter in which way you want to find the book: ");
            System.out.println("The book name -- Enter 1");
            System.out.println("The author and price range -- Enter 2");
            System.out.println("The author and range of publication year -- Enter 3");
            System.out.println("Back to main menu -- Enter 4");

            int choice = input.nextInt();
            if (choice == 1){
                Operator op = new Operator();
                System.out.println("Please enter the name of the book you want to find");
                bookname = input.nextLine();
                list = op.findBook(bookname, author, year1,year2,minPrice,maxPrice);
                for (int i=0;i<list.size();i++){
                    Book b = (Book)list.get(i);
                    System.out.println(b.bookInfo());
                }
            }else if(choice == 2){
                Operator op = new Operator();
                System.out.println("Please enter the name of the author you want to find");
                author = input.nextLine();
                System.out.println("Please enter the price range,seperated by ',' ,for example: 10,100");
                String[] price = input.nextLine().split(",");
                minPrice = Float.parseFloat(price[0]);
                maxPrice = Float.parseFloat(price[1]);
                list = op.findBook(bookname, author, year1,year2,minPrice,maxPrice);
                for (int i=0;i<list.size();i++){
                    Book b = (Book)list.get(i);
                    System.out.println(b.bookInfo());
                }
            }else if(choice == 2){
                Operator op = new Operator();
                System.out.println("Please enter the name of the author you want to find");
                author = input.nextLine();
                System.out.println("Please enter the price range,seperated by ',' ,for example: 10,100");
                String[] price = input.nextLine().split(",");
                minPrice = Float.parseFloat(price[0]);
                maxPrice = Float.parseFloat(price[1]);
                list = op.findBook(bookname, author, year1,year2,minPrice,maxPrice);
                for (int i=0;i<list.size();i++){
                    Book b = (Book)list.get(i);
                    System.out.println(b.bookInfo());
                }
            }else if(choice == 3){
                Operator op = new Operator();
                System.out.println("Please enter the name of the author you want to find");
                author = input.nextLine();
                System.out.println("Please enter the range of publication year,seperated by ',' ,for example: 1945,1966");
                String[] year = input.nextLine().split(",");
                year1 = Integer.parseInt(year[0]);
                year2 = Integer.parseInt(year[1]);
                list = op.findBook(bookname, author, year1,year2,minPrice,maxPrice);
                for (int i=0;i<list.size();i++){
                    Book b = (Book)list.get(i);
                    System.out.println(b.bookInfo());
                }
            }else if(choice == 4){
                mainPage();
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
        input.close();
    }

    public static void main(String[]args){
        MainClass mainClass = new MainClass();
    }
}
