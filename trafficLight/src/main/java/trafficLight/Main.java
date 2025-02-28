package trafficLight;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import java.io.File;
import swiftbot.SwiftBotAPI;
import swiftbot.Button;
import swiftbot.ImageSize;



public class Main {

	public static void main(String[] args) {
		SwiftBotAPI API = new SwiftBotAPI();
		int[] colourLightUpRed = {255,0,0};
		int[] colourToLightUpGreen = {0,255,0};
		int[] colourToLightUpBlue = {0,0,255};

		
		//for loop to test the rgb value 
		
		BufferedImage img = API.takeStill(ImageSize.SQUARE_1080x1080);

		

		API.enableButton(Button.B, () -> {
			System.out.println("Taking Pic ;)");

			try {

				ImageIO.write(img, "jpg", new File("/data/home/pi/Images/Picture.jpg"));

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		System.out.println("\nPress 'A' on the SwiftBot to START Traffic Light Detection");
		System.out.println("Some Ascii Art");

		API.enableButton(Button.A, () -> { 
			System.out.println("Swiftbot Started Choom");
			try {



				API.fillUnderlights(colourLightUpRed);
				Thread.sleep(20000);
				API.disableUnderlights();

				API.fillUnderlights(colourToLightUpGreen);
				Thread.sleep(20000);
				API.disableUnderlights();

				API.fillUnderlights(colourToLightUpBlue);
				Thread.sleep(20000);
				API.disableUnderlights();




			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}
	//	
	//	private static void Detection() 
	//	{
	//		
	//		
	//		
	//	}
	//	



}
