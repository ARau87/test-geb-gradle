package modules

import geb.Module

class VehicleGroupListTable extends Module{

    static content = {
        cell                { $('td')}
        editButton          { cell[0].$('img', 0)}
        vehicleGroupName    { cell[1].text()}
        pricePerDay         { cell[2].text()}
        freeKmProDay        { cell[3].text()}
        costProKm           { cell[4].text()}
    }
}
