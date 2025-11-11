package playwrightTraditional;
import java.nio.file.Paths;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestBookstore {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://depaul.bncollege.com/");
            page.getByPlaceholder("Enter your search details (").click();
            page.getByPlaceholder("Enter your search details (").fill("earbuds");
            page.getByPlaceholder("Enter your search details (").press("Enter");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("brand")).click();
            page.locator("#facet-brand").getByRole(AriaRole.LIST).locator("label")
                    .filter(new Locator.FilterOptions().setHasText("brand JBL (12)"))
                    .getByRole(AriaRole.IMG).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
            page.locator("label").filter(new Locator.FilterOptions().setHasText("Color Black (9)"))
                    .locator("svg").first().click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
            page.locator("#facet-price svg").nth(2).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();
            page.getByLabel("Add to cart").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();
            page.getByLabel("Enter Promo Code").click();
            page.getByLabel("Enter Promo Code").fill("TEST");
            page.getByLabel("Apply Promo Code").click();
            page.getByLabel("Proceed To Checkout").first().click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();
            page.getByPlaceholder("Please enter your first name").click();
            page.getByPlaceholder("Please enter your first name").fill("joe");
            page.getByPlaceholder("Please enter your last name").click();
            page.getByPlaceholder("Please enter your last name").fill("rac");
            page.getByPlaceholder("Please enter a valid email").click();
            page.getByPlaceholder("Please enter a valid email").fill("email@example.com");
            page.getByPlaceholder("Please enter a valid phone").click();
            page.getByPlaceholder("Please enter a valid phone").fill("1237896654");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();
            page.getByLabel("Remove product JBL Quantum").click();

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("videos/trace.zip")));
            context.close();
            browser.close();
        }
    }
}