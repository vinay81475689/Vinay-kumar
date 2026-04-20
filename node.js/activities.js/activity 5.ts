interface Settings{
    theme?: "light"  | "dark"
    fontSize?: number
}
let applySettings = (settings: Settings) => {
    const theme = settings.theme || "dark";

    const size = settings.fontSize ?? 10;

    console.log(`Theme :m ${theme}`);
    console.log(`Font size : ${size}`);
}
export { applySettings }