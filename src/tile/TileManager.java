package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TileManager {
    GamePanel gp;
    /*
    public Tile[] tile;
    public int[][] mapTileNum;
    */
    public Map<Character, Tile> tile;
    public char[][] mapTileVal;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        /*
        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
         */

        tile = new HashMap<>();
        mapTileVal = new char[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/map02.txt");
    }

    public void getTileImage() {
        try {
            /*
            tile[0] = new Tile();
            tile[0].image = getImage("/tiles/floor/outBounds.png");
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = getImage("/tiles/wall/leftWall1.png");
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = getImage("/tiles/wall/rightWall1.png");
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = getImage("/tiles/wall/topWall2.png");
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = getImage("/tiles/wall/bottomWall1.png");
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = getImage("/tiles/floor/floor7.png");

            tile[6] = new Tile();
            tile[6].image = getImage("/tiles/wall/bottomLeftWall.png");
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = getImage("/tiles/wall/bottomRightWall.png");
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = getImage("/tiles/wall/leftPassageWall.png");
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = getImage("/tiles/wall/rightPassageWall.png");
            tile[9].collision = true;
            */
            /*
            tile[0] = new Tile();
            tile[0].image = getImage("/tiles/wall/topLeftWall.png");
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = getImage("/tiles/wall/topRightWall.png");
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = getImage("/tiles/wall/bottomLeftWall.png");
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = getImage("/tiles/wall/bottomRightWall.png");
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = getImage("/tiles/floor/topLeftFloor.png");

            tile[5] = new Tile();
            tile[5].image = getImage("/tiles/floor/topRightFloor.png");

            tile[6] = new Tile();
            tile[6].image = getImage("/tiles/floor/bottomLeftFloor.png");

            tile[7] = new Tile();
            tile[7].image = getImage("/tiles/floor/bottomRightFloor.png");

            tile[8] = new Tile();
            tile[8].image = getImage("/tiles/floor/rightFloor.png");

            tile[9] = new Tile();
            tile[9].image = getImage("/tiles/floor/leftFloor.png");

            tile[10] = new Tile();
            tile[10].image = getImage("/tiles/floor/bottomFloor1.png");

            tile[11] = new Tile();
            tile[11].image = getImage("/tiles/floor/bottomFloor2.png");

            tile[12] = new Tile();
            tile[12].image = getImage("/tiles/floor/topFloor1.png");

            tile[13] = new Tile();
            tile[13].image = getImage("/tiles/floor/topFloor2.png");

            tile[14] = new Tile();
            tile[14].image = getImage("/tiles/wall/rightWall1.png");
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = getImage("/tiles/wall/rightWall2.png");
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = getImage("/tiles/wall/leftWall1.png");
            tile[16].collision = true;

            tile[17] = new Tile();
            tile[17].image = getImage("/tiles/wall/leftWall2.png");
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = getImage("/tiles/wall/topWall1.png");
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = getImage("/tiles/wall/topWall2.png");
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = getImage("/tiles/wall/topWall3.png");
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = getImage("/tiles/wall/bottomWall1.png");
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = getImage("/tiles/wall/bottomWall2.png");
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = getImage("/tiles/floor/floor1.png");

            tile[24] = new Tile();
            tile[24].image = getImage("/tiles/floor/floor2.png");

            tile[25] = new Tile();
            tile[25].image = getImage("/tiles/floor/floor3.png");

            tile[26] = new Tile();
            tile[26].image = getImage("/tiles/floor/floor4.png");

            tile[27] = new Tile();
            tile[27].image = getImage("/tiles/floor/floor5.png");

            tile[28] = new Tile();
            tile[28].image = getImage("/tiles/floor/floor6.png");

            tile[29] = new Tile();
            tile[29].image = getImage("/tiles/floor/floor7.png");

            tile[30] = new Tile();
            tile[30].image = getImage("/tiles/wall/leftPassageWall.png");

            tile[31] = new Tile();
            tile[31].image = getImage("/tiles/wall/rightPassageWall.png");

            tile[32] = new Tile();
            tile[32].image = getImage("/tiles/floor/outBounds.png");
            */
            tile.put('0' , new Tile());
            tile.get('0').image = getImage("/tiles/floor/outBounds.png");
            tile.get('0').collision = true;

            tile.put('1' , new Tile());
            tile.get('1').image = getImage("/tiles/wall/leftWall1.png");
            tile.get('1').collision = true;

            tile.put('2' , new Tile());
            tile.get('2').image = getImage("/tiles/wall/rightWall1.png");
            tile.get('2').collision = true;

            tile.put('3' , new Tile());
            tile.get('3').image = getImage("/tiles/wall/topWall2.png");
            tile.get('3').collision = true;

            tile.put('4' , new Tile());
            tile.get('4').image = getImage("/tiles/wall/bottomWall1.png");
            tile.get('4').collision = true;

            tile.put('5' , new Tile());
            tile.get('5').image = getImage("/tiles/floor/floor7.png");

            tile.put('6' , new Tile());
            tile.get('6').image = getImage("/tiles/wall/bottomLeftWall.png");
            tile.get('6').collision = true;

            tile.put('7' , new Tile());
            tile.get('7').image = getImage("/tiles/wall/bottomRightWall.png");
            tile.get('7').collision = true;

            tile.put('8' , new Tile());
            tile.get('8').image = getImage("/tiles/wall/leftPassageWall.png");
            tile.get('8').collision = true;

            tile.put('9' , new Tile());
            tile.get('9').image = getImage("/tiles/wall/rightPassageWall.png");
            tile.get('9').collision = true;
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
    public BufferedImage getImage(String name) throws IOException { return ImageIO.read(getClass().getResourceAsStream(name));}

    public void loadMap(String filePath){

        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            /*
            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while(col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            */
            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while(col < gp.maxWorldCol) {
                    String[] values = line.split(" ");
                    char val = values[col].charAt(0);
                    mapTileVal[col][row] = val;
                    col++;
                }
                if(col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            br.close();

        }catch(Exception e) {

        }
    }

    public void draw(Graphics2D g2) {


        int worldCol = 0;
        int worldRow = 0;
        /*
        while (worldCol < gp.maxWorldCol & worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
        */
        while (worldCol < gp.maxWorldCol & worldRow < gp.maxWorldRow) {
            char tileNum = mapTileVal[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile.get(tileNum).image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
