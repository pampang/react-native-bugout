import {
  NativeModules,
} from 'react-native';

const RNBugout = NativeModules.RNBugout;

export default class Bugout {

  /**
   * init
   */
  static initBugout(appKey: String, channel: String) {
    RNBugout.initBugout(appKey, channel);
  }

  /**
   * setShakeStatus
   */
  static setShakeStatus(status: Boolean) {
    RNBugout.setShakeStatus(status);
  }
}