
import javazoom.jl.player.Player;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Application {
    //Is Current GNIB Holder
    static boolean IS_CURRENT_GNIB_HOLDER = false;
    //Personal Information
    static String GNIBNO_STRING = "a";
    static String YEAR_OF_BIRTH= "1971";
    static String MONTH_OF_BIRTH_IN_LETTER = "Dec";
    static String DAY_OF_BIRTH = "19";
    static String YEAR_OF_EXPIRE = "2019";
    static String MONTH_OF_EXPIRE_IN_LETTER = "Dec";
    static String DAY_OF_EXPIRE = "31";
    static String FIRST_NAME = "DO";
    static String LAST_NAME = "THANH LONG";
    static String EMAIL = "thelongdt@gmail.com";
    static String PASSPORT_NO= "awe";


    public static void main(String[] args) {


        try{
            InputStream in1 = new FileInputStream("Developed by Vietnamese.mp3");
            InputStream in2 = new FileInputStream("Begin.mp3");
            Player playMP3 = new Player(in1);
            playMP3.play();
            playMP3 = new Player(in2);
            playMP3.play();
        }
        catch (Exception e){

        }
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.getProperties();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://burghquayregistrationoffice.inis.gov.ie/Website/AMSREG/AMSRegWeb.nsf/AppSelect?OpenForm"); //launch Firefox and open Url

//        WebElement cat = driver.findElement()
        Select category = new Select(driver.findElement(By.cssSelector("#category")));
        category.selectByVisibleText("All");

        Select subCategory = new Select(driver.findElement(By.cssSelector("#subcategory")));
        subCategory.selectByVisibleText("All");

        Select ConfirmGNIB = new Select(driver.findElement(By.cssSelector("#ConfirmGNIB")));
        if(IS_CURRENT_GNIB_HOLDER){
            ConfirmGNIB.selectByVisibleText("Yes");
            WebElement GNIBNo = driver.findElement(By.cssSelector("#GNIBNo"));
            GNIBNo.sendKeys(GNIBNO_STRING);
        }
        else ConfirmGNIB.selectByVisibleText("No");



        WebElement UsrDeclaration = driver.findElement(By.name("UsrDeclaration"));
        UsrDeclaration.click();

        if(IS_CURRENT_GNIB_HOLDER){
            WebElement GNIBExDT = driver.findElement(By.cssSelector("#GNIBExDT"));
            GNIBExDT.sendKeys("k");


            boolean foundEXPIRE = false;
            List<WebElement> expiredYears = driver.findElements(By.cssSelector(".datepicker-years table tbody tr td span "));
            for (WebElement year : expiredYears) {
                if (year.getText().equals(YEAR_OF_EXPIRE)) {
                    year.click();
                    List<WebElement> months = driver.findElements(By.cssSelector(".datepicker-months table tbody tr td span "));
                    for (WebElement month : months) {
                        if (month.getText().equals(MONTH_OF_EXPIRE_IN_LETTER)) {
                            month.click();
                            List<WebElement> days = driver.findElements(By.cssSelector(".datepicker-days table tbody tr td.day"));
                            for (WebElement day : days) {
                                if (day.getAttribute("class").contains("old"))
                                    continue;
                                if (day.getText().equals(DAY_OF_EXPIRE)) {
                                    day.click();
                                    foundEXPIRE = true;
                                    break;
                                }

                            }
                        }
                        if (foundEXPIRE) break;
                    }
                }
                if (foundEXPIRE) break;
            }

        }

        WebElement GivenName = driver.findElement(By.cssSelector("#GivenName"));
        GivenName.sendKeys(FIRST_NAME);

        WebElement SurName = driver.findElement(By.cssSelector("#SurName"));
        SurName.sendKeys(LAST_NAME);

        WebElement DOB = driver.findElement(By.cssSelector("#DOB"));
        DOB.sendKeys("");

        int numberOfCLick = 0;
        if(Integer.valueOf(YEAR_OF_BIRTH)>=2010){

        }else{
            if(Integer.valueOf(YEAR_OF_BIRTH)>=2000){
                numberOfCLick = 1;
            }
            else{
                if(Integer.valueOf(YEAR_OF_BIRTH) >= 1990){
                    numberOfCLick =2;
                }
                else {
                    if(Integer.valueOf(YEAR_OF_BIRTH) >= 1980){
                        numberOfCLick = 3;
                    }
                    else {
                        if(Integer.valueOf(YEAR_OF_BIRTH) >= 1970){
                            numberOfCLick =4;
                        }
                        else{
                            if(Integer.valueOf(YEAR_OF_BIRTH) >= 1960){
                                numberOfCLick = 5;
                            }
                        }
                    }
                }

            }
        }
        for (int i = 0; i < numberOfCLick; i++) {
            driver.findElement(By.cssSelector(".datepicker-years table thead tr th ")).click();

        }
        boolean foundDOB = false;
        List<WebElement> DOByears = driver.findElements(By.cssSelector(".datepicker-years table tbody tr td span "));
        for (WebElement year : DOByears) {
            if (year.getText().equals(YEAR_OF_BIRTH)) {
                year.click();
                List<WebElement> months = driver.findElements(By.cssSelector(".datepicker-months table tbody tr td span "));
                for (WebElement month : months) {
                    if (month.getText().equals(MONTH_OF_BIRTH_IN_LETTER)) {
                        month.click();
                        List<WebElement> days = driver.findElements(By.cssSelector(".datepicker-days table tbody tr td.day"));
                        for (WebElement day : days) {
                            if (day.getAttribute("class").contains("old"))
                                continue;
                            if (day.getText().equals(DAY_OF_BIRTH)) {
                                day.click();
                                foundDOB = true;
                                break;
                            }

                        }
                    }
                    if (foundDOB) break;

                }
            }
            if (foundDOB) break;
        }
        Select nationality = new Select(driver.findElement(By.cssSelector("#Nationality")));
        nationality.selectByVisibleText("Vietnam, Socialist Republic of");

        WebElement Email = driver.findElement(By.cssSelector("#Email"));
        Email.sendKeys(EMAIL);

        WebElement EmailConfirm = driver.findElement(By.cssSelector("#EmailConfirm"));
        EmailConfirm.sendKeys(EMAIL);

        Select FamAppYN = new Select(driver.findElement(By.cssSelector("#FamAppYN")));
        FamAppYN.selectByVisibleText("No");

        Select PPNoYN = new Select(driver.findElement(By.cssSelector("#PPNoYN")));
        PPNoYN.selectByVisibleText("Yes");

        WebElement PPNo = driver.findElement(By.cssSelector("#PPNo"));
        PPNo.sendKeys(PASSPORT_NO);


        WebElement btLook4App = driver.findElement(By.cssSelector("#btLook4App"));
        btLook4App.click();


        Select AppSelectChoice = new Select(driver.findElement(By.cssSelector("#AppSelectChoice")));
        AppSelectChoice.selectByVisibleText("closest to today");
        WebElement btSrch4Apps = driver.findElement(By.cssSelector("#btSrch4Apps"));
        WebElement lastElement = driver.findElement(By.cssSelector(".footer-v1"));
        int y = lastElement.getLocation().getY();
        driver.executeScript("window.scrollTo(0," + y + ")");

        boolean foundAppointment = false;
        while (foundAppointment == false) {
            btSrch4Apps.click();
            WebElement bookthis;
            try {
                Thread.sleep(100);
                bookthis = driver.findElement(By.cssSelector(".appOption"));
                foundAppointment = true;
                bookthis.click();
                System.out.println("FOUND");
                InputStream in = new FileInputStream("Appointment detected.mp3");
                Player playMP3 = new Player(in);
                playMP3.play();

            } catch (Exception e) {

            }


        }
        try{

            System.out.println("FOUND");
            InputStream in = new FileInputStream("Appointment detected.mp3");
            Player playMP3 = new Player(in);
            playMP3.play();
        }catch (Exception e){

        }
    }
}
