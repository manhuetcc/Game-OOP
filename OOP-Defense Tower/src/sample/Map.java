package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;

public class Map {
    public  static ArrayList<Tower> arrayTower = new ArrayList<>();
    public static ArrayList<Enemy> arrayEnemy = new ArrayList<>();
    public static ArrayList<Bullet> arrayBullet = new ArrayList<>();
    //số mạng còn lại:
    public static Integer heart = 5;
    //số tiền đang có:
    public static Integer coin = 200;


    private Pane towerPane = new Pane();
    private Pane enemyPane = new Pane();
    private Pane bulletPane = new Pane();
    private Group mapGame = new Group();


    //điểm đầu và điểm cuối
    public static Point2D spawner = Spawner.spawer;
    public static Point2D target = Target.target;

    //điểm rẽ 1
    public static Point2D rotary1 = new Point2D(448, 444);
    //điểm rẽ 2
    public static Point2D rotary2 = new Point2D(448, 89);

    public Pane getTowerPane() {
        return towerPane;
    }
    public Pane getEnemyPane() {
        return enemyPane;
    }
    public Pane getBulletPane() {
        return bulletPane;
    }

    public Group getMapGame() {
        return mapGame;
    }

    public Group initMapEntity() {
        ArrayList<Point2D> arrayPointForTower = new ArrayList<>();
        arrayPointForTower.add(new Point2D(165, 370));
        arrayPointForTower.add(new Point2D(325, 540));
        arrayPointForTower.add(new Point2D(540, 350));
        arrayPointForTower.add(new Point2D(365, 150));
        arrayPointForTower.add(new Point2D(670, 185));
        arrayPointForTower.add(new Point2D(750, 25));
        //createArrayTower(arrayPointForTower);

        ArrayList<Point2D> arrayPointForEnemy = new ArrayList<>();
        arrayPointForEnemy.add(new Point2D(0, 444));
        arrayPointForEnemy.add(new Point2D(-60, 444));
        arrayPointForEnemy.add(new Point2D(-120, 444));
        arrayPointForEnemy.add(new Point2D(-180, 444));

        //createEnemy(arrayPointForTower);

        mapGame.getChildren().addAll(towerPane,enemyPane,bulletPane);
        return mapGame;
    }

    public static void createArrayEnemy() {
        Point2D point2D = new Point2D(0, 444);
        for (int i = 0; i < 15; i++) {
            arrayEnemy.add(createEnemy(point2D, i));
            if (i == 2) {
                point2D = new Point2D(point2D.getX() - 650, point2D.getY());
            }
            else if (i < 2)
                point2D = new Point2D(point2D.getX() - 100, point2D.getY());
            else
                point2D = new Point2D(point2D.getX() - 30, point2D.getY());
        }
    }
    public static void createArrayBullet() {
        Bullet bullet1 = new Bullet(arrayTower.get(0));
        bullet1.setImage("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile273.png");
        Bullet bullet2 = new Bullet(arrayTower.get(1));
        bullet2.setImage("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile274.png");
        Bullet bullet3 = new Bullet(arrayTower.get(2));
        bullet3.setImage("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile274.png");
        Bullet bullet4 = new Bullet(arrayTower.get(3));
        bullet4.setImage("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile273.png");

        arrayBullet.add(bullet1);
        arrayBullet.add(bullet2);
        arrayBullet.add(bullet3);
        arrayBullet.add(bullet4);

    }

    public void createArrayTower(ArrayList<Point2D> arrPoint) {
        Tower tower;
        ImageView imageTower;
        for (Point2D point2D : arrPoint) {
            tower = new Tower("sample/image/AssetsKit_1/shapes/100.png", point2D.getX(), point2D.getY(), 300);
            imageTower = tower.initTower();
            arrayTower.add(tower);
            towerPane.getChildren().add(imageTower);
        }
    }

    public static Enemy createEnemy(Point2D point2D, int n) {
            //Enemy enemy = new Enemy("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile245.png", point2D.getX(), point2D.getY());
            Enemy enemy;
            if (n < 3) {
                enemy = new TankerEnemy("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile246.png", point2D.getX(), point2D.getY());
            }
            else
                enemy = new NormalEnemy("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile245.png", point2D.getX(), point2D.getY());
            return enemy;
        }
    }
