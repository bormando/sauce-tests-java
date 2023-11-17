package pages;

import com.microsoft.playwright.Page;
import elements.Item;
import elements.Navbar;

public class ProductsPage {
  public Page page;
  public Navbar navbar;

  public ProductsPage(Page page) {
    this.page = page;
    this.navbar = new Navbar(page);
  }

  public void open() {
    this.page.navigate("/inventory.html");
  }

  public Item getItem(String title) {
    return new Item(this.page, title);
  }
}
