package com.example.surfdemo.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exprssn")
public class Expression {

    @Id
    @Column(name = "expression_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String start;
    private String finish;


    @Temporal(TemporalType.DATE)
    private Date date;



    public Expression() {
        this.date = new Date();
    }

    public Expression(String start, String finish) {
        this.start = start;
        this.finish = finish;

        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }



    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
