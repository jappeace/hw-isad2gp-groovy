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

package nl.jappieklooster.ISAD2;


import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * decides what to start up, based on the args given
 * @author jappie
 */
public class Starter implements Runnable {

	public static void main(String args[]) {
		Starter s = new Starter();
		s._args = args;
		EventQueue.invokeLater(s);
	}


	private String[] _args;
	/**
	 * @param args the command line arguments
	 */

	@Override
	public void run() {
        JFrame window = null;

		if(_args.length == 0 || _args[0].equals("maze")){
			window = new nl.jappieklooster.ISAD2.maze.rendering.Window();
		}else if(_args[0].equals("point")){
			window = new nl.jappieklooster.ISAD2.points.rendering.Window();
		}else if (_args[0].equals("compress")){
			window = nl.jappieklooster.ISAD2.compression.rendering.Window.createWindow();
		}else if (_args[0].equals("backtrack")){
			window = new nl.jappieklooster.ISAD2.backtracking.rendering.Window();
		}
		/* Create and display the form */
        window.setVisible(true);	// TODO Auto-generated method stub
		
	}
}
