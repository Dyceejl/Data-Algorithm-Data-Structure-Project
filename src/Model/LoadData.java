package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class LoadData {

	private HashMap<String, BufferedImage> listImage;

	public LoadData() {
		listImage = new HashMap<String, BufferedImage>();

		try {
            BufferedImage image = ImageIO.read(new File("D:\\Data-Algorithm-Data-Structure-Project\\src\\icon.png"));
			BufferedImage titleImg = ImageIO.read(new File("D:\\Data-Algorithm-Data-Structure-Project\\src\\icon 1.png"));

			listImage.put("title", titleImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public HashMap<String, BufferedImage> getListImage() {
		return listImage;
	}

	public void setListImage(HashMap<String, BufferedImage> listImage) {
		this.listImage = listImage;
	}

}
