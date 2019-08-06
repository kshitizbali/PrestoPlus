package com.kshitizbali.presto;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.kshitizbali.presto.view.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    private String fName, lName, email, phone;

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        fName = "Kshitiz";
        lName = "Bali";
        email = "k@k.com";
        phone = "9876543210";
    }


    @Test
    public void scrollToItemCheckClickAndText() {


        onView(withId(R.id.btSignUp)).check(matches(isDisplayed()));
        onView(withId(R.id.groupSignUp))
                .check(matches(not(isDisplayed())));


        onView(withId(R.id.btSignUp)).perform(click());
        onView(withId(R.id.btSignUp))
                .check(matches(withText(R.string.sign_up)));
        onView(withId(R.id.cvSIgnUp)).check(matches(isDisplayed()));
        onView(withId(R.id.groupWelcome))
                .check(matches(not(isDisplayed())));

        onView(withId(R.id.atvFirstName)).perform(typeText(fName), closeSoftKeyboard());


        onView(withId(R.id.atvLastName)).perform(typeText(lName), closeSoftKeyboard());


        onView(withId(R.id.atvEmailId)).perform(typeText(email), closeSoftKeyboard());


        onView(withId(R.id.atvPhone)).perform(typeText(phone), closeSoftKeyboard());


        onView(withId(R.id.btSignUpFinal)).perform(click());
        /*onView(withId(R.id.btSignUpFinal))
                .check(matches(withText(R.string.sign_up)));*/
        onView(withId(R.id.tvStatusTitle)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonOk)).perform(click());
        /*onView(withText(R.string.welcome_to_the_family)).inRoot(isPlatformPopup()).perform(click());*/
        //onView(withId(R.id.tvStatusTitle)).check(matches(not(isDisplayed())));


        onView(withId(R.id.atvFirstName)).check(matches(withText("")));

        onView(withId(R.id.atvLastName)).check(matches(withText("")));
        onView(withId(R.id.atvEmailId)).check(matches(withText("")));
        onView(withId(R.id.atvPhone)).check(matches(withText("")));

    }

}
