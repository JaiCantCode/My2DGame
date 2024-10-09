package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        hitBox = new Rectangle(8,16,32,32);

        setDefaultValues();
        getPlayerImage();

    }
    public void setDefaultValues() {
        worldX = 100;
        worldY = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {

        try {
            down1 = getImage("/player/WizardSprite/Images/WizardDown0.png");
            down2 = getImage("/player/WizardSprite/Images/WizardDown1.png");
            down3 = getImage("/player/WizardSprite/Images/WizardDown2.png");
            down4 = getImage("/player/WizardSprite/Images/WizardDown3.png");
            downleft1 = getImage("/player/WizardSprite/Images/WizardDownLeft0.png");
            downleft2 = getImage("/player/WizardSprite/Images/WizardDownLeft1.png");
            downleft3 = getImage("/player/WizardSprite/Images/WizardDownLeft2.png");
            downleft4 = getImage("/player/WizardSprite/Images/WizardDownLeft3.png");
            downright1 = getImage("/player/WizardSprite/Images/WizardDownRight0.png");
            downright2 = getImage("/player/WizardSprite/Images/WizardDownRight1.png");
            downright3 = getImage("/player/WizardSprite/Images/WizardDownRight2.png");
            downright4 = getImage("/player/WizardSprite/Images/WizardDownRight3.png");
            left1 = getImage("/player/WizardSprite/Images/WizardLeft0.png");
            left2 = getImage("/player/WizardSprite/Images/WizardLeft1.png");
            left3 = getImage("/player/WizardSprite/Images/WizardLeft2.png");
            left4 = getImage("/player/WizardSprite/Images/WizardLeft3.png");
            right1 = getImage("/player/WizardSprite/Images/WizardRight0.png");
            right2 = getImage("/player/WizardSprite/Images/WizardRight1.png");
            right3 = getImage("/player/WizardSprite/Images/WizardRight2.png");
            right4 = getImage("/player/WizardSprite/Images/WizardRight3.png");
            up1 = getImage("/player/WizardSprite/Images/WizardUp0.png");
            up2 = getImage("/player/WizardSprite/Images/WizardUp1.png");
            up3 = getImage("/player/WizardSprite/Images/WizardUp2.png");
            up4 = getImage("/player/WizardSprite/Images/WizardUp3.png");
            upleft1 = getImage("/player/WizardSprite/Images/WizardUpLeft0.png");
            upleft2 = getImage("/player/WizardSprite/Images/WizardUpLeft1.png");
            upleft3 = getImage("/player/WizardSprite/Images/WizardUpLeft2.png");
            upleft4 = getImage("/player/WizardSprite/Images/WizardUpLeft3.png");
            upright1 = getImage("/player/WizardSprite/Images/WizardUpRight0.png");
            upright2 = getImage("/player/WizardSprite/Images/WizardUpRight1.png");
            upright3 = getImage("/player/WizardSprite/Images/WizardUpRight2.png");
            upright4 = getImage("/player/WizardSprite/Images/WizardUpRight3.png");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage(String name) throws IOException { return ImageIO.read(getClass().getResourceAsStream(name));}
    public void update() {

        switch (keyH.upPressed + "-" + keyH.downPressed + "-" + keyH.leftPressed + "-" + keyH.rightPressed) {
            case "true-false-false-false", "true-false-true-true" -> {
                direction = "up";
                keyH.pressed = true;
            }
            case "false-true-false-false", "false-true-true-true" -> {
                direction = "down";
                keyH.pressed = true;
            }
            case "false-false-true-false", "true-true-true-false" -> {
                direction = "left";
                keyH.pressed = true;
            }
            case "false-false-false-true", "true-true-false-true" -> {
                direction = "right";
                keyH.pressed = true;
            }
            case "true-false-true-false" -> {
                direction = "upleft";
                keyH.pressed = true;
            }
            case "true-false-false-true" -> {
                direction = "upright";
                keyH.pressed = true;
            }
            case "false-true-true-false" -> {
                direction = "downleft";
                keyH.pressed = true;
            }
            case "false-true-false-true" -> {
                direction = "downright";
                keyH.pressed = true;
            }
            case "false-false-false-false" -> keyH.pressed = false;
        }

        //Check Tile Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(keyH.pressed && !collisionOn) {
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
                case "upleft" -> { worldX -= speed * diagonalMultiplier; worldY -= speed * diagonalMultiplier; }
                case "upright" -> { worldX += speed * diagonalMultiplier; worldY -= speed * diagonalMultiplier; }
                case "downleft" -> { worldX -= speed * diagonalMultiplier; worldY += speed * diagonalMultiplier; }
                case "downright" -> { worldX += speed * diagonalMultiplier; worldY += speed * diagonalMultiplier; }
            }
        }
        if(keyH.pressed && collisionOn && gp.cChecker.collisionSide != null) {
            switch (direction) {
                case "upleft" -> {
                    if(gp.cChecker.collisionSide.equals("left")) worldY -= speed * diagonalMultiplier;
                    else worldX -= speed * diagonalMultiplier;
                }
                case "upright" -> {
                    if(gp.cChecker.collisionSide.equals("right")) worldY -= speed * diagonalMultiplier;
                    else worldX += speed * diagonalMultiplier;
                }
                case "downleft" -> {
                    if(gp.cChecker.collisionSide.equals("left")) worldY += speed * diagonalMultiplier;
                    else worldX -= speed * diagonalMultiplier;
                }
                case "downright" -> {
                    if(gp.cChecker.collisionSide.equals("right")) worldY += speed * diagonalMultiplier;
                    else worldX += speed * diagonalMultiplier;
                }
            }
        }


        if(keyH.downPressed || keyH.leftPressed || keyH.upPressed || keyH.rightPressed)  {
            spriteCounter++;
            if (spriteCounter > 5) {
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }else{
            spriteNum = 1;
        }
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.RED);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "up" :
                if(spriteNum == 1) image = up1;
                if(spriteNum == 2) image = up2;
                if(spriteNum == 3) image = up3;
                if(spriteNum == 4) image = up4;
                break;
            case "down" :
                if(spriteNum == 1) image = down1;
                if(spriteNum == 2) image = down2;
                if(spriteNum == 3) image = down3;
                if(spriteNum == 4) image = down4;
                break;
            case "left" :
                if(spriteNum == 1) image = left1;
                if(spriteNum == 2) image = left2;
                if(spriteNum == 3) image = left3;
                if(spriteNum == 4) image = left4;
                break;
            case "right" :
                if(spriteNum == 1) image = right1;
                if(spriteNum == 2) image = right2;
                if(spriteNum == 3) image = right3;
                if(spriteNum == 4) image = right4;
                break;
            case "upleft" :
                if(spriteNum == 1) image = upleft1;
                if(spriteNum == 2) image = upleft2;
                if(spriteNum == 3) image = upleft3;
                if(spriteNum == 4) image = upleft4;
                break;
            case "upright" :
                if(spriteNum == 1) image = upright1;
                if(spriteNum == 2) image = upright2;
                if(spriteNum == 3) image = upright3;
                if(spriteNum == 4) image = upright4;
                break;
            case "downleft" :
                if(spriteNum == 1) image = downleft1;
                if(spriteNum == 2) image = downleft2;
                if(spriteNum == 3) image = downleft3;
                if(spriteNum == 4) image = downleft4;
                break;
            case "downright" :
                if(spriteNum == 1) image = downright1;
                if(spriteNum == 2) image = downright2;
                if(spriteNum == 3) image = downright3;
                if(spriteNum == 4) image = downright4;
                break;
        }
        g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize,null);
    }
}
