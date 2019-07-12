package com.airconsole.plugin.share;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.content.Intent;

public class CordovaPluginShare extends CordovaPlugin {

  private static final String TAG = "CordovaPluginShare";

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    Context context = this.cordova.getActivity().getApplicationContext();

    if (action.equals("share")) {
      try {
        String text = args.getString(0);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        this.cordova.getActivity().startActivity(Intent.createChooser(sendIntent, "Share on:"));
      } catch (Exception e) {
        Log.d(TAG, e.toString());
      }
    }

    return true;
  }

}
