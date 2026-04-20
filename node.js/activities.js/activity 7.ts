// type userResponce = {

// }
// async function getData ( userID : number ): Promice<UserResponce> {
//     return new Promice((resolve, reject) =>
//     {
//         setTimeout(() =>{
//             if (userId == 1) {
//                 resolve({
//                     id : 1,
//                     name : "Jane",
//                     email: "jane@zzz.com"
//                 });,
//             }else{
//                 reject(new Error("Invalid user ID"));
//             }
//         },2000);
//     });
// }

// async function rundemo(id: number){
//     try{

//     }
// }
type UserResponse = {
    id: number;
    name: string;
    email: string;
};

async function getData(userId: number): Promise<UserResponse> {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (userId === 1) {
                resolve({
                    id: 1,
                    name: "Jane",
                    email: "jane@zzz.com"
                });
            } else {
                reject(new Error("Invalid user ID"));
            }
        }, 2000);
    });
}

async function runDemo(id: number) {
    try {
        console.log(`Fetching data for ID: ${id}...`);
        const data = await getData(id);
        console.log("Success:", data);
    } catch (error) {
        if (error instanceof Error) {
            console.error("Error:", error.message);
        }
    }
}

export {runDemo}
