var exec = require('cordova/exec');

var CordovaPluginShare = {
  share: function(text) {
    exec(null, null, "CordovaPluginShare", "share", [text]);
  }
};

module.exports = CordovaPluginShare;
