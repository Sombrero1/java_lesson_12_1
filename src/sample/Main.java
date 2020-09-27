package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



enum Planet{
    EARTH(10,10),MARS(100,100),UPITER(10000,10000);
    private final double mass;
    private final double radius;
    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
    }
    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group,1000,500);



        MenuBar menu= new MenuBar();
        Menu planets=new Menu("change planet");

        MenuItem itemsOfMenu[]=new MenuItem[]{
                new MenuItem(Planet.EARTH.toString()),
                new MenuItem(Planet.MARS.toString()),
                new MenuItem(Planet.UPITER.toString())
        };

        Text txt=new Text("");
        txt.setLayoutY(50);

        for (MenuItem t: itemsOfMenu
             ) {
            planets.getItems().add(t);
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Planet g=Planet.valueOf(t.getText());
                    txt.setText("Planet: " + g.toString() + " radius:" + g.getRadius() +" mass:" + g.getMass());//cуда передать радиус планеты

                }
            });
        }

        menu.getMenus().add(planets);

        BorderPane menuPane=new BorderPane();
        menuPane.setTop(menu);




        group.getChildren().addAll(menuPane,txt);
        primaryStage.setTitle("Enum");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
