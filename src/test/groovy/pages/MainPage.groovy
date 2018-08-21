package pages

import geb.Page
import pages.locationBlock.CreateLocationPage
import testVariables.TestVariables

class MainPage extends Page{

    static url = TestVariables.URL

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Herzlich Willkommen - Audi Service Station"
    }

    static content = {
        pageBanner          { $('h3')}

        logoutLink          { $('a', href: '/rac/logout')}
        locationsLink       { $('a',  id: 'configurationLink')}
        reservationsLink    { $('a', id: 'reservationsLink')}
        vehicleGroupsLink   { $('a#vehicleGroupsLink')}
        usersLink           { $('a#usersLink', 0)}
        vehiclesLink        { $('a#vehiclesLink', 0)}
        newLocationLink     { $('a', href: '/rac/locations/new')}

    }

    void reservationsLinkClick() {
        reservationsLink.click()
    }

    void vehicleGroupsLinkClick() {
        vehicleGroupsLink.click()
    }

    void usersLinkClick() {
        usersLink.click()
    }

    void vehiclesLinkClick() {
        vehiclesLink.click()
    }

    void myDataLinkClick() {
        myDataLink.click()
    }

    void locationsLinkClick() {
        locationsLink.click()
    }

    void newLocationLinkClick(){
        to CreateLocationPage
    }

    void reportsLinkClick() {
        reportsLink.click()
    }

    void logoutLinkClick() {
        logoutLink.click()
    }
}
