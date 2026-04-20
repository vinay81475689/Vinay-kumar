class SimpleCalculator {
    // Private property: only accessible inside this class
    private lastResult: number = 0;

    add(a: number, b: number): number {
        this.lastResult = a + b;
        return this.lastResult;
    }

    subtract(a: number, b: number): number {
        this.lastResult = a - b;
        return this.lastResult;
    }

    // Optional: getter to see the last result safely
    getLastResult(): number {
        return this.lastResult;
    }
}

// Example usage:
const calc = new SimpleCalculator();
console.log("Add:", calc.add(10, 5));      // Output: 15
console.log("Subtract:", calc.subtract(20, 4)); // Output: 16
console.log("Last Result:", calc.getLastResult()); // Output: 16

export { SimpleCalculator };
