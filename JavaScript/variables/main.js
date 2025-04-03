//Numeros
let number = 10;

//String
let string = "Hola";
let persona = "Diego tiene " + number + " años";
let persona2 = `Diego tiene ${number} años`;
console.log(persona);

//Boolean
let esMayor = true;
let esMenor = false;

//Null
let vacio = null;

//Undefined
let indefinido = undefined;
console.log(indefinido);

let persona3 = {
    nombre: "Diego",
    edad: 10,
    esMayor: true,
    hijo: {
        nombre: "Juan",
        edad: 5,
        hijo: {
            nombre: "Pedro",
            edad: 2
        }
    }
}
console.log(persona3.nombre);

persona3.deuda_banco = 1000;
console.log(persona3);

persona3.deuda_banco -= 500;
console.log(persona3);

//Array
let array = [1, 2, 3, 4, 5];
let variado = [1, "Hola", true, null, undefined, {nombre: "Diego"}, [1, 4]];
variado[6].push(5);
variado[6].unshift(2);
variado[6].reverse();
variado[5].apellido = "Perez";
console.log(variado);

