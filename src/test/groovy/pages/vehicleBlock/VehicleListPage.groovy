package pages.vehicleBlock

import geb.Page
import modules.VehicleListTable
import testVariables.TestVariables

class VehicleListPage extends Page{

    static url = TestVariables.URL + "vehicles/list"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeugverwaltung"
    }

    static content = {
        pageBanner              { $('h2', class: 'listTitle')}

        vehicleImportButton     { $('button', 1, type: 'submit')}
        newVehicleButton        { $('button', 0, type: 'submit')}
        licenseNrFilterField    { $('input#yadcf-filter--vehiclesListTable-1')}
        vehicleTable            { $('table#vehiclesListTable')}
        vehicleTableRow         { vehicleTable.$('tbody').$('tr').moduleList(VehicleListTable)}

        previousButton          { $('a#vehiclesListTable_previous')}
        nextButton              { $('a#vehiclesListTable_next')}
    }

    void vehicleImportButtonClick() {
        vehicleImportButton.click()
    }

    void newVehicleButtonClick() {
        newVehicleButton.click()
    }

    void licenseNrFilterFieldInput(String nr) {
        waitFor {vehicleTable.isDisplayed()}
        licenseNrFilterField = nr
    }

    void editButtonClick(String nr) {
        waitFor {vehicleTableRow.findResult {it.licenseNr == nr ? it : null}}
        def row = vehicleTableRow.findResult {it.licenseNr == nr ? it : null}
        row.editButton.click()
    }
}
