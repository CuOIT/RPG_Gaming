package entity;
import main.GamePanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import object.OBJ_Heart;
import object.OBJ_Rock;
public class Boar_monster extends Entity{
	GamePanel gp;
	public Boar_monster(GamePanel gp) {
        super(gp);
		this.gp = gp;
    type = monsterType;
	name = "Boar_Monster";
    defaultSpeed = 1;
	speed = defaultSpeed;
    maxLife= 4;
    life=maxLife;

    solidArea.x = 3; 
    solidArea.y= 18;
    solidArea.width = 42;
    solidArea.height = 30;
    solidAreaDefaultX = solidArea.x;
    solidAreaDefaultY = solidArea.y;

    getImage();
    }
    public void getImage(){
        up1=setup("/monster/Boar_Left_1", gp.tileSize, gp.tileSize);
		up2=setup("/monster/Boar_Right_1", gp.tileSize, gp.tileSize);
		down1=setup("/monster/Boar_Left_1", gp.tileSize, gp.tileSize);
		down2=setup("/monster/Boar_Right_2", gp.tileSize, gp.tileSize);
		left1=setup("/monster/Boar_Left_1", gp.tileSize, gp.tileSize);
		left2=setup("/monster/Boar_Left_2", gp.tileSize, gp.tileSize);
		right1=setup("/monster/Boar_Right_1", gp.tileSize, gp.tileSize);
		right2=setup("/monster/Boar_Right_2", gp.tileSize, gp.tileSize);
    }
    public void setAction(){
        actionLockCounter++;
		if(actionLockCounter==75) {
			Random random=new Random();
			int i = random.nextInt(100)+1;
			if(i<=25) {
				direction="up";
			}
			if(i>25 && i<50)
			{
				direction="down";
			//	System.out.println(distanceToPlayer());
			}
			if(i>50 && i<=75) {
				direction="left";
			}
			if(i>75 && i<=100) {
				direction = "right";
				//System.out.println(distanceToPlayer());
			}
			actionLockCounter=0;
		}

		if(distanceToPlayer()<200) pathFinding();
		else speed=1;
    }
    //Tinh khoang cach den nhan vat
    public void draw(Graphics2D g2) {
		BufferedImage image=null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldX + gp.player.screenY;
			
		switch(direction) {
		case "up":
			if(this.worldX<gp.player.worldX) {
				if(spriteNum==1) image=right1;
				if(spriteNum==2) image=right2;
			}
	    	else 
	    	{
	    		if(spriteNum==1) image=left1;
				if(spriteNum==2) image=left2;
	    	}
			break;
		case "down":
			if(this.worldX<gp.player.worldX) {
				if(spriteNum==1) image=right1;
				if(spriteNum==2) image=right2;
			}
	    	else 
	    	{
	    		if(spriteNum==1) image=left1;
				if(spriteNum==2) image=left2;
	    	}
			break;
		case "left":
			if(spriteNum==1)
				image=left1;
				if(spriteNum==2)
					image=left2;
			break;
		case "right":
			if(spriteNum==1)
				image=right1;
				if(spriteNum==2)
					image=right2;
			break;
		}

		if(invincible == true){
			hpBarOn = true;
			hpBarCounter = 0;
			changeAlpha(g2, 0.4F);
		}
		if(dying == true){
			dyingAnimation(g2);
		}
	
		screenX=worldX-gp.player.worldX+gp.player.screenX;
		screenY=worldY-gp.player.worldY+gp.player.screenY;
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
		 // THEM TU DONG  THANH MAU CUA CON QUAI(DANG)
		 if(hpBarOn == true ){
			double oneScale = (double)gp.tileSize/maxLife;
			double hpBarValue = oneScale*life;

			g2.setColor(new Color(35, 35, 35));
			g2.fillRect(screenX -1, screenY - 16, gp.tileSize +2, 12);
			
			g2.setColor(new Color(255,0,30));
			g2.fillRect(screenX , screenY - 15, (int)hpBarValue, 10);
			
			hpBarCounter++;

			if(hpBarCounter > 1000){
				hpBarCounter = 0;
				hpBarOn = false;
			}
		}	
		
		g2.drawImage(image,screenX,screenY,width,height,null); 
	
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		changeAlpha(g2,1F);
		// HET BO SUNG(DANG)
	// bo sung hieu ung quai chet di tu 194-231(DANG)
	}
    public double distanceToPlayer(){
    	return Math.sqrt(Math.pow(this.worldX-gp.player.worldX,2)+Math.pow(this.worldY-gp.player.worldY,2));
    }
    public void pathFinding() {
    	this.speed=4;
    	if(Math.abs(this.worldY-gp.player.worldY)>10) {
    	if(this.worldY<gp.player.worldY) direction="down";
    	else direction="up";
    	}
    	else if(this.worldX<gp.player.worldX) direction="right";
    	else direction="left";
    	
    }

    public void damageReaction(){
	actionLockCounter = 0;
	direction = gp.player.direction;

}	
	public void checkDrop(){
		// cast a die(Dang)
		//int i = new Random().nextInt(100);

		// set the monster drop
		dropItem(new OBJ_Heart(gp));
	}
}


