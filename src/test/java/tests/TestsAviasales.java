package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectsAS.HomePage;

public class TestsAviasales extends BaseTest {

    @Test
    public void turnOnNightMode() {
        var homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickOnNightModeButton();
    }

    @Test
    public void ticketsPurchase() {
        var homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.setNewTrip("Den", "Lax");
        homePage.setUpDatesForNewTrip();
        homePage.setUpPassangersNumberAndComfortLevel();
        homePage.searchForTickets();
        var buyTickets = homePage.buyTickets();
        Assert.assertTrue(buyTickets, "There is no button to buy tickets");
    }

    @Test
    public void creatingTripWithMultiplyCities() {
        var homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.createMultiplyCitiesTrip();
        homePage.setTripOne("SLC", "LAX");
        homePage.setTripTwo("LAX", "DEN");
        homePage.setTripThree("DEN", "SLC");
        homePage.setUpPassengersAndComfortLevel();
        homePage.clickFindTicketsButton();
/*        var noTickets = homePage.errorMessage();
        Assert.assertTrue(noTickets, "Error message is not visible");
 */
    }
}
  /*  @Test
    public void searhcForHotel(){
        var homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.selectHotelsTab();
        homePage.setHotelsData();
    }*/

