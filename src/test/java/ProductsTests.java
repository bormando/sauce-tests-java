import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Page;
import config.TestSuite;
import elements.Item;
import java.util.Objects;
import java.util.regex.Pattern;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.SignInPage;

public class ProductsTests extends TestSuite {
  private ProductsPage productsPage;

  @BeforeMethod
  void setup() {
    SignInPage signInPage = new SignInPage(this.page);
    signInPage.signIn(this.dotenv.get("USERNAME"), this.dotenv.get("PASSWORD"));

    this.productsPage = new ProductsPage(this.page);
    this.productsPage.open();
  }

  @Test
  void addItemToCart() {
    Item item = this.productsPage.getItem("Sauce Labs Bike Light");
    assert Objects.equals(item.price, "$9.99");
    item.buttonAddToCart.click();
    assertThat(productsPage.navbar.cart).hasText("1");
  }

  @Test
  void openItem() {
    String title = "Sauce Labs Bolt T-Shirt";
    Item item = this.productsPage.getItem(title);
    item.title.click();
    assertThat(this.page).hasURL(Pattern.compile("/inventory-item.html"));
    assertThat(
            this.page.getByText(
                "Sauce Labs Bolt T-Shirt", new Page.GetByTextOptions().setExact(true)))
        .isVisible();
  }
}
