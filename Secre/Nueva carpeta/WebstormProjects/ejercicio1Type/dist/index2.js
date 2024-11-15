"use strict";
var cars = { make: "audi", model: "r8" };
var bus = { make: "ford", model: "ban", payloadCapacity: 10 };
var vehicles = [cars, bus];
vehicles.forEach(function (vehicle) {
    console.log("Make: ".concat(vehicle.make));
    console.log("Model: ".concat(vehicle.model));
    if ("payloadCapacity" in vehicle) {
        console.log("Payload Capacity: ".concat(vehicle.payloadCapacity));
    }
    console.log("--------");
});
