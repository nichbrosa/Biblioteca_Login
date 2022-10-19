package br.com.login.dao;


public class Main {
  public static void main(String[] args) throws Exception {
    Conexao dao = new Conexao();
    dao.readDataBase();
  }

}