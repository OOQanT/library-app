package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import jakarta.persistence.*;

@Entity(name = "user_loan_history")
public class UserLoanHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne // 대출기록은 여려개 일 수 있고 대출자는 여러명 일 수 있다.
    private User user;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "is_return")
    private boolean isReturn;

    public UserLoanHistory() {
    }

    public UserLoanHistory(User user, String bookName){
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void doReturn(){
        this.isReturn = true;
    }
}
