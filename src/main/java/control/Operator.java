/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.database;
import model.Book;

public class Operator {
    public boolean addBook(String bookname, String author, float price, int Pubyr){
        /*try-with-resources block */
         try(Connection conn = database.getConnection();Statement state = conn.createStatement()){
          String sql = "INSERT INTO bookmanage(bookname,PubYear,author,price) values('"+bookname+"','"+Pubyr+"','"+author+"',"+price+")";
          state.execute(sql);
          return true;
        } catch(SQLException e){
            e.printStackTrace();
          return false;
        } 
    }
    public boolean deleteBook(String bookname, int id){
        try(Connection conn = database.getConnection();Statement state = conn.createStatement()){
            String sql;
            if (id != -1){
                sql = "DELETE FROM bookmanage WHERE ID="+id;
            }else{
                sql = "DELETE FROM bookmanage WHERE bookname='"+bookname+"'";
            }
            state.execute(sql);
            return true;
        } catch (SQLException e){
            return false;
        }
    }
    public ArrayList<Book> findBook(String bookname, String author, int Pubyr_range1, int Pubyr_range2, float minPrice, float maxPrice){
        ArrayList<Book> booklist = new ArrayList<>();
        try(Connection conn = database.getConnection();Statement state = conn.createStatement()){
            String sql = null;
            ResultSet rs;
            if (bookname != null){
                sql = "SELECT * FROM bookmanage WHERE bookname='"+bookname+"'";
            }else if(author != null){
                sql = "SELECT * FROM bookmanage WHERE author='"+author+"'";
                if (Pubyr_range2!=0){
                    sql = sql+" and PubYear>="+Pubyr_range1+" and PubYear<="+Pubyr_range2+" ORDER BY PubYear DESC";
                }
            }else if(maxPrice!=0){
                sql = "SELECT * FROM bookmanage WHERE price=>"+minPrice+" and price<="+maxPrice+" ORDER BY price";
            }else{
                System.out.println("Unknown error");
                sql = "";
            }
            rs = state.executeQuery(sql);
            
            while(rs.next()){
                String bookName = rs.getString("bookname");
                String Author = rs.getString("author");
                float Price = rs.getFloat("price");
                int PubYr = rs.getInt("PubYear");
                Book book = new Book(bookName,Author,Price,PubYr);
                booklist.add(book);
            }
        }catch(SQLException e){
        }
        return booklist;
    }
    public void printAllbook(){
        ArrayList<Book> booklist = new ArrayList<>();
        try(Connection conn = database.getConnection();Statement state = conn.createStatement()){
            ResultSet rs = null;
            String sql = "SELECT * FROM bookmanage ORDER BY ID DESC";
            rs = state.executeQuery(sql);
            while(rs.next()){
                String bookName = rs.getString("bookname");
                String Author = rs.getString("author");
                float Price = rs.getFloat("price");
                int PubYr = rs.getInt("PubYear");
                Book book = new Book(bookName,Author,Price,PubYr);
                booklist.add(book);
            }
        for (int i=0;i<booklist.size();i++){
            Book b = (Book)booklist.get(i);
            System.out.println(b.bookInfo());
        }
        }catch(SQLException e){   
        }
    }
}

