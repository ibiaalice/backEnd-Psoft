package com.model;

/**
 * Classe de ajuda para receber o like da Discipline
 */
public class Like{
    private String email;
    private long idUser;

    /**
     * Classe construtora vazia
     */
    public Like() {
    	
    }

    /**
     * Classe construtora da classe Like
     * @param id id da Discipline que recebeu Like
     * @param email email de quem Like
     */
    public Like(long id, String email){
        this.email = email;
        this.idUser = id;
    }

    /**
     * Método get do Id da disciplina
     * @return retorna um long com o id
     */
    public long getIdUser(){
        return this.idUser;
    }

    /**
     * Método get do email do Like
     * @return retorna o email do dono do Like
     */
    public String getEmail(){
        return this.email;
    }
}
