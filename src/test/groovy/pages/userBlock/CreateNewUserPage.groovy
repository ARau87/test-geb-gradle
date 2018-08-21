package pages.userBlock

import geb.Page
import geb.module.Checkbox
import geb.module.Select
import testVariables.TestVariables

class CreateNewUserPage extends Page{

    static url = TestVariables.URL + "users/new"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Anwender anlegen"
    }

    static content = {
        pageBanner              { $('form').find('h2').first()}

        lastNameField           { $('input', name: 'lastName')}
        firstNameField          { $('input', name: 'firstName')}
        emailField              { $('input', name: 'email')}
        phoneField              { $('input', name: 'phone')}
        tenantSelect            { $('select', name: 'tenant').module(Select)}

        newPasswordField        { $('input', name: 'passwordNew')}
        repeatPasswordField     { $('input', name: 'passwordRepeat')}
        newPinField             { $('input', name: 'pinNew')}
        repeatPinField          { $('input', name: 'pinRepeat')}

        activeCheckbox          { $('input', id: 'active1').module(Checkbox)}
        mifareTokenIdField      { $('input', name: 'idNumber')}

        backButton              { $('button', class: 'backButton')}
        saveButton              { $('button', type: 'submit').first()}
        successMessage          { $('span', class: 'confirmMessageContainer')}
    }

    void lastNameFieldInput(String lastname) {
        lastNameField = lastname
    }

    void firstNameFieldInput(String firstname) {
        firstNameField = firstname
    }

    void emailFieldInput(String email) {
        emailField = email
    }

    void phoneFieldInput(String phone) {
        phoneField = phone
    }

    void selectTenant(String tenant) {
        tenantSelect.selected = tenant
    }

    void newPasswordFieldInput(String password1) {
        newPasswordField = password1
    }

    void repeatPasswordFieldInput(String password2) {
        repeatPasswordField = password2
    }

    void newPinFieldInput(String pin1) {
        newPinField = pin1
    }

    void repeatPinFieldInput(String pin2) {
        repeatPinField = pin2
    }

    void activatedCheckbox() {
        if (activeCheckbox.unchecked) {
            activeCheckbox.check()
        }
        assert activeCheckbox.checked
    }

    void mifareTokenIdFieldInput(String tokenid) {
        mifareTokenIdField = tokenid
    }

    void backButtonClick() {
        backButton.click()
    }

    void saveButtonClick() {
        saveButton.click()
    }

    void checkSuccessMessage(String message) {
        successMessage.isDisplayed()
        assert successMessage.text().contains(message)
    }
}
