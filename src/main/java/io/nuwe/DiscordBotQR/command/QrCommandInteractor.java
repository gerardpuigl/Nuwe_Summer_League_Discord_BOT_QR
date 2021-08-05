package io.nuwe.DiscordBotQR.command;

import java.awt.Color;
import java.io.IOException;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class QrCommandInteractor implements SlashCommandCreateListener {

	@Override
	public void onSlashCommandCreate(SlashCommandCreateEvent event) {
		if (event.getSlashCommandInteraction().getCommandName().equalsIgnoreCase("qr")) {

			SlashCommandInteraction interaction = event.getSlashCommandInteraction();

			String url = interaction.getFirstOptionStringValue().get();
			String description = interaction.getSecondOptionStringValue().get();
			User username = interaction.getUser();

			try {
				EmbedBuilder embed = getEmbedBuilder(url, description, username);
				
				interaction.createImmediateResponder()
				.addEmbed(embed)				
				.respond();

			} catch (IOException e) {
				interaction.createImmediateResponder().append("Something went wrong: " + e.getMessage());
			}
		}
	}

	private EmbedBuilder getEmbedBuilder(String url, String description, User user) throws IOException {
		
		EmbedBuilder embed = new EmbedBuilder()
			    .setTitle("QR link")
			    .setDescription(description)
			    .setAuthor(user)
			    .addField("Link", url)
			    .setColor(Color.yellow)
			    .setImage("https://chart.googleapis.com/chart?cht=qr&chs=250x250&chl=" + url);

		return embed;
	}


}
