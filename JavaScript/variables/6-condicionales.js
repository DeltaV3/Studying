import prompt from 'prompt';

let num = 5;

if(num > 0){
    console.log(num + " es mayor que 0")
} else if(num < 0) {
    console.log(num + "es menor que 0");
} else{
    console.log("Come pimga");
}

//Operador ternario
let num2 = 5;
let resultado = num2 > 0 ? num2 + " es mayor que 0" : num2 + " es menor que 0"
console.log(resultado);