import { expect, test } from "@playwright/test";

test("Activity 4", async ({ page }) => {
    await page.goto("https://training-support.net/webelements/drag-drop");
    const title = await page.title();
    console.log(`The title of the page is: ${title}`);
	
    const ball = page.getByTestId("ball");
    const dz1 = page.getByTestId("dropzone1");
    const dz2 = page.getByTestId("dropzone2");

    await ball.dragTo(dz1);
    await expect(dz1).toHaveText(/Dropped/);

    await ball.dragTo(dz2);
    await expect(dz2).toHaveText(/Dropped/);

    await page.close();

});