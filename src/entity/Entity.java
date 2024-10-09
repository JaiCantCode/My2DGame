package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;
    public double diagonalMultiplier = 0.75;

    public BufferedImage down1,down2,down3,down4,downleft1,downleft2,downleft3,downleft4,left1,left2,left3,left4,right1,right2,right3,right4,up1,up2,up3,up4,upleft1,upleft2,upleft3,upleft4,upright1,upright2,upright3,upright4,downright1,downright2,downright3,downright4;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle hitBox;
    public boolean collisionOn = false;

}
