package org.mvn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass{
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement radiobutton;
	
	@FindBy(id="continue")
	private WebElement cntbutton;

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getCntbutton() {
		return cntbutton;
	}
	

}
