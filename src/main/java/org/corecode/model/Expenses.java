package org.corecode.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Expenses {


    public Expenses(Integer id, int amount, String category, String description, Timestamp createdAt, Timestamp updatedAt, String invoiceUrl) {
        this.Id = id;
        this.Amount = amount;
        this.Category = category;
        this.Description = description;
        this.CreatedAt = createdAt;
        this.UpdatedAt = updatedAt;
        this.InvoiceUrl = invoiceUrl;
    }

    //default constructor
    public Expenses(){}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Timestamp getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        CreatedAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        UpdatedAt = updatedAt;
    }

    public String getInvoiceUrl() {
        return InvoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        InvoiceUrl = invoiceUrl;
    }

    private Integer Id;
    private int Amount;

    private String Category;

    private String Description;

    private Timestamp CreatedAt;

    private Timestamp UpdatedAt;
    private String InvoiceUrl;


    @Override
    public String toString() {
        return "Expenses{" +
                "Id=" + Id +
                ", Amount='" + Amount + '\'' +
                ", Category='" + Category + '\'' +
                ", Description='" + Description + '\'' +
                ", CreatedAt=" + CreatedAt +
                ", UpdatedAt=" + UpdatedAt +
                ", InvoiceUrl='" + InvoiceUrl + '\'' +
                '}';
    }
}
