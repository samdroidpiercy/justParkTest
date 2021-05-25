# justParkTest
Test Project For Just Park Interview Process

I have put a dependencies.gradle file in the top level of the project, this means that dependencies in any future modules will be pulled from this single source of truth and ensure that there are no version clashes throughout the project. 

I have used RXKotlin rather than livedata with android jetpack viewmodels, as RX was touted as a “nice to see”.

Single of retrofit is used as it is costly to create and will be used frequently in an app such of this, but factories are used for view model dependencies as they are lightweight and we don’t necessarily want to hold state between loads. 

I have used Koin for dependency injection as it is lightweight, suits Kotlin well and doesn’t require a rebuild of the project every time you add a new dependency.

I have used an extension function for getCardDrawable, as this is extendable code that is used in more than one place. 

I have used an extension function to enbolden the title part of the text for each name/value pair after a certain point. This allows us to use one textview rather than two for each name/value pair in the display and highlights the fact that a bit of code can infact be more readable than a bunch of xml.

I have used a scrollview for the details fragment, as these will not fit on very short screens and when more details are added, all screen will need the scroll functionality.

My UX consideration was to show the data I currently have immediate access to whilst the api data is returned. With more time I would like to show ghost views for the views that have not been populated yet, as this is considered a better “waiting experience”. 

I have written a unit test using kotlin mockito and have created a test entity to show how to simplify complicated objects that need to be used again and again in testing.

I have written an extremely basic end to end test using Kakao and Espresso. Kakao makes view navigation look neat and readable in the code and espresso is fast for end to end tests.

API BUG: There is a slight issue with the JSON:

In https://justpark-hiring-json-api.herokuapp.com/api/booking/4614 and https://justpark-hiring-json-api.herokuapp.com/api/booking/4611 “listing” is not closed off after id, whereas in  https://justpark-hiring-json-api.herokuapp.com/api/booking/4613 it is. This means that we cannot generically parse the JSON for this screen.

I have had to make "address" in the BookingDetails data class nullable and display “Not available” if the address is null as a result of this API Bug. 

Things I have missed: Details view could be made to fit the tablet better (rearrange the card views to be side by side, increase font size). I should use a placeholder for the image view. I have not dealt with the unhappy paths (connectivity issues/ api failures)
