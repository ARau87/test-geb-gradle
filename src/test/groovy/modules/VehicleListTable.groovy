package modules

import geb.Module
import geb.module.Checkbox

class VehicleListTable extends Module{

    static content = {
        cell                { $('td')}
        editButton          { cell[0].$('img', 0)}
        licenseNr           { cell[1].text()}
        vehicleCategory     { cell[2].text()}
        vin                 { cell[3].text()}
        fuelType            { cell[4].text()}
        automatic           { cell[5].module(Checkbox)}
        color               { cell[6].text()}
        gps                 { cell[7].module(Checkbox)}
        terminal            { cell[8].text()}
        active              { cell[9].module(Checkbox)}
        blocked             { cell[10].module(Checkbox)}
        vehicleGroup        { cell[11].text()}
    }
}
