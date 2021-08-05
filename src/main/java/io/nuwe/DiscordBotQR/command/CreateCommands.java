package io.nuwe.DiscordBotQR.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionChoice;
import org.javacord.api.interaction.SlashCommandOptionType;
import org.javacord.api.listener.server.ServerJoinListener;

import io.nuwe.DiscordBotQR.utils.QrColors;

public class CreateCommands implements ServerJoinListener {

	DiscordApi api;

	public CreateCommands(DiscordApi api) {
		this.api = api;
	}

	@Override
	public void onServerJoin(ServerJoinEvent event) {
		//create the command "/qr"
		SlashCommand.with("qr", "get QR with your url",
			Arrays.asList(
					//create mandatory request "url" 
					SlashCommandOption.create(SlashCommandOptionType.STRING, "url","Add the url that you want to convert in QR", true),
					//create option request "color" with options
					SlashCommandOption.createWithChoices(SlashCommandOptionType.STRING, "color","Choose the color for your QR", false, getOptionList()),
					//create option description
					SlashCommandOption.create(SlashCommandOptionType.STRING, "description","Add the messege over your QR", false)
					))
		.createGlobal(api)
		.join();
		
		SlashCommand.with("show_all", "show a sample of all colors available",
				Arrays.asList(
						//create mandatory request "url" 
						SlashCommandOption.create(SlashCommandOptionType.STRING, "url","Add the url that you want to convert in QR", true)
						))
			.createGlobal(api)
			.join();
	}
	
	
	private List<SlashCommandOptionChoice> getOptionList() {
		QrColors[] allColors = QrColors.values();
		return Arrays.asList(allColors).stream()
		.map(c -> SlashCommandOptionChoice.create(c.toString(), c.toString()))
		.collect(Collectors.toList());
		
	}

}
