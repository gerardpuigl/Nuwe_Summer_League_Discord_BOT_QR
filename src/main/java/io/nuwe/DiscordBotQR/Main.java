package io.nuwe.DiscordBotQR;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import io.nuwe.DiscordBotQR.command.CreateCommands;
import io.nuwe.DiscordBotQR.command.QrCommandInteractor;
import io.nuwe.DiscordBotQR.command.QrCommandMessage;
import io.nuwe.DiscordBotQR.command.TestInteractor;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
    	String token;
    	try {
            token = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			token = System.getenv().get("DICORD_TOKEN");
			if(token == null) logger.error("Please provide a valid token as the first argument!");
			return;
		} 
    	
        // Enable debugging, if no slf4j logger was found
        FallbackLoggerConfiguration.setDebug(true);

        // The token from your discord bot

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Generatd commands when the bood enter in a server
        api.addServerJoinListener( new CreateCommands(api));

        // Add listeners
        api.addMessageCreateListener(new QrCommandMessage());
        api.addSlashCommandCreateListener(new TestInteractor());
        api.addSlashCommandCreateListener(new QrCommandInteractor());

        // Log a message, if the bot joined or left a server
        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));

        // Print the invite url of the bot
        logger.info("You can invite me by using the following url: " + api.createBotInvite());       
    }

}
