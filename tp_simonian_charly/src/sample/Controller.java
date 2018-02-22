package sample;


import javafx.application.Platform;
import javafx.event.Event;

import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ColorPicker;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Controller {
    private EventHandler buttonDeleteListener;
    private EventHandler buttonCloneListener;
    private EventHandler clickOnCanvas;
    private EventHandler clickOnRadioButtonCircle;
    private EventHandler clickOnRadioButtonLine;
    private EventHandler clickOnRadioButtonSelect;
    private EventHandler clickOnRadioButtonRectangle;
    private EventHandler colorChanged;
    private int forme = 0;





    @FXML
    private Button delete;
    @FXML
    private Button clone ;
    @FXML
    private RadioButton ligne;
    @FXML
    private RadioButton cercle;
    @FXML
    private RadioButton selecte;
    @FXML
    private RadioButton rectangle;
    @FXML
    private Canvas dessin;
    @FXML
    private ColorPicker color_picker;


    @FXML
    public  void initialize(){
        GraphicsContext gc = dessin.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.WHITE);





        buttonDeleteListener = new EventHandler() {

            public void handle(Event event) {

                gc.clearRect(0,0,1000,1000);
            }
        };

        buttonCloneListener = new EventHandler() {

            public void handle(Event event) {
                Platform.exit();
            }
        };

        clickOnRadioButtonCircle = new EventHandler() {

            public void handle(Event event) {
                forme = 1;
            }
        };
        clickOnRadioButtonLine = new EventHandler() {

            public void handle(Event event) {
                forme=0;

                }
        };
        clickOnRadioButtonSelect = new EventHandler() {

            public void handle(Event event) {
                forme = 2;

                }
        };
        clickOnRadioButtonRectangle = new EventHandler() {

            public void handle(Event event) {
                forme = 3;
           }
        };











       dessin.setOnMouseClicked(  e ->  {
           if(forme == 0){
               gc.strokeLine(e.getX(), e.getY(), e.getX()+100, e.getY());
           }
           if(forme == 1){
               gc.fillOval(e.getX(),e.getY(),50,50);
           }
           if(forme == 3){
               gc.fillRect(e.getX(),e.getY(),50,50);
           }

       });






        delete.setOnAction(buttonDeleteListener);
        clone.setOnAction(buttonCloneListener);

        ToggleGroup group = new ToggleGroup();
        ligne.setToggleGroup(group);
        cercle.setToggleGroup(group);
        rectangle.setToggleGroup(group);
        selecte.setToggleGroup(group);


        color_picker.setOnAction(e -> {
            gc .setStroke(color_picker.getValue());
            gc .setFill(color_picker.getValue());
        });




        ligne.setOnAction(clickOnRadioButtonLine);
        cercle.setOnAction(clickOnRadioButtonCircle);
        rectangle.setOnAction(clickOnRadioButtonRectangle);
        selecte.setOnAction(clickOnRadioButtonSelect);

    }





}
