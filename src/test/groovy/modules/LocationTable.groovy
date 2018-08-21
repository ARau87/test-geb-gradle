package modules

import geb.Module

class LocationTable extends Module{

    static content = {
        cell                { $('td')}
        editLink            { cell[0].$('img', title: 'Bearbeiten')}
        locationName        { cell[1].text()}
        locationAddress     { cell[2].text()}
        locationTerminal    { cell[3].text()}
    }
}
