/* EasyDateCreateException.java - Copyright (c) 2005 by Stefan Thesing
DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
                    Version 2, December 2004 

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net> 

 Everyone is permitted to copy and distribute verbatim or modified 
 copies of this license document, and changing it is allowed as long 
 as the name is changed. 

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION 

  0. You just DO WHAT THE FUCK YOU WANT TO.

 */

package io.github.lucasvenez.ormclass.utils;


/**
 * EasyDateCreateException is used in the contstruction
 * of {@link EasyDate}.
 * Its thrown when an invalid month-value is specified.
 * @author Stefan Thesing<br>
 * Website: <a href="http://www.webdings.de">http://www.webdings.de</a>
 * @version 1.0.1 10.08.2005
 * @see EasyDate
 * 
	 */

public class EasyDateCreateException extends java.lang.Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4911661781409420883L;

	public EasyDateCreateException(int month) {
		super("EasyDate could not be created. " + month + " is not a valid month-value. Note that January is represented by 1 not by 0!");
	}
}