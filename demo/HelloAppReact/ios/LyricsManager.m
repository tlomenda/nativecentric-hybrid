//
//  LyricsManager.m
//  HelloAppReact
//
//  Created by Torey Lomenda on 4/19/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "LyricsManager.h"

#import "RCTBridge.h"
#import "RCTEventDispatcher.h"

#import "HelloAppReact-Swift.h"

@implementation LyricsManager

@synthesize bridge = _bridge;
@synthesize methodQueue = _methodQueue;

RCT_EXPORT_MODULE();

- (void) playNextLyricForLionel {
  AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
  MainViewController *mainVC = (MainViewController *) appDelegate.window.rootViewController;
  
  NSString *nextLyric = [appDelegate.helloByLionelRitchie getNextLyric];
  mainVC.nextLyricLabel.text = nextLyric;
  
  // Send event to JS side for Adele to wait
  RCTBridge *eventBridge = self.bridge;
  
  if (eventBridge == nil) {
    eventBridge = _defaultBridge;
  }
  
  [eventBridge.eventDispatcher sendAppEventWithName:@"hello.NextLyric" body:@{@"lyric":@"...Listening..."}];
}

- (void) playNextLyricForAdele {
  AppDelegate *appDelegate = (AppDelegate *) [UIApplication sharedApplication].delegate;
  MainViewController *mainVC = (MainViewController *) appDelegate.window.rootViewController;
  
  mainVC.nextLyricLabel.text = @"...Listening...";
  
  NSString *nextLyric = [appDelegate.helloByAdele getNextLyric];
  
  // Send event to JS side to display Adele lyric
  RCTBridge *eventBridge = self.bridge;
  
  if (eventBridge == nil) {
    eventBridge = _defaultBridge;
  }
  [eventBridge.eventDispatcher sendAppEventWithName:@"hello.NextLyric" body:@{@"lyric":nextLyric}];
}

RCT_EXPORT_METHOD(playNextLionelLyric) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [self playNextLyricForLionel];
  });
}
RCT_EXPORT_METHOD(playNextAdeleLyric) {
  dispatch_async(dispatch_get_main_queue(), ^{
   [self playNextLyricForAdele];
  });
}

@end
