package pages.tenantBlock

import geb.Page
import geb.waiting.WaitTimeoutException
import models.Tenant
import modules.TenantTable
import org.openqa.selenium.NotFoundException
import testVariables.TestVariables

class TenantListPage extends Page{

    static url = TestVariables.URL + 'tenants/list'

    static at = {
        headline.isDisplayed()
    }

    static content = {

        headline                        { $('h2.listTitle')}

        tenantTable                     { $('table', id:'tenantListTableId')}
        tableBody                       { tenantTable.$('tbody') }
        tableRows                       { tableBody.$('tr').moduleList(TenantTable)}

    }

    def findTenantByName(Tenant tenant){

        try {
            def row = waitFor(2) {tableRows.findResult {it.tenantName == tenant.name ? it : null }}

            return row
        }
        catch(WaitTimeoutException e){

            return null

        }

    }

    def pressEditButtonOf(Tenant tenant) throws NotFoundException{

        def tenantRow = this.findTenantByName(tenant)

        tenantRow != null ? tenantRow.editLink.click() : {throw NotFoundException('Tenant not found!')}

    }
}
