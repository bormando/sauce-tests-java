package elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Navbar {
  public Locator cart;

  public Navbar(Page page) {
    this.cart = page.locator(".shopping_cart_link");
  }
}
