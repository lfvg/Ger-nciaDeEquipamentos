/**
 * Created by Walber on 19/06/2016.
 */
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile

driver = {
    File file = new File("C:\\Users\\LFeli\\Documents\\ESS\\chromedriver.exe"); //configurar com o enderço correto do chromedriver.
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    new ChromeDriver();
}

environments {
    // run as “grails -Dgeb.env=chrome test-app”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
        driver = { File file = new File("C:\\Users\\LFeli\\Documents\\ESS\\chromedriver.exe"); //configurar com o enderço correto do chromedriver.
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            new ChromeDriver(); }
    }

}