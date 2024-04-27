package org.vendor.portal.testClasses;

import commonClasses.AbstractTestClass;
import commonClasses.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.vendor.portal.model.VendorPortalTestData;
import org.vendor.portal.pages.DashboardPage;
import org.vendor.portal.pages.LoginPage;

public class VendorPortalTest extends AbstractTestClass {
    protected VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testData")
    public void setJSONData(String testData){
        this.testData = JsonUtil.getTestData(testData, VendorPortalTestData.class);
    }

    @Test
    public void loginPageTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html#");
        Assert.assertTrue(loginPage.isAt());

        loginPage.setUserName(testData.userName());
        loginPage.setPassword(testData.password());
        loginPage.setCheckBox();
        loginPage.clickLoginBtn();
    }

    @Test(dependsOnMethods = "loginPageTest")
    public void dashboardPageTest(){
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.isAt();
        Assert.assertEquals(dashboardPage.getMonthlyEarning(),testData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashboardPage.getInventory(), testData.availableInventory());

        dashboardPage.filterByName(testData.searchKeyword());

        System.out.println(testData.searchResultCount());
    }

}
