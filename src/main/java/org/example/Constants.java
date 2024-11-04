package org.example;

public class Constants {
    public static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";
    //Ручки
    public static final String CREATE_COURIER_PATH = "/api/v1/courier";
    public static final String COURIER_LOGIN_PATH = "/api/v1/courier/login";
    public static final String ORDERS_PATH =  "/api/v1/orders";
    public static final String CANCEL_ORDER_PATH = "/api/v1/orders/cancel";

    //Messages
    public static final String LOGIN_ALREADY_USED = "Этот логин уже используется";
    public static final String NOT_ENOUGH_DATA_FOR_CREATE = "Недостаточно данных для создания учетной записи";
    public static final String NOT_ENOUGH_DATA_FOR_LOGIN = "Недостаточно данных для входа";
    public static final String ACCOUNT_NOT_FOUND = "Учетная запись не найдена";
    public static final String CREATE_SUCCES_ANSWER = "{\"ok\":true}";

    //Коды
    public static final int SUCCES_CREATED = 201;
    public static final int BAD_REQUEST = 400;
    public static final int OK = 200;
    public static final int NOT_FOUND = 404;
    public static final int CONFLICT = 409;


}
