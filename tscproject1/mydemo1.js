// let message:String='World';
// let no:number=10;
// let bool:boolean=true;
// let omni:any="Yeah";
// console.log("Hello "+message+" "+no+" " +bool + " " + omni);
// omni = 20;
// console.log(omni);
// let arr:number[]=[1,2,3,54];
// for(let i=0;i<arr.length;i++){
//     console.log(arr[i]);
// }
// let sports: String[] = ['cricket','football','basketball'];
// sports.push('volleyball');
// sports.push('hockey');
// for(let sport of sports){
//     console.log(sport);
// }
var Address = /** @class */ (function () {
    function Address(addressLine1, addressLine2, city) {
        this._addressLine1 = addressLine1;
        this._addressLine2 = addressLine2;
        this._city = city;
    }
    Address.prototype.showDetails = function () {
        return 'Address: ' + this._addressLine1 + ',' + this._addressLine2 + ', City: ' + this._city;
    };
    return Address;
}());
var Person = /** @class */ (function () {
    function Person(_firstName, _lastName, _email, _address) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.address = _address;
    }
    Person.prototype.showDetails = function () {
        return 'First Name: ' + this.firstName + ',Last Name: ' + this.lastName + ',email: ' + this.email + ', address: ' + address.showDetails();
    };
    Object.defineProperty(Person.prototype, "_firstName", {
        get: function () {
            return this.firstName;
        },
        set: function (_firstName) {
            this.firstName = _firstName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "_lastName", {
        get: function () {
            return this.lastName;
        },
        set: function (_lastName) {
            this.lastName = _lastName;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "_email", {
        get: function () {
            return this.email;
        },
        set: function (_email) {
            this.email = _email;
        },
        enumerable: false,
        configurable: true
    });
    return Person;
}());
var address = new Address('A13', 'cp', 'Delhi');
var person = new Person('Jhon', 'Doe', 'jd@gmail.com', address);
console.log(person.showDetails());
