package com.company.controller;

import com.company.model.Agent;
import com.company.service.AgentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Objects;

public class SaveController {

    public TextField typeTextField;

    public TextField nameTextField;

    public TextField mailTextField;

    public TextField iconTextField;

    public TextField addressTextField;

    public TextField priorityTextField;

    public TextField directorTextField;

    public TextField innTextField;

    public TextField kppTextField;

    public TextField numberTextField;

    private final AgentService agentService;

    public SaveController() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.agentService = new AgentService(factory);
    }

    public void exit(ActionEvent actionEvent) {
        final Button exit = (Button) actionEvent.getSource();
        exit.getScene().getWindow().hide();
    }

    public void back(ActionEvent actionEvent) {
        final Button exit = (Button) actionEvent.getSource();
        exit.getScene().getWindow().hide();

        openMainScene();
    }

    public void save(ActionEvent actionEvent) {
        final Button exit = (Button) actionEvent.getSource();
        exit.getScene().getWindow().hide();

        openMainScene();

        final Agent agent = new Agent(
                nameTextField.getText(),
                typeTextField.getText(),
                mailTextField.getText(),
                numberTextField.getText(),
                addressTextField.getText(),
                Integer.parseInt(priorityTextField.getText()),
                directorTextField.getText(),
                Long.parseLong(innTextField.getText()),
                Integer.parseInt(kppTextField.getText())
        );

        agentService.save(agent);
    }

    private void openMainScene(){
        Stage stage = new Stage();

        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/main.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Список агентов");
        assert root != null;
        stage.setScene(new Scene(root));
        stage.show();
    }
}

