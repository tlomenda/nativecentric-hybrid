# HelloApp Demo: React Native
This README provides details on using React Native and setting up the *HelloAppReact* demo app to run on your workstation.

##Demo Setup
React Native requires HomeBrew, Node, Watchman, and Flow to work.  Follow these [setup instructions](https://facebook.github.io/react-native/docs/getting-started.html) to get started.

The demo code is located at [./demo/HelloAppReact](./demo/HelloAppReact).

###Package Dependencies
* **Node** ([https://nodejs.org](https://nodejs.org)).  JavaScript runtime that also provides a package manager (npm) for many JavaScript libraries and packages.
* **Watchman** ([GitHub](https://github.com/facebook/watchman)).  Watches files and triggers actions when they change.
* **Flow** ([GitHub](https://github.com/dreamerslab/node.flow)).  A deadly simple flow control package for node.js.

###Installing React Native CLI
```
$ npm install -g react-native-cli
```

###IDE Dev Tools
* Xcode 7.3 or Higher
* Android 
	* Android SDK
	
	```
	$ brew install android-sdk
	``` 	
	* Android Studio 2.0 or Higher.
* **Atom** ([https://atom.io/](https://atom.io/)) with atom-react Package.  Great tool for React JSX development.

```
$ apm install react
```  



##Key Selling Points
* Ability to render using the platform's standard rendering APIs (eg: UIKit on iOS).

* React Native also has the potential to positively impact your product release cycle. For instance, Apple permits JavaScript-based changes to an app’s behavior to be loaded over the air with no additional review cycle necessary.

* Native Bridge to Render to native platform

* JSX Combines JavaScript and Markup in one file (separation of concerns NOT technology).

* Relies on CSS Flexbox for Layout

* Allows CSS consistent support of styling rules.  Unlike the web where CSS support varies across browsers.

* React Native for iOS and Android includes support for many of the commonly used features, and React Native can support any asynchronous native API

##Book:  *Learning React Native*

**About Author**

Bonnie Eisenman is a software engineer at Twitter with previous experience at Codecademy, Google, and Fog Creek Software. She has spoken at several conferences on topics ranging from React to musical programming and Arduinos. In her spare time, she enjoys building electronic musical instruments, laser-cutting chocolate, and learning languages.