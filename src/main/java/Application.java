
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javazoom.jl.player.Player;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Application extends javafx.application.Application {
    //Is Current GNIB Holder
    static Boolean IS_CURRENT_GNIB_HOLDER = false;
    //Personal Information
    static String GNIBNO_STRING = "a";
    static String YEAR_OF_BIRTH = "1971";
    static String MONTH_OF_BIRTH_IN_LETTER = "Dec";
    static String DAY_OF_BIRTH = "19";
    static String YEAR_OF_EXPIRE = "2019";
    static String MONTH_OF_EXPIRE_IN_LETTER = "Dec";
    static String DAY_OF_EXPIRE = "31";
    static String FIRST_NAME = "DO";
    static String LAST_NAME = "THANH LONG";
    static String EMAIL = "thelongdt@gmail.com";
    static String PASSPORT_NO = "awe";

    public static GridPane groupRoot = new GridPane();

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");

        primaryStage.show();
        groupRoot.setHgap(50);
        groupRoot.setVgap(4);
        groupRoot.setGridLinesVisible(true);
        groupRoot.setPadding(new Insets(10));
        final int numCols = 4;
        final int numRows = 10;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth(50);
            groupRoot.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(50);
            groupRoot.getRowConstraints().add(rowConst);
        }
        Label lbl_firstName = new Label("First name");
        Label lbl_lastName = new Label("Last name");
        Label lbl_DOB = new Label("DOB");
        Label lbl_email = new Label("Email");
        Label lbl_passportNo = new Label("Passport \nnumber");
        Label lbl_isGnibHolder = new Label("Is a current \n   GNIB/IRP holder?");
        Label lbl_GNIBNo = new Label("GNIB number");
        Label lbl_GNIBExp = new Label("GNIB \nExpiry");

        groupRoot.add(lbl_firstName, 0, 0, 2, 1);
        groupRoot.add(lbl_lastName, 0, 1, 2, 1);
        groupRoot.add(lbl_DOB, 0, 2, 2, 1);
        groupRoot.add(lbl_email, 0, 3, 2, 1);
        groupRoot.add(lbl_passportNo, 0, 4, 2, 1);
        groupRoot.add(lbl_isGnibHolder, 0, 5, 2, 1);
        groupRoot.add(lbl_GNIBNo, 0, 6, 2, 1);
        groupRoot.add(lbl_GNIBExp, 0, 7, 2, 1);


        ChoiceBox DOB_DayChoiceBox = new ChoiceBox();
        ChoiceBox DOB_MonthChoiceBox = new ChoiceBox();
        ChoiceBox DOB_YearChoiceBox = new ChoiceBox();
        ChoiceBox EXP_DayChoiceBox = new ChoiceBox();
        ChoiceBox EXP_MonthChoiceBox = new ChoiceBox();
        ChoiceBox EXP_YearChoiceBox = new ChoiceBox();
        for (int i = 1; i <= 31; i++) {
            DOB_DayChoiceBox.getItems().add(i);
            EXP_DayChoiceBox.getItems().add(i);
        }
        String[] months = "Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec".split(" ");
        DOB_MonthChoiceBox.getItems().addAll(months);
        EXP_MonthChoiceBox.getItems().addAll(months);

        for (int i = 1960; i <= 2050; i++) {
            DOB_YearChoiceBox.getItems().add(i);
            EXP_YearChoiceBox.getItems().add(i);
        }
        TextField txt_firstName = new TextField("First name");
        TextField txt_lastname = new TextField("Last name");
        TextField txt_email = new TextField("abc@gmail.com");
        TextField txt_passportNo = new TextField("A9999999");
        TextField txt_GNIBNo = new TextField("R123456");
        RadioButton txt_currentGNIBYes = new RadioButton("Yes");
        RadioButton txt_currentGNIBNo = new RadioButton("No");
        txt_currentGNIBYes.setUserData("true");
        txt_currentGNIBNo.setUserData("false");
        ToggleGroup radioGroup = new ToggleGroup();
        txt_currentGNIBNo.setToggleGroup(radioGroup);
        txt_currentGNIBYes.setToggleGroup(radioGroup);

        groupRoot.add(txt_firstName, 1, 0, 3, 1);
        groupRoot.add(txt_lastname, 1, 1, 3, 1);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(20);
        hBox1.setPadding(new Insets(14, 0, 0, 0));

        hBox1.getChildren().add(DOB_DayChoiceBox);
        hBox1.getChildren().add(DOB_MonthChoiceBox);
        hBox1.getChildren().add(DOB_YearChoiceBox);
        groupRoot.add(hBox1, 1, 2, 3, 1);
        groupRoot.add(txt_email, 1, 3, 3, 1);
        groupRoot.add(txt_passportNo, 1, 4, 3, 1);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(50);
        hBox2.setPadding(new Insets(14, 0, 0, 0));

        hBox2.getChildren().add(txt_currentGNIBNo);
        hBox2.getChildren().add(txt_currentGNIBYes);
        groupRoot.add(hBox2, 2, 5, 2, 1);

        groupRoot.add(txt_GNIBNo,1,6,3,1);
        HBox hBox3 = new HBox();
        hBox3.setSpacing(20);
        hBox3.setPadding(new Insets(14, 0, 0, 0));

        hBox3.getChildren().add(EXP_DayChoiceBox);
        hBox3.getChildren().add(EXP_MonthChoiceBox);
        hBox3.getChildren().add(EXP_YearChoiceBox);
        groupRoot.add(hBox3, 1, 7, 3, 1);

        txt_GNIBNo.setVisible(false);
        lbl_GNIBNo.setVisible(false);
        hBox3.setVisible(false);
        lbl_GNIBExp.setVisible(false);

        txt_currentGNIBNo.setOnAction(event -> {
            hBox3.setVisible(false);
            lbl_GNIBNo.setVisible(false);
            txt_GNIBNo.setVisible(false);
            lbl_GNIBExp.setVisible(false);
        });
        txt_currentGNIBYes.setOnAction(event -> {
            hBox3.setVisible(true);
            lbl_GNIBNo.setVisible(true);
            lbl_GNIBExp.setVisible(true);
            txt_GNIBNo.setVisible(true);

        });

        Button btn_submit = new Button("Submit");
        Button btn_reset = new Button("Reset");
        groupRoot.add(btn_submit,1, 8,2,1);
        groupRoot.add(btn_reset,2, 8,2,1);

        btn_submit.setOnMouseClicked(event -> {
            IS_CURRENT_GNIB_HOLDER = Boolean.valueOf(radioGroup.getSelectedToggle().getUserData().toString());
            GNIBNO_STRING = txt_GNIBNo.getText();
            YEAR_OF_BIRTH = DOB_YearChoiceBox.getValue().toString();
            MONTH_OF_BIRTH_IN_LETTER = DOB_MonthChoiceBox.getValue().toString();
            DAY_OF_BIRTH = DOB_DayChoiceBox.getValue().toString();
            YEAR_OF_EXPIRE = EXP_YearChoiceBox.getValue().toString();
            MONTH_OF_EXPIRE_IN_LETTER = EXP_MonthChoiceBox.getValue().toString();
            DAY_OF_EXPIRE = EXP_DayChoiceBox.getValue().toString();
            FIRST_NAME = txt_firstName.getText();
            LAST_NAME = txt_lastname.getText();
            EMAIL = txt_email.getText();
            PASSPORT_NO = txt_passportNo.getText();

            register();
        });


        Scene scene = new Scene(groupRoot, 1024, 768);
        primaryStage.setTitle("Sample Long");
        primaryStage.setScene(scene);
        primaryStage.show();

//        register();
    }

    public static void register() {

        try {
            InputStream in1 = new FileInputStream("Developed by Vietnamese.mp3");
            InputStream in2 = new FileInputStream("Begin.mp3");
            Player playMP3 = new Player(in1);
            playMP3.play();
            playMP3 = new Player(in2);
            playMP3.play();
        } catch (Exception e) {

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
        if (IS_CURRENT_GNIB_HOLDER) {
            ConfirmGNIB.selectByVisibleText("Yes");
            WebElement GNIBNo = driver.findElement(By.cssSelector("#GNIBNo"));
            GNIBNo.sendKeys(GNIBNO_STRING);
        } else ConfirmGNIB.selectByVisibleText("No");


        WebElement UsrDeclaration = driver.findElement(By.name("UsrDeclaration"));
        UsrDeclaration.click();

        if (IS_CURRENT_GNIB_HOLDER) {
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
        if (Integer.valueOf(YEAR_OF_BIRTH) >= 2010) {

        } else {
            if (Integer.valueOf(YEAR_OF_BIRTH) >= 2000) {
                numberOfCLick = 1;
            } else {
                if (Integer.valueOf(YEAR_OF_BIRTH) >= 1990) {
                    numberOfCLick = 2;
                } else {
                    if (Integer.valueOf(YEAR_OF_BIRTH) >= 1980) {
                        numberOfCLick = 3;
                    } else {
                        if (Integer.valueOf(YEAR_OF_BIRTH) >= 1970) {
                            numberOfCLick = 4;
                        } else {
                            if (Integer.valueOf(YEAR_OF_BIRTH) >= 1960) {
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
        try {

            System.out.println("FOUND");
            InputStream in = new FileInputStream("Appointment detected.mp3");
            Player playMP3 = new Player(in);
            playMP3.play();
        } catch (Exception e) {

        }
    }
}
