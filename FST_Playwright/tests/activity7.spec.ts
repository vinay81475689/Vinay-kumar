
// Page object for new pages
const newPage = context.waitForEvent('page');

// Perform action to open a new page/tab/window
await page.getByRole('button', { name: "Open New Tab" }).click();


// Wait for the new page to be opened
const newTab = await newPage;
// Use the new page for further actions
await newTab.getByRole()



// Handler for when new pages are opened
// Use case: when you want to perform actions on any new page that is opened, regardless of how it was triggered (e.g., by clicking a link, button, or through JavaScript).
context.on('page', async page => {
    // Perform actions on the new page
    await page.getByRole('heading', { name: "New Tab" }).waitFor();
    const title = await page.title();
    console.log(title);
});
















// Import required modules
import { test, expect } from '@playwright/test';
import read_csv from './read_csv.ts';

test.beforeEach(async ({ page }) => {
    // Open the test page
    await page.goto("https://training-support.net/webelements/todo-list");
    // Assert the title of the page
    await expect(page).toHaveTitle("Selenium: To-Do List");
});

test('Add tasks', async ({ page }) => {
    // Read tasks from the CSV file
    const tasksList = read_csv("tasks.csv");
    console.log(tasksList);

    // Locate the input field and the add button
    const inputText = page.getByTestId("todo-input");
    const addButton = page.getByTestId("todo-add");

    // Add each task from the CSV file to the todo list
    for (const task of tasksList) {
        console.log(task.tasks);
        await inputText.fill(task.tasks);
        await addButton.click();
    }

    // Assert that the tasks have been added to the list
    const addedTasks = page.locator("li.w-full");
    // const addedTasks = page.getByRole("listitem");
    await expect(addedTasks).toHaveCount(5);
});



import { parse } from "csv-parse/sync";
import fs from "fs";
import path from "path";

type Record = {
    tasks: string;
};

export default function readCSV(filePath: string): Record[] {
    // Read the CSV file and parse it into an array of records
    const records: Record[] = parse(
        fs.readFileSync(path.join(__dirname, filePath), "utf-8"),
        {
            columns: true,
            skipEmptyLines: true,
        }
    );

    // Return the array of records
    return records;
}