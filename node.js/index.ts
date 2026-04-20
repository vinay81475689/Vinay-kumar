// import { calcYear } from "./activities/activity 1.js";

// console.log(calcYear("Vinay",23));
// Activity 2
// import { generateFizzBuzz } from "./activities/activity 2.js";

// console.log(generateFizzBuzz(20));
// activity 3
// Use 'import type' for the interface and 'import' for the actual data
// import type { Book } from "./activities.js/activity 3.js";
// const myNewBook: Book = {
//     title: "TypeScript Essentials",
//     author: "Microsoft",
//     year: 2024
// };

// console.log("New Book Created:", myNewBook);

// If you want to use the 'books' array from the other file, 
// make sure to add 'export { books }' to your activity-4.ts file.


// // 4. Print everything to the terminal
// console.log("--- Application Settings ---");
// console.log(`Theme: ${theme}`);
// console.log(`Font Size: ${fontSize}px`);

// console.log("\n--- Function Output ---");
// console.log(`Input: [${numbers}]`);
// console.log(`Squared Evens: [${result}]`);
// import { applySettings } from "./activities.js/activity 5.js";
// console.log("--- Test Case 1 ---");
// applySettings({ theme: "light", fontSize: 24 });
// console.log("\n--- Test Case 2 ---");
// applySettings({});
// console.log("\n--- Test Case 3 ---");
// applySettings({ fontSize: 0 }); 
// import { SimpleCalculator } from "./activities.js/activity 6.js";

// const calc = new SimpleCalculator();
// const sum = calc.add(10, 5);
// console.log(`Addition Result (10 + 5): ${sum}`);
// const difference = calc.subtract(20, 4);
// console.log(`Subtraction Result (20 - 4): ${difference}`);

// console.log(`The most recent result was: ${calc.getLastResult()}`);

// Testing the code
// import { runDemo } from "./activities.js/activity 7.js";
// runDemo(1); // Success
// runDemo(2); // Fails
// import { UserRole,roleDescriptions } from "./activities.js/activity 8.js";
// function displayRoleDetails(role: UserRole) {
//     const description = roleDescriptions[role];
//     console.log(`[${role}] -> ${description}`);
// }

// // 2. Test with different roles
// console.log("--- User Permissions Lookup ---");

// displayRoleDetails(UserRole.Admin);  // Output: [Admin] -> Has full access...
// displayRoleDetails(UserRole.Viewer); // Output: [Viewer] -> Can only read...

// // 3. Example of using Record in a loop
// console.log("\n--- Full Dictionary ---");
// Object.values(UserRole).forEach((role) => {
//     console.log(`${role}: ${roleDescriptions[role as UserRole]}`);
// });

import { sumAll } from "./activities.js/activity 9.js";

// 1. Testing with a few numbers
const total1 = sumAll(5, 10, 15);
console.log(`Total (5 + 10 + 15): ${total1}`);

// 2. Testing with many numbers
const total2 = sumAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
console.log(`Total (1 to 10): ${total2}`);

// 3. Testing with zero arguments
const total3 = sumAll();
console.log(`Total (None): ${total3}`);

// ❌ Error Check:
// sumAll(10, "20"); // This will fail because it only accepts number[]

// import { sanitizeInput } from "./activities.js/activity 10.js";
// // Test with malicious inputs
// const maliciousInput = "   <script>alert('Hacked!');</script> & buy some \"cheap\" stuff!   ";
// const safeOutput = sanitizeInput(maliciousInput);
// // Print strings
// console.log("Original:", maliciousInput);
// console.log("Sanitized:", safeOutput);