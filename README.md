# Discord Bot QR Nuwe Summer League Backend
Discord Bot that generates an embedded Discord card with a QR code from a custom URL. As optional, you can choose the color and description for this card.

<p align="center">
  <img src="https://github.com/gerardpuigl/Nuwe_Summer_League_Discord_BOT_QR/blob/main/screenshot/QR_Generator_ScreenShot_1.jpg" alt="Discord_Bot_Qr" title="Discord_Bot_Qr" width="350px"/>
</p>

## 🔨 Technology stack
- JAVA
- [Javacord](https://github.com/Javacord/Javacord)
- [Google QR Api](https://developers.google.com/chart/infographics/docs/qr_codes)

## ✔️ Task

- **Task-1:** Set up the Discord bot and install it on a server.
- **Task-2:** Configure the connection with QR API.
- **Task-3:** Create a command that, with String generate a QR code.
- **Task-4:** Implement a URL verification solution.
- **Task-5:** Create testing. (I add a slash command in the Discord bot that shows all possible options without posting them, testing the app and allowing the user to see all color options.)
- **Task-6:** Give the option to choose the QR color.

## ⚙️ How to Use

### Discord

You can install my bot in your server just with this **link**:  [Add QR_Generetor to your server](https://discord.com/api/oauth2/authorize?client_id=872553688491774013&permissions=2048&scope=bot%20applications.commands)

### Localhost

In terminal / cmd, open the application folder and run the jar + <your_dicord_bot_token>

**Important:** Your Discord bot should have allowed bot permissions, applications.commands & Sende Messages to work properly.

Example `java -jar discord_bot_qr-1.1.jar + <your_dicord_bot_token>`

## 💬 Commands

You can use this commands in inbox chat inside the server or with a MD conversation with the Bot.

### Generate QR

Generates an embedded Discord card with a QR code from a custom URL. As optional, you can choose the color and description for this card.

`/qr url:<your_custom_url> OPTIONAL color:<choose_a_color> description:<your_custom_description>`

### Show All

Show a sample of each available color. Only the user will see this response, they cannot be published:

`/show_all url:<your_custom_url>`


<p align="center">
  <img src="https://github.com/gerardpuigl/Nuwe_Summer_League_Discord_BOT_QR/blob/main/screenshot/QR_Generator_ScreenShot_2.jpeg" alt="Discord_Bot_Qr" title="Discord_Bot_Qr" width="350px"/>
</p>
