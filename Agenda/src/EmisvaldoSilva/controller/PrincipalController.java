/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EmisvaldoSilva.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

/**
 *
 * @author Emisvaldo
 */
public class PrincipalController implements Initializable {
    
    
    @FXML
    private MenuItem miCadastrar;

    @FXML
    private MenuItem miGrupoContato;

    @FXML
    private MenuItem miConsultar;

    @FXML
    private ImageView bContato;

    @FXML
    private MenuBar mbMenuBar;

    @FXML
    private ImageView bGrupoContato;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
