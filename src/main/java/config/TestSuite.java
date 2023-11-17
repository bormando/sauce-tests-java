package config;

import com.microsoft.playwright.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.*;

public class TestSuite {
  protected Browser browser;
  protected Page page;
  protected Playwright playwright;
  protected Dotenv dotenv;

  @BeforeMethod
  public void globalSetup() {
    dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();

    playwright = Playwright.create();
    playwright.selectors().setTestIdAttribute("data-test");

    BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
    launchOptions.setHeadless(false);
    launchOptions.setChannel("chrome");

    this.browser = playwright.chromium().launch(launchOptions);
    Browser.NewPageOptions newPageOptions = new Browser.NewPageOptions();
    newPageOptions.baseURL = dotenv.get("BASE_URL");

    this.page = browser.newPage(newPageOptions);
  }

  @AfterMethod
  public void globalTeardown() {
    this.playwright.close();
  }
}
