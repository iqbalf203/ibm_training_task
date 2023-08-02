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

class Address {
    private _addressLine1: string;
    private _addressLine2: string;
    private _city: string;

    constructor(addressLine1: string, addressLine2: string, city: string) {
        this._addressLine1 = addressLine1;
        this._addressLine2 = addressLine2;
        this._city = city;
    }

    public showDetails():string{
        return 'Address: '+this._addressLine1+','+this._addressLine2+', City: '+this._city;
    }

}

class Person {
    private firstName: string;
    private lastName: string;
    private email: string;
    private address:Address;

    constructor(_firstName: string, _lastName: string, _email: string,_address:Address) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
        this.address = _address;
    }

    showDetails(): string {
        return 'First Name: ' + this.firstName + ',Last Name: ' + this.lastName + ',email: ' + this.email+', address: '+address.showDetails();
    }

    public get _firstName(): string {
        return this.firstName;
    }
    public set _firstName(_firstName: string) {
        this.firstName = _firstName;
    }
    public get _lastName(): string {
        return this.lastName;
    }
    public set _lastName(_lastName: string) {
        this.lastName = _lastName;
    }
    public get _email(): string {
        return this.email;
    }
    public set _email(_email: string) {
        this.email = _email;
    }
}

let address = new Address('A13','cp','Delhi');
let person = new Person('Jhon', 'Doe', 'jd@gmail.com',address);
console.log(person.showDetails());

