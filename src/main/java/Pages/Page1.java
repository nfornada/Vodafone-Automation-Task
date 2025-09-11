package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Page1 extends ParentPage {


public Page1(WebDriver driver){
   super(driver);
}

    By RelatedSearchesSections = By.xpath("//h2[normalize-space(.)='Related searches for Vodafone']");
    By ListUnderneath =By.xpath("./following-sibling::*[1]//li | ./parent::div/following-sibling::*[1]//div[contains(@class,'suggestion_text')]");

   // List<WebElement> elements;

    public int numoftextsfound() throws InterruptedException {
        checkPage(1);
        List<WebElement> elements = driver.findElements(RelatedSearchesSections);
        System.out.println("Number of 'Related searches for Vodafone' sections: "+elements.size()+"\n");
        return elements.size();

    }

    public boolean checkitemsunderneath(String data)  {
        List<WebElement> items;
        List<WebElement> elements = driver.findElements(RelatedSearchesSections);
        int matcheditems;
        int countoflist;
        for (WebElement section : elements)
        {
            matcheditems=0;
            System.out.println("parent list: " +section.getText() );
             items = section.findElements(ListUnderneath);
            countoflist=items.size();
            for(WebElement item :items)
            {
                String text = item.getText().toLowerCase().trim();
                if(text.contains(data.toLowerCase().trim()))
                {
                    System.out.println(text);
                    matcheditems++;
                }
            }
            System.out.println("no. of items related" + countoflist);
            System.out.println("no. of matched items" + matcheditems+"\n");
            if(!(matcheditems==countoflist))
            {
                System.out.println("Not all elements in this section contain Vodafone.");
                return false;
            }
        }
        return true;

    }

}
