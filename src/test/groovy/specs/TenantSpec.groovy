package specs

import geb.spock.GebSpec
import models.Tenant
import org.openqa.selenium.NotFoundException
import pages.LoginPage
import pages.tenantBlock.CreateTenantPage
import pages.tenantBlock.EditTenantPage
import pages.tenantBlock.TenantListPage

class TenantSpec extends GebSpec{

    def "p_find_tenant_by_name"(){

        Tenant tenant = new Tenant('München')

        given: "I login as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the tenant administration page"
        to TenantListPage

        then: "I can find the tenant in the list of tenants"
        at TenantListPage
        findTenantByName(tenant)

    }

    def "n_cannot_find_tenant_that_does_not_exist"(){

        Tenant tenant = new Tenant('FooBar')

        given: "I login as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the tenant administration page"
        to TenantListPage

        then: "I cannot find the tenant in the list of tenants as it does not exist"
        at TenantListPage
        assert findTenantByName(tenant) == null

    }

    def "n_cannot_click_edit_button_of_tenant_that_does_not_exist"(){

        Tenant tenant = new Tenant('FooBar')

        given: "I login as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the tenant administration page"
        to TenantListPage

        then: "I cannot press the tenant's edit button as it does not exist"
        at TenantListPage
        try {
            pressEditButtonOf(tenant)
        }
        catch(NotFoundException err) {
            assert true
        }
    }

    def "p_edit_existing_tenant"(){

        Tenant tenant = new Tenant('München')
        Tenant editedTenant = new Tenant(tenant.name)
        editedTenant.minimumAge = tenant.minimumAge + 1
        editedTenant.currency = 'Pound'

        given: "I login as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the tenant administration page and press the edit button of a tenant"
        to TenantListPage
        at TenantListPage
        pressEditButtonOf(tenant)

        then: "I can edit the tenant's values"
        at EditTenantPage
        fillTenantForm(editedTenant)

        and: "Change it back to the original values"
        to TenantListPage
        at TenantListPage
        pressEditButtonOf(editedTenant)
        at EditTenantPage
        fillTenantForm(tenant)

    }

    def "p_create_new_tenant"(){

        Tenant tenant = Tenant.createTenantWithRandomName('Geb-Tenant')

        given: "I login as administrator"
        to LoginPage
        at LoginPage
        logInAsAdministrator()

        when: "I go to the 'New Tenant Page'"
        to CreateTenantPage

        then: "I can create a new tenant and afterwards find it in the tenants list"
        at CreateTenantPage
        fillTenantForm(tenant)
        to TenantListPage
        at TenantListPage
        findTenantByName(tenant)


    }
}
