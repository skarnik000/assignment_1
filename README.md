# Assignment 1

Please read this entire document carefully before starting.

===========

## Congratulations!

You have been contracted to develop an Android application on behalf of Fruityvice, a world leader in fruit datamining.

They have asked you to design and implement an application which will allow authenticated users to access and study nutritional information
about many kinds of fruit.

## Requirements

* Users must first log in to use the application. When the application is opened, if a user is not authenticated, present the user with a Login
  screen.
    * A user must log in with a simple username and password. Since the authentication backend is not ready, allow a user to enter any username
      with length greater than four characters, but only allow "password" as the password.
    * After a user logs in, navigate to the Fruit List screen.
    * If a user opens the application and they have logged in before already, skip the Login screen and navigate to the List screen.
* The rest of the application will consist of a List/Detail pattern.
    * After logging in, the user should be presented with a list of fruit. Each item, representing a fruit, should contain the following
      information.
        * The fruit's traditional name
        * The fruit's genus
        * The fruit's order. (Be sure to label the genus and order. Most users won't know which is which.)
    * A user should be able to scroll and examine these items on the List page.
* A user may then click on one of these items and will then be taken to the Fruit Detail page, to learn further information about that
  particular fruit.
* On the Fruit Detail page, a user will be able to learn all of the information about a particular fruit that Fruitvice has available.
* The user must be able to go back to the list to choose another fruit to learn about.






