
package appencuestas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public  class HealthApp {
    
    //Scena
    //public static Scene scene;
    //Gridpane
    public static GridPane gridPane ;
    //Texto
    public static Text title ;
    //DatePicker
    public static DatePicker birthdayDP;
    public static DatePicker dateOfMedicVisitDP;
    //BorderPane
    public static BorderPane borderPane;
    //Hbox
    public static HBox hboxTitle;
    public static HBox hboxToggleYesOrNo;
    public static HBox hboxToggleMedicalInsurance;
    //Img
    public static Image imgTitle ;
    public static ImageView imgViewTitle;
    
   public static Image imgBotton;
   public static ImageView imgviewBotton = new ImageView(imgBotton);
    //Label
    public static Label dateOfBirth;
    public static Label dateOfMedicVisit;
    public static Label placeOfOrigin;
    public static Label placeOfResidence;
    public static Label visitDoctorEveryYear;
    public static Label medicalInsurance;
    public static Label specialistVisit ;
    public static Label howOften;
    public static Label medicalAssistance;
    public static Label slidderMedicalAssistanceL;
    public static Label sameHospital ;
    public static Label  sliderCalificationHospitalL;
    public static Label medicalInsuranceS;
    public static  Label  medicalInsuranceSL;
    
    //TexField
    public static TextField placeOfOriginTF;
    public static TextField placeOfResidenceTF;
    public static TextField specialistVisitTF ;
    
    //Radio Buttons
     public static RadioButton radioButtonYes;
     public static RadioButton radioButtonNo;
     
     public static RadioButton radioButtonYesMedicalInsurance;
     public static RadioButton radioButtonNoMedicalInsurance ;
     
     //ToggleGroup
     public static ToggleGroup toggleGroupYesOrNo;
     public static ToggleGroup toggleGroupYesOrNoMedicalInsurance;
     
     //Choicebox
     public static ChoiceBox timeCB;
     
     //Sliders
     public static Slider sliderMedicalAssitance;
     public static Slider sliderCalificationHospital;
     public static Slider sliderMedicalInsurance ;
     
     //Button
     public static Button btnSend = new Button();
     public static Button btnSalir= new Button();

    
    public static void saludScreen(Scene scene, BorderPane borderPane, Stage primaryStage){
 
        //Boto atras
        
        Button backButton = new Button("←");
         backButton.setOnAction(e -> {
            scene.setRoot(AppEncuestas.borderPane);
        });
        
        //Configuraciones de la escena
         gridPane= new GridPane();
         gridPane.setHgap(10);
         gridPane.setVgap(20);
         gridPane.setPadding( new Insets(50, 0,0 , 0));
         
         borderPane= new BorderPane();    
         borderPane.setCenter(gridPane); // Add gridpane al centro del bordepane
         borderPane.getStylesheets().add("/css/style.css");
         scene.setRoot(borderPane); // PARA NO CAMBIAR DE SCENA
         
         
         //Texto del titulo y botones
           Button maximize = new Button();
         maximize.setText("");
         maximize.setOnAction((ActionEvent event) -> {    
             if (primaryStage.isFullScreen())  primaryStage.setFullScreen(false);
             else   primaryStage.setFullScreen(true);  
        });
         title= new Text();  
         title.setFill(Color.DODGERBLUE);
        title.setEffect(new Lighting());
         btnSalir.setText("X");
         btnSalir.setStyle("-fx-background-color: red");
          // Función cerrado programa
        btnSalir.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
         title.setText("Encuesta de salud");
         title.setId("titleHealth"); 
         // Imagen del titulo
         imgTitle= new Image("src/healthTitle.png",85,85,false,false);
         imgViewTitle = new ImageView(imgTitle);
         // Hbox donde almaceno titulo e imagen
         hboxTitle= new  HBox();
         hboxTitle.setPadding( new Insets(50,0, 0, 0));
         hboxTitle.setMargin(title, new Insets(0, 50, 0, 50));
         hboxTitle.setMargin(btnSalir, new Insets(0, 50, 0, 10));
         hboxTitle.setMargin(maximize, new Insets(0, 50,0 , 50));
         hboxTitle.getChildren().addAll(backButton,title,maximize,btnSalir);
         hboxTitle.setAlignment(Pos.CENTER);
         borderPane.setTop(hboxTitle);
         
         //Fecha de nacimiento
         dateOfBirth = new Label();
         birthdayDP = new DatePicker();
          birthdayDP.setDayCellFactory((DatePicker picker) -> new DateCell() {
             @Override
             public void updateItem(LocalDate date, boolean empty) {
                 super.updateItem(date, empty);
                  // Si la fecha es mayor a la actual
                 if (date.isAfter(LocalDate.now()))  this.setDisable(true);
                 // Si la fechaes menor de 2000
                 if(date.isBefore(LocalDate.of(1923, Month.JANUARY, 1))){
                     this.setDisable(true);
                 }
             }
         });

         birthdayDP.setEditable(false);
         dateOfBirth.setText("Fecha de nacimiento: ");
         dateOfBirth.setFont(Font.font(Font.getDefault().getFamily(), 18));
         gridPane.setAlignment(Pos.TOP_CENTER);
         gridPane.add(dateOfBirth, 0, 0);
         gridPane.add(birthdayDP, 1, 0);
         
         //Fecha ultima revision medica
          dateOfMedicVisit= new Label();
          dateOfMedicVisitDP= new DatePicker();
          dateOfMedicVisitDP.setDayCellFactory((DatePicker picker) -> new DateCell() {
             @Override
             public void updateItem(LocalDate date, boolean empty) {
                 super.updateItem(date, empty);
                  // Si la fecha es mayor a la actual
                 if (date.isAfter(LocalDate.now()))  this.setDisable(true);
                 // Si la fechaes menor de 2000
                 if(date.isBefore(LocalDate.of(2000, Month.JANUARY, 1))){
                     this.setDisable(true);
                 }
             }
         });
          dateOfMedicVisitDP.setEditable(false);
          dateOfMedicVisit.setText("Fecha de la última revisión médica: ");
          dateOfMedicVisit.setFont(Font.font(Font.getDefault().getFamily(), 18));
          gridPane.add(dateOfMedicVisit, 0, 1);
          gridPane.add(dateOfMedicVisitDP, 1, 1);
          
          //Lugar de origen
          placeOfOrigin = new Label();
          placeOfOriginTF = new TextField();
          placeOfOrigin.setText("Lugar de origen: ");
          placeOfOrigin.setFont(Font.font(Font.getDefault().getFamily(), 18));
          gridPane.add(placeOfOrigin, 0, 11);
          gridPane.add(placeOfOriginTF, 1, 11);
         
          //Lugar de residencia
          placeOfResidence = new Label();
          placeOfResidenceTF = new TextField();
          placeOfResidence.setText("Lugar de residencia: ");
          placeOfResidence.setFont(Font.font(Font.getDefault().getFamily(), 18));
          gridPane.add(placeOfResidence, 0, 12);
          gridPane.add(placeOfResidenceTF, 1, 12);
          
          //Visita al medico todos los años
          visitDoctorEveryYear = new Label();
          radioButtonYes = new RadioButton();
          radioButtonNo = new RadioButton();
          toggleGroupYesOrNo= new ToggleGroup();
          hboxToggleYesOrNo = new HBox();
          visitDoctorEveryYear.setText("¿Visita al médico todos los años? : ");
          visitDoctorEveryYear.setFont(Font.font(Font.getDefault().getFamily(), 18));
          radioButtonYes.setText("Sí");
          radioButtonYes.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
          radioButtonNo.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
          radioButtonNo.setText("No");
          radioButtonYes.setToggleGroup(toggleGroupYesOrNo);
          radioButtonNo.setToggleGroup(toggleGroupYesOrNo);
          hboxToggleYesOrNo.getChildren().add(radioButtonYes);
          hboxToggleYesOrNo.getChildren().add(radioButtonNo);
          gridPane.add(visitDoctorEveryYear, 0, 2); 
          gridPane.add(hboxToggleYesOrNo, 1, 2); 
          
          //Tiene seguro medico u obra social
          medicalInsurance= new Label();
          radioButtonYesMedicalInsurance = new RadioButton();
          radioButtonNoMedicalInsurance = new RadioButton();
          hboxToggleMedicalInsurance = new HBox();
          toggleGroupYesOrNoMedicalInsurance = new ToggleGroup();
          medicalInsurance.setText("¿Tiene seguro médico u obra social?");
          medicalInsurance.setFont(Font.font(Font.getDefault().getFamily(), 18));
          radioButtonYesMedicalInsurance.setText("Sí");
          radioButtonYesMedicalInsurance.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
          radioButtonNoMedicalInsurance.setPadding(new Insets(5,0,0,5)); // Padding a los botones SI y NO
          radioButtonNoMedicalInsurance.setText("No");
          radioButtonYesMedicalInsurance.setToggleGroup(toggleGroupYesOrNoMedicalInsurance);
          radioButtonNoMedicalInsurance.setToggleGroup(toggleGroupYesOrNoMedicalInsurance); 
          hboxToggleMedicalInsurance.getChildren().add(radioButtonYesMedicalInsurance);
          hboxToggleMedicalInsurance.getChildren().add(radioButtonNoMedicalInsurance);
          gridPane.add(medicalInsurance, 0, 3); 
          gridPane.add(hboxToggleMedicalInsurance, 1, 3); 
          
          //A que especialista acude con frecuencia
          specialistVisit = new Label();
          specialistVisitTF = new TextField();
          timeCB  = new ChoiceBox();
          timeCB.setId("Choice");
          howOften = new Label();
          specialistVisit.setText("¿A qué especialistas acude con frecuencia?");
          specialistVisit.setFont(Font.font(Font.getDefault().getFamily(), 18));
          howOften.setText("¿Cada cuánto tiempo?");
          howOften.setFont(Font.font(Font.getDefault().getFamily(), 18));
          timeCB.getItems().addAll("1 año", "2 años","3 años");
          gridPane.add(specialistVisit, 0, 13); 
          gridPane.add(specialistVisitTF, 1, 13); 
          gridPane.add(howOften, 0, 14); 
          gridPane.add(timeCB, 1, 14); 
          
          //Como calificaria la asistencia medica que recibe
          slidderMedicalAssistanceL = new Label();
          medicalAssistance = new Label();
          sliderMedicalAssitance = new Slider();
          medicalAssistance.setText("¿Cómo calificaría la asistencia médica que recibe? ");
          medicalAssistance.setFont(Font.font(Font.getDefault().getFamily(), 18));
          sliderMedicalAssitance.setMin(0);
          sliderMedicalAssitance.setMax(10);
          sliderMedicalAssitance.setValue(0);
          sliderMedicalAssitance.setShowTickLabels(true);
          sliderMedicalAssitance.setMajorTickUnit(1);
          sliderMedicalAssitance.setMinorTickCount(1);
          sliderMedicalAssitance.setBlockIncrement(1);
          slidderMedicalAssistanceL.setFont(Font.font(Font.getDefault().getFamily(), 18));
          gridPane.add(medicalAssistance, 0, 5); 
          gridPane.add(slidderMedicalAssistanceL, 1, 5); 
          gridPane.add(sliderMedicalAssitance, 0, 6); 
          sliderMedicalAssitance.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) -> { sliderMakeLabel(sliderMedicalAssitance,slidderMedicalAssistanceL);});
        
          //Como calificaria la organizacion del hospital de tu localidad
          sameHospital = new Label();
          sliderCalificationHospital = new Slider();
          sliderCalificationHospitalL= new Label();
          sameHospital.setText("¿Cómo calificaría la organización del hospital de tu localidad?");
          sameHospital.setFont(Font.font(Font.getDefault().getFamily(), 18));
          sliderCalificationHospital.setMin(0);
          sliderCalificationHospital.setMax(10);
          sliderCalificationHospital.setValue(0);
          sliderCalificationHospital.setShowTickLabels(true);
          sliderCalificationHospital.setMajorTickUnit(1);
          sliderCalificationHospital.setMinorTickCount(1);
          sliderCalificationHospital.setBlockIncrement(1);
          sliderCalificationHospitalL.setFont(Font.font(Font.getDefault().getFamily(), 18));
          gridPane.add(sameHospital, 0, 7); 
          gridPane.add(sliderCalificationHospital, 0, 8); 
          gridPane.add(sliderCalificationHospitalL, 1, 7); 
          sliderCalificationHospital.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) -> { sliderMakeLabel(sliderCalificationHospital,sliderCalificationHospitalL);});
         
          //Como calificaria el servicio de su seguro medico
          medicalInsuranceS = new Label();
          sliderMedicalInsurance = new Slider();
          medicalInsuranceSL= new Label();
          medicalInsuranceS.setText("¿Cómo calificaría el servicio de su seguro médico u obra social?");
          medicalInsuranceS.setFont(Font.font(Font.getDefault().getFamily(), 18));
          sliderMedicalInsurance.setMin(0);
          sliderMedicalInsurance.setMax(10);
          sliderMedicalInsurance.setValue(0);
          sliderMedicalInsurance.setShowTickLabels(true);
          sliderMedicalInsurance.setMajorTickUnit(1);
          sliderMedicalInsurance.setMinorTickCount(1);
          sliderMedicalInsurance.setBlockIncrement(1);
          medicalInsuranceSL.setFont(Font.font(Font.getDefault().getFamily(), 18));
          gridPane.add(medicalInsuranceS, 0, 9); 
          gridPane.add(sliderMedicalInsurance, 0, 10); 
          gridPane.add(medicalInsuranceSL, 1, 9); 
          sliderMedicalInsurance.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) -> { sliderMakeLabel(sliderMedicalInsurance,medicalInsuranceSL);});
          //Boton enviar
          btnSend.setText("Enviar");
          gridPane.add(btnSend, 1, 15); 
      
          btnSend.setOnAction(e -> {
              MakeCSV();
         });
          
          
               
        
    }

    private static boolean TestError(){
        Label errorPlaceOfOrigin = new Label("*");
        Label errorPlaceOfResidenceTF = new Label("*");
        Label errorSpecialistVisitTF = new Label("*");
        Label errorTimeCB = new Label("*"); 
        Label errorSliderMedicalInsurance = new Label("*"); 
        Label errorSliderCalificationHospital = new Label("*"); 
        Label errorSliderMedicalAssitance = new Label("*");
        Label errorBirthdayDP = new Label("*");
        Label errorDateOfMedicVisitDP = new Label("*");
        Label errorToggleGroupYesOrNoMedicalInsurance = new Label("*");
        Label errorToggleGroupYesOrNo = new Label("*");
        Boolean  showError=false;
        
        if ( placeOfOriginTF.getCharacters().length() ==0 || textChecker(placeOfOriginTF.getText()) == false) { // Validacion de  textfield vacio 
            errorPlaceOfOrigin.setStyle("-fx-text-fill: #FF2D00;");
            gridPane.add(errorPlaceOfOrigin, 2, 11);
            showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 11);
        
        
        
        if ( placeOfResidenceTF.getCharacters().length() ==0 || textChecker(placeOfResidenceTF.getText()) == false) { // Validacion de  textfield vacio 
            errorPlaceOfResidenceTF.setStyle("-fx-text-fill: #FF2D00;");
             gridPane.add(errorPlaceOfResidenceTF, 2, 12);
             showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 12);
        
        
            
            
        if (specialistVisitTF.getCharacters().length()==0 || textChecker(specialistVisitTF.getText() ) == false)
        {
          errorSpecialistVisitTF.setStyle("-fx-text-fill: #FF2D00;");
           gridPane.add(errorSpecialistVisitTF, 2, 13);
            showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 13);
            
            
            
        if (timeCB.getValue()==null)
        {
             errorTimeCB.setStyle("-fx-text-fill: #FF2D00;");
             gridPane.add(errorTimeCB, 2, 14);
            showError=true;
        }else  gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 14);
            
            
        
        if (sliderMedicalInsurance.getValue()==0) // 2 10
        {
            errorSliderMedicalInsurance.setStyle("-fx-text-fill: #FF2D00;");
             gridPane.add(errorSliderMedicalInsurance, 1, 10);
            showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 1 && GridPane.getRowIndex(node) == 10);
        
        
        
        
         if (sliderCalificationHospital.getValue()==0)
        {
             errorSliderCalificationHospital.setStyle("-fx-text-fill: #FF2D00;");
            gridPane.add(errorSliderCalificationHospital, 1, 8);
                    
            showError=true;
        }else  gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 1 && GridPane.getRowIndex(node) == 8);
         
         
         
         
          if (sliderMedicalAssitance.getValue()==0)
        {

            errorSliderMedicalAssitance.setStyle("-fx-text-fill: #FF2D00;");
             gridPane.add(errorSliderMedicalAssitance, 1, 6);
            showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 1 && GridPane.getRowIndex(node) == 6);
          
          
          
          
          
          
           if (birthdayDP.getValue()== null)
        {
            errorBirthdayDP.setStyle("-fx-text-fill: #FF2D00;");
            gridPane.add(errorBirthdayDP, 2, 0);
            showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 0);
           
           
           
           
            if (dateOfMedicVisitDP.getValue()== null)
        {
            errorDateOfMedicVisitDP.setStyle("-fx-text-fill: #FF2D00;");
            gridPane.add(errorDateOfMedicVisitDP, 2, 1);
            showError=true;
        }else gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 1);
            
            
            
            
            if (toggleGroupYesOrNo.getSelectedToggle()==null) {     
                errorToggleGroupYesOrNo.setStyle("-fx-text-fill: #FF2D00;");
                gridPane.add(errorToggleGroupYesOrNo, 2, 2);
        }else{
               
                 gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 2);

            }
            
            
            
            
            
            
                if (toggleGroupYesOrNoMedicalInsurance.getSelectedToggle()==null) {  
                    errorToggleGroupYesOrNoMedicalInsurance.setStyle("-fx-text-fill: #FF2D00;");
                    gridPane.add(errorToggleGroupYesOrNoMedicalInsurance, 2, 3);
        }else{
                    gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 3);

            }
                if (showError==true)
        {
            Label errorLabel = new Label("* Los campos marcados deben rellenarse");
            errorLabel.setStyle("-fx-text-fill: red;");
            gridPane.add(errorLabel, 0, 15);
        }else {
                gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 15);
                
                }  
                
                
                
          
        return showError;
    }
     public static boolean textChecker(String text) {
        return text.matches("[a-zA-Z\\sñ]+");
    }
   private static String getRadioButtonValue( RadioButton radioButton){
        
        String yesOrNo=" ";
        if (radioButton.isSelected()) {
            yesOrNo="Si ";
        }else{
            yesOrNo="No";
        }   
        return yesOrNo;  
    }
   public static void sliderMakeLabel(Slider sliderComun,Label labelComun){
        
        int slidderValue=(int)sliderComun.getValue();
        switch (slidderValue)
        {
            case 0:       
                 
               
            case 1:          
                  labelComun.setText("Muy mala");
                  labelComun.setTextFill(Color.RED);
                   break;
            case 2:          

            case 3:        
                  labelComun.setText("Mala");
                  labelComun.setTextFill(Color.RED);

            case 4:          
                break;
            case 5:     
                  labelComun.setText("Regular");
                  labelComun.setTextFill(Color.ORANGE);
            case 6:          
                 break;
            case 7:         
                  labelComun.setText("Bueno");
                  labelComun.setTextFill(Color.ORANGE);
                break;
            case 8:        
                 labelComun.setText("Muy Bueno");
                  labelComun.setTextFill(Color.GREEN);

            case 9:          
                break;
            case 10:      
                  labelComun.setText("Excelente");
                  labelComun.setTextFill(Color.GREEN);
                 break;
        }
          
        
    }
   public static  String MakeCSV( ) {
       if (TestError()== false)
       {
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
            String fileName = "Enc_Salud_" + dtf.format(now) + ".csv";

            // Whatever the file path is.
            File statText = new File(downloadPath + "/" + fileName);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            
           w.write(birthdayDP.getValue()+";"+placeOfOriginTF.getText()+";"+dateOfMedicVisitDP.getValue()+";"+placeOfResidenceTF.getText()+";"+getRadioButtonValue(radioButtonYes)+";"+getRadioButtonValue(radioButtonYesMedicalInsurance)+";"+specialistVisitTF.getText()+";"+timeCB.getValue()+";"+slidderMedicalAssistanceL.getText()+";"+sliderCalificationHospitalL.getText()+";"+medicalInsuranceSL.getText() +"\n");
            
            w.close();
            Label correctCSV = new Label("Formulario enviado correctamente");
              correctCSV.setTextFill(Color.GREEN);
           
            gridPane.add(correctCSV, 1, 16);
            
            
            return downloadPath + "/" + fileName;
        } catch (IOException e) {
            System.err.println("Problem writing to the file " + e);
        }
       }else{
           
       }
        

        return "error";
    }  
}
