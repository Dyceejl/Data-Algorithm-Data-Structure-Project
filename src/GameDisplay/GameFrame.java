package GameDisplay;

import javax.swing.JFrame;

import Model.LoadData;

public class GameFrame extends JFrame {

    private LoadData loadData;

    private GamePanel gamePanel;

    public GameFrame() {

        loadData = new LoadData();

        add(gamePanel = new GamePanel(9, 9, 10));

        setIconImage(loadData.getListImage().get("title"));

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
    
}
