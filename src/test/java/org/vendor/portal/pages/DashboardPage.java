package org.vendor.portal.pages;

import commonClasses.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends AbstractPage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningInput;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningInput;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginInput;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryInput;

    @FindBy(xpath = "//*[@id='dataTable_filter']//input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement recordDetailInput;

     public String getMonthlyEarning(){
         return monthlyEarningInput.getText();
     }

     public String getAnnualEarning(){
         return annualEarningInput.getText();
     }

     public String getProfitMargin() {
         return profitMarginInput.getText();
     }

     public String getInventory(){
         return availableInventoryInput.getText();
     }

     public void filterByName(String name){
         searchInput.sendKeys(name);
     }

     public String getRecords(){
         return recordDetailInput.getText();
     }


    @Override
    public boolean isAt() {
         wait.until(ExpectedConditions.visibilityOf(monthlyEarningInput));
         return monthlyEarningInput.isDisplayed();
    }
}
