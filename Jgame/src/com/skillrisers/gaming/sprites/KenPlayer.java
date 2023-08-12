package com.skillrisers.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KenPlayer extends Sprite {
	BufferedImage damageEffectImages[] = new BufferedImage[5];
	private BufferedImage walkImages [] = new BufferedImage[6];
	private BufferedImage kickImages[] = new BufferedImage[6]; 
	private BufferedImage punchImages[] = new BufferedImage[6]; 
	private BufferedImage handhImages[] = new BufferedImage[6];
	public KenPlayer() throws IOException {
		x = GWIDTH - 400;
		h = 200;
		w = 200;
		y = FLOOR - h;
		imageIndex = 0;
		currentMove = WALK;
		speed = 0;
		image = ImageIO.read(KenPlayer.class.getResource(KEN_IMAGE));
		loadDamageEffect();
		loadWalkImages();
		loadKickImages();
		loadPunchImages();
		loadHandhImages();
	}
	
	public void loadDamageEffect() {
		damageEffectImages[0]  = image.getSubimage(1365,3276,65,95);
		damageEffectImages[1]  = image.getSubimage(1437,3271,88,99);
		damageEffectImages[2]  = image.getSubimage(1537,3278,75,91);
		damageEffectImages[3]  = image.getSubimage(1627,3277,70,92);
		damageEffectImages[4]  = image.getSubimage(1712	,3274,63,98);
	}
	public void jump() {
		if(!isJump) {
		isJump = true;
		force = -20;
		y = y + force;
		}
	}
	
	public void fall() {
		if(y>=(FLOOR-h)) {
			isJump = false;
			return ;
		}
		y = y + force;
		force = force + GRAVITY;
	}
	
	private void loadWalkImages() {
		walkImages[0]  = image.getSubimage(1690,682,62,102);
		walkImages[1]  = image.getSubimage(1755,683,69,97);
		walkImages[2]  = image.getSubimage(1825,680,69,104);
		walkImages[3]  = image.getSubimage(1895,679,65,102);
		walkImages[4]  = image.getSubimage(1967,678,61,102);
		walkImages[5]  = image.getSubimage(1620,680,62,102);
	}
	
	private void loadKickImages() {
		kickImages[0] = image.getSubimage(1617,1561,72,97);
		kickImages[1] = image.getSubimage(1689,1564,68,103);
		kickImages[2] = image.getSubimage(1768,1563,71,97);
		kickImages[3] = image.getSubimage(1836,1563,123,100);
		kickImages[4] = image.getSubimage(1966,1561,71,102);
		kickImages[5] = image.getSubimage(2032,1563,65,102);
	}
	
	private void loadPunchImages() {
		punchImages[0] = image.getSubimage(1372,1148,76,105);
		punchImages[1] = image.getSubimage(1444,1146,69,102);
		punchImages[2] = image.getSubimage(1514,1144,73,105);
		punchImages[3] = image.getSubimage(1589,1147,79,100);
		punchImages[4] = image.getSubimage(1661,1144,119,105);
		punchImages[5] = image.getSubimage(1778,1144,85,104);
	}
	
	private void loadHandhImages() {
		handhImages[0] = image.getSubimage(2016,2742,81,96);
		handhImages[1] = image.getSubimage(1913,2743,99,92);
		handhImages[2] = image.getSubimage(1808,2745,108,88);
		handhImages[3] = image.getSubimage(1692,2750,123,83);
		handhImages[4] = image.getSubimage(1644,2745,163,91);
		handhImages[5] = image.getSubimage(1816,2747,93,87);
	}
	
	private BufferedImage printWalk() {
		if(imageIndex>5) {
			imageIndex=0;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}
	private BufferedImage printKick() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = WALK;
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}
	private BufferedImage printPunch() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = WALK;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}
	private BufferedImage printHandh() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove = HANDh;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}
	
	public BufferedImage printDamageImage() {
		if(imageIndex>damageEffectImages.length-1) {
			imageIndex = 0;
			currentMove = WALK;
		}
		BufferedImage img =  damageEffectImages[imageIndex];
		imageIndex++;
		return img;
		
	}
	
	/*@Override
	public BufferedImage defaultImage() {
		if(currentMove == WALK)
		return   image.getSubimage(1756,685,62,94);
		else {
			return printDamageImage();
		}
	}*/
	@Override
	public BufferedImage defaultImage() {
		 if(currentMove == KICK) {
			return printKick();
		}
		 else if (currentMove == PUNCH) {
			 return printPunch();
		 }
		 else if (currentMove == HANDh) {
			 return printHandh();
		 }
		 else if (currentMove == WALK) {
			 return printWalk();
		 }
		 else {
			 return printDamageImage();
		 }
	}
	
}
