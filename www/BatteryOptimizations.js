var BatteryOptimizations = function() {};

BatteryOptimizations.prototype.run = function(successCallback,failureCallback) {
    cordova.exec(successCallback, failureCallback, 'BatteryOptimizations', 'run', [true]);
}

module.exports = new BatteryOptimizations();
