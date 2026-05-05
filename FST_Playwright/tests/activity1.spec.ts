import { test, expect } from '@playwright/test';

test('simple homepage test', async ({ page }) => {
    await page.goto("https://training-support.net");
    let pageTitle = await page.title();
    console.log(`Title of the page is ${pageTitle}`);
    const aboutButton = page.getByText("About Us");
    await aboutButton.click();

    await page.waitForURL("**/about/");

    pageTitle = await page.title();
    console.log(`Title of the page is ${pageTitle}`);
});
