package pages.tenantBlock

import geb.Page
import models.Tenant
import testVariables.TestVariables

class CreateTenantPage extends Page {

    static url = TestVariables.URL + 'tenants/new'

    static at = {
        headline.isDisplayed()
    }

    static content = {

        headline                        { $('form h2')}

        nameInput                       { $('input', id:'name')}
        currencySelect                  { $('select', id:'currency.currencyId')}

        submitButton                    { $('button', type:'submit').not('button.backButton')}

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

    boolean fillTenantForm(Tenant tenant){

        try {

            nameInput = tenant.name

            String currencyValue = getOptionValue(tenant.currency, currencySelect)
            currencyValue != null ? selectOption(currencySelect, currencyValue) : selectOption(currencySelect, '-1')

            submitButton.click()

            return true
        }

        catch (Exception e){
            return false
        }

    }

}
