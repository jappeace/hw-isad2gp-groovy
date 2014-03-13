package nl.jappieklooster.ISAD2

import java.awt.Image
import java.awt.image.BufferedImage
import javax.swing.JPanel
import java.awt.Graphics
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
	
	static{
		Graphics.metaClass.fillOval = {double x, double y, double w, double h -> 
            delegate.fillOval(
                    (int) x.round(), 
                    (int) y.round(), 
					(int) w.round(),
					(int) h.round()
            )
		}
		
	}

}
