package com.example.emt_lab2_173115.entity;

import com.example.emt_lab2_173115.entity.ennumeration.StatusCart;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="shopping_carts")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idshoppingcart")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="statusshoppingcart")
    private StatusCart status = StatusCart.CREATED;


    @Column(name="createdate")
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name="closedate")
    private LocalDateTime closeDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name="user_shoppingcart")
    private User user;

    @ManyToMany
    @JoinTable(name = "books_carts",
            joinColumns = @JoinColumn(name = "id_cart"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    private List<Book> books;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusCart getStatus() {
        return status;
    }

    public void setStatus(StatusCart status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<com.example.emt_lab2_173115.entity.Book> getBooks() {
        return books;
    }

    public void setBooks(List<com.example.emt_lab2_173115.entity.Book> books) {
        this.books = books;
    }
}
