package TestCase.DataProvider;

import Pages.CarFuelConsumptionTracker;
import base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Delete_Car_Fuel_Consumption_Tracker_DataProvider_Test extends TestBase {
    @DataProvider(name="userData")
    public static Object[][]userData()
    {
        return new Object[][]
                {
                        {"123","22","220","Gas","10262023","0102","123"},
                        {"456","33","330","Petrol","10252023","0203","111"},
                        {"789","44","440","Electric","10242023","0304","222"},
                };
    }
    @Test  (dataProvider = "userData",description = "Adding a data in the ( Saving Records )")
    public void Delete_Car_Fuel_Consumption_Tracker(String CarNumber,String FuelInLiters,String FuelCost,String FuelType,String Date,String Time,String CompanyId)  {
        CarFuelConsumptionTracker CarFuelConsumptionTrackerobject = new CarFuelConsumptionTracker(driver);
        CarFuelConsumptionTrackerobject.Add_Car_Fuel_Consumption_Tracker(CarNumber,FuelInLiters,FuelCost,FuelType,Date,Time,CompanyId);
        CarFuelConsumptionTrackerobject.Delete_Car_Fuel_Consumption_Tracker(CompanyId);
    }

}
