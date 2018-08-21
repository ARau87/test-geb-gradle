package pages.vehicleGroupBlock

import geb.Page
import modules.VehicleGroupListTable
import testVariables.TestVariables

class VehicleGroupListPage extends Page{

    static url = TestVariables.URL + "vehiclegroups/list"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeuggruppenverwaltung"
    }

    static content = {
        pageBanner              { $('h2', class: 'listTitle')}
        newVehicleGroupButton   { $('button', type: 'submit')}
        nameFilterField         { $('input#yadcf-filter--vehicleGroups-1')}
        vehicleGroupTable       { $('table#vehicleGroups')}
        vehicleGroupTableRow    { vehicleGroupTable.$('tbody').$('tr').moduleList(VehicleGroupListTable)}

        previousButton          { $('a#vehicleGroups_previous')}
        nextButton              { $('a#vehicleGroups_next')}
    }

    void newVehicleGroupButtonClick() {
        newVehicleGroupButton.click()
    }

    void nameFilterFieldInput(String name) {
        waitFor {vehicleGroupTable.isDisplayed()}
        nameFilterField = name
    }

    void editButtonClick(String name) {
        waitFor {vehicleGroupTableRow.findResult {it.vehicleGroupName == name ? it : null}}
        def row = vehicleGroupTableRow.findResult {it.vehicleGroupName == name ? it : null}
        row.editButton.click()
    }
}
