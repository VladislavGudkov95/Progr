package com.company.controller;

import com.company.model.Agent;
import com.company.service.AgentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    @FXML
    public TextField searchTextField;
    @FXML
    public BorderPane borderPane;
    @FXML
    public VBox vBox;
    @FXML
    public ScrollPane scrollPane;

    GridPane gridPane;

    ObservableList<Agent> agents = FXCollections.observableArrayList();

    private final AgentService agentDao;

    public MainController() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.agentDao = new AgentService(factory);
    }

    @SneakyThrows
    @FXML
    public void initialize() {
        agents.addAll(agentDao.findAll());


        for (Agent agent : agents) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/box.fxml"));
            gridPane = loader.load();

            BoxController boxController = loader.getController();
            boxController.setDate(agent);

            vBox.getChildren().add(gridPane);
        }

    }

    public void saveButton(ActionEvent actionEvent) {
        final Button button = (Button) actionEvent.getSource();
        button.getScene().getWindow().hide();

        Stage stage = new Stage();

        Parent root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/save.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Добавить агента");
        assert root != null;
        stage.setScene(new Scene(root));
        Image image = new Image(String.valueOf(getClass().getResource("/icon.ico")));
        stage.getIcons().add(image);
        stage.show();
    }


    public void delete(ActionEvent actionEvent) {
    }

    public void update(ActionEvent actionEvent) {
    }


}
