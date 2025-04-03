//Operador AND o Y
let a = true && true;
let b = false && false;
console.log(a)

//Operador Or o O

let e = true || true;
let f = true || false;

let i = 5;
let j = 10;
let uni = "UCEVA";
let edad = 18;

if(i < j && (uni === "UCEVA" || edad < 18)){
    console.log("Condicion verdadera");
}

//Operador de negacion NOT !
let edad1 = 15;
let mayor = !(edad1 < 18);
let mayor1 = !!(edad < 18);

let apellido = 0;
if (!apellido){
    console.log("Apellido no tiene valor");
}
