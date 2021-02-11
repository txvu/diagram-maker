package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JColorChooser;

import model.Element;
import model.IRender;
import model.Oval;
import model.Parallelogram;
import java.awt.event.KeyListener;
// import model.Rectangle;
import model.Rhombus;
import model.Text;
import model.Line;
import view.MainScreen;

public class DrawEventListener implements ActionListener, MouseListener, KeyListener {

    private MainScreen panel;
    private int clicks = 0;
    private Line line;
    private Color color = Color.WHITE;
    public static final int UNIT_MOVE = 5;

    private String shape = "";

    public DrawEventListener(MainScreen panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == panel.getClearButton()) {
            panel.getCanvas().getShapes().clear();
            panel.getCanvas().repaint();
        } else if (source == panel.getBackButton()) {
            if (!panel.getCanvas().getShapes().isEmpty()) {
                panel.getCanvas().getShapes().remove(panel.getCanvas().getShapes().size() - 1);
                panel.getCanvas().repaint();
            }

        // } else if (source == panel.getGridOnButton()) {
        //     panel.getCanvas().setGridOn(true);
        //     panel.getCanvas().repaint();
        // } else if (source == panel.getGridOffButton()) {
        //     panel.getCanvas().setGridOn(false);
        //     panel.getCanvas().repaint();
        } else if (source == panel.getGridVieCheckBox()) {
            panel.getCanvas().setGridOn(panel.getGridVieCheckBox().isSelected());
            panel.getCanvas().repaint();
        } else if (source == panel.getCursorButton()) {
            boolean isInMovingMode = panel.getCanvas().getMovingMode();
            panel.getCanvas().setMovingMode(!isInMovingMode);
            panel.getColorButton().setFocusable(isInMovingMode);
            panel.getCursorButton().setFocusable(isInMovingMode);
            panel.getOveButton().setFocusable(isInMovingMode);
            panel.getRecButton().setFocusable(isInMovingMode);
            panel.getParalleButton().setFocusable(isInMovingMode);
            panel.getRhombusButton().setFocusable(isInMovingMode);
            panel.getLineButton().setFocusable(isInMovingMode);
            panel.getTextButton().setFocusable(isInMovingMode);
            panel.getTextField().setFocusable(isInMovingMode);
            panel.getCanvas().repaint();
        } else if (source == panel.getOveButton()) {
            shape = "OVEL";
        } else if (source == panel.getRecButton()) {
            shape = "REC";
        } else if (source == panel.getParalleButton()) {
            shape = "PARALLELOGRAM";
        } else if (source == panel.getRhombusButton()) {
            shape = "RHOMBUS";
        } else if (source == panel.getLineButton()) {
            shape = "LINE";
        } else if (source == panel.getTextButton()) {
            shape = "TEXT";
        } else if (source == panel.getColorButton()) {
            color = JColorChooser.showDialog(panel.getWindow(), "Select a color", color);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        ArrayList<IRender> shapes = panel.getCanvas().getShapes();

        if (panel.getCanvas().getMovingMode()) {
            for (int i = 0; i < shapes.size(); i++) {
                Rectangle r = shapes.get(i).getBoundingBox();
                if (r.contains(e.getX(), e.getY())) {
                    panel.getCanvas().setSelectedIndex(i);
                    panel.getCanvas().repaint();
                    return;
                }
            }
            panel.getCanvas().setSelectedIndex(-1);
            panel.getCanvas().repaint();
        } else {
            ++clicks;
        switch (clicks) {
            case 1:

                switch (shape) {
                    case "OVEL":
                        Element oval = new Oval(e.getX(), e.getY(), color);
                        panel.getCanvas().getShapes().add(oval);
                        break;
                    case "REC":
                        Element rec = new model.Rectangle(e.getX(), e.getY(), color);
                        panel.getCanvas().getShapes().add(rec);
                        break;
                    case "PARALLELOGRAM":
                        Element parallelogram = new Parallelogram(e.getX(), e.getY(), color);
                        panel.getCanvas().getShapes().add(parallelogram);
                        break;
                    case "RHOMBUS":
                        Element rhombus = new Rhombus(e.getX(), e.getY(), color);
                        panel.getCanvas().getShapes().add(rhombus);
                        break;
                    case "LINE":
                        line = new Line(e.getX(), e.getY(), color);
                        panel.getCanvas().getShapes().add(line);
                        break;
                    case "TEXT":
                        if (panel.getTextField().getText() != null) {
                            Element text = new Text(e.getX(), e.getY(), panel.getTextField().getText(), color);
                            panel.getCanvas().getShapes().add(text);
                            panel.getTextField().setText("");
                        }
                        break;
                    default:
                        break;
                }

                if (shape != "LINE") {
                    clicks = 0;
                }
                // panel.getCanvas().getShapes().add(element);
                break;
            case 2:
                line.setX2(e.getX());
                line.setY2(e.getY());

                clicks = 0;
                break;
        }

        panel.getCanvas().repaint();
        }

        

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed");
        int selectedIndex = panel.getCanvas().getSelectedIndex();
        if (!panel.getCanvas().getMovingMode()) return;
        // if (selectedIndex < 0)
        //     return;

        IRender element = panel.getCanvas().getShapes().get(selectedIndex);

        var key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                element.translate(-UNIT_MOVE, 0);
                break;
            case KeyEvent.VK_RIGHT:
                element.translate(UNIT_MOVE, 0);
                break;
            case KeyEvent.VK_UP:
                element.translate(0, -UNIT_MOVE);
                break;
            case KeyEvent.VK_DOWN:
                element.translate(0, UNIT_MOVE);
                System.out.println("Down");
                break;
        }

        panel.getCanvas().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
