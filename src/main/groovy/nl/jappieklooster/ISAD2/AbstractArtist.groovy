package nl.jappieklooster.ISAD2

import java.awt.Image
import java.awt.image.BufferedImage
import javax.swing.JPanel
import java.awt.Graphics
import nl.jappieklooster.vector.Vector2D
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
		Graphics.metaClass.fillOval = {Vector2D one, Vector2D two -> 
            delegate.fillOval(
                    one.x, 
                    one.y, 
					two.x,
					two.y
            )
		}
		Graphics.metaClass.drawLine = {Vector2D one, Vector2D two -> 
            delegate.drawLine(
                    (int) one.x.round(), 
                    (int) one.y.round(), 
					(int) two.x.round(),
					(int) two.y.round()
            )
		}
		
	}

}
