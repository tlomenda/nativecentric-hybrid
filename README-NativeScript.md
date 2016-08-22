# HelloApp Demo: NativeScript
This README provides details on using NativeScript with TypeScript and Angular2 and setting up the *HelloAppNativeScript* demo app to run on your workstation.

To get started with NativeScript:  [NativeScript Get Started](http://docs.nativescript.org/angular/tutorial/ng-chapter-0).

##Demo Setup
The demo code is located at [./demo/HelloAppNativeScript](./demo/HelloAppNativeScript).

###Installing and Running
If you have not done so, make sure you have the pre-reqs and NativeScript installed.  See [NativeScript Get Started](http://docs.nativescript.org/angular/tutorial/ng-chapter-0).

From a command-line:

* ```cd ./demo/HelloAppNativeScript```
* ```tns build ios```
* ```tns build android```

###IDE Dev Tools
* Xcode 7.3 or Higher
* Android 
	* Android SDK
	
	```
	$ brew install android-sdk
	``` 	
	* Android Studio 2.0 or Higher.
* **Atom** ([https://atom.io/](https://atom.io/)) with atom-react Package.  Great tool for Typescript/Angular 2 development.

*NOTE:  The majority of code will be JS/CSS code so Atom or a Web Dev Tooling of choice will be used over XCode and Android Studio.*

## Running the Demo App
From the command-line, make sure you are in the *./demo/HelloAppNativeScript* directory.

* iOS:   ```tns run ios --emulator```
* Android:  ```tns run android --emulator```