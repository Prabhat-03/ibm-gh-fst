import { test } from "@playwright/test";

test("Activity 1", async ({ page }) => {
  await page.goto("https://training-support.net");

  let title = await page.title();
  console.log(`The title of the page is: ${title}`);

  const button = page.getByRole("link").filter({ hasText: "About Us" });
  button.click();

  await page.waitForURL("**/about/");

  title = await page.title();
  console.log(`The title of the About Us page is: ${title}`);

  await page.close();
});
