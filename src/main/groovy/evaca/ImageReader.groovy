package evaca

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

/* ImageReader */	
class ImageReader {
	
	
	/* ImageReader */	
	byte[] readImageFile(String path){

		// String profileImagePath = "/var/www/html/xtras/users/MoaLaiSkirulais/evaca7571/src/main/webapp/sham/img/users/"
		// String image = '1.jpg'

		// File imageFile = new File(profileImagePath+image);
		File imageFile = new File(path);
		
		BufferedImage originalImage=ImageIO.read(imageFile);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos );
		byte[] imageInByte = baos.toByteArray();

		
	}

	

	
	
}

