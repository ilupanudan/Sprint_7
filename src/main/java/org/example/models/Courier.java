package org.example.models;

import org.example.utils.Randomizer;



public class Courier {


    private String login;
    private String firstName;
    private String password;



    public Courier(String login, String firstName, String password){
        this.login = login;
        this.firstName = firstName;
        this.password = password;
    }

    public Courier(){}

    public static Courier randomCourier() {
        return new Courier(
                Randomizer.randomString(),
                Randomizer.randomString(),
                Randomizer.randomString());
    }

    public static Courier withoutLogin() {
        return new Courier(null,
                randomCourier().getPassword(),
                randomCourier().getFirstName());
    }

    public static Courier withoutFirstName() {
        return new Courier(randomCourier().getLogin(),
                null,
                randomCourier().getPassword());
    }

    public static Courier withoutPassword() {
        return new Courier(randomCourier().getLogin(),
                randomCourier().getPassword(),
                null);
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getPassword() {
        return password;}

    public void setPassword(String password) {

        this.password = password;
    }



}
