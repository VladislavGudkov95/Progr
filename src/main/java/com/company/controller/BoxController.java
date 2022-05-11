package com.company.controller;

import com.company.model.Agent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BoxController {
    @FXML
    public Label typeAndNameLabel;
    @FXML
    public Label prodazhaLabel;
    @FXML
    public ImageView imageView;
    @FXML
    public Label saleLabel;
    @FXML
    public Label numberPhoneLabel;
    @FXML
    public Label priorityLabel;

    public void setDate(Agent agent){
        typeAndNameLabel.setText(agent.getType() + "|" + subText(agent.getName()));
        try {
            Image image = new Image(String.valueOf(getClass().getResource("resources/images/" + agent.getLogCompany())));
            imageView.setImage(image);
        }catch (IllegalArgumentException e) {
            Image image = new Image("/picture.png");
            imageView.setImage(image);
        }
            numberPhoneLabel.setText(agent.getNumber());
            priorityLabel.setText("Приоритетность: " + agent.getPriority());

    }

    private String subText(String name) {
        if(name.length() < 15) {
            return name;
        }else{
            return name.substring(0,15);
        }
    }
}
