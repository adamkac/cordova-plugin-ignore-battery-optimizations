package org.apache.cordova.batteryoptimizations;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;

import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.net.Uri;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;

/**
 * Plugin class which does the actual handling
 */
public class BatteryOptimizations extends CordovaPlugin {

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("run")) {
    	Context context = cordova.getActivity().getApplicationContext();
			Intent intent = new Intent();
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			String packageName = context.getPackageName();
			PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
			if (pm.isIgnoringBatteryOptimizations(packageName))
			    intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
			else {
			    // intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
			    // intent.setData(Uri.parse("package:" + packageName));
			}
			context.startActivity(intent);
    }
    else {
        return false;
    }

    // Only alert and confirm are async.
    callbackContext.success();

    return true;
  }

}
