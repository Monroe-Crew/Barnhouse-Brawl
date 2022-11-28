import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.*;
public class Left extends SelectorArrows{
    private int timer = 0;
    private boolean grow = true;
    public void act(){
        grow = !(timer==60);
        if(grow){
            timer++;
            BufferedImage oldImage = getImage().getAwtImage();
            int w = getImage().getWidth();
            int h = getImage().getHeight();
            BufferedImage newImage = resize(oldImage, w+2, h+2);

            GreenfootImage gImage = new GreenfootImage(newImage.getWidth(), newImage.getHeight());
            BufferedImage gBufImg = gImage.getAwtImage();
            Graphics2D graphics = (Graphics2D)gBufImg.getGraphics();
            graphics.drawImage(newImage, null, 0, 0);
            setImage(gImage);
            //getImage().scale(getImage().getWidth()+5, getImage().getHeight()+5);
        }
    }      

    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_REPLICATE);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  
}
