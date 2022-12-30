package appencuestas;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
/**
 *
 * @author guillermogallegogonzalez
 */
public class SportApp {
 
    public void sportScreen(Scene sportScreen, BorderPane root2,  Stage primaryStage) {
 
        // Declaración layout
        VBox root = new VBox();
        root.getStylesheets().add("/css/style.css");
        sportScreen.setRoot(root);
 
 
        // Configuración BorderPane
        HBox appHeader = new HBox();
 
 
        // Configuración GridPane superior
        GridPane formInterface = new GridPane();
        formInterface.setAlignment(Pos.CENTER);
        formInterface.setHgap(10);
        formInterface.setVgap(15);
        formInterface.setPadding(new Insets(25, 25, 25, 25));
 
        // Configuración GridPane Medio Superior
        GridPane formInterfaceMid = new GridPane();
        formInterfaceMid.setAlignment(Pos.CENTER);
        formInterfaceMid.setHgap(10);
        formInterfaceMid.setVgap(15);
        formInterfaceMid.setPadding(new Insets(25, 25, 25, 25));
 
        // Configuración Gridpane Medio Inferior
        GridPane formInterfaceMidBottom = new GridPane();
        formInterfaceMidBottom.setAlignment(Pos.CENTER);
        formInterfaceMidBottom.setHgap(10);
        formInterfaceMidBottom.setVgap(15);
        formInterfaceMidBottom.setPadding(new Insets(25, 25, 25, 25));
 
        // Configuración Gridpane Inferior
        GridPane formInterfaceBottom = new GridPane();
        formInterfaceBottom.setAlignment(Pos.CENTER);
        formInterfaceBottom.setHgap(10);
        formInterfaceBottom.setVgap(15);
        formInterfaceBottom.setPadding(new Insets(25, 25, 25, 25));
 
        // Añadimos los BorderPanes al VBox
        root.getChildren().add(appHeader);
        root.getChildren().add(formInterface);
        root.getChildren().add(formInterfaceMid);
        root.getChildren().add(formInterfaceMidBottom);
        root.getChildren().add(formInterfaceBottom);
 
        // Declaración elementos interfaz VBox
        Text title = new Text("Encuesta de deportes");
        Button exitButton = new Button("X");
        Button backButton = new Button("←");
        Button maximize = new Button("");
 
        // Introducción elementos VBox
        exitButton.setStyle("-fx-background-color: red");
         maximize.setOnAction((ActionEvent event) -> {
             if (primaryStage.isFullScreen())  primaryStage.setFullScreen(false);
             else   primaryStage.setFullScreen(true);
        });
        appHeader.setMargin(title, new Insets(0, 50, 0, 50));
        appHeader.setPadding( new Insets(50,0, 0, 0));
        appHeader.setMargin(maximize, new Insets(0, 50,0 , 50));
        title.setFill(Color.DODGERBLUE);
        title.setEffect(new Lighting());
        title.setFont(Font.font(Font.getDefault().getFamily(), 40));
        appHeader.getChildren().addAll(backButton, title,maximize, exitButton);
        appHeader.setAlignment(Pos.CENTER);
 
        // Declaración elementos interfaz GridPane Superior
        Label professionText = new Label("Profesión:");
        TextField professionField = new TextField();
        Label ageText = new Label("Edad:");
        ChoiceBox<String> ageChoiceBox = new ChoiceBox<>();
        Text brotherText = new Text("Nº Hermanos:");
        ChoiceBox<String> brotherChoiceBox = new ChoiceBox<>();
        Label sexLabel = new Label("Sexo:");
        ToggleGroup sexToggleGroup = new ToggleGroup();
        RadioButton manButton = new RadioButton("Hombre");
        RadioButton womenButton = new RadioButton("Mujer");
        ImageView sexImgView = new ImageView();
        Image sexImg = new Image("src/sex.png", 60, 60, false, false);
        Image manImg = new Image("src/boy.png", 60, 60, false, false);
        Image womenImg = new Image("src/girl.png", 60, 60, false, false);
 
        // Configuración elementos interfaz GridPane Superior
        manButton.setToggleGroup(sexToggleGroup);
        womenButton.setToggleGroup(sexToggleGroup);
        ageChoiceBox.getItems().add("Menos de 15");
        ageChoiceBox.getItems().add("Entre 15 - 18");
        ageChoiceBox.getItems().add("Entre 19 - 35");
        ageChoiceBox.getItems().add("Entre 36 - 60");
        ageChoiceBox.getItems().add("Más de 60");
        brotherChoiceBox.getItems().add("Ninguno");
        brotherChoiceBox.getItems().add("Uno");
        brotherChoiceBox.getItems().add("Dos");
        brotherChoiceBox.getItems().add("Más de dos");
        sexImgView.setImage(sexImg);
        sexImgView.setFitHeight(60);
        sexImgView.setFitWidth(60);
 
        // Introducción elementos GridPane Superior
        formInterface.add(professionText, 0, 0);
        formInterface.add(professionField, 1, 0);
        formInterface.add(ageText, 0, 1);
        formInterface.add(ageChoiceBox, 1, 1);
        formInterface.add(brotherText, 3, 1);
        formInterface.add(brotherChoiceBox, 4, 1);
        formInterface.add(sexLabel, 0, 2);
        formInterface.add(manButton, 1, 2);
        formInterface.add(womenButton, 2, 2);
        formInterface.add(sexImgView, 3, 2);
 
        // Declaración elementos interfaz GridPane Medio Superior
        CheckBox sportCheckBox = new CheckBox("(Marca la casilla si haces deporte)");
        Label doSportLabel = new Label("¿Practicas algún deporte?");
        TextField sportTextField = new TextField();
        Label favoriteBrandLabel = new Label("¿Cuál es tu marca de ropa favorita?");
        TextField favoriteBrandTextField = new TextField();
        CheckBox otherBrandCheckBox = new CheckBox("(Marca la casilla si usas)");
        Label otherBrandLabel = new Label("¿Hay otras marcas que también usa? ¿Cuáles?");
        TextField otherBrandTextField = new TextField();
        Label chooseBrandLabel = new Label("¿Por qué elige una marca?");
        ChoiceBox<String> chooseBrandChoiceBox = new ChoiceBox<>();
        Label productLabel = new Label("¿Cuántos productos por año compra de esta marca?");
        ChoiceBox<String> productChoiceBox = new ChoiceBox<>();
 
        // Configuración elementos interfaz GridPane Medio Superior
        sportTextField.setDisable(true);
        sportTextField.setPromptText("¿Cuál?");
        otherBrandTextField.setPromptText("Separado por comas");
        otherBrandTextField.setDisable(true);
        chooseBrandChoiceBox.getItems().add("Por el precio");
        chooseBrandChoiceBox.getItems().add("Por la comodidad que ofrecen los productos");
        chooseBrandChoiceBox.getItems().add("Por la calidad de los productos");
        chooseBrandChoiceBox.getItems().add("Por la estética de los productos");
        chooseBrandChoiceBox.getItems().add("Otros");
        productChoiceBox.getItems().add("Entre uno y cinco");
        productChoiceBox.getItems().add("Entre seis y diez");
        productChoiceBox.getItems().add("Entre once y quince");
        productChoiceBox.getItems().add("Más de quince");
 
        // Introducción elementos GridPane Medio Superior
        formInterfaceMid.add(sportCheckBox, 0, 0);
        formInterfaceMid.add(doSportLabel, 1, 0);
        formInterfaceMid.add(sportTextField, 2, 0);
        formInterfaceMid.add(favoriteBrandLabel, 0, 1);
        formInterfaceMid.add(favoriteBrandTextField, 1, 1);
        formInterfaceMid.add(otherBrandCheckBox, 0, 2);
        formInterfaceMid.add(otherBrandLabel, 1, 2);
        formInterfaceMid.add(otherBrandTextField, 2, 2);
        formInterfaceMid.add(chooseBrandLabel, 0, 3);
        formInterfaceMid.add(chooseBrandChoiceBox, 1, 3);
        formInterfaceMid.add(productLabel, 0, 4);
        formInterfaceMid.add(productChoiceBox, 1, 4);
 
        // Declaración elementos interfaz GridPane Medio Inferior
        Label qualityLabel = new Label("¿Cómo describiría la calidad de los productos de esa marca?");
        Slider qualitySlider = new Slider();
        Label qualitySliderLabel = new Label();
        Label costLabel = new Label("¿Cómo describiría la relación precio-calidad de esa marca?");
        Slider costSlider = new Slider();
        Label costLabelSlider = new Label("Muy Mala");
        Label shoesLabel = new Label("¿Cada cuánto cambia sus zapatillas deportivas?");
        ChoiceBox<String> shoesChoiceBox = new ChoiceBox<>();
        Label garmetLabel = new Label("¿Qué prenda compra con más frecuencia?");
        ChoiceBox<String> garmetChoiceBox = new ChoiceBox<>();
        Label moneyLabel = new Label("¿Cuánto dinero gasta en prendas deportivas por año?");
        ChoiceBox<String> moneyChoiceBox = new ChoiceBox<>();
        Label bestBrandLabel = new Label(
                "¿Cree que las mejores marcas son aquellas más conocidas o que tienen mayor publicidad?");
        ToggleGroup bestBrandToggleGroup = new ToggleGroup();
        RadioButton yesButton = new RadioButton("Sí");
        RadioButton noButton = new RadioButton("No");
        RadioButton dontKnowButton = new RadioButton("No sé");
 
        // Configuración elementos interfaz GridPane Medio Inferior
        yesButton.setToggleGroup(bestBrandToggleGroup);
        noButton.setToggleGroup(bestBrandToggleGroup);
        dontKnowButton.setToggleGroup(bestBrandToggleGroup);
        qualitySlider.setMin(0);
        qualitySlider.setMax(6);
        qualitySlider.setValue(0);
        qualitySlider.setShowTickLabels(true);
        qualitySlider.setMajorTickUnit(1);
        qualitySlider.setMinorTickCount(1);
        qualitySlider.setBlockIncrement(1);
        qualitySlider.valueProperty()
                .addListener((ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) -> {
                    sliderMakeLabel(qualitySlider, qualitySliderLabel);
                });
        qualitySliderLabel.setText("Muy Mala");
        qualitySliderLabel.setTextFill(Color.RED);
        costSlider.setMin(0);
        costSlider.setMax(6);
        costSlider.setValue(0);
        costSlider.setShowTickLabels(true);
        costSlider.setMajorTickUnit(1);
        costSlider.setMinorTickCount(1);
        costSlider.setBlockIncrement(1);
        costSlider.valueProperty()
                .addListener((ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) -> {
                    sliderMakeLabel(costSlider, costLabelSlider);
                });
        costLabelSlider.setTextFill(Color.RED);
        shoesChoiceBox.getItems().add("Cada seis meses");
        shoesChoiceBox.getItems().add("Cada doce meses");
        shoesChoiceBox.getItems().add("Cada dieciocho meses");
        shoesChoiceBox.getItems().add("Cada veinticuatro meses");
        shoesChoiceBox.getItems().add("Cada 3 años");
        shoesChoiceBox.getItems().add("Cada 4 años");
        shoesChoiceBox.getItems().add("Cada 5 años");
        shoesChoiceBox.getItems().add("Otros");
        garmetChoiceBox.getItems().add("Calzado");
        garmetChoiceBox.getItems().add("Chaquetas");
        garmetChoiceBox.getItems().add("Pantalones");
        garmetChoiceBox.getItems().add("Shorts");
        garmetChoiceBox.getItems().add("Faldas");
        garmetChoiceBox.getItems().add("Vestidos");
        garmetChoiceBox.getItems().add("Playeras");
        garmetChoiceBox.getItems().add("Otros");
        moneyChoiceBox.getItems().add("Menos de 500€");
        moneyChoiceBox.getItems().add("Entre 500€ y 1.000€");
        moneyChoiceBox.getItems().add("Entre 1.000€ y 1500€");
        moneyChoiceBox.getItems().add("Entre 1.000€ y 1500€");
        moneyChoiceBox.getItems().add("Más de 2.000€");
 
        // Introducción elementos GridPane Medio Inferior
        formInterfaceMidBottom.add(qualityLabel, 0, 0);
        formInterfaceMidBottom.add(qualitySlider, 1, 0);
        formInterfaceMidBottom.add(qualitySliderLabel, 2, 0);
        formInterfaceMidBottom.add(costLabel, 0, 1);
        formInterfaceMidBottom.add(costSlider, 1, 1);
        formInterfaceMidBottom.add(costLabelSlider, 2, 1);
        formInterfaceMidBottom.add(shoesLabel, 0, 2);
        formInterfaceMidBottom.add(shoesChoiceBox, 1, 2);
        formInterfaceMidBottom.add(garmetLabel, 0, 3);
        formInterfaceMidBottom.add(garmetChoiceBox, 1, 3);
        formInterfaceMidBottom.add(moneyLabel, 0, 4);
        formInterfaceMidBottom.add(moneyChoiceBox, 1, 4);
        formInterfaceMidBottom.add(bestBrandLabel, 0, 5);
        formInterfaceMidBottom.add(yesButton, 0, 6);
        formInterfaceMidBottom.add(noButton, 1, 6);
        formInterfaceMidBottom.add(dontKnowButton, 2, 6);
 
        // Declaración elementos interfaz GridPane Inferior
        Button sendButton = new Button();
 
        // Configuración elementos interfaz GridPane Inferior
        Label validacion = new Label();
        sendButton.setText("Enviar");
 
        // Introducción elementos GridPane Inferior
        formInterfaceBottom.add(sendButton, 0, 0);
        formInterfaceBottom.add(validacion, 1, 0);
 
        // Función volver al menu
        backButton.setOnAction(e -> {
            sportScreen.setRoot(AppEncuestas.borderPane);
        });
 
        // Función cerrado programa
        exitButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
 
        // Función enviar
        sendButton.setOnAction(e -> {
            MakeCSV(professionField, sportTextField,
                favoriteBrandTextField, otherBrandTextField, ageChoiceBox,
                brotherChoiceBox, chooseBrandChoiceBox,
                productChoiceBox, shoesChoiceBox, bestBrandToggleGroup,
                yesButton, noButton, dontKnowButton, sexToggleGroup,
                manButton, womenButton, qualitySlider, costSlider,qualitySliderLabel,shoesLabel,formInterface,formInterfaceMid,formInterfaceMidBottom,moneyChoiceBox,garmetChoiceBox,formInterfaceBottom,validacion);
        });
 
        // Función cambio de imágen sexo Masculino y femenino
        manButton.setOnAction((ActionEvent event) -> {
            womenButton.setSelected(false);
            sexImgView.setImage(manImg);
            // Si los dos botones no estan seleccionados se selecciona la imagen por defecto
            if (womenButton.isSelected() == false && manButton.isSelected() == false) {
                sexImgView.setImage(sexImg);
            }
        });
 
        womenButton.setOnAction((ActionEvent event) -> {
            manButton.setSelected(false);
            sexImgView.setImage(womenImg);
            // Si los dos botones no estan seleccionados se selecciona la imagen por defecto
            if (womenButton.isSelected() == false && manButton.isSelected() == false) {
                sexImgView.setImage(sexImg);
            }
        });
 
        // Función para deshabilitar el TextField de deportes si el checkbox no se
        // encuentra marcados
        sportCheckBox.setOnAction((ActionEvent event) -> {
            if (sportCheckBox.isSelected() == true) {
                sportTextField.setDisable(false);
            } else {
                sportTextField.setDisable(true);
                sportTextField.setText("");
            }
        });
 
        // Función para deshabilitar el TextField de otras marcas si el checkbox no se
        // encuentra marcados
        otherBrandCheckBox.setOnAction((ActionEvent event) -> {
            if (otherBrandCheckBox.isSelected() == true) {
                otherBrandTextField.setDisable(false);
            } else {
                otherBrandTextField.setDisable(true);
                otherBrandTextField.setText("");
            }
        });
 
        // Autocompletado
    }
 
    public static void sliderMakeLabel(Slider sliderComun, Label labelComun) {
 
        int slidderValue = (int) sliderComun.getValue();
        switch (slidderValue) {
            case 0:
                labelComun.setText("Muy mala");
                labelComun.setTextFill(Color.RED);
                break;
            case 1:
                labelComun.setText("Mala");
                labelComun.setTextFill(Color.RED);
                break;
            case 2:
                labelComun.setText("Regular");
                labelComun.setTextFill(Color.ORANGE);
                break;
            case 3:
                labelComun.setText("Buena");
                labelComun.setTextFill(Color.ORANGE);
                break;
            case 4:
                labelComun.setText("Muy Buena");
                labelComun.setTextFill(Color.GREEN);
                break;
            case 5:
                labelComun.setText("Excelente");
                labelComun.setTextFill(Color.GREEN);
                break;
        }
 
    }
 
    private static boolean TestError(TextField professionField, TextField sportTextField,
            TextField favoriteBrandTextField, TextField otherBrandTextField, ChoiceBox<String> ageChoiceBox,
            ChoiceBox<String> brotherChoiceBox, ChoiceBox<String> chooseBrandChoiceBox,
            ChoiceBox<String> productChoiceBox, ChoiceBox<String> shoesChoiceBox, ToggleGroup bestBrandToggleGroup,
            RadioButton yesButton, RadioButton noButton, RadioButton dontKnowButton, ToggleGroup sexToggleGroup,
            RadioButton manButton, RadioButton womenButton, Slider qualitySlider, Slider costSlider,GridPane formInterface,GridPane formInterfaceMid, GridPane formInterfaceMidBottom,ChoiceBox<String> moneyChoiceBox ,ChoiceBox<String> garmetChoiceBox, GridPane formInterfaceBottom, Label validacion) {
        Boolean showError = false;
 
        Label profesionError = new Label("*");
        Label sportError = new Label("*");
        Label favoriteError = new Label("*");
        Label otherBrandError = new Label("*");
        Label ageError = new Label("*");
        Label brotherError = new Label("*");
        Label chooseError = new Label("*");
        Label productError = new Label("*");
        Label shoesError = new Label("*");
        Label bestError = new Label("*");
        Label sexError = new Label("*");
        Label qualityError = new Label("*");
        Label costError = new Label("*");
        Label moneyError = new Label("*");
        Label garmetError = new Label("*");
 
        if (professionField.getCharacters().length() == 0) {
            profesionError.setStyle("-fx-text-fill: #FF2D00;");
            formInterface.add(profesionError, 2, 0);
            showError = true;
        } else {
             formInterface.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 0);
        }
 
        if (sportTextField.getCharacters().length() == 0) {
            if(sportTextField.isDisable() == false){
            sportError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMid.add(sportError, 3, 0);
            showError = true;}
        } else {
            formInterfaceMid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 0);
        }
 
        if (favoriteBrandTextField.getCharacters().length() == 0) {
            favoriteError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMid.add(favoriteError, 2, 1);
            showError = true;
        } else {
            formInterfaceMid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 1);
        }
 
        if (otherBrandTextField.getCharacters().length() == 0) {
            if(otherBrandTextField.isDisable()==false){
            otherBrandError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMid.add(otherBrandError, 3, 2);
            showError = true;}
        } else {
           formInterfaceMid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 2);
        }
 
        if (ageChoiceBox.getValue() == null) {
            ageError.setStyle("-fx-text-fill: #FF2D00;");
            formInterface.add(ageError, 2, 1);
            showError = true;
        } else {
            formInterface.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 1);
        }
 
        if (brotherChoiceBox.getValue() == null) {
            brotherError.setStyle("-fx-text-fill: #FF2D00;");
            formInterface.add(brotherError, 5, 1);
            showError = true;
        } else {
            formInterface.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 5 && GridPane.getRowIndex(node) == 1);
        }
 
        if (chooseBrandChoiceBox.getValue() == null) {
            chooseError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMid.add(chooseError, 2, 3);
            showError = true;
        } else {
            formInterfaceMid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 3);
        }
 
        if (productChoiceBox.getValue() == null) {
            productError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMid.add(productError, 2, 4);
            showError = true;
        } else {
             formInterfaceMid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 4);
        }
 
        if (shoesChoiceBox.getValue() == null) {
            shoesError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMidBottom.add(shoesError, 2, 2);
            showError = true;
        } else {
            formInterfaceMidBottom.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 2);
        }
 
        if (bestBrandToggleGroup.getSelectedToggle() == null) {
            bestError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMidBottom.add(bestError, 3, 6);
            showError = true;
        } else {
            formInterfaceMidBottom.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 6);
        }
 
        if (sexToggleGroup.getSelectedToggle() == null) {
            sexError.setStyle("-fx-text-fill: #FF2D00;");
            formInterface.add(sexError, 4, 2);
            showError = true;
        } else {
            formInterface.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 4 && GridPane.getRowIndex(node) == 2);
        }
 
 
 
        if (qualitySlider.getValue() == 0) {
            qualityError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMidBottom.add(qualityError, 3, 0);
            showError = true;
        } else {
            formInterfaceMidBottom.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 0);
        }
 
        if (costSlider.getValue() == 0) {
            costError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMidBottom.add(costError, 3, 1);
            showError = true;
        } else {
            formInterfaceMidBottom.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 3 && GridPane.getRowIndex(node) == 1);
        }
 
        if (moneyChoiceBox.getValue() == null) {
            moneyError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMidBottom.add(moneyError, 2, 3);
            showError = true;
        } else {
             formInterfaceMidBottom.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 3);
        }
 
        if (garmetChoiceBox.getValue() == null) {
            garmetError.setStyle("-fx-text-fill: #FF2D00;");
            formInterfaceMidBottom.add(garmetError, 2, 4);
            showError = true;
        } else {
             formInterfaceMidBottom.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 4);
        }
 
        return showError;
    }
 
 
 
 
    public static String MakeCSV(TextField professionField, TextField sportTextField,
            TextField favoriteBrandTextField, TextField otherBrandTextField, ChoiceBox<String> ageChoiceBox,
            ChoiceBox<String> brotherChoiceBox, ChoiceBox<String> chooseBrandChoiceBox,
            ChoiceBox<String> productChoiceBox, ChoiceBox<String> shoesChoiceBox, ToggleGroup bestBrandToggleGroup,
            RadioButton yesButton, RadioButton noButton, RadioButton dontKnowButton, ToggleGroup sexToggleGroup,
            RadioButton manButton, RadioButton womenButton, Slider qualitySlider, Slider costSlider, Label qualitySliderLabel, Label shoesLabel,GridPane formInterface, GridPane formInterfaceMid,GridPane formInterfaceMidBottom,ChoiceBox<String> moneyChoiceBox,ChoiceBox<String> garmetChoiceBox,GridPane formInterfaceBottom,Label validacion) {
        if (TestError(professionField, sportTextField,
                favoriteBrandTextField, otherBrandTextField, ageChoiceBox,
                brotherChoiceBox, chooseBrandChoiceBox,
                productChoiceBox, shoesChoiceBox, bestBrandToggleGroup,
                yesButton, noButton, dontKnowButton, sexToggleGroup,
                manButton, womenButton, qualitySlider, costSlider,formInterface,formInterfaceMid,formInterfaceMidBottom,moneyChoiceBox,garmetChoiceBox,formInterfaceBottom,validacion) == false) {
            try {
                String currentPath = Paths.get("").toAbsolutePath().normalize().toString();
                String downloadFolder = "/CsVFiles";
                String downloadPath = currentPath + downloadFolder;
                File newFolder = new File(downloadPath);
                boolean dirCreated = newFolder.mkdir();
 
                // get current time
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-M-yyyy_HH-mm-ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));
                String fileName = "Enc_Deportes" + dtf.format(now) + ".csv";
 
                // Whatever the file path is.
                File statText = new File(downloadPath + "/" + fileName);
                FileOutputStream is = new FileOutputStream(statText);
                OutputStreamWriter osw = new OutputStreamWriter(is);
                Writer w = new BufferedWriter(osw);
 
                w.write(professionField.getText()+";"+ageChoiceBox.getValue()+";"+brotherChoiceBox.getValue()+";"+sportTextField.getText()+";"+favoriteBrandTextField.getText()+";"+
                        otherBrandTextField.getText() + ";" + qualitySliderLabel.getText() + shoesLabel.getText() + ";" + chooseBrandChoiceBox.getValue() + ";" + productChoiceBox.getValue()  + 
                        ";" + shoesChoiceBox.getValue() + ";" +moneyChoiceBox.getValue() + ";" + garmetChoiceBox.getValue());
                validacion.setStyle("-fx-text-fill: green;");
            validacion.setText("Formulario enviado correctamente");
 
                w.close();
 
 
                return downloadPath + "/" + fileName;
            } catch (IOException e) {
                System.err.println("Problem writing to the file " + e);
            }
        } else {
 
            validacion.setStyle("-fx-text-fill: red;");
                validacion.setText("* Los campos marcados deben rellenarse");
        }
 
        return "error";
    }
}