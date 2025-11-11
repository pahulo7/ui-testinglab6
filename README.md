Part 1 - Traditional Playwright Test
I made a file called TestBookstore.java inside src/test/java/playwrightTraditional/. It goes to the DePaul Bookstore site, searches for earbuds, filters the results, adds one JBL product to the cart, and removes it. The test runs in Chrome and shows that Playwright works correctly.

Part 2 - Video Recording
The test also records a video of what happens in the browser. The video is saved inside the videos folder so that I can watch everything the test did.

Part 3 - GitHub Actions
I created a GitHub repo and added a file called .github/workflows/maven.yml. It makes GitHub automatically run my tests each time I push new code. WHen i saw the green check mark I knew my tests have worked. My repo link is https://github.com/pahulo7/ui-testinglab6.

Part 4 - Playwright LLM (AI)
This paet was about Playwright’s AI tool that helps make tests using text commands. My version does not support the –use-ai flag, so I made a file called TestBookstoreAI.java to show what it would look like. I also checked https://github.com/microsoft/playwright-mcp to learn more.

What I Learned
I learned how to record Playwright tests, make and run browser tests, view test videos, use GitHub Actions to test online, and understand how Playwright AI can write tests from text.

Files in My Project
The project includes TestBookstore.java, TestBookstoreAI.java, the videos folder, the .github/workflows/maven.yml file, and the README.md file. Everything for the lab is done.