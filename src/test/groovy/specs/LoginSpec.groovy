package specs

import geb.spock.GebSpec
import models.User
import pages.LoginPage
import pages.MainPage
import spock.lang.Unroll

class LoginSpec extends GebSpec{


    static User admin = new User()

    def "p_Succesful_Login"() {
        given:
            to LoginPage

        when: "I log in as administrator"
            at LoginPage
                logInAsAdministrator()

        then: "I'm on Main page"
            at MainPage

        and: "I'll log out"
            logOut()
    }

    @Unroll
    def "n_Login_With_#testName"() {

        given:
            to LoginPage

        when: "I log in with empty user name"
            at LoginPage
                logInAsUser(userEmail, password)

        then: "Error message is displayed"
            checkErrorMessageIsDisplayed()


        where:
        testName                | userEmail                           | password
        "Wrong_Password"        | admin.email                         | "wrong_password"
        "User_Not_Exists"       | "user_not_exists@creamteam.de"      | "not_exist"
        "Wrong_Email"           | "werkstatt-superadmin@creamteam.ru" | admin.password
        "Empty_Email_Field"     | ""                                  | admin.password
        "Empty_Password_Field"  | admin.email                         | ""
        "Both_Fields_Are_Empty" | ""                                  | ""
    }


    private void checkErrorMessageIsDisplayed() {
        at LoginPage
            errorMessageIsDisplayed()
    }

    void logOut() {
        logoutLinkClick()
        at LoginPage
    }
}
