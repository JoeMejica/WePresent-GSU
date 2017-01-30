package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Controller {

    @FXML
    public TextField hostIP;

    @FXML
    public Button updateBtn;

    @FXML
    public PasswordField adminPassword;

    @FXML
    public Button viewDB;

    @FXML
    public Button closeBtn;

    public void runSeleniumScript(ActionEvent actionEvent) {

        String inputURL = hostIP.getText();
        String adminPW = adminPassword.getText();

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();


        driver.get("https://"+inputURL+"/cgi-bin/login.cgi?lang=en&src=AwLoginAdmin.html");


        //input login credentials and login
        driver.findElement(By.name("password")).sendKeys(adminPW);
        driver.findElement(By.name("Login")).click();

        //click firmware upgrade link
        driver.findElement(By.linkText("Firmware Upgrade")).click();


        //upload firmware update file
        driver.findElement(By.id("filename")).sendKeys("/wePresent.2000.2.1.1.7.nad");


        //click "Upgrade"
        driver.findElement(By.id("uploadfw")).click();





    }

    public void openDatabaseURL(ActionEvent actionEvent) {

        try {
            Desktop.getDesktop().browse(new URI("https://mygsu.sharepoint.com/sites/orphans/wj717/_layouts/15/WopiFrame2.aspx?sourcedoc=%7B10A11F4C-99E2-4E2A-9E83-81589092A7C7%7D&file=2016-09-19%20-%20Visix%20Database.xlsx&action=default"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

    }

    public void closeApplication(ActionEvent actionEvent) {

        Platform.exit();
    }
}
