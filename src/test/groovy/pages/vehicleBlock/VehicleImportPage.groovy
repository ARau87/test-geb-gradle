package pages.vehicleBlock

import geb.Page
import testVariables.TestVariables

class VehicleImportPage extends Page{

    static url = TestVariables.URL + "vehicles/import"

    static at = {
        pageBanner.isDisplayed()
        pageBanner.text() == "Fahrzeuge importieren"
    }

    static content = {
        pageBanner                  { $('section', class: 'ym-grid linearize-level-1').find('h2').first()}
        importFileField             { $('input#importFile_text')}
        fileUploadButton            { $('input', 1, class: 'fileupload_new fileupload_la')}
        vehicleListImportButton     { $('button', type: 'submit')}
    }

    void importFileFieldCheck() {
        importFileField.isDisplayed()
    }

    void fileUploadButtonCheck() {
        fileUploadButton.isDisplayed()
    }

    void vehicleListImportButtonCheck() {
        vehicleListImportButton.isDisplayed()
        assert vehicleListImportButton.text() == "Fahrzeugliste hochladen"
        println(vehicleListImportButton.text())
    }
}
