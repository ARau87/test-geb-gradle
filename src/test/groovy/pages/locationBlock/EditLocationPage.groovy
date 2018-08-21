package pages.locationBlock

import models.Location

class EditLocationPage extends CreateLocationPage {

    static at = {
        headline.isDisplayed()
    }

    void editLocation(Location editedLocation){

        super.fillLocationForm(editedLocation)

    }
}
