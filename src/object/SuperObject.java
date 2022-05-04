package object;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;
public class SuperObject {

		public BufferedImage image,image2,image3;
		public String name;
		public boolean collision;
		public int worldX,worldY;
		public Rectangle solidArea=new Rectangle(0,0,48,48);
		public int solidAreaDefaultX=0;
		public int solidAreaDefaultY=0;
		UtilityTool uTool=new UtilityTool();
		
		public void draw(Graphics2D g2,GamePanel gp) {
			int screenX=worldX-gp.player.worldX+gp.player.screenX;
			int screenY=worldY-gp.player.worldY+gp.player.screenY;
			if(gp.player.screenX>gp.player.worldX) {
				screenX=worldX;
			}
			if(gp.player.screenY>gp.player.worldY) {
				screenY=worldY;
			}
			int rightOffset=gp.screenWidth-gp.player.screenX;
			 if(rightOffset>gp.worldWidth-gp.player.worldX) {
				 screenX=gp.screenWidth-(gp.worldWidth-worldX);
			 }
			int bottomOffset=gp.screenHeight-gp.player.screenY;
				if(bottomOffset>gp.worldHeight-gp.player.worldY) {
					screenY=gp.screenHeight- (gp.worldHeight-worldY);
			 }		
			g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null); 
	}
}