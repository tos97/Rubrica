package Models;

import java.util.UUID;

public class User {

    private String nome;
    private String surname;
    private String age;
    private String uid;

    public User(String nome, String surname, String age) {
        this.nome = nome;
        this.surname = surname;
        this.age = age;
        this.uid = UUID.randomUUID().toString();
    }

    public User(String nome, String surname, String age,String id) {
        this.nome = nome;
        this.surname = surname;
        this.age = age;
        this.uid = id;
    }

    public String getId() {
        return uid;
    }

    public void setId(String id) {
        this.uid = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
