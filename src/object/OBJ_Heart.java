package object;
import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		name="Heart";
		image=setup("/objects/hp_full",gp.tileSize,gp.tileSize);
		image2=setup("/objects/hp_half",gp.tileSize,gp.tileSize);
		image3=setup("/objects/hp_plank",gp.tileSize,gp.tileSize);
		
}
}




