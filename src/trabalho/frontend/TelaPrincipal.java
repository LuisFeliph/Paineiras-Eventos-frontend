package trabalho.frontend;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.io.IOException;

import org.w3c.dom.Text;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import trabalho.backend.BancoDeDados;
import trabalho.dominio.PersistenceService;
import trabalho.dominio.Usuario;

public class TelaPrincipal extends Application {
	// Armazena o layout principal da aplicação
	BorderPane root=null;
	// BD fake
	public PersistenceService service = new BancoDeDados();
	// Variável para manter o user logado 
	private Usuario usuarioLogado;
	// Chama a tela principal
    public BorderPane getRoot() {
		return root;
	}

	@Override
    public void start(Stage primaryStage) {
		// Inicializa o layout principal
        root = new BorderPane();
        
        // Criação do menu
        MenuBar menuBar = new MenuBar();
        
        // Menu Arquivo
        Menu menuArquivo = new Menu("Arquivo");
        MenuItem itemTela1 = new MenuItem("Agendamentos");
        MenuItem itemTela2 = new MenuItem("Lista de Usuarios");
       // MenuItem itemTela3 = new MenuItem("Lista de Locais");
        MenuItem itemTela4 = new MenuItem("Gerir Usuários");
        MenuItem itemTela5 = new MenuItem("Minhas Contas");
        menuArquivo.getItems().addAll(itemTela1,itemTela2,itemTela4,itemTela5);
        
        menuBar.getMenus().addAll(menuArquivo);
        root.setTop(menuBar);

        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.setTitle("Menu App");
        primaryStage.show();
        
        
        // Eventos de clique nos itens de menu
        itemTela1.setOnAction(event -> {
            root.setCenter(new Tela1());
        });
        
        itemTela2.setOnAction(event -> {
            root.setCenter(new TelaDeListagemDeUsuarios(this));
        });
        itemTela4.setOnAction(event -> {
            try {
                Parent usuariosRoot = FXMLLoader.load(getClass().getResource("usuarios.fxml"));
                root.setCenter(usuariosRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
     //   itemTela4.setOnAction(event -> {
    //    	root.setCenter(new TelaDeListagemDeOrganizacoes(this));
    //    });
        itemTela5.setOnAction(event -> {
            try {
                Parent contasRoot = FXMLLoader.load(getClass().getResource("contas.fxml"));
                root.setCenter(contasRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        root.setCenter(new TelaDeLogin(this));
    }
	
    public static void main(String[] args) {
        launch(args);
    }
    // Metodo para obter o usuário logado
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	//Metodo para definir se o usuário está logado
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}

// Definição das classes de tela
// Tela 1
class Tela1 extends StackPane {
    public Tela1() {
        Text text = new Text("Conteúdo da Tela 1");
        text.setFill(Color.WHITE);
        setPadding(new Insets(10));
        setStyle("-fx-background-color: lightblue;");
        getChildren().add(text);
    }
}

// Tela 2 SEM USO
class Tela2 extends StackPane {
    public Tela2() {
        Text text = new Text("Conteúdo da Tela 2");
        text.setFill(Color.WHITE);
        setPadding(new Insets(10));
        setStyle("-fx-background-color: lightgreen;");
        getChildren().add(text);
    }
}
