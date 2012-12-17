package org.dzirtbry.stereoimages.swing;

import org.dzirtbry.stereoimages.StereoImageCreator;
import org.dzirtbry.stereoimages.generators.SimpleMaskCreator;
import org.dzirtbry.stereoimages.generators.TextImageGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Simple frame to show how generator is working.
 *
 * Contains main entry point
 *
 * @author volodymyr.kotyuk
 */
public class StereoImagesFrame extends JFrame implements ActionListener {
    private final static int SIZE = 640;
    StereoImageCreator imageCreator = new StereoImageCreator();
    SimpleMaskCreator maskCreator = new SimpleMaskCreator();
    private JLabel label;
    private JTextField text;
    private JButton button;
    private ImagePanel imagePanel;


    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public StereoImagesFrame() throws HeadlessException {
        super("Generate stereo images");
        init();
    }

    private void init() {
        label = new JLabel("Text for generation");
        text = new JTextField(10);
        button = new JButton("Generate!");
        button.addActionListener(this);

        JPanel topPanel = new JPanel(new FlowLayout());

        imagePanel = new ImagePanel(new TextImageGenerator("Enter text to generate!").generate(SIZE, SIZE));

        topPanel.add(label);
        topPanel.add(text);
        topPanel.add(button);

        this.getContentPane().add(topPanel, BorderLayout.NORTH);
        this.getContentPane().add(imagePanel);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!text.getText().isEmpty() && text.getText().length() < 20) {
            BufferedImage stereoImage = imageCreator.createStereoImage(maskCreator.createMaskFromText(SIZE, SIZE, text.getText()));
            imagePanel.setImage(stereoImage);
        }
    }

    public static void main(String[] args) {
        StereoImagesFrame stereoImagesFrame = new StereoImagesFrame();
    }
}
