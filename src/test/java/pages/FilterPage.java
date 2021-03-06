package pages;

import pages.common.Common;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterPage extends Common {

    private By queryResult = By.cssSelector(".ait-search-query");
    private By itemList = By.cssSelector(".ait-search-categories-content > div > div:nth-child(1) > ul > li:nth-child(1)");
    private By brandList = By.cssSelector(".filter-data > div:nth-child(4)");
    private By brandName = By.cssSelector("div.row>label[for='s62086']");
    private By loader = By.cssSelector("#loader");
    private By productSortList = By.cssSelector(".select-add-info");
    private By mostStars = By.cssSelector(".drop-list li[rel='4']");

    public void checkQueryResult(String tag) {
        closePopup();
        closeBottomBar();
        waitUntil(queryResult);
        assertThat(driver.findElement(queryResult).getText()).isEqualToIgnoringCase("Meklēšanas rezultāti: " + tag);
    }

    public void pickBrand() {
        driver.findElement(itemList).click();
        closePopup();
        closeBottomBar();
        driver.findElement(brandList).click();
        clickOnHiddenElement(brandName);
        waitForInvisibilityOfElement(loader);
    }

    public void pickBestRated() {
        waitUntil(productSortList);
        driver.findElement(productSortList).click();
        driver.findElement(mostStars).click();
        waitForInvisibilityOfElement(loader);
    }

    public  void selectBestRated (){
        driver.findElement(By.cssSelector(".product-grid > section:nth-child(" + 1 + ") .p-image")).click();
    }
}
