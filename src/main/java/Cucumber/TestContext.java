package Cucumber;

import Managers.DriverManager;
import Managers.PageObjectManager;

public class TestContext {
    private DriverManager driverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getWebDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
