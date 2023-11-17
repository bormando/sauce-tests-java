package pages;

import com.microsoft.playwright.*;

public class SignInPage {
  public Page page;
  public Locator inputUsername, inputPassword, buttonLogin, textError;

  public SignInPage(Page page) {
    this.page = page;
    this.inputUsername = this.page.getByTestId("username");
    this.inputPassword = this.page.getByTestId("password");
    this.buttonLogin = this.page.getByTestId("login-button");
    this.textError = this.page.getByTestId("error");
  }

  public void open() {
    this.page.navigate("/");
  }

  public void signIn(String username, String password) {
    this.open();
    this.inputUsername.type(username);
    this.inputPassword.type(password);
    this.buttonLogin.click();
  }
}
