//nơi bắt đầu chạy
package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    public static Scene scene = null;
    public static AnimationTimer loopGame = null;
    static int dem = 0;

    private static EventHandler<MouseEvent> handlerStart = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Stage stage_play = (Stage) scene.getWindow();
            //((Group) scene.getRoot()).getChildren().clear();
            stage_play.setTitle("Tower Defense/Play Game");
            GameStage gameStage = new GameStage();
            stage_play.setScene(scene);
            AnimationTimer loop_game = Main.ForloopGame();
            //loop_game.start();
            loop_game.stop();

            stage_play.show();
        }
    };

    public static Scene initMenu() {
        Group root = new Group();
        Canvas canvas = new Canvas(1132, 642);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image mh_nen = new Image("sample/image/mh.png");
        gc.drawImage(mh_nen, 0 , 0);
        ImageView start = new ImageView("sample/image/start.png");
        start.setX(420);
        start.setY(470);
        start.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerStart);
        root.getChildren().addAll(canvas,start);

        return new Scene(root);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Menu Game");
        scene = initMenu();
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static AnimationTimer ForloopGame() {
        Tower tower1 = new NormalTower("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile249.png", 165, 320, 200);
        Tower tower2 = new SniperTower("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile250.png", 330, 560, 250);
        Tower tower3 = new SniperTower("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile250.png", 550, 5, 250);
        Tower tower4 = new NormalTower("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile249.png", 340, 180, 200);

        Map.arrayTower.add(tower1);
        Map.arrayTower.add(tower2);
        Map.arrayTower.add(tower3);
        Map.arrayTower.add(tower4);

        Map.createArrayEnemy();
        Map.createArrayBullet();




        Main.loopGame = new AnimationTimer() {
            final long startNanoTime = System.nanoTime();

            Bullet bullet1 = Map.arrayBullet.get(0);
            Bullet bullet2 = Map.arrayBullet.get(1);
            Bullet bullet3 = Map.arrayBullet.get(2);
            Bullet bullet4 = Map.arrayBullet.get(3);


            ImageView imageTower1, imageTower2, imageTower3, imageTower4, imageEnemy1, imageEnemy2, imageEnemy3, imageEnemy4, imageEnemy, imageBullet1, imageBullet2,imageBullet3,imageBullet4;
            Text heart, coin;
            Group groupEnemy = new Group();

            @Override
            public void handle(long currentNanoTime) {
                groupEnemy.getChildren().clear();
                ((Group) Main.scene.getRoot()).getChildren().removeAll(groupEnemy, heart, imageBullet1, imageBullet2, imageBullet3, imageBullet4);

                double t = (currentNanoTime - startNanoTime) / 1000000000.0;


                imageTower1 = tower1.initTower();
                imageTower2 = tower2.initTower();
                imageTower3 = tower3.initTower();
                imageTower4 = tower4.initTower();

                imageTower1.setRotate(180);
                imageTower3.setRotate(180);
                imageTower4.setRotate(90);

                if (Map.arrayEnemy.size() > 0) {
                    for (Enemy enemy : Map.arrayEnemy) {
                        enemy.moveEnemy();
                        if (Enemy.checkHeart(enemy)) {
                            Map.arrayEnemy.remove(enemy);
                        }
                        if (enemy.heart <= 0) {
                            Map.arrayEnemy.remove(enemy);
                        }
                        imageEnemy = enemy.initEnemy();
                        imageEnemy.setRotate(enemy.rotateEnemy());

                        if (Enemy.checkPos(enemy)) {
                            Map.heart--;
                            Map.arrayEnemy.remove(enemy);
                            continue;
                        }
                        groupEnemy.getChildren().add(imageEnemy);
                    }
                }

                imageBullet1 = bullet1.initBullet();
                bullet1.setSpeedBullet(t/20);
                bullet1.moveBullet(Map.arrayEnemy.get(0).getX(), Map.arrayEnemy.get(0).getY() , 200);
                if (bullet1.checkContact(Map.arrayEnemy.get(0))) {
                    bullet1.resetBullet();
                    Map.arrayEnemy.get(0).heart -= 0.2;
                }


                imageBullet2 = bullet2.initBullet();
                bullet2.setSpeedBullet(t/20);
                bullet2.moveBullet(Map.arrayEnemy.get(0).getX(), Map.arrayEnemy.get(0).getY() , 200);
                if (bullet2.checkContact(Map.arrayEnemy.get(0))) {
                    bullet2.resetBullet();
                    Map.arrayEnemy.get(0).heart -= 0.3;
                }

                imageBullet3 = bullet3.initBullet();
                bullet3.setSpeedBullet(t/20);
                bullet3.moveBullet(Map.arrayEnemy.get(3).getX(), Map.arrayEnemy.get(3).getY() , 200);
                if (bullet3.checkContact(Map.arrayEnemy.get(3))) {
                    bullet3.resetBullet();
                    Map.arrayEnemy.get(2).heart -= 0.3;
                }

                imageBullet4 = bullet4.initBullet();
                bullet4.setSpeedBullet(t/20);
                bullet4.moveBullet(Map.arrayEnemy.get(0).getX(), Map.arrayEnemy.get(0).getY() , 200);
                if (bullet4.checkContact(Map.arrayEnemy.get(0))) {
                    bullet4.resetBullet();
                    Map.arrayEnemy.get(1).heart -= 0.2;
                }

                ((Group) Main.scene.getRoot()).getChildren().add(groupEnemy);
                if (Map.heart == 0) {
                    Text game_Over = new Text(910, 230, "Game Over");
                    game_Over.setFont(Font.font( "Times New Roman!", FontWeight.BOLD, 40 ));
                    game_Over.setFill(Color.RED);
                    ((Group) Main.scene.getRoot()).getChildren().add(game_Over);

                    ((Group) Main.scene.getRoot()).getChildren().remove(groupEnemy);
                    Main.loopGame.stop();
                }

                heart = new Text( 1005, 382, Map.heart.toString());
                heart.setFont(Font.font( "Times New Roman", FontWeight.BOLD, 35 ));
                heart.setFill(Color.RED);

                coin = new Text(1000, 325, Map.coin.toString());
                coin.setFont(Font.font( "Times New Roman", FontWeight.BOLD, 35 ));
                coin.setFill(Color.BLACK);

                ((Group) Main.scene.getRoot()).getChildren().addAll(imageTower1,imageTower2,imageTower3,imageTower4, heart, coin, imageBullet1, imageBullet2, imageBullet3, imageBullet4);

            }
        };
        return Main.loopGame;
    }
}
