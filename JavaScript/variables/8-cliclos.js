//While
let i = 0;
while(i < 10){
    console.log(i);
    i++;
}

i=0;
do{
    console.log(i);
    i++;
}while(i<10)

for (let k = 0; k < 10; k++){
    console.log(k);
}


//For of
let ArrayNumbers = [1,2,3,4,5,6,7,8]
for (let numero of ArrayNumbers){
    console.log(numero);
}

let persona = {
    nombre: "Juan",
    apellido: "Perez",
    edad: 25
}

for (let propiedad in persona){
    console.log(propiedad)
    console.log(persona[propiedad]);
}

for (let i = 0; i<Object.keys(persona);i++){
    console.log(persona[Object.keys(persona)[i]]);
}