const squaredEvens = (nums : number[]): number[] => {
    let result =nums
        .filter((num) => num % 2 == 0)
        .map((num) => num ** 2);

        return result;
}

export { squaredEvens };