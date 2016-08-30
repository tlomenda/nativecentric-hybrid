#Tech Talk Abstract

##Overview
Over the past year, I have been exploring Cordova/PhoneGap, React Native, and NativeScript for hybrid/cross platform mobile development with JavaScript. As part of this exploration, my key question was, “Can I access the power of the native mobile platform while also leveraging the openness of JavaScript to maximize code reuse across platforms?”.

This led me down the road of a taking what I call a native-centric hybrid approach to developing iOS and Android apps. The philosophy behind this approach is that since Users expect an **intimate UX** on their devices, Developers should be diligent to get **intimate with the platforms** they are targeting while also striving to **maximize code reuse** to reduce overall development costs. 

The essence then is to mix native code (i.e. iOS, Java) with JavaScript code in the “right way” and strike a balance between UX and code reuse. 

In general, I discovered that things can get tricky mixing native code and JavaScript code, especially if there is a high degree of interaction between components.

However there are merits to this approach if care and attention is followed. Some key discoveries:

* Consider using native tech for app flow, transitions, animations, UI components with rich, complex interaction
* Consider using HTML/CSS/JS for content rich UI components, services & business logic
* React Native is a friendlier option for mixing Pure Native and Cross-platform JavaScript than Cordova
* NativeScript with TypeScript/Angular 2 is an opinionated framework that takes a JavaScript first approach to cross platform mobile development
* In the end, not sure the added complexity of mixing Cordova and Native is worth it. If you need to mix, React Native is a better option.

##Benefits of Attending
* Gain insight from real-world experience on using JavaScript for hybrid/cross-platform app development
* Gain insight on ways to mix native and web components in a mobile app
* Information to identify which areas of a mobile app should be native vs web
* Highlight development techniques to easily bridge JavaScript and Native components 

##Speaker Bio
Torey is a Chief Software Technologist at Object Partners Inc. specializing in Mobile & Enterprise technologies with 21 years of professional experience.  He has led various large scale end-to-end applications including the development of many iOS, enterprise integrated, mobile business apps.  Most recently, he has applied his software expertise in exploring Cordova and the cross-platform JavaScript frameworks React Native and NativeScript to maximize code reuse across iOS and Android.

He supports a pragmatic delivery approach utilizing iterative development and continuous integration practices.

#Speaker Notes
These notes are meant to capture the talking points and opinions that are to be conveyed to the audience.

##Key Points
* Users expect **intimate UX**, Developers should get more **intimate with the platforms** they are targeting while striving to **maximize code reuse**.

##General Outline

* The Hybrid Mobile Development Spectrum
* Why Native-centric
* Hybrid Web vs Cross-platform JavaScript
* Inflated Expectations
* Ionic & Cordova Walkthrough
* React Native Walkthrough
* NativeScript Walkthrough (To be Continued...)
* Wrap-up
	* Discoveries
	* References 	