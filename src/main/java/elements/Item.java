package elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Item {
  public String description, price;
  public Locator card, title, buttonAddToCart;

  public Item(Page page, String title) {
    this.card =
        page.locator(".inventory_item", new Page.LocatorOptions().setHas(page.getByText(title)));
    this.description = this.card.locator(".inventory_item_desc").textContent();
    this.price = this.card.locator(".inventory_item_price").textContent();
    this.title = this.card.locator(".inventory_item_name");
    this.buttonAddToCart = this.card.getByText("Add to cart");
  }
}
