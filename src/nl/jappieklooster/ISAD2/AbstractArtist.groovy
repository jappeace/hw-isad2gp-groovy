package nl.jappieklooster.ISAD2

import java.awt.Image
import java.awt.image.BufferedImage
import javax.swing.JPanel

/** common base for artists */
abstract class AbstractArtist {
	JPanel canvas
	BufferedImage image
	protected JPanel getCanvas(){ canvas}
	private void setImage(BufferedImage image){
		this.image = image
	}
	Image render(){
		this.image = new BufferedImage(canvas.width, canvas.height, BufferedImage.TYPE_INT_ARGB)
		return image
	}

}
