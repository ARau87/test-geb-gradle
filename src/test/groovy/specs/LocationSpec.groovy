package specs

import geb.spock.GebSpec
import models.Location
import pages.LoginPage
import pages.MainPage
import pages.locationBlock.CreateLocationPage
import pages.locationBlock.EditLocationPage
import pages.locationBlock.LocationListPage

class LocationSpec extends GebSpec{

    def "p_find_Location_By_Name"() {

        Location location = new Location('München')

        given:
        to LoginPage

        when: "I log in as administrator and go to the location administration page"
        at LoginPage
        logInAsAdministrator()
        at MainPage
        locationsLinkClick()

        then: "I can find the location in the locations table"
        at LocationListPage
        findLocationByName(location)


    }

    def "p_create_new_random_location"(){

        Location location = Location.createLocationWithRandomName('Geb-Location')
        location.tenant = 'Köln'


        given:
        to LoginPage

        when: "I login as administrator and click the 'New Location' button on MainPage"
        at LoginPage
        logInAsAdministrator()
        to CreateLocationPage

        and: "I create a new location"
        at CreateLocationPage
        fillLocationForm(location)

        then: "I can find the location in the location administration page"
        to LocationListPage
        at LocationListPage
        findLocationByName(location)

    }

    def "p_edit_location"(){

        Location location = Location.createLocationWithRandomName('Geb-Location')
        Location editedLocation = Location.createLocationWithRandomName('Geb-Location')

        given:
        to LoginPage

        when: "I login as administrator and click the 'New Location' button on MainPage"
        at LoginPage
        logInAsAdministrator()
        to CreateLocationPage

        and: "I create a new location and edit it"
        at CreateLocationPage
        fillLocationForm(location)
        to LocationListPage
        at LocationListPage
        pressEditButton(location)
        at EditLocationPage
        editLocation(editedLocation)

        then: "I can find the edited location in the location administration page"
        to LocationListPage
        at LocationListPage
        findLocationByName(editedLocation)

    }

}
