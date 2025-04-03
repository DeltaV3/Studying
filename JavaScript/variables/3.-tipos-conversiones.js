//Transformar variables a String

let number = 123;
console.log(typeof number);
number = String(number);
console.log(number);


//Transformar variables a Number
let texto = "1a23";
console.log(typeof texto);
texto = Number(texto);
console.log(texto); //Cuando no se puede convertir a número, devuelve NaN
console.log(typeof texto);

let suma = "10" + 20;
console.log(suma); 
console.log(typeof suma);

//Transformar variables a Boolean
let b1 = Boolean({});
let b2 = Boolean(0);
console.log(b1);