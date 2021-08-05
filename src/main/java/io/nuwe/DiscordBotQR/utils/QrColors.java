package io.nuwe.DiscordBotQR.utils;

import java.awt.Color;

public enum QrColors {
	
	NUWE("659859"),
//	GREEN("0b730b"),
	RED("b22626"),
	PINK("eb9696"),
	ORANGE("ffc800"),
	YELLOW("d4d41c"),
	MAGENTA("b52ab5"),
	CYAN("21c2c2"),
//	BLUE("0f0fc4"),
//	GRAY("808080"),
	DARK_GRAY("404040"),
	BLACK("000000");

	private final String code;

	QrColors(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static String getCode(String color) {
		QrColors[] allColors = QrColors.values();
		for (QrColors qrColor : allColors) {
			if (color.equalsIgnoreCase(qrColor.name())) {
				return qrColor.getCode();
			}
		}
		return "00000";
	}
	
	public static Color getRGBfromHexCode(String colorCode) {
	    return new Color(
	            Integer.valueOf( colorCode.substring( 0, 2 ), 16 ),
	            Integer.valueOf( colorCode.substring( 2, 4 ), 16 ),
	            Integer.valueOf( colorCode.substring( 4, 6 ), 16 ) );
	}
		
}
