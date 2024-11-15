interface Car{
    make : string;
    model : string;
}

interface Bus{
    make : string;
    model : string;
    payloadCapacity : number;
}

type Vehicle =  Car | Bus;

let cars : Car = {make : "audi", model : "r8"};
let bus : Bus = {make : "ford", model : "ban", payloadCapacity : 10};

let vehicles : Vehicle[] = [cars, bus];

vehicles.forEach((vehicle) => {
    console.log(`Make: ${vehicle.make}`);
    console.log(`Model: ${vehicle.model}`);
    if ("payloadCapacity" in vehicle) {
        console.log(`Payload Capacity: ${vehicle.payloadCapacity}`);
    }
    console.log("--------");
});