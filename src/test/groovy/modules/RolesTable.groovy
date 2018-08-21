package modules

import geb.Module

class RolesTable extends Module{

    static content = {
        cell             {$('td')}
        removeButton    { cell[0].$('a', 0)}
        roleName        { cell[1].text()}
        locationName    { cell[2].text()}
    }
}
