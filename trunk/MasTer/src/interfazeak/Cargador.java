package interfazeak;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Cargador{

	public static BufferedImage getImagen(String file){
		BufferedImage imagen = null;	
		//Le pedimos al ClassLoader que busque en el jar la url de nuestra imagen o recurso
		java.net.URL imageURL = EI_loginInterfaz.class.getResource(file);
		try{		
			imagen = ImageIO.read(imageURL);
		}catch(java.io.IOException e){
			System.out.println(e.getMessage());
		}
		return imagen;
	}

	}