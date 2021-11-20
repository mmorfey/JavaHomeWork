package com.pb.taran.hw8;

public class Auth {
    private String login;
    private String password;

    public Auth() {
    }

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!checkLogin(login)) {
            throw new WrongLoginException("логин не соответствует требованиям.");
        }
        if (!checkPassword(password)) {
            throw new WrongPasswordException("пароль не соответствует требованиям.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }
        this.login = login;
        this.password = password;
        System.out.println("Пользователь зарегистрирован");
    }

    public void signIn(String login, String password) throws WrongLoginException, WrongPasswordException {
        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Авторизация успешна. Здравствуй " + login);
        }
        if (!this.login.equals(login)){
            throw new WrongLoginException("неверный логин.");
        }
        if (!this.password.equals(password)){
            throw new WrongPasswordException("неверный пароль.");
        }
    }

    private static boolean checkLogin(String login) {
        final String loginRegex = "[a-zA-Z0-9]{5,15}";
        return login.matches(loginRegex);
    }

    private static boolean checkPassword(String password) {
        final String passwordRegex = "[a-zA-Z0-9_&$]{8,}";
        return password.matches(passwordRegex);
    }
}