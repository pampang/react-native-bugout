//
//  RNBugout.h
//  RNBugout
//
//  Created by PAMPANG on 2017/8/22.
//  Copyright © 2017年 PAMPANG. All rights reserved.
//

#if __has_include(<React/RCTBridgeModule.h>)
#import <React/RCTBridgeModule.h>
#elif __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#elif __has_include("React/RCTBridgeModule.h")
#import "React/RCTBridgeModule.h"
#endif

@interface RNBugout : NSObject <RCTBridgeModule>

+(void)initBugout:(NSString *)appKey channel:(NSString *)channel;

@end
