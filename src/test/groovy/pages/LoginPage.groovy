package pages

import geb.Page
import models.User
import testVariables.TestVariables

class LoginPage extends Page{

    public static final String LANGUAGE_DE = 'DE'
    public static final String LANGUAGE_FR = 'FR'
    public static final String LANGUAGE_EN = 'EN'

    static url = TestVariables.URL + "login"

    static at = {
        loginButton.isDisplayed()
    }

    static content = {
        emailField              { $('input', name: 'username')}
        passwordField           { $('input', name: 'password')}
        loginButton             { $('button', type: 'submit')}
        forgotPasswordLink      { $('a', href: '/rac/forgotpassword')}

        deLanguageButton        { $('a', href: '/rac/login?lang=de_DE')}
        enLangualeButton        { $('a', href: '/rac/login?lang=en_GB')}
        frLanguageButton        { $('a', href: '/rac/login?lang=fr_FR')}
        itLanguageButton        { $('a', href: '/rac/login?lang=it_IT')}

        errorMessage            { $('span', class: 'errorMessageContainer')}
    }

    void logInAsAdministrator() {
        User admin = new User()
        changeLanguage(LoginPage.LANGUAGE_DE)
        emailField = admin.email
        passwordField = admin.password
        loginButton.click()
    }

    void changeLanguage(String language) {
        switch (language){
            //TODO: Add more languages here!!!
            case LoginPage.LANGUAGE_DE:
                deLanguageButton.click()
                break
            default:
                deLanguageButton.click()
        }
    }

    void logInAsUser(String email, String password) {
        emailField = email
        passwordField = password
        loginButton.click()
    }

    void logInAsUser(User user){
        emailField = user.email
        passwordField = user.password
        loginButton.click()
    }

    void errorMessageIsDisplayed() {
        errorMessage.isDisplayed()
    }

    void forgotPasswordLinkClick() {
        forgotPasswordLink.click()
    }
}

