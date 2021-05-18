package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.poli.PuzzleN.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controladora {
	
	public static String linha = new String();	
	
	@FXML
	private static ArrayList<String> lista = new ArrayList<String>();

	@FXML
	private ListView<String> Lista = new ListView<String>();
	
	public static Puzzle puzzle = new Puzzle(null, null);

    private Label lblGanhou = new Label();

	private Label texto = new Label();
	
    @FXML
    private Button botaoResolverFacil;
    
    @FXML
    private Button botaoResolverMedio;
    
    @FXML
    private Button botaoResolverDificil;

	@FXML
	private AnchorPane inicial;

	@FXML
	private Button botaoRetorno;
	
	@FXML
	private AnchorPane desistir;
	
    @FXML
    private AnchorPane nivelDificil;

	@FXML
	private AnchorPane nivelFacil;

	@FXML
	private AnchorPane nivelMedio;

	@FXML
	private Button botaoDesistir;

	@FXML
	private Label labelNome = new Label();

	@FXML
	private Button botao0x0;

	@FXML
	private Button botao0x1;

	@FXML
	private Button botao0x2;

	@FXML
	private Button botao1x0;

	@FXML
	private Button botao1x1;

	@FXML
	private Button botao1x2;

	@FXML
	private Button botao2x0;

	@FXML
	private Button botao2x1;

	@FXML
	private Button botao2x2;

	@FXML
	private MenuButton JogarMenuButton;

	@FXML
	private MenuItem menuItemFacil;

	@FXML
	private MenuItem menuItemMedio;

	@FXML
	private MenuItem menuItemDificil;

	@FXML
	private MenuItem menuItemInsano;

	@FXML
	private Button botaoRanking;

	@FXML
	private Button botaoInstrucao;

	@FXML
	private Button botaoInicioPartida;

	@FXML
	private TextField nome;

	@FXML
	private Button botao0x3;

	@FXML
	private Button botao1x3;

	@FXML
	private Button botao2x3;

	@FXML
	private Button botao3x3;

	@FXML
	private Button botao3x0;

	@FXML
	private Button botao3x1;

	@FXML
	private Button botao3x2;

	@FXML
	private Button botao0x4;

	@FXML
	private Button botao1x4;

	@FXML
	private Button botao2x4;

	@FXML
	private Button botao3x4;

	@FXML
	private Button botao4x4;

	@FXML
	private Button botao4x0;

	@FXML
	private Button botao4x1;

	@FXML
	private Button botao4x2;

	@FXML
	private Button botao4x3;
	
	
	public void initialize() {
			
			try {
				Rankear();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for(int i =0; i <lista.size(); i++) {
				
				if(lista.get(i)==null) {
					break;
				}
				Lista.getItems().add(lista.get(i));
			}
	}
	

	@FXML
	void acaoMenuItemDificil(ActionEvent event) throws IOException {
		if (verificaNome()) {
			alerta("Erro", "Nome nao informado", "por favor bote o nome");
		} else {
			nivelDificil = FXMLLoader.load(getClass().getResource("NivelDificil.fxml"));
			puzzle = new PuzzleDificil(new Jogador(nome.getText()), Dificuldade.Dificil);
			Main.stage.setScene(new Scene(nivelDificil));
		}

	}

	@FXML
	void acaoMenuItemFacil(ActionEvent event) throws IOException {
		if (verificaNome()) {
			alerta("Erro", "Nome nao informado", "por favor bote o nome");
		} else {
			nivelFacil = FXMLLoader.load(getClass().getResource("NivelFacil.fxml"));
			puzzle = new PuzzleFacil(new Jogador(nome.getText()), Dificuldade.Facil);
			Main.stage.setScene(new Scene(nivelFacil));
		}

	}
	
	@FXML
	void acaoBotaoResolverDificil(ActionEvent event) throws IOException{
		PuzzleDificil.resoluçãoDificil();
	}
	
	@FXML
	void acaoBotaoResolverFacil(ActionEvent event) throws IOException{
		PuzzleFacil.resoluçãoFacil();	
	}	
	
    @FXML
    void acaoBotaoResolverMedio(ActionEvent event) {
		PuzzleMedio.resoluçãoMedio();
    }

	
	@FXML
	void acaoMenuItemInsano(ActionEvent event) throws IOException {
		
		alertaInsano("Nivel Insano", "Nivel não comportado graficamente", "Por favor utilize o console para jogar");
		br.com.poli.PuzzleN.Main.Insano();
	}

	@FXML
	void acaoMenuItemMedio(ActionEvent event) throws IOException {
		if (verificaNome()) {
			alerta("Erro", "Nome nao informado", "por favor bote o nome");
		} else {
			nivelMedio = FXMLLoader.load(getClass().getResource("NivelMedio.fxml"));
			puzzle = new PuzzleMedio(new Jogador(nome.getText()), Dificuldade.Medio);
			Main.stage.setScene(new Scene(nivelMedio));
		}

	}

	@FXML
	void acaoBotao0x0(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(0, 0);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void acaoBotao0x1(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(0, 1);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao0x2(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(0, 2);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao0x3(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(0, 3);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao0x4(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(0, 4);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@FXML
	void acaoBotao1x0(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(1, 0);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao1x1(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(1, 1);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao1x2(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(1, 2);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao1x3(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(1, 3);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@FXML
	void acaoBotao1x4(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(1, 4);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao2x0(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(2, 0);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao2x1(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(2, 1);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao2x2(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(2, 2);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao2x3(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(2, 3);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao2x4(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(2, 4);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao3x0(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(3, 0);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao3x1(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(3, 1);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao3x2(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(3, 2);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao3x3(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(3, 3);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void acaoBotao3x4(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(3, 4);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao4x0(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(4, 0);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao4x1(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(4, 1);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao4x2(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(4, 2);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@FXML
	void acaoBotao4x3(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(4, 3);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotao4x4(ActionEvent event) {
		puzzle.getGridPuzzle().executaMovimento(4, 4);
		setaValorBotao();
		try {
			ganhar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void acaoBotaoInicioPartida(ActionEvent event) {
		labelNome.setText("Nome: " + puzzle.getJogador().getNome());
		
		
		puzzle.iniciaPartida();
		if(puzzle.getDificuldade().equals(Dificuldade.Facil)) {
			puzzle.getGridPuzzle().geraTabuleiro(Dificuldade.Facil);
			nivelFacil.getChildren().remove(botaoInicioPartida);
		}else if(puzzle.getDificuldade().equals(Dificuldade.Medio)){
			puzzle.getGridPuzzle().geraTabuleiro(Dificuldade.Medio);
			nivelMedio.getChildren().remove(botaoInicioPartida);
		}else if(puzzle.getDificuldade().equals(Dificuldade.Dificil)) {
			puzzle.getGridPuzzle().geraTabuleiro(Dificuldade.Dificil);
			nivelDificil.getChildren().remove(botaoInicioPartida);
		}
	
		
		setaBotaoVisivel();

		setaValorBotao();
		
		
	
	}
	
	public boolean verificaNome() {
		if (nome.getText().equals("")) {
			return true;
		}
		return false;
	}

	public static void alerta(String titulo, String mensagemdecima, String mensagemdebaixo) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

		dialogoInfo.setTitle(titulo);
		dialogoInfo.setHeaderText(mensagemdecima);
		dialogoInfo.setContentText(mensagemdebaixo);
		dialogoInfo.showAndWait();
	}
	
	public static void alertaInsano(String titulo, String mensagemdecima, String mensagemdebaixo) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);

		dialogoInfo.setTitle(titulo);
		dialogoInfo.setHeaderText(mensagemdecima);
		dialogoInfo.setContentText(mensagemdebaixo);
		dialogoInfo.showAndWait();
	}

	
	public void setaBotaoVisivel() {
		botao0x0.setDisable(false);
		botao0x1.setDisable(false);
		botao0x2.setDisable(false);
		if (!(botao0x3 == null)) {
			botao0x3.setDisable(false);
		}
		if (!(botao0x4 == null)) {
			botao0x4.setDisable(false);
		}
		

		botao1x0.setDisable(false);
		botao1x1.setDisable(false);
		botao1x2.setDisable(false);
		if (!(botao1x3 == null)) {
			botao1x3.setDisable(false);
		}
		
		if (!(botao1x4 == null)) {
			botao1x4.setDisable(false);
		}
		

		botao2x0.setDisable(false);
		botao2x1.setDisable(false);
		botao2x2.setDisable(false);
		if (!(botao2x3 == null)) {
			botao2x3.setDisable(false);
		}
		
		if (!(botao2x4 == null)) {
			botao2x4.setDisable(false);
		}

		if (!(botao3x0 == null)) {
			botao3x0.setDisable(false);
		}
		if (!(botao3x1 == null)) {
			botao3x1.setDisable(false);
		}
		if (!(botao3x2 == null)) {
			botao3x2.setDisable(false);
		}
		if (!(botao3x3 == null)) {
			botao3x3.setDisable(false);
		}
		if (!(botao3x4 == null)) {
			botao3x4.setDisable(false);
		}
		if (!(botao4x0 == null)) {
			botao4x0.setDisable(false);
		}
		if (!(botao4x1 == null)) {
			botao4x1.setDisable(false);
		}
		if (!(botao4x2 == null)) {
			botao4x2.setDisable(false);
		}
		if (!(botao4x3 == null)) {
			botao4x3.setDisable(false);
		}
		if (!(botao4x4 == null)) {
			botao4x4.setDisable(false);
		}
		
		
	}
	
	public void ganhar() throws IOException  {
		
		if(puzzle.isFimDeJogo()) {
			Ranking();
			Calendar tempofinal = Calendar.getInstance();
			double fim = (double)(tempofinal.getTimeInMillis() - puzzle.getTempo().getTimeInMillis()) / 60000;
			desistir = FXMLLoader.load(getClass().getResource("Desistir.fxml"));
			desistir.getChildren().add(lblGanhou);
			lblGanhou.setText("VOCÊ CONSEGUIU VENCER!!");
			lblGanhou.setStyle("-fx-text-fill: blue; -fx-font-size: 25;");
			lblGanhou.setLayoutX(150);
			lblGanhou.setLayoutY(100);
			desistir.getChildren().add(texto);
			texto.setText("Seu tempo foi de " + String.valueOf(fim) + " Minutos." + "\n" + "E sua pontuação de " + String.valueOf(puzzle.getScore().pontos(puzzle)));
			texto.setLayoutY(250);
			texto.setLayoutX(150);
			texto.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");
			Main.stage.setScene(new Scene(desistir));
			
		}
	}
	public void setaValorBotao() {

		botao0x0.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[0][0].getValor()));
		botao0x1.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[0][1].getValor()));
		botao0x2.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[0][2].getValor()));
		if (!(botao0x3 == null)) {
			botao0x3.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[0][3].getValor()));
		}
		if (!(botao0x4 == null)) {
			botao0x4.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[0][4].getValor()));
		}

		botao1x0.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[1][0].getValor()));
		botao1x1.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[1][1].getValor()));
		botao1x2.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[1][2].getValor()));
		if (!(botao1x3 == null)) {
			botao1x3.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[1][3].getValor()));
		}
		if (!(botao1x4 == null)) {
			botao1x4.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[1][4].getValor()));
		}
		botao2x0.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[2][0].getValor()));
		botao2x1.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[2][1].getValor()));
		botao2x2.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[2][2].getValor()));
		if (!(botao2x3 == null)) {
			botao2x3.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[2][3].getValor()));
		}
		if (!(botao2x4 == null)) {
			botao2x4.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[2][4].getValor()));
		}
		if (!(botao3x0 == null)) {
			botao3x0.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[3][0].getValor()));
		}
		if (!(botao3x1 == null)) {
			botao3x1.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[3][1].getValor()));
		}
		if (!(botao3x2 == null)) {
			botao3x2.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[3][2].getValor()));
		}
		if (!(botao3x3 == null)) {
			botao3x3.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[3][3].getValor()));
		}
		if (!(botao3x4 == null)) {
			botao3x4.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[3][4].getValor()));
		}
		if (!(botao4x0 == null)) {
			botao4x0.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[4][0].getValor()));
		}
		if (!(botao4x1 == null)) {
			botao4x1.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[4][1].getValor()));
		}
		if (!(botao4x2 == null)) {
			botao4x2.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[4][2].getValor()));
		}
		if (!(botao4x3 == null)) {
			botao4x3.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[4][3].getValor()));
		}
		if (!(botao4x4 == null)) {
			botao4x4.setText(Integer.toString(puzzle.getGridPuzzle().getGrids()[4][4].getValor()));
		}

	}

	@FXML
	void acaoBotaoRanking() throws IOException {
		
		Pane ranking = FXMLLoader.load(getClass().getResource("Ranking.fxml"));
		Main.stage.setScene(new Scene(ranking));

	}

	@FXML
	void acaoBotaoInstrucao() throws IOException {
		Pane instrucao = FXMLLoader.load(getClass().getResource("Instrucao.fxml"));
		Main.stage.setScene(new Scene(instrucao));
	}

	@FXML
	void acaoBotaoDesistir(ActionEvent event) throws IOException {
		Calendar tempofinal = Calendar.getInstance();
		double fim;
		if(!(puzzle.getTempo() == null)) {
			 fim = (double)(tempofinal.getTimeInMillis() - puzzle.getTempo().getTimeInMillis()) / 60000;
		}else {
			fim = 0;
		}
		desistir = FXMLLoader.load(getClass().getResource("Desistir.fxml"));
		desistir.getChildren().add(lblGanhou);
		lblGanhou.setText("VOCÊ PERDEU!!");
		lblGanhou.setStyle("-fx-text-fill: blue; -fx-font-size: 25;");
		lblGanhou.setLayoutX(150);
		lblGanhou.setLayoutY(100);
		desistir.getChildren().add(texto);
		texto.setText("Seu tempo foi de " + String.valueOf(fim) + " Minutos." +"E sua pontuação de 0.");
		texto.setLayoutY(250);
		texto.setLayoutX(150);
		texto.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");
		Main.stage.setScene(new Scene(desistir));
	}

	@FXML
	void acaoBotaoRetorno(ActionEvent event) throws IOException {
		inicial = FXMLLoader.load(getClass().getResource("Inicial.fxml"));
		Main.stage.setScene(new Scene(inicial));
	}
	
    @FXML
    void acaoBotaoRetorno2(ActionEvent event) throws IOException {
		inicial = FXMLLoader.load(getClass().getResource("Inicial.fxml"));
		Main.stage.setScene(new Scene(inicial));
    }
	
	public static void Ranking() throws IOException {
		
		Calendar tempofinal = Calendar.getInstance();
		double fim = (double)(tempofinal.getTimeInMillis() - puzzle.getTempo().getTimeInMillis()) / 60000;
		
		FileWriter rank = new FileWriter("Ranking.txt",true);
		PrintWriter gravarRank = new PrintWriter(rank);

			gravarRank.write(String.valueOf(puzzle.getJogador().getNome()+"\t"+puzzle.getScore().pontos(puzzle) + "\t" + "Pontos" +"\t"+puzzle.getDificuldade()+ "\t" + String.valueOf(fim) + " Minutos." + "\n"));
			rank.close();
		}
		
	
	public  static void Rankear() throws IOException {
		
		FileReader rank = new FileReader("Ranking.txt");
		BufferedReader lerRank = new BufferedReader (rank);
		
		while(linha != null ) {
			linha = lerRank.readLine();
			lista.add(linha);
		}
		
		rank.close();
		
		
	}
	
}
