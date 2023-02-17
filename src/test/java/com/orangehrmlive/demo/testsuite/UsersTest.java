package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.testbase.TestBase;
import com.orangehrmlive.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest extends TestBase {

    HomePage homepage;
    AdminPage admin;
    LoginPage loginpage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;


    @BeforeMethod
    public void inIT() {
        homepage = new HomePage();
        admin = new AdminPage();
        loginpage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }
    //1.adminShouldAddUserSuccessFully().
    //Login to Application
    //click On "Admin" Tab
    //Verify "System Users" Text
    //click On "Add" button
    //Verify "Add User" Text
    //
    //Select User Role "Admin"
    //enter Employee Name "Ananya Dash"
    //enter Username
    //Select status "Disable"
    //enter password
    //enter Confirm Password
    //click On "Save" Button
    //verify message "Successfully Saved"
    @Test
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginpage.enterUserName("Admin");
        loginpage.enterPassword("admin123");
        loginpage.clickOnLoginButton();
        Thread.sleep(1000);
        homepage.clickAdminButton();

        String expected = "System Users";
        Assert.assertEquals(viewSystemUsersPage.verifySystemUsersText(), expected);

        Thread.sleep(1000);
        viewSystemUsersPage.clickAddButton();

        String expected1 = "Add User";
        Assert.assertEquals(viewSystemUsersPage.verifyAddUserText(), expected1);

        addUserPage.selectUserRoleAdmin();
        addUserPage.enterEmployeeName();
        addUserPage.enterUserName("paul");
        addUserPage.clickStatusDropDown1();
        addUserPage.enterPasswordField("Abcd123@");
        addUserPage.enterConfirmPasswordField("Abcd123@");
        addUserPage.clickSaveButton();

    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginpage.enterUserName("Admin");
        loginpage.enterPassword("admin123");
        loginpage.clickOnLoginButton();
        homepage.clickAdminButton();

        String expected = "System Users";
        Assert.assertEquals(viewSystemUsersPage.verifySystemUsersText(), expected);
        viewSystemUsersPage.enterUserNameField("paul");
        viewSystemUsersPage.clickUserRollDropdown();
        addUserPage.enterEmployeeName();
        viewSystemUsersPage.clickStatusDropDown();
        viewSystemUsersPage.clickSearchButton();

    }
    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        loginpage.enterUserName("Admin");
        loginpage.enterPassword("admin123");
        loginpage.clickOnLoginButton();
        homepage.clickAdminButton();

        String expected = "System Users";
        Assert.assertEquals(viewSystemUsersPage.verifySystemUsersText(), expected);
        viewSystemUsersPage.enterUserNameField("paul");
        viewSystemUsersPage.clickUserRollDropdown();
        addUserPage.enterEmployeeName();
        viewSystemUsersPage.clickStatusDropDown();
        viewSystemUsersPage.clickSearchButton();
    }/*Verify "System Users" Text
Enter Username
Select User Role
Select Satatus
Click on "Search" Button
Verify the User should be in Result list.
Click on Check box
Click on Delete Button
Popup will display
Click on Ok Button on Popup
verify message "Successfully Deleted"*/

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginpage.enterUserName("Admin");
        loginpage.enterPassword("admin123");
        loginpage.clickOnLoginButton();
        homepage.clickAdminButton();

        String expected = "System Users";
        Assert.assertEquals(viewSystemUsersPage.verifySystemUsersText(), expected);
        viewSystemUsersPage.enterUserNameField("paul");
        viewSystemUsersPage.clickUserRollDropdown();
        addUserPage.enterEmployeeName();
        viewSystemUsersPage.clickStatusDropDown();
        viewSystemUsersPage.clickSearchButton();

    }

}

