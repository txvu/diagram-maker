package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.DrawEventListener;
import model.Element;

public class MainScreen {

    private JFrame window;
    private Canvas canvas;
    private MiniCanvas miniCanvas;

    private JButton oveButton;
    private JButton rhombusButton;
    private JButton lineButton;
    private JButton paralleButton;
    private JButton recButton;
    private JButton textButton;
    private JButton colorButton;
    private JButton cursorButton;

    private JTextField textField = new JTextField();

    private JButton clearButton = new JButton("Clear");
    // private JButton gridOnButton = new JButton("Grid On");
    // private JButton gridOffButton = new JButton("Grid Off");
    private JButton backButton = new JButton("Back");
    private JCheckBox gridVieCheckBox = new JCheckBox("Grid View");

    public MainScreen(JFrame window) {
        this.window = window;
        window.setTitle("Flow Chart");
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel westPanel = new JPanel();
        cp.add(BorderLayout.WEST, westPanel);

        JPanel eastPanel = new JPanel();
        // cp.add(BorderLayout.EAST, eastPanel);

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
        eastPanel.add(editPanel);

        miniCanvas = new MiniCanvas(this);
        editPanel.add(miniCanvas);

        editPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // JLabel textLabel = new JLabel("Text");
        // Icon textIcon = new ImageIcon("./assets/text32.png");
        textButton = new JButton(" Text ");
        // editPanel.add(textLabel);
        editPanel.add(textButton);
        editPanel.add(textField);

        Icon rhombusIcon = new ImageIcon("./assets/rhomb.png");
        Icon ovalIcon = new ImageIcon("./assets/oval.png");
        Icon lineIcon = new ImageIcon("./assets/line.png");
        Icon parallelogramIcon = new ImageIcon("./assets/parallelogram.png");
        Icon recIcon = new ImageIcon("./assets/rec.png");
        Icon cursorIcon = new ImageIcon("./assets/cursor.png");
        

        rhombusButton = new JButton(rhombusIcon);
      
         oveButton = new JButton(ovalIcon);
         lineButton = new JButton(lineIcon);
         paralleButton = new JButton(parallelogramIcon);
         recButton = new JButton(recIcon);
         cursorButton = new JButton(cursorIcon);

        JPanel toolsPanel = new JPanel();
        // toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.X_AXIS));
        // Title border for radio buttons
        TitledBorder toolstitle = BorderFactory.createTitledBorder("Tools");
        toolsPanel.setBorder(toolstitle);

        toolsPanel.add(cursorButton);
        // toolsPanel.add(Box.createRigidArea(new Dimension(60, 36)));

        JPanel elementsPanel = new JPanel();
        elementsPanel.setLayout(new GridLayout(7,1));
        // Title border for radio buttons
        TitledBorder title = BorderFactory.createTitledBorder("Elements");
        elementsPanel.setBorder(title);

        elementsPanel.add(oveButton);
        elementsPanel.add(recButton);
        elementsPanel.add(paralleButton);
        elementsPanel.add(rhombusButton);
        elementsPanel.add(lineButton);
        // elementsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        elementsPanel.add(textButton);
        elementsPanel.add(textField);

        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.add(toolsPanel);
        westPanel.add(elementsPanel);

        

        JPanel southPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        gridVieCheckBox.setSelected(true);
        buttonPanel.add(gridVieCheckBox);
        buttonPanel.add(backButton);
        // buttonPanel.add(gridOnButton);
        // buttonPanel.add(gridOffButton);
        buttonPanel.add(clearButton);
        southPanel.add(buttonPanel);
        cp.add(BorderLayout.SOUTH, southPanel);

        TitledBorder optionTitle = BorderFactory.createTitledBorder("Options");
        JPanel optionsPanel = new JPanel();
        optionsPanel.setBorder(optionTitle);
        westPanel.add(optionsPanel);
        Icon colorIcon = new ImageIcon("./assets/color.png");
        colorButton = new JButton(colorIcon);
        optionsPanel.add(colorButton);


        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        DrawEventListener listener = new DrawEventListener(this);
        cursorButton.addActionListener(listener);
        // cursorButton.setFocusable(false);
        oveButton.addActionListener(listener);
        // oveButton.setFocusable(false);
        recButton.addActionListener(listener);
        // recButton.setFocusable(false);
        paralleButton.addActionListener(listener);
        // paralleButton.setFocusable(false);
        rhombusButton.addActionListener(listener);
        // rhombusButton.setFocusable(false);
        lineButton.addActionListener(listener);
        // lineButton.setFocusable(false);
        textButton.addActionListener(listener);
        // textButton.setFocusable(false);

        colorButton.addActionListener(listener);
        // colorButton.setFocusable(false);
        
        // textField.setFocusable(false);

        gridVieCheckBox.addActionListener(listener);
        backButton.addActionListener(listener);
        // backButton.setFocusable(false);
        clearButton.addActionListener(listener);
        // clearButton.setFocusable(false);
        // gridOnButton.addActionListener(listener);
        // gridOnButton.setFocusable(false);
        // gridOffButton.addActionListener(listener);
        // gridOffButton.setFocusable(false);
        canvas.addMouseListener(listener);
        canvas.addKeyListener(listener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);
    }

    public JFrame getWindow() {
        return window;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JButton getBackButton() {
        return backButton;
    }

    // public JButton getGridOnButton() {
    //     return gridOnButton;
    // }

    // public JButton getGridOffButton() {
    //     return gridOffButton;
    // }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getOveButton() {
        return oveButton;
    }

    public MiniCanvas getMiniCanvas() {
        return miniCanvas;
    }

    public JButton getRecButton() {
        return recButton;
    }

    public JButton getRhombusButton() {
        return rhombusButton;
    }

    public JButton getLineButton() {
        return lineButton;
    }

    public JButton getParalleButton() {
        return paralleButton;
    }

    public JButton getTextButton() {
        return textButton;
    }

    public JButton getColorButton() {
        return colorButton;
    }

    public JButton getCursorButton() {
        return cursorButton;
    }

    public JCheckBox getGridVieCheckBox() {
        return gridVieCheckBox;
    }
}