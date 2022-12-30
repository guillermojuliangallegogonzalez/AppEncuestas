package appencuestas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppEncuestas extends Application {
    public static BorderPane borderPane = new BorderPane();
    public static SportApp sportApp = new SportApp();

    @Override
    public void start(Stage primaryStage) throws Exception {

        
         Scene scene= new Scene(borderPane,1300,1000);
         VBox vBox1;
         VBox vBox2;
         HBox hboxAll;
         HBox hboxTitle;
         Text title;
          //Img
    
         Image imgTitle= new Image("src/lista-de-verificacion.png",100,100,false,false);
         ImageView imgViewTitle = new ImageView(imgTitle);
         
         Image imgHealth= new Image("src/reporte-de-salud.png",85,85,false,false);
         ImageView imgViewHelath = new ImageView(imgHealth);
         
         Image imgAcademy= new Image("src/graduado.png",85,85,false,false);
         ImageView imgViewAcademy = new ImageView(imgAcademy);
         
         Image imgSport= new Image("src/corriendo.png",85,85,false,false);
         ImageView imgViewSport = new ImageView(imgSport);
         
         Image imgPopulation= new Image("src/mundo.png",85,85,false,false);
         ImageView imgViewPopulation = new ImageView(imgPopulation);
         
         //Texto del titulo
         title= new Text();
        title.setText("Encuestas");
        title.setId("title");
        title.setFill(Color.DODGERBLUE);
        title.setEffect(new Lighting());
  
        
         // Hbox donde almaceno titulo e imagen y botton
         Button  btnSalir = new Button();
         Button maximize = new Button();
         maximize.setText("");
         maximize.setOnAction((ActionEvent event) -> {    
             if (primaryStage.isFullScreen())  primaryStage.setFullScreen(false);
             else   primaryStage.setFullScreen(true);  
        });
         btnSalir.setText("X");
         btnSalir.setStyle("-fx-background-color: red");
          // Función cerrado programa
        btnSalir.setOnAction((ActionEvent event) -> {    
            System.exit(0);
        });
         hboxTitle= new  HBox();
         //hboxTitle.setId("titleID");
         hboxTitle.setPadding( new Insets(50,0, 0, 0));
         hboxTitle.setMargin(title, new Insets(0, 50, 0, 50));
         hboxTitle.setMargin(btnSalir, new Insets(0, 50, 0, 50));
         hboxTitle.getChildren().addAll(imgViewTitle,title,maximize,btnSalir);
         hboxTitle.setAlignment(Pos.CENTER);
         borderPane.setTop(hboxTitle);
         
        //Boton salud
        Button health = new Button("Salud");
        health.setId("mainButton");
        health.setGraphic(imgViewHelath);
        //health.setStyle("-fx-font-size: 24;");
        health.setMaxWidth(300);
        health.setMaxHeight(220);
        health.setDefaultButton(true);
        health.setOnAction((ActionEvent t) -> { HealthApp.saludScreen(scene,borderPane,primaryStage);  });
        health.setPadding(new Insets(50, 50, 50, 50));
        
        //Boton deportes
        Button sports = new Button("Deportes");
        sports.setId("mainButton");
        sports.setGraphic(imgViewSport);
       // sports.setStyle("-fx-font-size: 24;");
        sports.setDefaultButton(true);
        sports.setOnAction((ActionEvent t) -> { sportApp.sportScreen(scene,borderPane,primaryStage);});
        sports.setPadding(new Insets(50, 50, 50, 50));
        
        //Boton academia    
        Button academy = new Button("Academia");
        academy.setId("mainButton");
        academy.setGraphic(imgViewAcademy);
        //academy.setStyle("-fx-font-size: 24;");
        academy.setDefaultButton(true);
        academy.setOnAction((ActionEvent t) -> {AcademiaApp.academiaScreen(scene,borderPane,primaryStage);});
        academy.setPadding(new Insets(50, 50, 50, 50));
        
         //Boton population    
        Button population = new Button("Población");
        population.setId("mainButton");
        population.setGraphic(imgViewPopulation);
        //population.setStyle("-fx-font-size: 24;");
        population.setDefaultButton(true);
        population.setOnAction((ActionEvent t) -> { PoblacionApp.poblacionScreen(scene,borderPane,primaryStage);  });
        population.setPadding(new Insets(50, 50, 50, 50));
        
        vBox1= new VBox();
        vBox2= new VBox();
        hboxAll = new HBox();
        vBox1.getChildren().add(health);
        vBox1.getChildren().add(sports);
        vBox2.getChildren().add(academy);
        vBox2.getChildren().add(population);
        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        hboxAll.setAlignment(Pos.CENTER);
        
        hboxAll.setSpacing(100);
        vBox1.setSpacing(100);
        vBox2.setSpacing(100);

        hboxAll.getChildren().addAll(vBox1,vBox2);
        borderPane.setCenter(hboxAll);

       borderPane.getStylesheets().add("/css/style.css");
       
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show(); 
        ResizeHelper.addResizeListener(primaryStage);
    }
 

    public static void main(String[] args) {
        launch(args);
    }

    
}
