package com.krafttech.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenu_stepDefs {

    @When("At first get the text of dashboard")
    public void at_first_get_the_text_of_dashboard() {
        System.out.println("dashboard text received");
    }
    @Then("go to Developers menu and get the text of Developer")
    public void go_to_developers_menu_and_get_the_text_of_developer() {
        System.out.println("clicked on developer menu");

    }
    @When("Get the text of dashboard")
    public void get_the_text_of_dashboard() {
        System.out.println("clipboard text received ");

    }
    @Then("go to Edit Profile menu and get the text of Edit User Profile")
    public void go_to_edit_profile_menu_and_get_the_text_of_edit_user_profile() {
        System.out.println("Edit User Profile text retrieved ");

    }
    @Then("go to My Profile menu and get the text of User Profile")
    public void go_to_my_profile_menu_and_get_the_text_of_user_profile() {
        System.out.println("went to profile and get user text");

    }

}
