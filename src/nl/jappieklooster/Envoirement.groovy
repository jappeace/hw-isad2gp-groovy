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

package nl.jappieklooster
import java.lang.management.ManagementFactory;
/**
 * A class that holds some info about the envoirement
 * @author jappie
 */
class Envoirement {
	public static final boolean isDebugging;
	static{
		isDebugging = ManagementFactory.runtimeMXBean.inputArguments.toString().indexOf("jdwp") >= 0;
	}
}

