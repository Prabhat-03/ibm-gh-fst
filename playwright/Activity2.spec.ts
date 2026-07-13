import { test } from "@playwright/test";

test("Activity 2", async ({ page }) => {
    await page.goto("https://training-support.net/webelements/simple-form");
    let title = await page.title();
    console.log(`Title of the Page is : ${title}`);

    await page.getByLabel("Full Name").fill("Yshesh");
    await page.getByLabel("Email Address").fill("Yshesh@ymail.com");
    await page.getByTestId("event-date").fill("2026-07-13");
    await page.getByLabel("Additional Details").fill("xyzzzzzzzzzz");
    await page.getByRole("button").filter({hasText: "Submit"}).click();

    const result = page.getByRole("heading").filter({hasText:"scheduled!"});
    console.log(`The result text is: ${await result.textContent()}`);

    await page.close();

});