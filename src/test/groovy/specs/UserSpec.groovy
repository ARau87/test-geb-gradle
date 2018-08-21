package specs

import geb.spock.GebSpec
import org.junit.Before
import pages.LoginPage
import pages.MainPage
import pages.userBlock.CreateNewUserPage
import pages.userBlock.EditUserPage
import pages.userBlock.UserListPage
import testVariables.TestVariables
import testVariables.TestVariablesUser

class UserSpec extends GebSpec {

    @Before
    def "ASS RAC Admin login"() {
        to LoginPage
        logInAsAdministrator()
    }

    def "p_Create_New_User"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to User List page"
        usersLinkClick()
        at UserListPage

        then: "I go to Create New User page"
        clickNewUserButton()
        at CreateNewUserPage

        and: "I create a new user"
        fillUserData()
        fillPasswordAndPin()
        fillAdminView()
        saveUser()

        and: "I'm on Edit User page"
        at EditUserPage
    }

    def "p_Edit_User"() {
        given: "I'm on Main page"
        at MainPage

        when: "I go to User List page"
        usersLinkClick()
        at UserListPage

        then: "I go to Edit User page"
        goToEditUserPage()
        at EditUserPage

        and: "I edit an user"
        editUserData()
        saveUser()
        editPasswordAndPin()

        when: "I add roles to user"
        addRoles(2)
        clickDeleteButton()

        then: "I go to User List page"
        clickBackButton()
        at UserListPage
    }

    private void clickNewUserButton() {
        newUserButtonClick()
    }

    private void fillUserData() {
        lastNameFieldInput(TestVariablesUser.USER_LASTNAME)
        firstNameFieldInput(TestVariablesUser.USER_FIRSTNAME)
        emailFieldInput(TestVariablesUser.USER_EMAIL)
        phoneFieldInput(TestVariablesUser.USER_PHONE_NR)
        selectTenant(TestVariablesUser.TENANT)
    }

    private void fillPasswordAndPin() {
        fillPassword(TestVariablesUser.PASSWORD, TestVariablesUser.PASSWORD)
        fillPin(TestVariablesUser.PIN, TestVariablesUser.PIN)
    }

    private void fillPassword(String password1, String password2) {
        newPasswordFieldInput(password1)
        repeatPasswordFieldInput(password2)
    }

    private void fillPin(String pin1, String pin2) {
        newPinFieldInput(pin1)
        repeatPinFieldInput(pin2)
    }

    private void fillAdminView() {
        activatedCheckbox()
        mifareTokenIdFieldInput(TestVariablesUser.TOKEN_ID)
    }

    private void saveUser() {
        saveButtonClick()
        checkSuccessMessage(TestVariables.SUCCESS_MESSAGE)
    }

    private void goToEditUserPage() {
        emailFilterFieldInput(TestVariablesUser.USER_EMAIL)
        editButtonClick(TestVariablesUser.USER_EMAIL)
    }

    private void editUserData() {
        lastNameFieldInput(TestVariablesUser.USER_LASTNAME_EDIT)
        firstNameFieldInput(TestVariablesUser.USER_FIRSTNAME_EDIT)
        emailFieldInput(TestVariablesUser.USER_EMAIL_EDIT)
        phoneFieldInput(TestVariablesUser.USER_PHONE_NR_EDIT)
        checkTenant(TestVariablesUser.TENANT)
        mifareTokenIdFieldInput(TestVariablesUser.TOKEN_ID_EDIT)
    }

    private void editPasswordAndPin() {
        fillPassword(TestVariablesUser.PASSWORD_EDIT, TestVariablesUser.PASSWORD_EDIT)
        fillPin(TestVariablesUser.PIN_EDIT, TestVariablesUser.PIN_EDIT)
        saveButtonClick()
        checkSuccessMessage(TestVariables.PIN_SUCCESS_MESSAGE)
    }

    private void clickBackButton() {
        backButtonClick()
    }

    private void addRoles(int num) {
        for (def i = 0; i < num; i++){
            selectRole(TestVariablesUser.USER_ROLE[i])
            selectLocation(TestVariablesUser.LOCATION_NAME)
            addRoleButtonClick()
            checkSuccessMessage(TestVariables.ADD_ROLE_MESSAGE)
        }
        checkRolesList(num)
    }

    private void clickDeleteButton() {
        deleteButtonClick("Standort-Mitarbeiter")
        checkSuccessMessage(TestVariables.DELETE_ROLE_MESSAGE)
    }
}
