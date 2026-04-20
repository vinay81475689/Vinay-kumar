// The Dynamic Greeting
let calcYear = (name:string, age: number) =>{
    let year100: number = (2026-age)+100
    return `${name} will turn 100 in ${year100}`
}
export{calcYear}