package TestCase.CsvFile;

import Pages.CarFuelConsumptionTracker;
import base.TestBase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class Delete_Car_Fuel_Consumption_Tracker_Csvfile_Test extends TestBase {
    CSVReader reader;
    @Test  (description = "Adding a data in the ( Saving Records )")
    public void Add_Valid_Car_Fuel_Consumption_Tracker() throws IOException, CsvValidationException {
         String csvfile = System.getProperty("user.dir")+"/src/test/java/Data/Data.csv";
         reader= new CSVReader(new FileReader(csvfile));
         String [] csvCell;
         while ((csvCell=reader.readNext())!=null)
         {
             String CarNumber = csvCell[0];
             String FuelInLiters = csvCell[1];
             String FuelCost = csvCell[2];
             String FuelType = csvCell[3];
             String Date = csvCell[4];
             String Time = csvCell[5];
             String CompanyId = csvCell[6];

        CarFuelConsumptionTracker CarFuelConsumptionTrackerobject = new CarFuelConsumptionTracker(driver);
        CarFuelConsumptionTrackerobject.Add_Car_Fuel_Consumption_Tracker( CarNumber, FuelInLiters, FuelCost, FuelType, Date, Time, CompanyId);
        Assert.assertEquals(driver.findElement(By.xpath("//tr/td[text()='"+CompanyId+"']")).getText(),CompanyId);
        CarFuelConsumptionTrackerobject.Delete_Car_Fuel_Consumption_Tracker(CompanyId);

         }
    }
}
