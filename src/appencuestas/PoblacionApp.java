/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
/**
 *
 * @author usu2dam
 */
public class PoblacionApp {
    public static Label correctMessage;
 
 
    public static void poblacionScreen(Scene scene, BorderPane borderPane2, Stage primaryStage){
 
        //Boton hacia atras
        Button backButton = new Button("←");
         backButton.setOnAction(e -> {
            scene.setRoot(AppEncuestas.borderPane);
        });
 
        //Configuraciones de la escena
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.TOP_CENTER);
 
        BorderPane borderPane = new BorderPane();    
        borderPane.setCenter(gridPane);
        borderPane.getStylesheets().add("/css/style.css");
        scene.setRoot(borderPane);
 
        //Texto del titulo
        Text title= new Text();
        title.setText("Encuesta de población");
        title.setFill(Color.DODGERBLUE);
        title.setEffect(new Lighting());
        title.setFont(Font.font(Font.getDefault().getFamily(), 40));
 
 
        // Imagen del titulo y boton
         Button maximize = new Button();
         maximize.setText("");
         maximize.setOnAction((ActionEvent event) -> {    
             if (primaryStage.isFullScreen())  primaryStage.setFullScreen(false);
             else   primaryStage.setFullScreen(true);  
        });
         Button btnSalir = new Button();
          btnSalir.setText("X");
         btnSalir.setStyle("-fx-background-color: red");
          // Función cerrado programa
        btnSalir.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
       
        // Hbox para el titulo e imagen
        HBox hboxTitle= new  HBox();
        hboxTitle.setPadding( new Insets(50,0, 0, 0));
        hboxTitle.setMargin(title, new Insets(0, 50, 0, 50));
         hboxTitle.setMargin(maximize, new Insets(0, 50,0 , 50));
        hboxTitle.getChildren().addAll(backButton,title,maximize,btnSalir);
        hboxTitle.setAlignment(Pos.CENTER);
        borderPane.setTop(hboxTitle);
 
 
 
        //Servicios en el hogar
        Label homeServicesLabel = new Label("¿Qué servicios tiene en su hogar? ");
        homeServicesLabel.setFont(Font.font(Font.getDefault().getFamily(), 18));
        gridPane.add(homeServicesLabel, 0, 1);
        //Servicios del hogar checkboxs
        GridPane checkboxGrid = new GridPane();//un gridpane donde colocar tosod los checkbox
 
        CheckBox homeServicesAguaCheckBox = new CheckBox("Agua potable");
        checkboxGrid.add(homeServicesAguaCheckBox, 0, 0);
 
        CheckBox homeServicesElectricidadCheckBox = new CheckBox("Electricidad");
        checkboxGrid.add(homeServicesElectricidadCheckBox, 0, 1);
 
        CheckBox homeServicesGasCheckBox = new CheckBox("Gas");
        checkboxGrid.add(homeServicesGasCheckBox, 0, 2);
 
        CheckBox homeServicesInternetCheckBox = new CheckBox("Internet");
        checkboxGrid.add(homeServicesInternetCheckBox, 0, 3);
 
        CheckBox homeServicesTelevivionCheckBox = new CheckBox("Televisión por Cable");
        checkboxGrid.add(homeServicesTelevivionCheckBox, 0, 4);
 
        gridPane.add(checkboxGrid, 0, 2);
 
        //Dispositivos electronicos en el hogar
        Label devicesLabel = new Label("Indique qué dispositivos electrónicos hay en su hogar y la cantidad: ");
        devicesLabel.setFont(Font.font(Font.getDefault().getFamily(), 18));
        gridPane.add(devicesLabel, 0, 3);
 
        GridPane electronicDevicesGrid = new GridPane();//GridPane para los labels y spinners de Devices
 
        Label devicesComputadoraLabel = new Label("Computadora de escritorio: ");
        Spinner devicesComputadoraSpinner = new Spinner(0, 99, 0);
        electronicDevicesGrid.add(devicesComputadoraLabel, 0, 0);
        electronicDevicesGrid.add(devicesComputadoraSpinner, 1, 0);
 
        Label devicesPortatilLabel = new Label("Computadora portátil: ");
        Spinner devicesPortatilSpinner = new Spinner(0, 99, 0);
        electronicDevicesGrid.add(devicesPortatilLabel, 0, 1);
        electronicDevicesGrid.add(devicesPortatilSpinner, 1, 1);
 
        Label devicesMovilLabel = new Label("Móvil: ");
        Spinner devicesMovilSpinner = new Spinner(0, 99, 0);
        electronicDevicesGrid.add(devicesMovilLabel, 0, 2);
        electronicDevicesGrid.add(devicesMovilSpinner, 1, 2);
 
        Label devicesTabletLabel = new Label("Tablet: ");
        Spinner devicesTabletSpinner = new Spinner(0, 99, 0);
        electronicDevicesGrid.add(devicesTabletLabel, 0, 3);
        electronicDevicesGrid.add(devicesTabletSpinner, 1, 3);
 
        Label devicesTeleLabel = new Label("Televisión: ");
        Spinner devicesTeleSpinner = new Spinner(0, 99, 0);
        electronicDevicesGrid.add(devicesTeleLabel, 0, 4);
        electronicDevicesGrid.add(devicesTeleSpinner, 1, 4);
 
        gridPane.add(electronicDevicesGrid, 0, 4);
 
 
 
        //Nivel educativo alcanzado
        Label educationLevelLabel = new Label("Nivel educativo alcanzado: ");
        educationLevelLabel.setFont(Font.font(Font.getDefault().getFamily(), 18));
        gridPane.add(educationLevelLabel, 0, 5);
        ChoiceBox educationLevelChoiceBox = new ChoiceBox();
        educationLevelChoiceBox.getItems().addAll("Primaria", "Secundaria","Bachillerato", "Posgrado", "Ninguno");
        gridPane.add(educationLevelChoiceBox, 1, 5);
        //error
        Label educationLevelError = new Label("*");
        educationLevelError.setStyle("-fx-text-fill: #FF2D00;");
        educationLevelError.setVisible(false);
        gridPane.add(educationLevelError, 2, 5);
 
        //Nivel educativo cursando
        Label educationActualLabel = new Label("Actualmente, ¿está estudiando? ¿en qué nivel?");
        educationActualLabel.setFont(Font.font(Font.getDefault().getFamily(), 18));
        gridPane.add(educationActualLabel, 0, 6);
        ChoiceBox educationActualChoiceBox = new ChoiceBox();
        educationActualChoiceBox.getItems().addAll("Primaria", "Secundaria","Bachillerato", "Posgrado", "Ninguno");
        gridPane.add(educationActualChoiceBox, 1, 6);
        //error
        Label educationActualError = new Label("*");
        educationActualError.setStyle("-fx-text-fill: #FF2D00;");
        educationActualError.setVisible(false);
        gridPane.add(educationActualError, 2, 6);
 
 
        //Seccion de trabajo
        Label ifWorkLabel = new Label("¿Actualmente trabaja? ");
        ifWorkLabel.setFont(Font.font(Font.getDefault().getFamily(), 18));
 
        ToggleGroup toggleGroupWork = new ToggleGroup();
 
        RadioButton radioButtonWorkYes = new RadioButton("Sí");
        radioButtonWorkYes.setToggleGroup(toggleGroupWork);
        RadioButton radioButtonWorkNo = new RadioButton("No");
        radioButtonWorkNo.setToggleGroup(toggleGroupWork);
 
        HBox hboxToggleWork = new HBox();
        radioButtonWorkYes.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
        radioButtonWorkNo.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
        hboxToggleWork.getChildren().addAll(radioButtonWorkYes, radioButtonWorkNo);
        gridPane.add(ifWorkLabel, 0, 7); 
        gridPane.add(hboxToggleWork, 1, 7); 
        radioButtonWorkNo.setSelected(true);
 
        //Elementos a añadir si hay ingresos extra
        GridPane workGridPane = new GridPane();
 
        //Sector de trabajo
        Label workSectorLabel = new Label("¿En qué sector? ");
        TextField workSectorField = new TextField();
        workGridPane.add(workSectorLabel, 0, 0); 
        workGridPane.add(workSectorField, 1, 0);
        //error
        Label workSectorError = new Label("*");
        workSectorError.setStyle("-fx-text-fill: #FF2D00;");
        workSectorError.setVisible(false);
        workGridPane.add(workSectorError, 2, 0);
 
        //Horas de trabajo
        Label workHoursLabel = new Label("¿Cuántas horas trabaja por semana? ");
        ChoiceBox workHoursChoiceBox = new ChoiceBox();
        workHoursChoiceBox.getItems().addAll("Menos de diez horas", "Entre diez y veinte horas","Entre veinte y treinta horas", "Entre treinta y cuarenta horas", "Entre cuarenta y cincuenta horas", "Más de cincuenta horas");
        workGridPane.add(workHoursLabel, 0, 1); 
        workGridPane.add(workHoursChoiceBox, 1, 1);
        //error
        Label workHoursError = new Label("*");
        workHoursError.setStyle("-fx-text-fill: #FF2D00;");
        workHoursError.setVisible(false);
        workGridPane.add(workHoursError, 2, 1);
 
        //Salario
        Label salaryLabel = new Label("Indique su salario: ");
        ChoiceBox salaryChoiceBox = new ChoiceBox();
        salaryChoiceBox.getItems().addAll("Menos de 10.000€", "Entre 10.000€ y 15.000€","Entre 15.000€ y 20.000€", "Entre 20.000€ y 50.000€", "Entre 50.000€ y 100.000€", "Más de 100.000€");
        workGridPane.add(salaryLabel, 0, 2); 
        workGridPane.add(salaryChoiceBox, 1, 2);
        //error
        Label worksalaryError = new Label("*");
        worksalaryError.setStyle("-fx-text-fill: #FF2D00;");
        worksalaryError.setVisible(false);
        workGridPane.add(worksalaryError, 2, 2);
 
 
        //En caso de trabajar añade los elementos
        radioButtonWorkYes.setOnAction(event -> {
            gridPane.add(workGridPane, 0, 8);
        });
 
        //En caso de cambiar a la opcion no eliminar los elementos
        radioButtonWorkNo.setOnAction(event -> {
            if(gridPane.getChildren().contains(workGridPane)){
                gridPane.getChildren().remove(workGridPane);
            }
        });
 
 
        //Pension jubilacion o desempleo
        Label extraInputLabel = new Label("¿Recibe alguna pensión, jubilación o seguro de desempleo? ");
        extraInputLabel.setFont(Font.font(Font.getDefault().getFamily(), 18));
 
        ToggleGroup toggleGroupExIn = new ToggleGroup();
 
        RadioButton radioButtonExInYes = new RadioButton("Sí");
        radioButtonExInYes.setToggleGroup(toggleGroupExIn);
        RadioButton radioButtonExInNo = new RadioButton("No");
        radioButtonExInNo.setToggleGroup(toggleGroupExIn);
 
        HBox hboxToggleExIn = new HBox();
        radioButtonExInYes.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
        radioButtonExInNo.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
        hboxToggleExIn.getChildren().addAll(radioButtonExInYes, radioButtonExInNo);
        gridPane.add(extraInputLabel, 0, 9); 
        gridPane.add(hboxToggleExIn, 1, 9);
        radioButtonExInNo.setSelected(true);
 
        //Elementos a añadir si hay ingresos extra
        HBox extraInputAmountHBox = new HBox();
        Label extraInputAmountLabel = new Label("Indique un monto: ");
        TextField extraImputAmountField = new TextField();
        extraInputAmountHBox.getChildren().addAll(extraInputAmountLabel, extraImputAmountField);
        //error
        Label inputAmountError = new Label("*");
        inputAmountError.setStyle("-fx-text-fill: #FF2D00;");
        inputAmountError.setVisible(false);
        extraInputAmountHBox.getChildren().add(inputAmountError);
 
 
        //En caso de haber ingrsos extra añade los elementos
        radioButtonExInYes.setOnAction(event -> {
            gridPane.add(extraInputAmountHBox, 0, 10);
        });
 
        //En caso de cambiar a la opcion no eliminar los elementos
        radioButtonExInNo.setOnAction(event -> {
            if(gridPane.getChildren().contains(extraInputAmountHBox)){
                gridPane.getChildren().remove(extraInputAmountHBox);
            }
        });
 
 
 
        //Boton enviar
        Button btnSend = new Button("Enviar");
        gridPane.add(btnSend, 1, 11);
        //formulario enviado
        correctMessage = new Label("Formulario enviado correctamente");
        correctMessage.setTextFill(Color.GREEN);
        correctMessage.setVisible(false);
        gridPane.add(correctMessage, 2, 11);
 
        btnSend.setOnAction(e -> {
            boolean error = false;
            //Comprueba que los campos necesarios esten marcados o no permite la creación del csv
            if(checkError(educationLevelChoiceBox)){
                educationLevelError.setVisible(true);
                error = true;
            } else {educationLevelError.setVisible(false);}
 
            if(checkError(educationActualChoiceBox)){
                educationActualError.setVisible(true);
                error = true;
            } else {educationActualError.setVisible(false);}
 
            if(radioButtonWorkYes.isSelected()){
                if(checkError(workSectorField) || !workSectorField.getText().matches("[a-zA-Z\\sñ]+")){
                    workSectorError.setVisible(true);
                    error = true;
                } else {workSectorError.setVisible(false);}
 
                if(checkError(workHoursChoiceBox)){
                    workHoursError.setVisible(true);
                    error = true;
                } else {workHoursError.setVisible(false);}
 
                if(checkError(salaryChoiceBox)){
                    worksalaryError.setVisible(true);
                    error = true;
                } else {worksalaryError.setVisible(false);}
            }
 
            if(radioButtonExInYes.isSelected()){
                if(checkError(extraImputAmountField) || !extraImputAmountField.getText().matches("[0-9]+")){
                    inputAmountError.setVisible(true);
                    error = true;
                } else {inputAmountError.setVisible(false);}
            }
            if ( error == true) {
                Label errorLabel = new Label("* Los campos marcados deben rellenarse");
                errorLabel.setStyle("-fx-text-fill: red;");
                  gridPane.add(errorLabel, 0, 11);  
            }else{
                 gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 11);
            }
 
 
            if (!error){
                MakeCSV(makeWrite(homeServicesAguaCheckBox, homeServicesElectricidadCheckBox, homeServicesGasCheckBox, homeServicesInternetCheckBox, homeServicesTelevivionCheckBox, devicesComputadoraSpinner, devicesPortatilSpinner, devicesMovilSpinner, devicesTabletSpinner, devicesTeleSpinner, educationLevelChoiceBox, educationActualChoiceBox, getRadioButtonValue(radioButtonWorkYes, radioButtonWorkNo), workSectorField, workHoursChoiceBox, salaryChoiceBox ,getRadioButtonValue(radioButtonExInYes, radioButtonExInNo), extraImputAmountField));
 
            }else{
                
            }
        });
 
         //return gridPane;
 
 
    }
 
    //comprueba que los campos de texto o choicebox no estén vacios
    private static boolean checkError (TextField text){
        boolean val = false;
 
        if(text.getCharacters().length() == 0 )
            val = true;
 
        return val;
    }
    private static boolean checkError (ChoiceBox choice){
        boolean val = false;
 
        if(choice.getValue() == null)
            val = true;
 
        return val;
    }
 
   //obtiene el valor del radiobutton seleccionado
   private static String getRadioButtonValue( RadioButton radioButton1, RadioButton radioButton2){
 
        String yesOrNo;
        if (radioButton1.isSelected()) {
            yesOrNo=radioButton1.getText();
        }else{
            yesOrNo=radioButton2.getText();
        }   
        return yesOrNo;  
    }
 
    //Crea el string para el csv
    private static String makeWrite(CheckBox waterS, CheckBox elecS, CheckBox gasS, CheckBox internetS, CheckBox tvS,
            Spinner pcN, Spinner laptopN, Spinner phoneN, Spinner tabletN, Spinner tvN,
            ChoiceBox studyLvl, ChoiceBox studyNow,
            String isWorking, TextField workSector, ChoiceBox workHours, ChoiceBox salary, 
            String isInput, TextField inputAmount){
 
        String write = "";
 
        write +=checkBValue(waterS) + ";";
        write +=checkBValue(elecS) + ";";
        write +=checkBValue(gasS) + ";";
        write +=checkBValue(internetS) + ";";
        write +=checkBValue(tvS) + ";";
 
        write +=pcN.getValue() + ";";
        write +=laptopN.getValue() + ";";
        write +=phoneN.getValue() + ";";
        write +=tabletN.getValue() + ";";
        write +=tvN.getValue() + ";";
 
        write +=studyLvl.getValue() + ";";
        write +=studyNow.getValue() + ";";
 
        write +=isWorking + ";";
        if(isWorking == "Sí"){
            write +=workSector.getText() + ";";
            write +=workHours.getValue() + ";";
            write +=salary.getValue() + ";";
        }
 
        write +=isInput + ";";
        if(isInput == "Sí")
            write +=inputAmount.getText() + ";";
 
        write += "\n";
 
        return write;
 
    }
 
    //Da un String a los checkbox
    private static String checkBValue(CheckBox ch){
               String value;
               if (ch.isSelected())
                   value="si";
               else
                   value="no";
               return value;
           }
 
    //Crea el csv
    public static  String MakeCSV( String infoWrite ) {
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
            String fileName = "Enc_Poblacion" + dtf.format(now) + ".csv";
 
            // Whatever the file path is.
            File statText = new File(downloadPath + "/" + fileName);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
 
                w.write(infoWrite);
                correctMessage.setVisible(true);
            w.close();
            return downloadPath + "/" + fileName;
        } catch (IOException e) {
            System.err.println("Problem writing to the file " + e);
        }
 
        return "error";
    }
}