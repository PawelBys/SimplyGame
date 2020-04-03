package game;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class PlatformGame extends Application {

        private HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
        private ArrayList<Node> shot = new ArrayList<Node>();
        Label label = new Label("SCORE");
        StringBuilder your_score = new StringBuilder(label.getText());
        int score = 0;

        private Pane appRoot = new Pane();
        private Pane gameRoot = new Pane();
        private Pane uiRoot = new Pane();


        private Node player;
        private Node skills;

        private Point2D playerVelocity = new Point2D(0, 0);

        private boolean canJump = true;

        private int levelWidth;

        private boolean dialogEvent = false, running = true;

        private String USER;
        private String HERO;
        private String src;


        int offset_aktualny;
        int offset_poczatkowy = 0;


        Image tlo = new Image("file:src/asset/Maps/background/game_background_2.png");

        int k = 0;

        public Image PLAYER_IMG;
        public Image[] HeroLeft = new Image[3];
        public Image[] HeroRight = new Image[3];
        public Image HeroStay;

        public boolean skill_limited = true;
        public boolean skill_enabled = false;
        public boolean monster_moved = true;

        LevelData levelData = new LevelData(gameRoot);


        public void setUser(String User){
            this.USER = User;
        }

        public void setHero(String hero){
            this.HERO = hero;
            switch(hero){
                case "Jenny":
                    src = "file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/character_femaleAdventurer_wide.png";
                    HeroLeft[0] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run0.png");
                    HeroLeft[1] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run1.png");
                    HeroLeft[2] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run2.png");

                    HeroRight[0] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run0.png");
                    HeroRight[1] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run1.png");
                    HeroRight[2] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run2.png");

                    HeroStay = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/character_femaleAdventurer_hold 2.png");
                    break;
                case "Jonny":
                    src = "file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/character_maleAdventurer_wide.png";
                    HeroLeft[0] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run0.png");
                    HeroLeft[1] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run1.png");
                    HeroLeft[2] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run2.png");

                    HeroRight[0] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run0.png");
                    HeroRight[1] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run1.png");
                    HeroRight[2] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run2.png");

                    HeroStay = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/character_maleAdventurer_hold 2.png");
                    break;
                case "Bob":
                    src = "file:src/asset/postacie/Male person 2/PNG/Poses HD/character_malePerson_wide.png";
                    HeroLeft[0] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run0.png");
                    HeroLeft[1] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run1.png");
                    HeroLeft[2] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run2.png");

                    HeroRight[0] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run0.png");
                    HeroRight[1] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run1.png");
                    HeroRight[2] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run2.png");

                    HeroStay = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/character_malePerson_hold 2.png");
                    break;
                case "Amy":
                    src = "file:src/asset/postacie/Female person 2/PNG/Poses HD/character_femalePerson_hold.png";

                    HeroLeft[0] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run0.png");
                    HeroLeft[1] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run1.png");
                    HeroLeft[2] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run2.png");

                    HeroRight[0] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run0.png");
                    HeroRight[1] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run1.png");
                    HeroRight[2] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run2.png");

                    HeroStay = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/character_femalePerson_hold.png");

                    break;
                case "Zulu":
                    src = "file:src/asset/postacie/Zombie 2/PNG/Poses HD/character_zombie_wide.png";
                    HeroLeft[0] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run0.png");
                    HeroLeft[1] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run1.png");
                    HeroLeft[2] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run2.png");

                    HeroRight[0] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run0.png");
                    HeroRight[1] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run1.png");
                    HeroRight[2] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run2.png");

                    HeroStay = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/character_zombie_duck.png");


                    break;
                case "Fred":
                    src = "file:src/asset/postacie/Robot 2/PNG/Poses HD/character_robot_wide.png";
                    HeroLeft[0] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run0.png");
                    HeroLeft[1] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run1.png");
                    HeroLeft[2] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run2.png");

                    HeroRight[0] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run0.png");
                    HeroRight[1] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run1.png");
                    HeroRight[2] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run2.png");

                    HeroStay = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/character_robot_hold 2.png");
                    break;
            }
            PLAYER_IMG = new Image(src);
        }


        private void initContent() {
            System.out.println(USER);
            System.out.println(HERO);

            Rectangle bg = new Rectangle(1280, 720);
            bg.setFill(new ImagePattern(tlo));

            levelWidth = 34 * 60;

            levelData.createLevel2();

            player = createEntity(0, 600, 60, 55, PLAYER_IMG);




            player.translateXProperty().addListener((obs, old, newValue) -> {
                offset_aktualny = newValue.intValue();
                //System.out.println("obs" +obs);
                //System.out.println("old" +old);
                /*System.out.println("P - " + offset_poczatkowy);
                System.out.println("A - " + offset_aktualny);*/
                System.out.print(player.getTranslateX());
                System.out.print(" - " +player.getTranslateY() + "\n");

                // obsluga kamery
                if (offset_aktualny > 640 && offset_aktualny < levelWidth - 640) {
                    gameRoot.setLayoutX(-(offset_aktualny - 640));
                }
            });
            gameRoot.getChildren().add(label);
            appRoot.getChildren().addAll(bg, gameRoot, uiRoot);
        }

        public void showSkill(Node skill , int value){
            skill_enabled = true;
            Line line = new Line();
            line.setStartX(skill.getTranslateX()+15);
            line.setEndX(skill.getTranslateX()+100);
            line.setStartY(skill.getTranslateY()+15);
            line.setEndY(skill.getTranslateY()+15);
            PathTransition pathTransition = new PathTransition();
            pathTransition.setNode(skill);
            pathTransition.setDuration(Duration.seconds(0.5));
            pathTransition.setPath(line);
            pathTransition.play();

            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    skill_enabled = false;
                    skill_limited = true;
                    gameRoot.getChildren().remove(skill);

                }
            });
        }

        public void moveMonstersRight(Node monster, int value , double x , double y){
            Line line2 = new Line();
            Image test =new Image("file:src/asset/Golem_02_Jump Start_000.png");
            changeImgae((Rectangle) monster, test);
            System.out.println(monster.getTranslateX());
            System.out.println(monster.getTranslateY());

            line2.setStartX(monster.getTranslateX());
            line2.setEndX(monster.getTranslateX()+value);

            line2.setStartY(monster.getTranslateY()+35);
            line2.setEndY(monster.getTranslateY()+35);

            PathTransition pathTransition = new PathTransition();
            pathTransition.setNode(monster);
            pathTransition.setDuration(Duration.seconds(2));
            //pathTransition.setCycleCount(PathTransition.INDEFINITE);
            pathTransition.setPath(line2);
            pathTransition.play();

            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    monster.setTranslateX(x+100.0);
                    monster.setTranslateY(y);

                    moveMonstersLeft(monster,value,x+100.0,y);
                }
            });
        }

        public void moveMonstersLeft(Node monster, int value , double x , double y){
            Line line2 = new Line();
            Image test =new Image("file:src/asset/golem.png");
            changeImgae((Rectangle) monster, test);
            System.out.println(monster.getTranslateX());
            System.out.println(monster.getTranslateY());

            line2.setStartX(monster.getTranslateX());
            line2.setEndX(monster.getTranslateX()-value);

            line2.setStartY(monster.getTranslateY()+35);
            line2.setEndY(monster.getTranslateY()+35);

            PathTransition pathTransition = new PathTransition();
            pathTransition.setNode(monster);
            pathTransition.setDuration(Duration.seconds(2));
            //pathTransition.setCycleCount(PathTransition.INDEFINITE);
            pathTransition.setPath(line2);
            pathTransition.play();

            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    monster.setTranslateX(x-100.0);
                    monster.setTranslateY(y);
                    moveMonstersRight(monster,value,x-100.0,y);
                }
            });
        }

        private void update() {
            if (isPressed(KeyCode.W) && player.getTranslateY() >= 5) {
                jumpPlayer();
            }

            if (isPressed(KeyCode.Q) && player.getTranslateY() >= 5) {
                Image test = new Image("file:src/asset/skile/efecto_fuego_00032.png");
                if(skill_limited){
                    skill_limited = false;
                    skills = createEntity((int)player.getTranslateX() + 50 , (int)player.getTranslateY() + 20,40,30,test);
                    showSkill(skills,50);
                }
            }


            if (isPressed(KeyCode.A) && player.getTranslateX() >= 5) {
                movePlayerX(-5);

                if(offset_aktualny + 10 < offset_poczatkowy){
                    offset_poczatkowy = offset_aktualny;
                    changeImgae((Rectangle) player,HeroLeft[k]);
                }
                k++;
                if(k==3){
                    k = 0;
                }

            }else if (isPressed(KeyCode.D) && player.getTranslateX() + 40 <= levelWidth - 5) {
                movePlayerX(5);

                if(offset_aktualny > offset_poczatkowy+10){
                    offset_poczatkowy = offset_aktualny;
                    changeImgae((Rectangle) player,HeroRight[k]);
                }
                k++;
                if(k==3){
                    k = 0;
                }
            }else{
                changeImgae((Rectangle) player,HeroStay);
            }


            if (playerVelocity.getY() < 10) {
                playerVelocity = playerVelocity.add(0, 1);
            }

            movePlayerY((int)playerVelocity.getY());

            // dodac petle po potworach
            if(monster_moved){
                moveMonstersRight(levelData.getMonster().get(2),100 , levelData.getMonster().get(2).getTranslateX() , levelData.getMonster().get(2).getTranslateY());
                moveMonstersRight(levelData.getMonster().get(1),100 , levelData.getMonster().get(1).getTranslateX() , levelData.getMonster().get(1).getTranslateY());
                moveMonstersRight(levelData.getMonster().get(0),100 , levelData.getMonster().get(0).getTranslateX() , levelData.getMonster().get(0).getTranslateY());

                monster_moved = false;
            }

            for( Node monsterki : levelData.getMonster()){
                if(player.getBoundsInParent().intersects(monsterki.getBoundsInParent())){
                    System.out.println("ajajaajajaja");
                    //gameRoot.getChildren().remove(player);
                }
            }

            if(skill_enabled == true){
                for( Node monsterki : levelData.getMonster()){
                    if(skills.getBoundsInParent().intersects(monsterki.getBoundsInParent())){
                        if((boolean)monsterki.getProperties().get("alive")){
                            System.out.println("o kurwa");
                            score += 10;
                            monsterki.getProperties().put("alive",false);
                            label.setText(String.valueOf(score));
                            gameRoot.getChildren().remove(monsterki);
                        }
                    }
                }
            }

            for (Node coin : levelData.getCoins()) {
                if (player.getBoundsInParent().intersects(coin.getBoundsInParent())) {
                    coin.getProperties().put("alive", false);
                    dialogEvent = true;
                    running = false;
                }
            }

            for (Iterator<Node> it = levelData.getCoins().iterator(); it.hasNext(); ) {
                Node coin = it.next();
                if (!(Boolean)coin.getProperties().get("alive")) {
                    it.remove();
                    gameRoot.getChildren().remove(coin);
                }
            }
        }


        private void movePlayerX(int value) {
            boolean movingRight = value > 0;

            for (int i = 0; i < Math.abs(value); i+=2) {
                for (Node platform : levelData.getPlatforms()) {
                    if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                        if (movingRight) {
                            if (player.getTranslateX() + 60 == platform.getTranslateX()) {
                                return;
                            }
                        }
                        else {
                            if (player.getTranslateX() == platform.getTranslateX() + 60) {
                                return;
                            }
                        }
                    }
                }
                player.setTranslateX(player.getTranslateX() + (movingRight ? 1 : -1));
            }
        }

        private void movePlayerY(int value) {
            boolean movingDown = value > 0;

            for (int i = 0; i < Math.abs(value); i++) {
                for (Node platform : levelData.getPlatforms()) {
                    if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                        if (movingDown) {
                            if (player.getTranslateY() + 55 == platform.getTranslateY()) {
                                player.setTranslateY(player.getTranslateY() - 1);
                                canJump = true;
                                return;
                            }
                        }
                        else {
                            if (player.getTranslateY() == platform.getTranslateY() + 55) {
                                return;
                            }
                        }
                    }
                }
                player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
            }
        }

        private void jumpPlayer() {
            if (canJump) {
                playerVelocity = playerVelocity.add(0, -30);
                canJump = false;
            }
        }

        private Node createEntity(int x, int y, int w, int h, Image image) {
            Rectangle entity = new Rectangle(w, h);
            entity.setTranslateX(x);
            entity.setTranslateY(y);
            entity.setFill(new ImagePattern(image));
            entity.getProperties().put("alive", true);

            gameRoot.getChildren().add(entity);
            return entity;
        }

        public void changeImgae(Rectangle player , Image image){
            player.setFill(new ImagePattern(image));
        }

        private boolean isPressed(KeyCode key) {
            return keys.getOrDefault(key, false);
        }


        @Override
        public void start(Stage primaryStage) throws Exception {
            initContent();

            Scene scene = new Scene(appRoot);
            scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
            scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
            primaryStage.setTitle("Game starts");
            primaryStage.setScene(scene);
            primaryStage.show();

            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (running) {
                        update();
                    }

                    if (dialogEvent) {
                        dialogEvent = false;
                        keys.keySet().forEach(key -> keys.put(key, false));

                        GameDialog dialog = new GameDialog();
                        dialog.setOnCloseRequest(event -> {
                            if (dialog.isCorrect()) {
                                System.out.println("Correct");
                            }
                            else {
                                System.out.println("Wrong");
                            }

                            running = true;
                        });
                        dialog.open();
                    }
                }
            };
            timer.start();
        }

}