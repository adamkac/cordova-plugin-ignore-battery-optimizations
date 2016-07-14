var BatteryOptimizations = function(successCallback,failureCallback) {
    cordova.exec(successCallback, failureCallback, 'BatteryOptimizations', 'run', [true]);
};

module.exports = BatteryOptimizations;
