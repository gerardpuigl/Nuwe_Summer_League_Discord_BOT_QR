package io.nuwe.DiscordBotQR.command;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class QrCommandMessage implements MessageCreateListener {
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if (event.getMessageContent().startsWith("!qr")) {
			String url = event.getMessageContent().replace("!qr ", "");

			try {
				MessageBuilder messageBuilder = getMessageBuilder(url, null);
				messageBuilder.send(event.getChannel());
			} catch (IOException e) {
				event.getChannel().sendMessage("Something went wrong: " + e.getMessage());
			}
		}
	}

	private MessageBuilder getMessageBuilder(String url, String description) throws IOException {
		MessageBuilder messageBuilder;
		
		URL goolgeApiUrl = new URL("https://chart.googleapis.com/chart?cht=qr&chs=250x250&chl=" + url);
		BufferedImage image = ImageIO.read(goolgeApiUrl);
		
		
		if (description == null)
			description = url;

		messageBuilder = new MessageBuilder()
				.append("Aquí puedes ver mi QR de " + description)
				.addAttachment(image, url + ".png");

		return messageBuilder;
	}

}
