package io.nuwe.DiscordBotQR.command;

import java.util.Arrays;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionType;
import org.javacord.api.listener.server.ServerJoinListener;

public class CreateCommands implements ServerJoinListener {

	DiscordApi api;

	public CreateCommands(DiscordApi api) {
		this.api = api;
	}

	@Override
	public void onServerJoin(ServerJoinEvent event) {
		SlashCommand.with("qr", "get QR with your url",
			Arrays.asList(SlashCommandOption.create(SlashCommandOptionType.STRING, "url","Add the url that you want to convert in qr", true),
							SlashCommandOption.create(SlashCommandOptionType.STRING, "description","Add the messege over your qr", false),
							SlashCommandOption.create(SlashCommandOptionType.STRING, "color","Choose the color for your QR", false)))
		.createGlobal(api).join();
	}

}
