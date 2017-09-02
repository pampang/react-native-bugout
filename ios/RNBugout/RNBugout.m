//
//  RNBugout.m
//  RNBugout
//
//  Created by PAMPANG on 2017/8/22.
//  Copyright © 2017年 PAMPANG. All rights reserved.
//

#import "RNBugout.h"
#import "Bugout/Bugout.h"

@implementation RNBugout

RCT_EXPORT_MODULE();

+(void)initBugout:(NSString *)appKey channel:(NSString *)channel {
    BugoutConfig* config = [BugoutConfig defaultConfig];
    [Bugout init:appKey channel:channel config:config];
    
    // 默认设置为禁用状态（但在ios下似乎不管用）
    // 如果直接设置 config.enabledShakeFeedback = NO; ，会导致setShakeStatus方法不管用，所以用一些比较hack的方法
    [Bugout enabledShakeFeedback:NO];
}

+(void)initBugoutWithNoFeedback:(NSString *)appKey channel:(NSString *)channel {
    BugoutConfig* config = [BugoutConfig defaultConfig];
    
    // 直接禁用shakeFeedback，之后无法再启用
    config.enabledShakeFeedback = NO;
    [Bugout init:appKey channel:channel config:config];
}


/**
 * 对js端暴露的init方法
 */
RCT_EXPORT_METHOD(initBugout:(NSString *)appKey channel:(NSString *)channel) {
    [RNBugout initBugout:appKey channel:channel];
}


/**
 * 对js端暴露的设置摇一摇功能
 */
RCT_EXPORT_METHOD(setShakeStatus:(BOOL)status) {
    [Bugout enabledShakeFeedback:status];
}

@end
