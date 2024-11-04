package org.example.models;

import org.example.utils.Randomizer;

public class CourierCreds {
    private String login;
    private String password;

    public CourierCreds() {
    }

    public CourierCreds(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public static CourierCreds from(Courier courier) {
        return new CourierCreds(courier.getLogin(), courier.getPassword());
    }

    public static CourierCreds randomCourier(){
        return new CourierCreds(Randomizer.randomString(), Randomizer.randomString());

    }

    public static CourierCreds withoutLogin(Courier courier){
        return new CourierCreds(null, courier.getPassword());
    }

    public static CourierCreds withoutPassword(Courier courier){
        return new CourierCreds(courier.getLogin(),null);
    }

    public static CourierCreds randomLoginCorrectPassword(Courier courier){
        return new CourierCreds(randomCourier().getLogin(), courier.getPassword());
    }

    public static CourierCreds randomPasswordCorrectLogin(Courier courier){
        return new CourierCreds(courier.getLogin(), randomCourier().getPassword());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
