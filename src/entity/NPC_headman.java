package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_headman extends Entity{
	public NPC_headman(GamePanel gp) {
		super(gp);
		direction="down";
		speed=2;
		getImage();
		collision=true;
	}
	public void setDefaultValues() {
		worldX=gp.tileSize*16;
		worldY=gp.tileSize*16;
	}
	
	public void getImage() {
		up1=setup("/npc/headman_Up1", gp.tileSize, gp.tileSize);
		up2=setup("/npc/headman_Up2", gp.tileSize, gp.tileSize);
		down2=setup("/npc/headman_Up2", gp.tileSize, gp.tileSize);
		down1=setup("/npc/headman_Up1", gp.tileSize, gp.tileSize);
		left1=setup("/npc/headman_Up1", gp.tileSize, gp.tileSize);
		left2=setup("/npc/headman_Up2", gp.tileSize, gp.tileSize);
		right1=setup("/npc/headman_Up1", gp.tileSize, gp.tileSize);
		right2=setup("/npc/headman_Up2", gp.tileSize, gp.tileSize);
	}
	public void setAction() {
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
			}
			if(i>50 && i<=75) {
				direction="left";
			}
			if(i>75 && i<=100) {
				direction = "right";
			}
			actionLockCounter=0;
		}
		
	}
	
}