# Sonder Trip - SonderTechnicalTest

The repository has contains the Sonder Technical test solution, where an Android project is created and followed the steps which were mentioned in the document. I named the application is <b>Sonder Trip</b> 

Here is the screenshots of the application:

<img src="https://github.com/aliahmedbd/MonsterLabTechnicalTest/blob/main/Screenshot%202021-11-24%20at%202.34.00%20PM.png" alt="" data-canonical-src="https://github.com/aliahmedbd/MonsterLabTechnicalTest/blob/main/Screenshot%202021-11-24%20at%202.34.00%20PM.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/MonsterLabTechnicalTest/blob/main/Screenshot%202021-11-24%20at%202.20.39%20PM.png" alt="" data-canonical-src="https://github.com/aliahmedbd/MonsterLabTechnicalTest/blob/main/Screenshot%202021-11-24%20at%202.20.39%20PM.png" width="200" height="400" />  <img src="https://github.com/aliahmedbd/MonsterLabTechnicalTest/blob/main/Screenshot%202021-11-24%20at%202.20.49%20PM.png" alt="" data-canonical-src="https://github.com/aliahmedbd/MonsterLabTechnicalTest/blob/main/Screenshot%202021-11-24%20at%202.20.49%20PM.png" width="200" height="400" />  

## Application Flow

1. A splash screen will be appeared
2. After splash screen loaded successfully then Home screen will be appeard. In home screen there will be two bottom navigation tab. 1. Images and another one is 2. Settings page
3. In Images tab Image list will be generated with image preview as well as user can download the image by clicking on download image icon. Image will be donwloaded in the file section.
4. While clicking on image icon system will be prompted a dialog for File write external permission.
5. Under the Setting page user can change the Page count and the image count per page.
  


## Technical Description

Here is the list of technologies are used to build this application:

1. <b>Kotlin</b>
2. <b>MVVM Architecture</b>
3. <b>Motion Layout</b> : `MotionLayout` is used for animate the app icon in the Splash screen.
4. <b> Retrofit, OkHttp</b> : To fetch the image data from API, I have used the network library which is Retrofit.
5. <b>Kotlin Coroutine</b> : To reduce the main thread task we can divide the task in many thread asychronously using the Kotlin Coroutine using `lifecycle` scope. Here is the sample example:   
```java
   lifecycleScope.launch {
          
        }
```
6. <b>Jetpack Component - Pagging 3</b> : Why pagging is required this application, because the image list has a massive amount of data and If I wanted to fetch these data ata single time it will take huge amount of time. So that pagination is required, the jetpack component which is Pagging3 is one of the most used jetpack component to perform the paginated data in the `RecyclerView`. It also better with Kotlin Coroutine and Kotlin Low. For that need to create Pagging adapter where we can detect the Success and Error state.
7.  Hilt (Dependancy Injection used)
10.  <b>Jetpack Component - Navigation</b> : Navigation is used for generate the  `BottomNavigationView` , where I can see the clear view visibilty on the Android studio, here is the screenshot.
