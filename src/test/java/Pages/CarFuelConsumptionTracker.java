package Pages;

import base.PageBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertFalse;

public class CarFuelConsumptionTracker extends PageBase {


    public CarFuelConsumptionTracker(WebDriver driver) {
        super(driver);
    }

    public void Add_Car_Fuel_Consumption_Tracker ( String CarNumber,String FuelInLiters,String FuelCost,String FuelType,String Date,String Time,String CompanyId) {
        WebElement Car_Number=  driver.findElement(By.name("carNumber"));
        SendData(Car_Number,CarNumber);
        WebElement Fuel_In_Liters=  driver.findElement(By.name("fuelInLiters"));
        SendData(Fuel_In_Liters,FuelInLiters);
        WebElement Fuel_Cost=  driver.findElement(By.name("fuelCost"));
        SendData(Fuel_Cost,FuelCost);
        WebElement Fuel_Type=  driver.findElement(By.name("fuelType"));
        SendData(Fuel_Type,FuelType);
        WebElement Date_and_Time=  driver.findElement(By.name("dateAndTime"));
        SendData(Date_and_Time,Date);
        Actions actions = new Actions(driver);
        actions.sendKeys(Date_and_Time, Keys.TAB).build().perform();
        SendData(Date_and_Time,Time);
        actions.sendKeys(Date_and_Time, Keys.ARROW_DOWN).build().perform();
        WebElement Company_Id=  driver.findElement(By.name("companyId"));
        SendData(Company_Id,CompanyId);
        WebElement Edit_Btn=  driver.findElement(By.className("btn-primary"));
       clickButton2(Edit_Btn);
    }
    public void Delete_Car_Fuel_Consumption_Tracker (String CustomerCompany ) {
         WebElement DeleteBTN =  driver.findElement(By.xpath("//tr/td[text()='"+CustomerCompany+"']/following-sibling::td/button"));
        clickButton2( DeleteBTN);
    }
}
