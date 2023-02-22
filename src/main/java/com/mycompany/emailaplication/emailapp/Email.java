package com.mycompany.emailaplication.emailapp;

import java.util.Scanner;

public class Email {
    private String nome;
    private String sobrenome;
    private String senha;
    private String departamento;
    private String email;
    private int mailBoxCapacity = 500;
    private int tamanhoSenhaPadrao = 10;
    private String emailAlternativo;
    private String dominioEmpresa = "empresa.com";

    // construtor para receber o nome e o sobrenome
    public Email(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        System.out.println("Email criado com sucesso: " + this.nome + this.sobrenome);
        this.departamento = setDepartamento();
        this.senha = senhaAleatoria(tamanhoSenhaPadrao);
        this.email = nome.toLowerCase() + "." + sobrenome.toLowerCase() + "@" + departamento + "." + this.dominioEmpresa;
        System.out.println("Seu email é: " + this.email);
        System.out.println("Sua senha é: " + this.senha);

    }

    private String setDepartamento() {
        System.out.println("Códigos dos departamentos.\n1-Vendas\n2-Desenvolvimento\n3-Contabilidade\n0-Nenhum\nEntre com o departamento: ");
        try (Scanner in = new Scanner(System.in)) {
            int departamento = in.nextInt();
            if(departamento == 1){
                return "vendas";
            }else if (departamento == 2) {
                return "desenvolvimento";
            }else if (departamento == 3) {
                return "desenvolvimento";
            }else{
                return "";
            }
        }

        
    }
    
    private String senhaAleatoria(int tamanho) {
        String caracteresSenha = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789!@#$%";
        char[] senha = new char[tamanho]; 
        for (int i = 0; i < tamanho; i++) {
            int random = (int) (Math.random() * caracteresSenha.length());
            senha[i] = caracteresSenha.charAt(random); 
        }
        return new String(senha);
        

    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public void mudarSenha(String senha) {
        this.senha = senha;
    }

    public int getMailBoxCapaity() {return mailBoxCapacity;}
    public String getEmailAlternativo() {return emailAlternativo;}
    public String getSenha() {return senha;}

    public String mostrarInformacoes() {
        return "Nome: " + nome + " " + sobrenome +
                "\nEmail da empresa: " + " " + email +
                "\nCapacidade da Caixa de entrada: " + mailBoxCapacity + "mb";
    }
}
