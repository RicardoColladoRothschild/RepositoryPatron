package org.corecode.view;


import org.corecode.model.Expenses;
import org.corecode.repository.ExpensesRepository;
import org.corecode.repository.IRepository;
import org.corecode.util.DataBaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
public class SwingApp extends JFrame {

    private final IRepository<Expenses> expensesRepository;

    private final JTable expensesTable;

        public SwingApp(){
            setTitle("My expenses");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600,300);

            expensesTable = new JTable();
            JScrollPane scrollPane = new JScrollPane(expensesTable);
            add(scrollPane, BorderLayout.CENTER);

                JButton addBtn = new JButton("Agregar");
                JButton updateBtn = new JButton("Actualizar");
                JButton deleteBtn = new JButton("Eliminar");

                JPanel buttonPanel = new JPanel();
                buttonPanel.add(addBtn);
                buttonPanel.add(updateBtn);
                buttonPanel.add(deleteBtn);
                add(buttonPanel, BorderLayout.SOUTH);

            addBtn.setBackground(new Color(46, 204, 113));
            addBtn.setForeground(Color.WHITE);
            addBtn.setFocusPainted(false);

            updateBtn.setBackground(new Color(52, 152, 219));
            updateBtn.setForeground(Color.WHITE);
            updateBtn.setFocusPainted(false);

            deleteBtn.setBackground(new Color(231, 76, 60));
            deleteBtn.setForeground(Color.WHITE);
            deleteBtn.setFocusPainted(false);
                expensesRepository = new ExpensesRepository();

                refreshExpensesTable();

                addBtn.addActionListener(event->{
                    try{
                        agregarExpense();
                        System.out.println("Agregado");
                    }catch(SQLException sql){System.out.println(sql.toString());}
                });

                updateBtn.addActionListener(event->updateExpense());
                //deleteBtn.addActionListener(event->deleteExpense());

        }

        private void refreshExpensesTable(){

                try{
                    List<Expenses> expenses = expensesRepository.findAll();

                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("ID");
                        model.addColumn("Amount");
                        model.addColumn("Category");
                        model.addColumn("Description");
                        model.addColumn("CreatedAt");
                        model.addColumn("InvoiceUrl");
                        model.addColumn("UpdatedAt");

                            for(Expenses expensee: expenses){
                                Object[] rowData = {
                                        expensee.getId(),
                                        expensee.getAmount(),
                                        expensee.getCategory(),
                                        expensee.getDescription(),
                                        expensee.getCreatedAt(),
                                        expensee.getInvoiceUrl(),
                                        expensee.getUpdatedAt()
                                };
                                model.addRow(rowData);
                            }
                            expensesTable.setModel(model);

                }catch(SQLException sql){
                    JOptionPane.showMessageDialog(null, sql.toString());
                }
        }

        private void agregarExpense() throws SQLException{
            JTextField id = new JTextField();
            JTextField amount = new JTextField();
            JTextField category = new JTextField();
            JTextField description = new JTextField();
            JTextField invoiceUrl = new JTextField();


            Object[] fields = {
                    "Id:", id,
                    "Amount", amount,
                    "Ctegory", category,
                    "Description", description,

                    "InvoiceUrl", invoiceUrl,

            };

            int result =  JOptionPane.showConfirmDialog(null, fields, "Agregar Expense", JOptionPane.OK_CANCEL_OPTION);

                if(result == JOptionPane.OK_OPTION){
                    LocalDate localDate = LocalDate.now();
                            LocalDateTime localdatetime = localDate.atStartOfDay();
                    Timestamp time = Timestamp.valueOf(localdatetime);
                    Expenses expense =new Expenses();
                    expense.setId(Integer.parseInt(id.getText()));
                    expense.setAmount(Integer.parseInt(amount.getText()));
                    expense.setCategory(category.getText());
                    expense.setDescription(description.getText());
                    expense.setCreatedAt(time);
                    expense.setInvoiceUrl(invoiceUrl.getText());
                    expense.setUpdatedAt(time);


                    expensesRepository.save(expense);
                }
            refreshExpensesTable();


        }



        private void updateExpense(){
            String expenseId = JOptionPane.showInputDialog(this, "Ingrese Expense Id: ", "Update Expense");
            String expenseField = JOptionPane.showInputDialog(this, "Que campo va actualziar (escriba el nombre de campo, tal cual:: \n"
                    +"Id\n"
                    +"Amount\n"
                    +"Category\n"
                    +"Description\n"
                    +"CreatedAt\n"
                    +"InvoiceUrl\n"
                    +"UpdatedAt\n", "Update Expense");
            String expenseNewData = JOptionPane.showInputDialog(this, "Ingrese Nuevo dato:: ", "Update Expense");

            if(expenseId!=null){
                expensesRepository.update(Integer.parseInt(expenseId), expenseField, expenseNewData);
                JOptionPane.showMessageDialog(null, "Se ha actulizado");
                refreshExpensesTable();
            }else{
                JOptionPane.showMessageDialog(null, "Id no encontrado");
            }
        }

}
