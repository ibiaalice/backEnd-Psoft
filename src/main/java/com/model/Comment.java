package com.model;
import javax.persistence.*;
import java.util.Date;

/**
 * Classe Entidade Comment
 */
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor do id
    private long id;
    @Column(name="reference")
    private long reference;
    @Column(name="text")
    private String text;
    @Column(name= "email")
    private String email;
    private Date data;
    @Column(name= "Deleted")
    private Boolean deleted;

    /**
     * Método construtor vazio
     */
    public  Comment (){
        this.deleted = false;
        this.data = new Date();
        this.text = "";
        this.reference = 0;
    }

    /**
     * Método construtor da classe com atributos com atributos
     * @param reference referencia do objeto que possui Comment
     * @param text texto que o Comment possui
     * @param email email, dono do Comment
     */
    public Comment(long reference, String text, String email){
        this.reference = reference;
        this.text = text;
        this.email = email;
        this.data = new Date();
        this.deleted = false;
    }

    //getters and setters

    /**
     * Método get do atributo deleted
     * @return um Boolean com o valor de deleted
     */
    public boolean getDeleted(){
        return  this.deleted;
    }

    /**
     * Método get do atributo Text
     * @return uma String com o valor do texto
     */
    public String getText() {
        return text;
    }

    /**
     * Método get do atributo email
     * @return um boolean com o valor de email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método get do atributo Id
     * @return retorna um long com o valor de id
     */
    public long getId() {
        return id;
    }

    /**
     * Método get do atributo reference
     * @return retorna um long de reference
     */
    public long getReference() {
        return reference;
    }

    /**
     * Método get do atributo Data
     * @return retorna um objeto data
     */
    public Date getData(){
        return  this.data;
    }

    /**
     * Método de edição do atributo email
     * @param email recebe um string email novo
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método de edição do atributo reference
     * @param reference recebe um long novo
     */
    public void setReference(long reference) {
        this.reference = reference;
    }

    /**
     * Método de edição do atributo text
     * @param text recebe um String text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Método de edição do atributo deleted
     * @param deleted recebe um boolean para deleted
     */
    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }

    //métodos habituais

    @Override
    public String toString() {
        return this.reference + "- " + this.text + " - " + this.email;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
