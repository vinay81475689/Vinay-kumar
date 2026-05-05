import { test, expect } from '@playwright/test';

test('Keyboard action test', async ({ page }) => {
    await page.goto("https://training-support.net/webelements/alerts");
    
    // Verify the title
    await expect(page).toHaveTitle("Selenium: Alerts");

    test('Handling alerts with accept', async ({ page}) =>{
    page.on('dialog', async dialog => {
        console.log(dialog.message());

        await dialog.accept();
    }) 
    await page.getByRole('button', { name : "Simple"}).click();
    let message = await page.getByTestId('result').textContent();
    expect(message).toBe('You just accepted a simple alert!');

  });

  test('Handling alerts with dismiss', async ({ page }) =>{
    page.on('dialog', async dialog =>{
        console.log(dialog.message());
        await dialog.dismiss();
    });
  });
  });