import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class StickerMaker {
    
    public void stickerMaker () throws Exception {
        // read image
        BufferedImage originalImage = ImageIO.read(new File("entry/filme.jpg"));

        // create a new image with transparency and a new Heigth
        int width = originalImage.getWidth();
        int altura = originalImage.getHeight();
        int newHeigth = altura + 200;
        BufferedImage newImage = new BufferedImage(width, newHeigth, BufferedImage.TRANSLUCENT);

        //copy original image to a new image (in memory)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        //  write a phase in new image 
        
        //  write a new image in a file
        ImageIO.write(newImage, "png", new File("output/sticker.png"));
    }

    public static void main(String[] args) throws Exception {
        var builderSticker = new StickerMaker();
        builderSticker.stickerMaker();
    }
}