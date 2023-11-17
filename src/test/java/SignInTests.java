import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import config.TestSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTests extends TestSuite {
  private SignInPage signInPage;

  @BeforeMethod
  void setup() {
    signInPage = new SignInPage(this.page);
    signInPage.open();
  }

  @Test
  void signInWithExistingCredentials() {
    signInPage.inputUsername.type(this.dotenv.get("USERNAME"));
    signInPage.inputPassword.type(this.dotenv.get("PASSWORD"));
    signInPage.buttonLogin.click();

    assertThat(this.page).hasURL("/inventory.html");
    assertThat(this.page.getByText("Products")).isVisible();
  }

  @Test
  void signInWithNotExistingCredentials() {
    signInPage.inputUsername.type(this.dotenv.get("USERNAME"));
    signInPage.inputPassword.type("invalid_password");
    signInPage.buttonLogin.click();

    assertThat(this.page).hasURL("/");
    assertThat(signInPage.textError).isVisible();
  }
}
