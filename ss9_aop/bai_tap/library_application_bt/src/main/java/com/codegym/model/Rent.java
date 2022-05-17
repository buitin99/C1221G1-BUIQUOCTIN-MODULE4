package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long idRent;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Rent() {
    }

    public Rent(Long idRent, Book book) {
        this.idRent = idRent;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdRent() {
        return idRent;
    }

    public void setIdRent(Long idRent) {
        this.idRent = idRent;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
