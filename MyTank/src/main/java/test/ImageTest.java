package test;

import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ImageTest {

	@Test
	public void test() {
		try {
			BufferedImage bufferedImage = ImageIO.read(ImageTest.class.getClassLoader()
					.getResourceAsStream("images/bulletD.gif"));
			assertNotNull(bufferedImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
