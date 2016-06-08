//
//  LyricsManager.h
//  HelloAppReact
//
//  Created by Torey Lomenda on 4/19/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "RCTBridgeModule.h"
@interface LyricsManager : NSObject<RCTBridgeModule>

@property (nonatomic, strong) RCTBridge *defaultBridge;

- (void) playNextLyricForLionel;
- (void) playNextLyricForAdele;
@end
