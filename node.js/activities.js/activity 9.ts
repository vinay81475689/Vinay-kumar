// Define the function using Rest Parameters
const sumAll = (...args: number[]): number => {
    // Use reduce to total the numbers in the array
    return args.reduce((total, current) => total + current, 0);
};

// Example Usage:
console.log("Sum 1:", sumAll(1, 2, 3));          // Output: 6
console.log("Sum 2:", sumAll(10, 20, 30, 40));   // Output: 100
console.log("Empty:", sumAll());                 // Output: 0

export { sumAll };
