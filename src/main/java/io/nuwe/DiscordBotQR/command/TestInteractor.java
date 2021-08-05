package io.nuwe.DiscordBotQR.command;

import java.net.MalformedURLException;

import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

import io.nuwe.DiscordBotQR.utils.QrColors;
import io.nuwe.DiscordBotQR.utils.Validator;

public class TestInteractor implements SlashCommandCreateListener {

	@Override
	public void onSlashCommandCreate(SlashCommandCreateEvent event) {
		if (event.getSlashCommandInteraction().getCommandName().equalsIgnoreCase("show_all")) {

			SlashCommandInteraction interaction = event.getSlashCommandInteraction();

			try {
//					interaction.respondLater();
					
					EmbedBuilder[] embeds = getTestAll(interaction);
					
					interaction.createImmediateResponder()//.createFollowupMessageBuilder()
					.addEmbeds(embeds)
					.setFlags(MessageFlag.EPHEMERAL)
					.respond();
			} catch (Exception e) {
				interaction
				.createImmediateResponder()
				.append("Something went wrong: " + e.getMessage())
				.setFlags(MessageFlag.EPHEMERAL)
				.respond();
			}
		}
	}

	private EmbedBuilder[] getTestAll(SlashCommandInteraction interaction) throws MalformedURLException {
		
		String url = interaction.getFirstOptionStringValue().get();
		Validator.validateURL(url);
		
		QrColors[] allColors = QrColors.values();
		EmbedBuilder[] embeds = new EmbedBuilder[allColors.length];
		
		User user = interaction.getUser();
				
		for (QrColors qrColor : allColors) {
			
			String colorCode = qrColor.getCode();
			
			EmbedBuilder embed = new EmbedBuilder()
					.setTitle("QR link")
					.setDescription(qrColor.toString())
					.setAuthor(user).addInlineField("Link", url)
					// .setColor(QrColors.getRGBfromHexCode("303136"))
					.setColor(QrColors.getRGBfromHexCode(colorCode))
					.setImage("https://chart.googleapis.com/chart?cht=qr&chs=300x200&chld=L&chco=" + colorCode + "&chl="+ url);
			
			embeds[qrColor.ordinal()] = embed;
		}
		return embeds;
	}
}
