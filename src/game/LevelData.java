package game;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LevelData {

    private ArrayList<Node> platforms = new ArrayList<Node>();
    private ArrayList<Node> coins = new ArrayList<Node>();



    private ArrayList<Node> monsters = new ArrayList<Node>();
    private ArrayList<Node> water = new ArrayList<Node>();
    private Pane gameRoot;

    Image Tile_1 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/1.png");
    Image Tile_2 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/2.png");
    Image Tile_3 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/3.png");
    Image Tile_4 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/4.png");
    Image Tile_5 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/5.png");
    Image Tile_6 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/6.png");
    Image Tile_7 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/7.png");
    Image Tile_8 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/8.png");
    Image Tile_9 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/9.png");
    Image Tile_a = new Image("file:src/asset/Maps/Zestaw_1/Tiles/a.png");
    Image Tile_b = new Image("file:src/asset/Maps/Zestaw_1/Tiles/b.png");
    Image Tile_c = new Image("file:src/asset/Maps/Zestaw_1/Tiles/c.png");
    Image Tile_d = new Image("file:src/asset/Maps/Zestaw_1/Tiles/d.png");
    Image Tile_e = new Image("file:src/asset/Maps/Zestaw_1/Tiles/e.png");
    Image Tile_y = new Image("file:src/asset/rozne/chest.png");
    Image Tile_x = new Image("file:src/asset/rozne/000_0041_coin5.png");
    Image Tile_m = new Image("file:src/asset/Golem_02_Jump Start_000.png");


    public LevelData(Pane gameRoot) {
        this.gameRoot = gameRoot;
    }

    public static final String[] LEVEL1 = new String[]{
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000y00000000000000",
            "0000000abc000abc00abc0000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000abc00m000000000000000000000000",
            "000000000abc0000000000000000000000",
            "00000000000000x0000000000000000000",
            "000m000000000abc0000x0000130000000",
            "0001222300000000000123000460m00000",
            "12285556991223999128569978de222300"
    };


    public Node createEntity2(int x, int y, int w, int h, Image image) {
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(new ImagePattern(image));
        entity.getProperties().put("alive", true);
        gameRoot.getChildren().add(entity);

        return entity;
    }

    public void createLevel()
    {

        for (int i = 0; i < LEVEL1.length; i++) {
            String line = LevelData.LEVEL1[i];
            for (int j = 0; j < line.length(); j++) {

                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform1 = createEntity2(j * 60, i * 60, 60, 60, Tile_1);
                        platforms.add(platform1);
                        break;
                    case '2':
                        Node platform2 = createEntity2(j * 60, i * 60, 60, 60, Tile_2);
                        platforms.add(platform2);
                        break;
                    case '3':
                        Node platform3 = createEntity2(j * 60, i * 60, 60, 60, Tile_3);
                        platforms.add(platform3);
                        break;
                    case '4':
                        Node platform4 = createEntity2(j * 60, i * 60, 60, 60, Tile_4);
                        platforms.add(platform4);
                        break;
                    case '5':
                        Node platform5 = createEntity2(j * 60, i * 60, 60, 60, Tile_5);
                        platforms.add(platform5);
                        break;
                    case '6':
                        Node platform6 = createEntity2(j * 60, i * 60, 60, 60, Tile_6);
                        platforms.add(platform6);
                        break;
                    case '7':
                        Node platform7 = createEntity2(j * 60, i * 60, 60, 60, Tile_7);
                        platforms.add(platform7);
                        break;
                    case '8':
                        Node platform8 = createEntity2(j * 60, i * 60, 60, 60, Tile_8);
                        platforms.add(platform8);
                        break;
                    case '9':
                        Node platform9 = createEntity2(j * 60, i * 60, 60, 60, Tile_9);
                        water.add(platform9);
                        break;
                    case 'a':
                        Node platforma = createEntity2(j * 60, i * 60, 60, 60, Tile_a);
                        platforms.add(platforma);
                        break;
                    case 'b':
                        Node platformb = createEntity2(j * 60, i * 60, 60, 60, Tile_b);
                        platforms.add(platformb);
                        break;
                    case 'c':
                        Node platformc = createEntity2(j * 60, i * 60, 60, 60, Tile_c);
                        platforms.add(platformc);
                        break;
                    case 'd':
                        Node platformd = createEntity2(j * 60, i * 60, 60, 60, Tile_d);
                        platforms.add(platformd);
                        break;
                    case 'e':
                        Node platforme = createEntity2(j * 60, i * 60, 60, 60, Tile_e);
                        platforms.add(platforme);
                        break;
                    case 'y':
                        Node platformy = createEntity2(j * 60, i * 70, 40, 40, Tile_y);
                        platforms.add(platformy);
                        break;
                    case 'x':
                        Node coin = createEntity2(j * 60, i * 60, 60, 60, Tile_x);
                        coins.add(coin);
                        break;
                    case 'm':
                        Node monster = createEntity2(j*60,i*60,60,60,Tile_m);
                        monsters.add(monster);
                }
            }
        }
    }

    public ArrayList<Node> getPlatforms() {
        return platforms;
    }

    public ArrayList<Node> getCoins() {
        return coins;
    }

    public ArrayList<Node> getMonster() {
        return monsters;
    }
}