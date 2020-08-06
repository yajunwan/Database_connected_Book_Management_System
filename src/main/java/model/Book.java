/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Book {
    private String bookname;
    private String author;
    private float price;
    private int publishYear;

    public Book(String bookname, String author, float price, int publishYear){
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.publishYear = publishYear;
    }

    public String getBookName(){
        return bookname;
    }

    public void setBookName(String bookname){
        this.bookname = bookname;
    }

    public String getAuthorName(){
        return author;
    }

    public void setAuthorName(String author){
        this.author = author;
    }

    public float getBookprice(){
        return price;
    }

    public void setBookprice(float price){
        this.price = price;
    }

    public int getPublishYear(){
        return publishYear;
    }

    public String bookInfo(){
        return String.format("Title: %s. Written By: %s. Published in: %d. Price: %f",bookname,author,publishYear,price);
    }


}

