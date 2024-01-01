package steps;

import Pages.CarFuelConsumptionTracker;
import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddingDataInSavingRecords extends TestBase {
    @Given("The User in the Car Fuel Consumption Tracker")
    public void user_Open_the_Car_Fuel_Consumption_Tracker() {

    }
   // @When("^Adding the new record By enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
   @When("Adding the new record By enter {string},{string},{string},{string},{string},{string}, {string}")
    public void Adding_the_new_record_in_the_SavedRecords(String CarNumber,String FuelInLiters,String FuelCost,String FuelType,String Date,String Time,String CompanyId) {
        CarFuelConsumptionTracker CarFuelConsumptionTrackerobject = new CarFuelConsumptionTracker(driver);
        CarFuelConsumptionTrackerobject.Add_Car_Fuel_Consumption_Tracker(CarNumber, FuelInLiters, FuelCost, FuelType, Date, Time, CompanyId);
    }
    @When("Check the new record saved in the saved records {string}")
    public void AssertTheSavedRecordSavedThenewRecord(String CompanyId) {
        Assert.assertEquals(driver.findElement(By.xpath("//tr/td[text()='"+CompanyId+"']")).getText(),CompanyId);
    }

}
