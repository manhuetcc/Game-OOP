package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import  java.io.*;

public class GameStage {
    private Map mapEntity = new Map();
    public GameStage() {
        initGameStage();
    }

    public void initGameStage() {
        Group root = new Group();
        Group rootBackground = new Group();
        Group rootMap = mapEntity.initMapEntity();


        Canvas canvas = new Canvas(1132, 642);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image play_screen = new Image("sample/image/nen.png");
        gc.drawImage(play_screen, 0, 0);
        Image road_image = new Image("sample/image/273.png");
        gc.drawImage(road_image, -33, 100);

        gc.setFill(Color.RED);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 35 );
        gc.setFont(theFont);

        Image heart = new Image("sample/image/heart.jpg");
        gc.drawImage(heart, 935, 350);
        //gc.fillText(Map.heart.toString(), 1005, 382);

        Image coin = new Image("sample/image/coin.png");
        gc.drawImage(coin, 935, 295);
        //gc.fillText(Map.coin.toString(), 1000, 325);

        //Trang trí màn hình
        Image tru = new Image("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile180.png");
        gc.drawImage(tru, 165, 320);
        gc.drawImage(tru, 330, 560);
        gc.drawImage(tru, 550, 5);
        gc.drawImage(tru, 340, 180);
        //gc.drawImage(tru, 380, 365);
        //gc.drawImage(tru, 670, 180);

        Image cay_nho = new Image("sample/image/AssetsKit_2/PNG/Retina/towerDefense_tile131.png");
        Image cay_to = new Image("sample/image/AssetsKit_2/PNG/Retina/towerDefense_tile130.png");
        Image tru_sua_chua2 = new Image("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile039.png");
        Image tru_sua_chua1 = new Image("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile041.png");
        Image da_to = new Image("sample/image/AssetsKit_2/PNG/Retina/towerDefense_tile136.png");
        Image da_nho1 = new Image("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile135.png");
        Image da_nho2 = new Image("sample/image/AssetsKit_2/PNG/Default size/towerDefense_tile137.png");
        Image bui_cay = new Image("sample/image/AssetsKit_2/PNG/Retina/towerDefense_tile132.png");
        Image bui_cay2 = new Image("sample/image/AssetsKit_2/PNG/Retina/towerDefense_tile134.png");

        gc.drawImage(tru_sua_chua1, 650, 8);
        gc.drawImage(tru_sua_chua2, 70, 540);
        gc.drawImage(cay_to, 50, 180);
        gc.drawImage(cay_to, 580, 460);
        gc.drawImage(cay_nho, 150, 160);
        gc.drawImage(da_to, 760, 155);
        gc.drawImage(da_nho1, 150, 10);
        gc.drawImage(da_nho2, 200, 14);
        gc.drawImage(bui_cay, 320, 320);
        gc.drawImage(bui_cay, 720, -10);
        gc.drawImage(bui_cay2, 650, 350);


        //nút trở về màn hình chờ
        ImageView MainMenu = Drawer.loadImageIcon(new Image("sample/image/AssetsKit_1/buttons/DefineButton2_83/1.png"), 950, 25);
        MainMenu.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerBackMenu);

        //nút bắt đầu chạy game
        ImageView Play = Drawer.loadImageIcon(new Image("sample/image/play.png"), 920, 570);
        Play.addEventFilter(MouseEvent.MOUSE_CLICKED, handlerPlay);

        root.getChildren().addAll(canvas, MainMenu, Play);
        Main.scene.setRoot(root);
    }

    private EventHandler<MouseEvent> handlerBackMenu = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            Map.heart = 10;
            Main.loopGame.stop();
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setTitle("Menu Game");
            Main.scene = Main.initMenu();
            stage.setScene(Main.scene);
            stage.show();
        }
    };
    private EventHandler<MouseEvent> handlerPlay = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            Media sound=new Media(new File("C:\\Users\\Secret\\IdeaProjects\\DefenseTower\\OOP-Defense Tower\\src\\sample\\Sound\\soundtrack.mp3").toURI().toString());
            MediaPlayer mediaPlayer=new MediaPlayer(sound);
            mediaPlayer.play();
            Media sounds=new Media(new File("C:\\Users\\Secret\\IdeaProjects\\DefenseTower\\OOP-Defense Tower\\src\\sample\\Sound\\soundtrack.mp3").toURI().toString());
            MediaPlayer mediaPlayers=new MediaPlayer(sounds);
            mediaPlayer.play();
            Main.loopGame.start();
        }
    };

}
