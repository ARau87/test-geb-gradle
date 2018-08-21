package modules

import geb.Module

class UserListTable extends Module{

    static content = {
        cell            { $('td')}
        editButton      { cell[0].$('img', 0)}
        lastName        { cell[1].text()}
        firstName       { cell[2].text()}
        eMail           { cell[3].text()}
        phoneNumber     { cell[4].text()}
    }
}
