package pages.userBlock

import geb.Page
import geb.module.Checkbox
import geb.module.FormElement
import geb.module.Select
import modules.UserRoleTable
import testVariables.TestVariables
import testVariables.TestVariablesUser

class EditUserPage extends Page{

    static url = TestVariables.URL + "users/user/edit/id"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Anwender bearbeiten"
    }

    static content = {
        pageBanner              { $('form').find('h2').first()}

        lastNameField           { $('input', name: 'lastName')}
        firstNameField          { $('input', name: 'firstName')}
        emailField              { $('input', name: 'email')}
        phoneField              { $('input', name: 'phone')}
        tenantSelect            { $('input', name: 'tenant.name')}

        newPasswordField        { $('input', name: 'passwordNew')}
        repeatPasswordField     { $('input', name: 'passwordRepeat')}
        newPinField             { $('input', name: 'pinNew')}
        repeatPinField          { $('input', name: 'pinRepeat')}

        activeCheckbox          { $('input', name: 'active').module(Checkbox)}
        mifareTokenIdField      { $('input', name: 'idNumber')}

        roleSelect              { $('select', name: 'newRoleId').module(Select)}
        locationSelect          { $('select', name: 'newLocationId').module(Select)}
        addRoleButton           { $('button', value: 'addRole')}
        roleTable               { $('table#roles')}
        roleTableRow            { roleTable.$('tbody').$('tr').moduleList(UserRoleTable)}

        backButton              { $('button', class: 'backButton')}
        saveButton              { $('button', 1, type: 'submit')}
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

    void checkTenant(String tenant) {
        assert tenantSelect.module(FormElement).readOnly
        assert tenantSelect.value() == tenant
    }

    void newPasswordFieldInput(String password) {
        newPasswordField = password
    }

    void repeatPasswordFieldInput(String password) {
        repeatPasswordField = password
    }

    void newPinFieldInput(String pin) {
        newPinField = pin
    }

    void repeatPinFieldInput(String pin) {
        repeatPinField = pin
    }

    void activatedCheckbox() {
        if (activeCheckbox.unchecked) {
            activeCheckbox.check()
        }
    }

    void mifareTokenIdFieldInput(String tokenid) {
        mifareTokenIdField = tokenid
    }

    void selectRole(String role) {
        roleSelect.selected = role
    }

    void selectLocation(String location) {
        locationSelect.selected = location
    }

    void addRoleButtonClick() {
        addRoleButton.click()
    }

    void deleteButtonClick(String role) {
        def row = roleTableRow.findResult {it.roleName == role ? it : null}
        row.deleteButton.click()
    }

    void checkRolesList(int num) {
        def found = true
        for (def i = 0; i < num; i++) {
            if (roleTableRow.findResult {it.roleName == TestVariablesUser.USER_ROLE[i] ? it : null} == null){
                found = false
                break
            }
        }
        assert found == true
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
