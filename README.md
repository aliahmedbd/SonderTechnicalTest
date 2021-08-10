# SonderTechnicalTest

The repository has contains the Sonder Technical test solution, where an Android project is created and followed the steps which were mentioned in the document.

Here is the screenshots of the application:

<img src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Splash%20Screen.png" alt="" data-canonical-src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Splash%20Screen.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Access%20Location.png" alt="" data-canonical-src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Access%20Location.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Map%20Screen.png" alt="" data-canonical-src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Map%20Screen.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Passenger%20List.png" alt="" data-canonical-src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Passenger%20List.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Passengar%20Details.png" alt="" data-canonical-src="https://github.com/aliahmedbd/SonderTechnicalTest/blob/main/Passengar%20Details.png" width="200" height="400" /> 


## Technical Description

Here is the list of technologies are used to build this application:

1. <b>Kotlin</b>
2. <b>MVVM Architecture</b>
3. <b>Motion Layout</b> : `MotionLayout` is used for animate the app icon in the Splash screen.
4. <b> Retrofit, OkHttp</b> : To fetch the passenger data from API, I have used the network library which is Retrofit.
5. <b>Kotlin Coroutine</b> : To reduce the main thread task we can divide the task in many thread asychronously using the Kotlin Coroutine using `lifecycle` scope. Here is the sample example:   
```java
   lifecycleScope.launch {
            viewModel.passengers.collectLatest { pagedData ->
                passengersAdapter.submitData(pagedData)
            }
        }
```
6. <b>Jetpack Component - Pagging 3</b> : Why pagging is required this application, because the passenger list has a massive amount of data and If I wanted to fetch these data ata single time it will take huge amount of time. So that pagination is required, the jetpack component which is Pagging3 is one of the most used jetpack component to perform the paginated data in the `RecyclerView`. It also better with Kotlin Coroutine and Live Data. For that need to create Pagging adapter where we can detect the Success and Error state.
7.  <b>Google Map</b>: Google Map API for Android, Places
