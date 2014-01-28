/*
 * Copyright (C) 2014 jappie
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package nl.jappieklooster.ISAD2.maze;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author jappie
 */
public class MazePanel extends javax.swing.JPanel {
	private final Artist artist;
	/**
	 * Creates new form MazePanel
	 */
	@SuppressWarnings("LeakingThisInConstructor")
	public MazePanel() {
		initComponents();
		
		// tie the groovy code into java
		artist = new Artist();
		MazeFactory mf = new MazeFactory(new SquareGrid(50, 100));
		artist.setSubject(mf.createMaze());
		artist.setCanvas(this);
		artist.render();
	}
	
	public void render(){
		artist.render();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = artist.getImage();
		if (img != null) {
			g.drawImage(img, 0, 0, null);
		}
	}
	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
