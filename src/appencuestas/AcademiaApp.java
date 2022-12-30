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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Lighting;
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
 * @author usu2dam
 */
public class AcademiaApp {
 
    //Layout del root
    public static BorderPane root;
    //HBox para el formulario
    public static HBox hboxForm;
    //Layout del contenido
    public static GridPane form;
    //HBox para el titulo
    public static HBox hboxTitle ;
    //Titulo de la encuesta
    public static Text title;
    //Variables formulario
    public static Label age;
    public static TextField ageTF;
    public static Label startYear;
    public static TextField startYearTF;
    public static Label collegeCareer;
    public static TextField collegeCareerTF;
    public static Label subjectsPassed;
    public static TextField subjectsPassedTF;
    public static Label subjectsStudying;
    public static TextField subjectsStudyingTF;
    public static Label hoursPerWeek;
    public static TextField hoursPerWeekTF;
    public static Label studyHoursPerWeek;
    public static TextField studyHoursPerWeekTF;
    public static Label subjectsLevel;
    public static RadioButton levelExcellent;
    public static RadioButton levelVeryGood;
    public static RadioButton levelGood;
    public static RadioButton levelRegular;
    public static RadioButton levelBad;
    public static RadioButton levelVeryBad;
    public static ToggleGroup toggleGroupLevel;
    public static GridPane gridpaneToggleLevel;
    public static Label projectParticipation;
    public static RadioButton participationYes;
    public static RadioButton participationNo;
    public static ToggleGroup toggleGroupParticipation;
    public static GridPane gridpaneToggleParticipation;
    public static Label participationName;
    public static TextField participationNameTF;
 
    //HBox para el boton
    public static VBox vboxBtnSend;
    //Boton de enviar
    public static Button btnSend;
 
    //Botones de la cabecera
    public static Button exitButton;
    public static Button backButton;
 
    //Etiquetas de errores en tipos de datos
    public static Label ageError;
    public static Label startYearError;
    public static Label collegeCareerError;
    public static Label subjectsPassedError;
    public static Label subjectsStudyingError;
    public static Label hoursPerWeekError;
    public static Label studyHoursPerWeekError;
    public static Label participationNameError;
 
    public static void academiaScreen(Scene scene, BorderPane borderPane, Stage primaryStage) {
        //config del layout del formulario
        form = new GridPane();
        form.setHgap(10);
        form.setVgap(20);
 
 
        //Config de la escena
        root = new BorderPane();
        title = new Text("Encuesta académica");
        title.setFill(Color.DODGERBLUE);
        title.setEffect(new Lighting());
        title.setFont(Font.font(Font.getDefault().getFamily(), 40));
         root.getStylesheets().add("/css/style.css");
 
        //Configuración de los botones de la cabecera
        exitButton = new Button("X");
        exitButton.setStyle("-fx-background-color: red");
        backButton = new Button("←");
           Button maximize = new Button();
         maximize.setText("");
         maximize.setOnAction((ActionEvent event) -> {    
             if (primaryStage.isFullScreen())  primaryStage.setFullScreen(false);
             else   primaryStage.setFullScreen(true);  
        });
 
        // Función cerrado programa
        exitButton.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
 
        // Función volver al menu
        backButton.setOnAction(e -> {
            scene.setRoot(borderPane);
        });
 
       HBox hboxTitle = new HBox();
        hboxTitle.setPadding( new Insets(50,0, 0, 0));
        hboxTitle.setMargin(title, new Insets(0, 50, 0, 0));
        hboxTitle.setMargin(backButton, new Insets(0, 50, 0, 50));
        hboxTitle.setMargin(maximize, new Insets(0, 50, 0, 50));
        hboxTitle.getChildren().addAll(backButton, title, maximize,exitButton);
        hboxTitle.setAlignment(Pos.CENTER);
 
        HBox hboxForm = new HBox();
        hboxForm.setMargin(title, new Insets(0, 50, 0, 0));
        hboxForm.getChildren().add(form);
        hboxForm.setAlignment(Pos.CENTER);
 
        root.setTop(hboxTitle);
        root.setCenter(hboxForm);
        hboxForm.setPadding(new Insets(50));
 
        scene.setRoot(root);
 
        //Etiquetas de errores en tipos de datos
        ageError = new Label("El campo debe contener un número");
        ageError.setTextFill(Color.RED);
        startYearError = new Label("El campo debe contener un número");
        startYearError.setTextFill(Color.RED);
        collegeCareerError = new Label("El campo debe contener texto");
        collegeCareerError.setTextFill(Color.RED);
        subjectsPassedError = new Label("El campo debe contener un número");
        subjectsPassedError.setTextFill(Color.RED);
        subjectsStudyingError = new Label("El campo debe contener un número");
        subjectsStudyingError.setTextFill(Color.RED);
        hoursPerWeekError = new Label("El campo debe contener un número");
        hoursPerWeekError.setTextFill(Color.RED);
        studyHoursPerWeekError = new Label("El campo debe contener un número");
        studyHoursPerWeekError.setTextFill(Color.RED);
        participationNameError = new Label("El campo debe contener texto");
        participationNameError.setTextFill(Color.RED);
 
 
        //Campos del formulario
        //Edad
        age = new Label("Edad: ");
        ageTF = new TextField();
        age.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(age, 0, 0);
        form.add(ageTF, 1, 0);
 
        ageTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!numberChecker(ageTF.getText()))
                        form.add(ageError, 2, 0);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 0);
 
            }
 
        });
 
        //Año de inicio
        startYear = new Label("Año de inicio de los estudios: ");
        startYearTF = new TextField();
        startYear.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(startYear, 0, 1);
        form.add(startYearTF, 1, 1);
 
        startYearTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!numberChecker(startYearTF.getText()))
                        form.add(startYearError, 2, 1);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 1);
 
            }
 
        });
 
        //Carrera cursada
        collegeCareer = new Label("Carrera cursada: ");
        collegeCareerTF = new TextField();
        collegeCareer.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(collegeCareer, 0, 2);
        form.add(collegeCareerTF, 1, 2);
 
        collegeCareerTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!textChecker(collegeCareerTF.getText()))
                        form.add(collegeCareerError, 2, 2);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 2);
 
            }
 
        });
 
        //Asignaturas aprobadas
        subjectsPassed = new Label("Número de signaturas aprobadas: ");
        subjectsPassedTF = new TextField();
        subjectsPassed.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(subjectsPassed, 0, 3);
        form.add(subjectsPassedTF, 1, 3);
 
        subjectsPassedTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!numberChecker(subjectsPassedTF.getText()))
                        form.add(subjectsPassedError, 2, 3);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 3);
 
            }
 
        });
 
        //Asignaturas estudiando
        subjectsStudying = new Label("Numero de asignaturas estudiando actualmente: ");
        subjectsStudyingTF = new TextField();
        subjectsStudying.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(subjectsStudying, 0, 4);
        form.add(subjectsStudyingTF, 1, 4);
 
        subjectsStudyingTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!numberChecker(subjectsStudyingTF.getText()))
                        form.add(subjectsStudyingError, 2, 4);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 4);
 
            }
 
        });
 
        //Horas por semana cursadas
        hoursPerWeek = new Label("Horas por semana cursadas: ");
        hoursPerWeekTF = new TextField();
        hoursPerWeek.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(hoursPerWeek, 0, 5);
        form.add(hoursPerWeekTF, 1, 5);
 
        hoursPerWeekTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!numberChecker(hoursPerWeekTF.getText()))
                        form.add(hoursPerWeekError, 2, 5);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 5);
 
            }
 
        });
 
        //Horas de estudio por semana
        studyHoursPerWeek = new Label("Horas de estudio por semana: ");
        studyHoursPerWeekTF = new TextField();
        studyHoursPerWeek.setFont(Font.font(Font.getDefault().getFamily(), 18));
        form.add(studyHoursPerWeek, 0, 6);
        form.add(studyHoursPerWeekTF, 1, 6);
 
        studyHoursPerWeekTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!numberChecker(studyHoursPerWeekTF.getText()))
                        form.add(studyHoursPerWeekError, 2, 6);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 6);
 
            }
 
        });
 
        //Calificacion del nivel de asignaturas
        subjectsLevel = new Label("Nivel de las asignaturas: ");
        subjectsLevel.setFont(Font.font(Font.getDefault().getFamily(), 18));
        levelExcellent = new RadioButton("Excelente");
        levelVeryGood = new RadioButton("Muy bueno");
        levelGood = new RadioButton("Bueno");
        levelRegular = new RadioButton("Regular");
        levelBad = new RadioButton("Malo");
        levelVeryBad = new RadioButton("Muy malo");
        toggleGroupLevel = new ToggleGroup();
        levelExcellent.setToggleGroup(toggleGroupLevel);
        levelVeryGood.setToggleGroup(toggleGroupLevel);
        levelGood.setToggleGroup(toggleGroupLevel);
        levelRegular.setToggleGroup(toggleGroupLevel);
        levelBad.setToggleGroup(toggleGroupLevel);
        levelVeryBad.setToggleGroup(toggleGroupLevel);
        gridpaneToggleLevel = new GridPane();
        gridpaneToggleLevel.setHgap(10);
        gridpaneToggleLevel.setVgap(10);
        gridpaneToggleLevel.add(levelExcellent, 0, 0);
        gridpaneToggleLevel.add(levelVeryGood, 1, 0);
        gridpaneToggleLevel.add(levelGood, 0, 1);
        gridpaneToggleLevel.add(levelRegular, 1, 1);
        gridpaneToggleLevel.add(levelBad, 0, 2);
        gridpaneToggleLevel.add(levelVeryBad, 1, 2);
        form.add(subjectsLevel, 0, 7);
        form.add(gridpaneToggleLevel, 1, 7);
 
        //Participacion en algun proyecto
        projectParticipation = new Label("Participación en algún proyecto de investigación: ");
        projectParticipation.setFont(Font.font(Font.getDefault().getFamily(), 18));
        participationYes = new RadioButton("Sí");
        participationNo = new RadioButton("No");
        toggleGroupParticipation = new ToggleGroup();
        participationYes.setToggleGroup(toggleGroupParticipation);
        participationNo.setToggleGroup(toggleGroupParticipation);
        gridpaneToggleParticipation = new GridPane();
        gridpaneToggleParticipation.setHgap(10);
        gridpaneToggleParticipation.setVgap(10);
        gridpaneToggleParticipation.add(participationYes, 0, 0);
        gridpaneToggleParticipation.add(participationNo, 1, 0);
        form.add(projectParticipation, 0, 8);
        form.add(gridpaneToggleParticipation, 1, 8);
 
        participationName = new Label("¿Cuál?: ");
        participationName.setFont(Font.font(Font.getDefault().getFamily(), 18));
        participationNameTF = new TextField();
 
        participationYes.setOnAction(event -> {
            if(!form.getChildren().contains(participationName)) {
                form.add(participationName, 0, 9);
                form.add(participationNameTF, 1, 9);
 
            }
 
        });
 
        participationNo.setOnAction(event -> {
            participationNameTF.setText("");
            //Elimina el posible mensaje de error que tuviera el campo al estar marcado el Si
            form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 9);
            if(form.getChildren().contains(participationName))
                form.getChildren().removeAll(participationName, participationNameTF);
 
        });
 
        participationNameTF.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue) {
                    if(!textChecker(participationNameTF.getText()))
                        form.add(participationNameError, 2, 9);
 
                }
 
                else
                    form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2 && GridPane.getRowIndex(node) == 9);
 
            }
 
        });
 
        btnSend = new Button("Enviar");
        vboxBtnSend = new VBox();
        vboxBtnSend.getChildren().add(btnSend);
        vboxBtnSend.setAlignment(Pos.CENTER);
        vboxBtnSend.setPadding(new Insets(50));
 
        Label sendForm = new Label("Formulario enviado correctamente");
        sendForm.setTextFill(Color.GREEN);
 
        root.setBottom(vboxBtnSend);
 
        btnSend.setOnAction(event -> {
            int missingFields = 0;
            int wrongFields = 0;
            //Elimina el posible mensaje de formulario enviado correctamente para volver a realizar la comprobacion
            vboxBtnSend.getChildren().remove(sendForm);
 
            //Elimina los mensajes de error antes de realizar la comprobación
            form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 0 && GridPane.getRowIndex(node) == 10);
            form.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 2);
 
            //Comprueba que los campos no estén vacios y si todo es correcto procede a guardar los datos en el archivo CSV
            /*
            missingFields = checkTextField(ageTF, form, 0) || checkTextField(startYearTF, form, 1) || 
                    checkTextField(collegeCareerTF, form, 2) || checkTextField(subjectsPassedTF, form, 3) ||
                    checkTextField(subjectsStudyingTF, form, 4) ||checkTextField(hoursPerWeekTF, form, 5) ||
                    checkTextField(studyHoursPerWeekTF, form, 6) || checkToggleGroup(toggleGroupLevel, form, 7) ||
                    checkToggleGroup(toggleGroupParticipation, form, 8);
            */
            if(checkTextField(ageTF, form, 0) == 1)
                missingFields++;
 
            else if(!numberChecker(ageTF.getText())) {
                form.add(ageError, 2, 0);
                wrongFields++;
 
            }
 
            if(checkTextField(startYearTF, form, 1) == 1)
                missingFields++;
 
            else if(!numberChecker(startYearTF.getText())) {
                form.add(startYearError, 2, 1);
                wrongFields++;
 
            }
 
            if(checkTextField(collegeCareerTF, form, 2) == 1)
                missingFields++;
 
            else if(!textChecker(collegeCareerTF.getText())) {
                form.add(collegeCareerError, 2, 2);
                wrongFields++;
 
            }
 
            if(checkTextField(subjectsPassedTF, form, 3) == 1)
                missingFields++;
 
            else if(!numberChecker(subjectsPassedTF.getText())) {
                form.add(subjectsPassedError, 2, 3);
                wrongFields++;
 
            }
 
            if(checkTextField(subjectsStudyingTF, form, 4) == 1)
                missingFields++;
 
            else if(!numberChecker(subjectsStudyingTF.getText())) {
                form.add(subjectsStudyingError, 2, 4);
                wrongFields++;
 
            }
 
            if(checkTextField(hoursPerWeekTF, form, 5) == 1)
                missingFields++;
 
            else if(!numberChecker(hoursPerWeekTF.getText())) {
                form.add(hoursPerWeekError, 2, 5);
                wrongFields++;
 
            }
 
            if(checkTextField(studyHoursPerWeekTF, form, 6) == 1)
                missingFields++;
 
            else if(!numberChecker(studyHoursPerWeekTF.getText())) {
                form.add(studyHoursPerWeekError, 2, 6);
                wrongFields++;
 
            }
 
            missingFields += checkToggleGroup(toggleGroupLevel, form, 7);
            missingFields += checkToggleGroup(toggleGroupParticipation, form, 8);
 
 
            if(form.getChildren().contains(participationName)) {
                if(checkTextField(participationNameTF, form, 9) == 1)
                    missingFields++;
 
                else if(!textChecker(participationNameTF.getText())) {
                    form.add(participationNameError, 2, 9);
                    wrongFields++;
 
                }
 
            }
 
            if(missingFields == 0 && wrongFields == 0) {
                makeCSV();
                vboxBtnSend.getChildren().remove(sendForm);
                vboxBtnSend.getChildren().add(sendForm);
 
            }
 
            else if(missingFields != 0){
                Label emptyFields = new Label("* Los campos marcados deben rellenarse");
                emptyFields.setTextFill(Color.RED);
                form.add(emptyFields, 0, 10);
 
            }
        });
    }
    //Metodo para comprobar si un togglegroup está seleccionado. Devuelve true en caso de
    //que lo esté y false en caso de que no esté seleccionado.
    public static int checkToggleGroup(ToggleGroup tg, GridPane form, int row) {
        int missingToggleGroup = 0;
 
        if(!exists(tg, tg.getSelectedToggle())) {
            missingToggleGroup = 1;
            Label errorLabel = new Label("*");
            errorLabel.setTextFill(Color.RED);
            form.add(errorLabel, 2, row);
 
        }
 
 
 
        return missingToggleGroup;
    }
 
    //Metodo auxiliar para comprobar si un ToggleGroup está seleccionado
    public static boolean exists(ToggleGroup tg, Toggle rb) {
        boolean exists = false;
 
        for(int i = 0; i < tg.getToggles().size(); i++) {
            if(tg.getToggles().get(i).equals(rb))
                exists = true;
 
        }
 
        return exists;
    }
 
    //Metodo para comprobar si un textfield tiene contenido, devuelve true en caso
    //de que tenga y false en caso de que no
    public static int checkTextField(TextField tf, GridPane form, int row) {
        int missingTextField = 0;
 
        Label error = new Label("*");
        error.setTextFill(Color.RED);
 
        if(tf.getText().isEmpty()) {
            missingTextField = 1;
            form.add(error, 2, row);
 
        }
 
        return missingTextField;
    }
 
 
    public static String makeCSV( ) {
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
            String fileName = "Enc_Academica_" + dtf.format(now) + ".csv";
 
            // Whatever the file path is.
            File statText = new File(downloadPath + "/" + fileName);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
 
            RadioButton level = (RadioButton) toggleGroupLevel.getSelectedToggle();
            RadioButton participation = (RadioButton) toggleGroupParticipation.getSelectedToggle();
 
            w.write(ageTF.getText() + ";" + startYearTF.getText() + ";" + collegeCareerTF.getText() + ";" + subjectsPassedTF.getText() + ";" + 
                    subjectsStudyingTF.getText() + ";" + hoursPerWeekTF.getText() + ";" + studyHoursPerWeekTF.getText() + ";" + 
                    level.getText() + ";" + participation.getText() + ";" +
                    participationNameTF.getText());
 
            w.close();
            return downloadPath + "/" + fileName;
        } catch (IOException e) {
            System.err.println("Problem writing to the file " + e);
        }
 
        return "error";
    }
 
    public static boolean numberChecker(String text) {
        return text.matches("[0-9]+");
    }
 
    public static boolean textChecker(String text) {
        return text.matches("[a-zA-Z\\sñ]+");
    }
 
}