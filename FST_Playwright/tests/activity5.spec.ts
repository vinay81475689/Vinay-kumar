import { test, expect } from '@playwright/test';

test('Keyboard action test', async ({ page }) => {
    await page.goto("https://training-support.net/webelements/keyboard-events");
    
    // Verify the title
    await expect(page).toHaveTitle("Selenium: Keyboard Events");

    // Click the page or the specific area to gain focus
    // On this site, the interaction usually happens on the body or a specific container
    await page.locator('body').click(); 

    // Type the secret message character by character
    await page.keyboard.type("helpusobi");
    
    // Press Control + Enter
    await page.keyboard.press("Control+Enter");

    // Verify the result text
    // Note: If 'result' is an ID, use #result. If it's a data-testid, getByTestId is correct.
    const result = page.locator("#result"); 
    await expect(result).toHaveText("It's a trap!! 👽");
});