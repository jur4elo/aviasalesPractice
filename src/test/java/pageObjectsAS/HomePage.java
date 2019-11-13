package pageObjectsAS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
    }

    public void openHomePage() {
        driver.get("https://www.aviasales.ru/");
    }

    WebElement departureInput() {
        return driver.findElement(By.id("origin"));
    }

    WebElement arrivingInput() {
        return driver.findElement(By.id("destination"));
    }

    WebElement departureDate() {
        return driver.findElement(By.id("departDate"));
    }

    WebElement passengers() {
        return driver.findElement(By.xpath("//*[@*='additional-fields__label']"));
    }

    WebElement businessClass() {
        return driver.findElement(By.xpath("(//*[@*='custom-radio__element'])[3]"));
    }


    public void setNewTrip(String cityD, String cityA) {
        arrivingInput().sendKeys(cityD);
        departureInput().click();
        departureInput().sendKeys(cityA);
    }

    public void setUpDatesForNewTrip() {
        departureDate().click();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("(//*[@role='button'])[2]"))).click().perform();
        act.moveToElement(driver.findElement(By.cssSelector("[aria-label='Mon Dec 02 2019']"))).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Mon Dec 16 2019']")));
        act.moveToElement(driver.findElement(By.cssSelector("[aria-label='Fri Dec 06 2019']"))).click().perform();

    }


    public void setUpPassangersNumberAndComfortLevel() {
        wait.until(ExpectedConditions.elementToBeClickable(passengers()));
        passengers().click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@*='#FFF'])[2]")));
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("(//*[@xmlns])[2]"))).click().perform();
        businessClass().click();
        passengers().click();
    }

    WebElement searchForTicketsButton() {
        return driver.findElement(By.xpath("(//*[@type='submit'])[2]"));
    }

    WebElement hotelsCheckbox() {
        return driver.findElement(By.xpath("//*[@class='of_input_checkbox__label']"));
    }

    WebElement buyButton() {
        return driver.findElement(By.xpath("//*[@class='buy-button']"));
    }

    public void searchForTickets() {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsCheckbox()));
        Actions act = new Actions(driver);
        act.moveToElement(hotelsCheckbox()).click().perform();
        act.moveToElement(searchForTicketsButton()).click().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='countdown__title']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@for='stops_1']")));
    }

    public boolean buyTickets() {
        return buyButton().isEnabled();
    }


    WebElement createMultiplyCitiesTripButton() {
        return driver.findElement(By.xpath("//*[@*='#multiway']"));
    }

    WebElement inputFirstDeparture() {
        return driver.findElement(By.xpath("(//*[@*='origin'])[1]"));
    }

    WebElement inputSecondtDeparture() {
        return driver.findElement(By.xpath("(//*[@*='origin'])[2]"));
    }

    WebElement inputThirdtDeparture() {
        return driver.findElement(By.xpath("(//*[@*='origin'])[3]"));
    }

    WebElement inputFirstDestination() {
        return driver.findElement(By.xpath("(//*[@*='destination'])[1]"));
    }

    WebElement inputSecondDestination() {
        return driver.findElement(By.xpath("(//*[@*='destination'])[2]"));
    }

    WebElement inputThirdDestination() {
        return driver.findElement(By.xpath("(//*[@*='destination'])[3]"));
    }

    WebElement addFlightButton() {
        return driver.findElement(By.xpath("//*[@*='#']"));
    }

    public void createMultiplyCitiesTrip() {
        createMultiplyCitiesTripButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@*='#']")));
        addFlightButton().click();
        wait.until(ExpectedConditions.visibilityOf(inputThirdDestination()));
    }

    public void setTripOne(String cityD, String cityA) {
        inputFirstDeparture().sendKeys(cityD);
        Actions act = new Actions(driver);
        act.moveToElement(inputFirstDestination()).click().perform();
        inputFirstDestination().sendKeys(cityA);
        driver.findElement(By.xpath("(//*[@*='departDate'])[1]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role='button'])[2]")));
        act.moveToElement(driver.findElement(By.xpath("(//*[@role='button'])[2]"))).click().perform();
        act.moveToElement(driver.findElement(By.cssSelector("[aria-label='Mon Dec 02 2019']"))).click().perform();
    }

    public void setTripTwo(String cityD, String cityA) {
        inputSecondtDeparture().sendKeys(cityD);
        Actions act = new Actions(driver);
        act.moveToElement(inputSecondDestination()).click().perform();
        inputSecondDestination().sendKeys(cityA);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@id='departDate'])[2]")));
        act.moveToElement(driver.findElement(By.xpath("(//*[@id='departDate'])[2]"))).click().perform();
        act.moveToElement(driver.findElement(By.cssSelector("[aria-label='Sat Dec 07 2019']"))).click().perform();
    }

    public void setTripThree(String cityD, String cityA) {
        inputThirdtDeparture().sendKeys(cityD);
        Actions act = new Actions(driver);
        act.moveToElement(inputThirdDestination()).click().perform();
        inputThirdDestination().sendKeys(cityA);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@id='departDate'])[3]")));
        act.moveToElement(driver.findElement(By.xpath("(//*[@id='departDate'])[3]"))).click().perform();
        act.moveToElement(driver.findElement(By.cssSelector("[aria-label='Thu Dec 12 2019']"))).click().perform();
    }

    WebElement plusOnePassengerButton() {
        return driver.findElement(By.xpath("(//*[@*='additional-fields__passenger-control --increment'])[1]"));
    }

    public void setUpPassengersAndComfortLevel() {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@*='additional-fields --multiway of_form_part']"))).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(plusOnePassengerButton()));
        act.moveToElement(plusOnePassengerButton()).doubleClick().perform();
        businessClass().click();
        passengers().click();
        act.moveToElement(driver.findElement(By.xpath("(//*[@*='custom-radio__element'])[3]"))).click().perform();
        act.moveToElement(driver.findElement(By.xpath("(//*[@*='additional-fields__label'])"))).click().perform();
    }

    WebElement message() {
        return driver.findElement(By.cssSelector(".error-informer__icon"));
    }

    public void clickFindTicketsButton() {
        driver.findElement(By.xpath("(//*[@*='submit'])[1]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='countdown__title']")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-informer__icon")));
    }

    public boolean errorMessage() {
        return message().isDisplayed();
    }

    public void clickOnNightModeButton() {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@class='theme-switcher__toggle-handler']"))).click().perform();
    }
}

  /*  public void selectHotelsTab() {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("(//*[@*='hotelTab'])[2]"))).click().perform();
    }*/


   /* public void setHotelsData(){
        wait.until(ExpectedConditions.elementToBeClickable(departureInput()));
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("(//*[@*='origin-label'])[1]"))).click().perform();
        departureInput().sendKeys("LAX");*/


/*        driver.findElement(By.xpath("(//*[@*='origin-label'])[2]")).sendKeys("Los Angeles");
        act.moveToElement(driver.findElement(By.xpath("(//*[@*='destination-label'])[2]"))).click().perform();
        driver.findElement(By.xpath("(//*[@*='destination-label'])[2]")).sendKeys("Chicago");
        act.moveToElement(driver.findElement(By.xpath("//*[@*='departDate']"))).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Mon Nov 11 2019']")));
        var pickTheDepartureDate = driver.findElement(By.cssSelector("[aria-label='Mon Nov 11 2019']"));
        pickTheDepartureDate.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@*='grid']")));
        var pickTheArrivingDate = driver.findElement(By.cssSelector("[aria-label='Sat Nov 16 2019']"));
        pickTheArrivingDate.click();*/






