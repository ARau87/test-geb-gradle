package modules

import geb.Module

class TenantTable extends Module{

    static content = {
        cell                { $('td')}
        editLink            { cell[0].$('img', title: 'Bearbeiten')}
        tenantName          { cell[1].text()}
    }

}
