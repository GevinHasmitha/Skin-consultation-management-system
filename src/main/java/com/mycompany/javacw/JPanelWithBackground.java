package com.mycompany.javacw;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Using constructor, the background image is loaded and then the
 * paintComponent() method is overrided to set the background image*
 */
public class JPanelWithBackground extends JPanel {

    private Image backgroundImage;

    public JPanelWithBackground(String imgName) throws IOException {
        this.backgroundImage = ImageIO.read(new File(imgName));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        /**To scale the background image we can use below code. It is commented as
         it uses high resources which cannot be provided by my computer**/
        //Image scaledImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);

        //Sets the background image
        g.drawImage(backgroundImage, 0, 0, this);
    }

}
