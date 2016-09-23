/* EasyDate.java - Copyright (c) 2005 by Stefan Thesing
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

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * EasyDate is a wrapper for {@link java.util.Calendar}
 * and its subclasses to provide easy date-representing
 * functionality.
 * By default it wraps a {@link java.util.GregorianCalendar}
 * 
 * @author Stefan Thesing<br>
 * Website: <a href="http://www.webdings.de">http://www.webdings.de</a>
 * @version 1.0 23.05.2005
 * @see java.util.Calendar
 * @see java.util.GregorianCalendar
 * @see EasyDateCreateException
 */
public class EasyDate {
    //  Attributes
	/**
	 * <code>cal</code> ist the wrapped calendar
	 */
	private Calendar cal;
	//Constructors
	/**
	 * constructs an EasyDate object wrapping the
	 * specified calendar.
	 * @param cal The calendar to be wrapped. The
	 * constructor accepts any subclass of {@link java.util.Calendar}
	 */
	public EasyDate(Calendar cal) {
		this.cal = cal;
	}
	/**
	 * constructs an EasyDate object wrapping a
	 * {@link java.util.GregorianCalendar} initialized at the moment
	 * of this constructor's call. Essentially, an object
	 * constructed by this constructor represents today.
	 */
	public EasyDate() {
	     this(new GregorianCalendar());	
	}
	/**
	 * constructs an EasyDate object wrapping a 
	 * {@link java.util.GregorianCalendar} of the
	 * specified year, month and day.
	 * <p>IMPORTANT: note that unlike in {@link 
	 * java.util.GregorianCalendar}'s constructors 
	 * January is represented by 1 and not by 0!
	 * So the months are represented according to the
	 * following table:<br>
	 *  <table border=1>
	 * 		<tr><th align=center>int #</th><th>represented month</th></tr>
	 *  	<tr><td align=right>1</td><td>January</td></tr>
	 * 		<tr><td align=right>2</td><td>February</td></tr>
	 * 		<tr><td align=right>3</td><td>March</td></tr>
	 * 		<tr><td align=right>4</td><td>April</td></tr>
	 * 		<tr><td align=right>5</td><td>May</td></tr>
	 * 		<tr><td align=right>6</td><td>June</td></tr>
	 * 		<tr><td align=right>7</td><td>July</td></tr>
	 * 		<tr><td align=right>8</td><td>August</td></tr>
	 * 		<tr><td align=right>9</td><td>September</td></tr>
	 * 		<tr><td align=right>10</td><td>October</td></tr>
	 * 		<tr><td align=right>11</td><td>November</td></tr>
	 * 		<tr><td align=right>12</td><td>December</td></tr>
	 *  
	 * @param year the year
	 * @param month the month 
	 * @param day the day
	 * @throws EasyDateCreateException when an invalid month value
	 * is specified
	 */
	public EasyDate(int year, int month, int day) throws EasyDateCreateException {
		if(month<1 || month >12) {
			throw new EasyDateCreateException(month);
		} else {
			this.cal = new GregorianCalendar(year, month-1, day);
		}	
	}
	//Methods
	/**
	 * @return the {@link 
	 * java.util.Calendar#YEAR} field of the
	 * wrapped calendar
	 */
	public int getYear() {
		return cal.get(Calendar.YEAR);
	}
	/**
	 * @return the {@link 
	 * java.util.Calendar#MONTH} field of the
	 * wrapped calendar
	 */
	public int getMonth() {
		return cal.get(Calendar.MONTH);
	}
	/**
	 * @return the {@link 
	 * java.util.Calendar#DAY_OF_MONTH} field of the
	 * wrapped calendar
	 */
	public int getDay() {
		return cal.get(Calendar.DAY_OF_MONTH);
	}
    /**
     * @return the wrapped calendar.
     */
    public Calendar getCal() {
        return cal;
    }
    /**
     * @param cal The calender to be wrapped.
     */
    public void setCal(Calendar cal) {
        this.cal = cal;
    }
}