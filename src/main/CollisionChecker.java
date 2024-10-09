package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public String collisionSide;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;
        int entityBottomWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        char tileNum1, tileNum2, tileNum3;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileVal[entityRightCol][entityTopRow];
                if (gp.tileM.tile.get(tileNum1).collision || gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileVal[entityRightCol][entityBottomRow];
                if (gp.tileM.tile.get(tileNum1).collision || gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileVal[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile.get(tileNum1).collision || gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileVal[entityRightCol][entityBottomRow];
                if (gp.tileM.tile.get(tileNum1).collision || gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                }
            }
            case "upleft" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileVal[entityRightCol][entityTopRow];
                tileNum3 = gp.tileM.mapTileVal[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile.get(tileNum1).collision && gp.tileM.tile.get(tileNum2).collision && gp.tileM.tile.get(tileNum3).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }else if (gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                    collisionSide = "up";
                }else if (gp.tileM.tile.get(tileNum3).collision) {
                    entity.collisionOn = true;
                    collisionSide = "left";
                }else if(gp.tileM.tile.get(tileNum1).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }

            }
            case "upright" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum2 = gp.tileM.mapTileVal[entityLeftCol][entityTopRow];
                tileNum1 = gp.tileM.mapTileVal[entityRightCol][entityTopRow];
                tileNum3 = gp.tileM.mapTileVal[entityRightCol][entityBottomRow];
                if(gp.tileM.tile.get(tileNum1).collision && gp.tileM.tile.get(tileNum2).collision && gp.tileM.tile.get(tileNum3).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }else if (gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                    collisionSide = "up";
                }else if (gp.tileM.tile.get(tileNum3).collision) {
                    entity.collisionOn = true;
                    collisionSide = "right";
                }else if(gp.tileM.tile.get(tileNum1).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }
            }
            case "downleft" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileVal[entityRightCol][entityBottomRow];
                tileNum3 = gp.tileM.mapTileVal[entityLeftCol][entityTopRow];
                if(gp.tileM.tile.get(tileNum1).collision && gp.tileM.tile.get(tileNum2).collision && gp.tileM.tile.get(tileNum3).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }else if (gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                    collisionSide = "down";
                }else if (gp.tileM.tile.get(tileNum3).collision) {
                    entity.collisionOn = true;
                    collisionSide = "left";
                }else if(gp.tileM.tile.get(tileNum1).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }
            }
            case "downright" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileVal[entityRightCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileVal[entityLeftCol][entityBottomRow];
                tileNum3 = gp.tileM.mapTileVal[entityRightCol][entityTopRow];
                if(gp.tileM.tile.get(tileNum1).collision && gp.tileM.tile.get(tileNum2).collision && gp.tileM.tile.get(tileNum3).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }else if (gp.tileM.tile.get(tileNum2).collision) {
                    entity.collisionOn = true;
                    collisionSide = "down";
                }else if (gp.tileM.tile.get(tileNum3).collision) {
                    entity.collisionOn = true;
                    collisionSide = "right";
                }else if(gp.tileM.tile.get(tileNum1).collision){
                    entity.collisionOn = true;
                    collisionSide = null;
                }
            }
        }
    }
}
