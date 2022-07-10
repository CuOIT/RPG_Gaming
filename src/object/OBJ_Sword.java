package object;



import entity.Entity;
import main.GamePanel;
public class OBJ_Sword extends Object{
	public OBJ_Sword(GamePanel gp) {
	super(gp);
	name="Sword";
	down1=setup("/objects/sword",gp.TILE_SIZE,gp.TILE_SIZE);
	description = "[" + name + "]\nA powerful sword.";
	knockBackPower = 10;
	attack=3;
	stackable=true;

}
}

