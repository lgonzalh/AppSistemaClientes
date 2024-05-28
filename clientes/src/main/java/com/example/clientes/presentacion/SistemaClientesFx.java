package com.example.clientes.presentacion;
import  com.example.clientes.ClientesApplication;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SistemaClientesFx extends Application {
    private ConfigurableApplicationContext applicationContext;

    //public static void main(String[] args) {
    // launch(args);
    //}
    @Override
    public void init(){
        this.applicationContext =
                new SpringApplicationBuilder(ClientesApplication.class).run();
    }
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(ClientesApplication.class.getResource("/templates/index.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene escena = new Scene(loader.load());
        Image icon = new Image(getClass().getResourceAsStream("/favicon.ico"));
        stage.getIcons().add(icon);
        stage.setScene(escena);
        stage.show();
        }
    @Override
    public void stop(){
        applicationContext.close();
        Platform.exit();
    }
}