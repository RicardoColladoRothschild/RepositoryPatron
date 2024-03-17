package org.corecode;

import org.corecode.model.Expenses;
import org.corecode.repository.ExpensesRepository;
import org.corecode.repository.IRepository;
import org.corecode.util.DataBaseConnection;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {



        System.out.println("Starting app");
            try(Connection conn = DataBaseConnection.getInstance();){
                System.out.println("Stablished connection to db");
                IRepository<Expenses> repository = new ExpensesRepository();
                System.out.println("Getting repository");

                //SHOWING ALL:
                //repository.findAll().forEach(System.out::println);

                //SAVING:
                /*LocalDate fecha = LocalDate.now();
                Expenses expense = new Expenses(2511, 1500, "VideoJuego", "Zelda Breath of the wild", Timestamp.valueOf(fecha.atStartOfDay()), Timestamp.valueOf(fecha.atStartOfDay()), "www.edeeste.com");
                    repository.save(expense);*/

                //Get one by ID:
                //System.out.println(repository.getById(2511));

                //updating:
               /* Expenses exp = repository.update(6, "InvoiceUrl", "www.unapec.com");
                System.out.println(exp);*/

                //Deleting Expense

                    repository.delete(6);
                    repository.findAll().forEach(System.out::println);
            }catch(SQLException sql){
                System.out.println(sql.toString());
            }
    }
}