package org.corecode.repository;

import org.corecode.model.Expenses;
import org.corecode.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpensesRepository implements IRepository<Expenses>{

    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }

    @Override
    public List<Expenses> findAll() throws SQLException {
            List<Expenses> expensesList = new ArrayList<>();
        
        try(Statement statement = getConnection().createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM \"Expenses\"");
        ){
            while(resultset.next()){
                expensesList.add(createdExpense(resultset));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expensesList;
    }



    @Override
    public Expenses getById(Integer id) {
        Expenses expense = null;

            try(PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM \"Expenses\" WHERE \"Id\"= ?")){
                statement.setInt(1,id);

                try(ResultSet resultset = statement.executeQuery()){
                    if(resultset.next()){
                            expense = createdExpense(resultset);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        return expense;
    }

    @Override
    public void save(Expenses expense) {

            try(PreparedStatement statement = getConnection().prepareStatement("INSERT INTO public.\"Expenses\" (\"Id\", \"Amount\", \"Category\", \"Description\", \"CreatedAt\", \"InvoiceUrl\", \"UpdatedAt\") VALUES(?,?,?,?,?,?,?)")){

                statement.setInt(1, expense.getId());
                statement.setInt(2, expense.getAmount());
                statement.setString(3, expense.getCategory());
                statement.setString(4, expense.getDescription());
                statement.setTimestamp(5, expense.getCreatedAt());
                statement.setString(6, expense.getInvoiceUrl());
                statement.setTimestamp(7, expense.getUpdatedAt());

                    int rowsAffected = statement.executeUpdate();

                        if(rowsAffected > 0){
                            System.out.println("Expense was created.");
                        }
            } catch (
                    SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public void delete(Integer id) {

        try(PreparedStatement stamt = getConnection().prepareStatement("DELETE FROM \"Expenses\" WHERE \"Id\"=?")){
            stamt.setInt(1, id);
            stamt.executeUpdate();
        }catch(SQLException sql){
            System.out.println(sql.toString());
        }
    }

    @Override
    public Expenses update(Integer id, String fieldToUpdate, Object input) {
        String query = "UPDATE \"Expenses\" SET \"" + fieldToUpdate + "\" = '"+input+"' WHERE \"Id\" = "+id;
                    if(this.getById(id)==null){
                        System.out.println("Could not found id, nothing was updated");
                        return null;
                    }
                    try(Statement statement = getConnection().createStatement()){
                        int rowsAffected = statement.executeUpdate(query);
                            if(rowsAffected > 0){
                                System.out.println("*******Updated was completed********");
                        }
                    }catch(SQLException sql){System.out.println(sql.toString());}

        return this.getById(id);
    }

    private Expenses createdExpense(ResultSet resultset) throws SQLException {
        Expenses expense = new Expenses();
        expense.setId(resultset.getInt("Id"));
        expense.setAmount(resultset.getInt("Amount"));
        expense.setCategory(resultset.getString("Category"));
        expense.setDescription(resultset.getString("Description"));
        expense.setCreatedAt(resultset.getTimestamp("CreatedAt"));

        expense.setInvoiceUrl(resultset.getString("InvoiceUrl"));
        expense.setUpdatedAt(resultset.getTimestamp("UpdatedAt"));

        return expense;
    }
}
