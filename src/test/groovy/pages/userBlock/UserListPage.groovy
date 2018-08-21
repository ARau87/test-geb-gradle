package pages.userBlock

import geb.Page
import modules.UserListTable
import testVariables.TestVariables

class UserListPage extends Page{

    static url = TestVariables.URL + "users/list"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Anwender"
    }

    static content = {
        pageBanner          { $('h2', class: 'listTitle')}
        newUserButton       { $('button', type: 'submit')}
        emailFilterField    { $('input#yadcf-filter--userListTableId-3')}
        userTable           {$('table#userListTableId')}
        userTableRow        { userTable.$('tbody').$('tr').moduleList(UserListTable)}

        previousButton      { $('a#userListTableId_previous')}
        nextButton          { $('a#userListTableId_next')}
    }

    void newUserButtonClick() {
        newUserButton.click()
    }

    void emailFilterFieldInput(String email) {
        emailFilterField = email
    }

    void editButtonClick(String email) {
        waitFor {userTableRow.findResult {it.eMail == email ? it : null}}
        def row = userTableRow.findResult {it.eMail == email ? it : null}
        row.editButton.click()
    }
}