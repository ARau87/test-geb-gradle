import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

System.setProperty('webdriver.chrome.driver', new File(".\\src\\test\\resources\\chromedriver.exe").getCanonicalPath())
driver = {new ChromeDriver()}

reportsDir = new File("target/geb-reports")
reportOnTestFailureOnly = true


environments {

    'ff' {
        System.setProperty('webdriver.gecko.driver', new File(".\\src\\test\\resources\\geckodriver.exe").getCanonicalPath())
        driver ={new FirefoxDriver()}
    }

}

waiting {
    timeout = 6
    retryInterval = 0.5
    slow { timeout = 12 }
    reallySlow { timeout = 24 }
}