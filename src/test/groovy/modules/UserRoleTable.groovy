package modules

import geb.Module

class UserRoleTable extends Module{

    static content = {
        cell            { $('td')}
        deleteButton    { cell[0].$('img', 0)}
        roleName        { cell[1].text()}
        locationName    { cell[2].text()}
    }
}
