package com.heika.test.verify.cases.UI;

import com.heika.test.ui.elements.factory.api.ElementFactory;
import com.heika.test.ui.verify.page.LeftPage;
import com.heika.test.ui.verify.page.LoginPage;
import com.heika.test.ui.verify.page.UserSearch;
import com.heika.test.utils.LogHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin
{
    @Parameters({"verify_ui_login_username", "verify_ui_login_password"})
    @Test(groups= {"UI"}, description = "")
    public void loginTest(String userName, String password) throws Exception
    {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://172.16.2.38:15081/login.html");

        LoginPage loginPage = ElementFactory.initElements(webDriver, LoginPage.class);
        LogHelper.log("登陆审核系统");
        loginPage.Login(userName, password);

        LeftPage navTree = ElementFactory.initElements(webDriver, LeftPage.class);
        LogHelper.log("点击“用户查询”导航栏");
        navTree.switchTo("用户查询");

        UserSearch userSearch = ElementFactory.initElements(webDriver, UserSearch.class);
        userSearch.search("身份证", "补件", "2305241981");
    }
}