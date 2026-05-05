import { test, expect } from '@playwright/test';

test('simple homepage test', async ({ page }) => {
    await page.goto("https://training-support.net/webelements/mouse-events");

    await expect(page).toHaveTitle("Selenium: Mouse Events")
    await page.getByRole('button', { name:'Cargo.toml'}).click();
    await expect(page.getByTestId("result")).toHaveText("You clicked on Cargo.toml");

     await page.getByRole('button', { name:'src'}).click({button: "right"});
     await page.getByRole('button', { name:'Rename'}).click();
    await expect(page.getByTestId("result")).toHaveText("You tried to rename src");

      await page.getByRole('button', { name:'src'}).click({button: "right"});
     await page.getByRole('button', { name:'Open'}).click();
    await expect(page.getByTestId("result")).toHaveText("You tried to open src");

await page.getByRole('button', { name:'target'}).dblclick();
await expect(page.getByTestId("result")).toHaveText("You double clicked on target");
});



