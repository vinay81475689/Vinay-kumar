// Import required modules
import { test, expect } from '@playwright/test';

// Create a test function
test('simple form test', async ({ page }) => {
    // Open the browser
    await page.goto("https://training-support.net/webelements/simple-form");

    // Get and print title
    let pageTitle = await page.title();
    console.log(`Title of the page is: ${pageTitle}`);

    // Assertion
    await expect(page).toHaveTitle("Selenium: Simple Form");

    // Fill up the form
    await page.getByRole('textbox', { name: 'Full Name' }).fill("Jane");
    await page.getByRole('textbox', { name: 'Email' }).fill("jane.doe@zzz.com");
    
    // Fill the date (Ensure the ID matches the site's implementation)
    await page.locator('#event-date').fill("2026-05-01"); 
    
    await page.getByRole('textbox', { name: 'Additional Details' }).fill("Long weekend");
    
    // Submit
    await page.getByRole('button', { name: 'Submit' }).click();

    // Print the confirmation message (ADDED await HERE)
    const confirmation = page.getByRole("heading").filter({ hasText: "scheduled" });
    await expect(confirmation).toHaveText("Your event has been scheduled!");
});