package pages.locationBlock

import geb.Page
import models.Location
import testVariables.TestVariables

class CreateLocationPage extends Page{

    static url = TestVariables.URL + 'locations/new'

    static at = {
        headline.isDisplayed()
    }

    static content = {

        locationForm                            { $('form', class: 'form_part') }
        headline                                { locationForm.$('h2') }
        wysiwygEditor                           { $('iframe', class:'cke_wysiwyg_frame cke_reset')}

        tenantSelect                            { locationForm.$('select#tenant')}
        addressInput                            { locationForm.$('input#address')}
        nameInput                               { locationForm.$('input#name')}
        phoneInput                              { locationForm.$('input#phone')}
        recipientInput                          { locationForm.$('input#recipientEmail')}
        senderInput                             { locationForm.$('input#senderEmail')}
        renterInput                             { locationForm.$('input#renterContact')}
        defaultLanguageSelect                   { locationForm.$('select', id: 'defaultLanguage.languageId')}
        countrySelect                           { locationForm.$('select', id: 'country.countryId')}

        submitButton                            { locationForm.$('button', type:'submit').not('button.backButton')}

        editorBody                              { wysiwygEditor.$('body')}


    }

    String getOptionValue(String name, def select){

        def options = select.$('option')

        for(def option : options){
            if(option.text() == name) return option.@value
        }

        return null

    }

    void selectOption(def select, String value){

        select.find('option').find{it.value() == value}.click()

    }

    void fillWYSIWYGEditor(String content){
        js.exec('',
                'var iframe = document.getElementsByTagName("iframe")[0];' +
                'var editor = iframe.contentWindow.document.getElementsByTagName("body")[0];' +
                'editor.innerHTML = "' + content + '";'
                )
    }

    void fillLocationForm(Location location){

        String tenantValue = getOptionValue(location.tenant, tenantSelect)

        tenantValue != null ? selectOption(tenantSelect, tenantValue) : selectOption(tenantSelect,'1')

        nameInput = location.name
        addressInput = location.address
        phoneInput = location.phoneNr
        recipientInput = location.emailMerchant
        senderInput = location.emailSender
        renterInput = location.info

        fillWYSIWYGEditor(location.contact)

        String defaultLanguageValue = getOptionValue(location.defaultLanguage, defaultLanguageSelect)
        defaultLanguageValue != null ?  selectOption(defaultLanguageSelect,defaultLanguageValue) : selectOption(defaultLanguageSelect,'-1')

        String countryValue = getOptionValue(location.country, countrySelect)
        countryValue != null ? selectOption(countrySelect, countryValue) : selectOption(countrySelect, '-1')

        submitButton.click()

    }


}
