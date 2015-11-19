//
//  DuetHybridBridge.swift
//  HelloApp
//
//  Created by Torey Lomenda on 11/13/15.
//
//

import Foundation

@objc(DuetHybridBridge) class DuetHybridBridge: CDVPlugin {
    var listenerCallbackId:String = ""
    
    //MARK: Navigation functions called from the JS side, native OS listens and responds
    func JS_TO_NATIVE_NEXTLYRIC(command: CDVInvokedUrlCommand) {
        print("JS_TO_NATIVE_NEXTLYRIC")
        
        self.commandDelegate!.runInBackground { () -> Void in
            dispatch_sync(dispatch_get_main_queue(), { () -> Void in
                let nextLyric:String = self.getLionelRitchieNextLyric()
                
                self.setNextLyric(nextLyric)
                
                let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK)
                self.commandDelegate!.sendPluginResult(pluginResult, callbackId: command.callbackId)
            })
        }
    }
    
    //MARK: Navigation functions called from the JS side, native OS listens and responds
    func JS_TO_NATIVE_WAITFORLYRIC(command: CDVInvokedUrlCommand) {
        print("JS_TO_NATIVE_WAITFORLYRIC")
        
        self.commandDelegate!.runInBackground { () -> Void in
            let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK)
            self.commandDelegate!.sendPluginResult(pluginResult, callbackId: command.callbackId)
            
            dispatch_sync(dispatch_get_main_queue(), { () -> Void in
                let nextLyric:String = "...Listens..."
                
                self.setNextLyric(nextLyric)
                
                let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK)
                self.commandDelegate!.sendPluginResult(pluginResult, callbackId: command.callbackId)
            })
        }
    }
    
    //MARK: Navigation functions called from the JS side, native OS listens and responds
    func GET_NEXTLYRIC_FOR_WEB(command: CDVInvokedUrlCommand) {
        print("GET_NEXTLYRIC_FOR_WEB")
        
        self.commandDelegate!.runInBackground { () -> Void in
            dispatch_sync(dispatch_get_main_queue(), { () -> Void in
                let nextLyric:String = self.getAdeleNextLyric()
                let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsString: nextLyric)
                self.commandDelegate!.sendPluginResult(pluginResult, callbackId: command.callbackId)
            })
        }
    }
    
    func ACTION_BIND_LISTENER(command: CDVInvokedUrlCommand) {
        print("ACTION_BIND_LISTENER")
        
        self.commandDelegate!.runInBackground { () -> Void in
            self.listenerCallbackId = command.callbackId
            
            let pluginResult:CDVPluginResult = CDVPluginResult(status: CDVCommandStatus_OK)
            pluginResult.setKeepCallbackAsBool(true)
            self.commandDelegate!.sendPluginResult(pluginResult, callbackId: command.callbackId)
        }
    }
    
    //MARK: functions invoked by the native OS, JS listens and responds to these function calls
    func reportEvent(eventData:NSDictionary) {
        print("reportEvent")
        
        self.commandDelegate!.runInBackground { () -> Void in
            let pluginResult:CDVPluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAsDictionary:eventData as [NSObject: AnyObject])
            pluginResult.setKeepCallbackAsBool(true)
            self.commandDelegate!.sendPluginResult(pluginResult, callbackId: self.listenerCallbackId)
        }
    }
    
    //MARK:  Private functions
    private func getLionelRitchieNextLyric() -> String {
        return (UIApplication.sharedApplication().delegate as! AppDelegate).helloByLionelRitchie.getNextLyric()
    }
    private func getAdeleNextLyric() -> String {
        return (UIApplication.sharedApplication().delegate as! AppDelegate).helloByAdele.getNextLyric()
    }
    
    
    private func setNextLyric(lyric:String) {
        let appDelegate:AppDelegate = UIApplication.sharedApplication().delegate as! AppDelegate
        let mainController:MainViewController = appDelegate.window!.rootViewController as! MainViewController
        
        mainController.nextLyricLabel.text = lyric
    }

}
