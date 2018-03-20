import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Tester
{
    public static void main(String args[]) throws IOException
    {
        File imageFile = new File("maze1.png");
        BufferedImage image = ImageIO.read(imageFile);
        BufferedImage testOutput = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        boolean[][] isWall = new boolean[image.getHeight()-2][image.getWidth()-2];

        for(int r = 1; r < image.getHeight()-1; r++)
        {
            for(int c = 1; c < image.getWidth()-1; c++)
            {
                isWall[r-1][c-1] = image.getRGB(c,r)!=-1;
                //System.out.println(image.getRGB(c,r));
                if(!isWall[r-1][c-1])
                    testOutput.setRGB(c,r,(Color.RED).getRGB());
                else
                    testOutput.setRGB(c,r,Color.YELLOW.getRGB());
                //System.out.print(isWall[r-1][c-1] ? " " : "*");
            }
            //System.out.println();
        }

        ImageIO.write(testOutput, "png", new File("maze1output.png"));
    }
}
