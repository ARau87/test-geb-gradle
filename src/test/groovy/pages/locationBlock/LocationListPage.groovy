package pages.locationBlock

import geb.Page
import geb.waiting.WaitTimeoutException
import models.Location
import modules.LocationTable
import org.openqa.selenium.NotFoundException
import testVariables.TestVariables

class LocationListPage extends Page {

    static url = TestVariables.URL + 'locations/list'

    static at = {
        headline.isDisplayed()
    }

    static content = {

        headline                                { $('h2', class: 'listTitle') }

        locationTable                           { $('table', id: 'locations') }
        tableBody                               { locationTable.$('tbody') }
        tableRows                               { tableBody.$('tr').moduleList(LocationTable)}

    }

    def getLocationRow(Location location){

        try {
            def row = waitFor(2) {tableRows.findResult {it.locationName == location.name ? it : null }}

            return row
        }
        catch(WaitTimeoutException e){

            return null

        }
    }


    boolean findLocationByName(Location location){
        def row = this.getLocationRow(location)
        return row != null
    }

    void pressEditButton(Location location) throws NotFoundException{

        def row = this.getLocationRow(location)

        if(row != null){
            row.editLink.click()
        }
        else {
            throw NotFoundException('EditButton not found!')
        }

    }


}
