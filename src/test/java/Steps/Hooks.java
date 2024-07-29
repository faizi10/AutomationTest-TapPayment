package Steps;

import Cucumber.TestContext;
import Managers.SoftAssertManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void before(Scenario scenario) {
        SoftAssertManager.createSoftAssert();
        beforeScenario(scenario);
    }

    @After
    public void after(Scenario scenario) {
        afterScenario(scenario);
        testContext.getDriverManager().closeWebDriver();
        SoftAssertManager.assertAllAndClear();
    }

    // Method for logging before starting a scenario
    private void beforeScenario(Scenario scenario) {
        System.out.println("/*****************************************************************************************************/");
        System.out.println("Starting Scenario - " + scenario.getName());
        System.out.println("Scenario Id :  - " + scenario.getId());
        System.out.println("Scenario Tags :  - " + scenario.getSourceTagNames());
        System.out.println("/*****************************************************************************************************/");
    }

    // Method for taking a screenshot and logging the scenario status after completion of the scenario,
    // and adding the screenshot as an attachment to the Allure report in case of failure.
    private void afterScenario(Scenario scenario) {
        System.out.println("/------------------------------------------------------------------------------------------------------/");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        if (scenario.isFailed()) {
            String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            formattedDateTime = formattedDateTime.replace(":", "-");
            File screenshot = ((TakesScreenshot) testContext.getDriverManager().getWebDriver()).getScreenshotAs(OutputType.FILE);
            String rootDirectoryPath = System.getProperty("user.dir");
            String screenShotDirectory = rootDirectoryPath + "/screenshots/" + LocalDate.now().toString() + "/";
            File screenshotFolder = new File(screenShotDirectory);
            screenshotFolder.mkdirs();
            String screenShotFilePath = screenshotFolder + "/" + formattedDateTime + " " + scenario.getName() + ".jpg";
            File targetFile = new File(screenShotFilePath);
            try {
                FileUtils.copyFile(screenshot, targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path screenShotContent = Paths.get(screenShotFilePath);
            try (InputStream is = Files.newInputStream(screenShotContent)) {
                Allure.addAttachment("Failure ", is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("/------------------------------------------------------------------------------------------------------/");
    }
}
