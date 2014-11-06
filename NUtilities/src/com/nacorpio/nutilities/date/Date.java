package com.nacorpio.nutilities.date;

public class Date {

	private long milliseconds;
	
	/**
	 * Defines a new date with a specified amount of milliseconds.
	 * @param par1 the milliseconds.
	 */
	public Date(long par1) {
		this.milliseconds = par1;
	}
	
	/**
	 * Defines a new date with zero milliseconds.
	 */
	public Date() {
		this.milliseconds = 0;
	}
	
	/**
	 * Add a specified amount of milliseconds.
	 * @param par1 the milliseconds.
	 */
	public final Date addMilliseconds(double par1) {
		if (par1 > 0)
			this.milliseconds += par1;
			return this;
	}
	
	/**
	 * Add a specified amount of seconds.
	 * @param par1 the seconds.
	 */
	public final Date addSeconds(double par1) {
		if (par1 > 0)
			this.milliseconds += par1 * 1000;
			return this;
	}
	
	/**
	 * Add a specified amount of minutes.
	 * @param par1 the minutes.
	 */
	public final Date addMinutes(double par1) {
		if (par1 > 0)
			addSeconds(60 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of half hours.
	 * @param par1 the half hours.
	 */
	public final Date addHalfHours(double par1) {
		if (par1 > 0)
			addMinutes(30 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of hours.
	 * @param par1 the hours.
	 */
	public final Date addHours(double par1) {
		if (par1 > 0)
			addMinutes(60 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of days.
	 * @param par1 the days.
	 */
	public final Date addDays(double par1) {
		if (par1 > 0)
			addHours(24 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of weeks.
	 * @param par1 the weeks.
	 */
	public final Date addWeeks(double par1) {
		if (par1 > 0)
			addDays(7 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of months.
	 * @param par1 the months.
	 */
	public final Date addMonths(double par1) {
		if (par1 > 0)
			addWeeks(4.34812D * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of half years.
	 * @param par1 the half years.
	 */
	public final Date addHalfYears(double par1) {
		if (par1 > 0)
			addYears(0.5 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of years.
	 * @param par1 the years.
	 */
	public final Date addYears(double par1) {
		if (par1 > 0)
			addMonths(12 * par1);
			return this;
	}
	
	/**
	 * Add a specified amount of centuries.
	 * @param par1 the centuries.
	 */
	public final Date addCenturies(double par1) {
		if (par1 > 0)
			addYears(100 * par1);
			return this;
	}
	
	/**
	 * Multiply the current milliseconds by a specified multiplier.
	 * @param par1 the multiplier.
	 * @return the Date for constructing purposes.
	 */
	public final Date multiply(double par1) {
		if (par1 > 0)
			this.milliseconds = (long) (this.milliseconds * par1);
			return this;
	}
	
	/**
	 * Returns how many nanoseconds the current amount of milliseconds represents.
	 * @return the nanoseconds.
	 */
	public final double getNanoseconds() {
		return getMicroseconds() * 1000;
	}
	
	/**
	 * Returns how many milliseconds that is currently set.
	 * @return the milliseconds.
	 */
	public final double getMilliseconds() {
		return milliseconds;
	}
	
	/**
	 * Returns how many microseconds the current amount of milliseconds represents.
	 * @return the microseconds.
	 */
	public final double getMicroseconds() {
		return milliseconds * 1000;
	}
	
	/**
	 * Returns how many seconds the current amount of milliseconds represents.
	 * @return the seconds.
	 */
	public final double getSeconds() {
		return (int) milliseconds / 1000;
	}
	
	/**
	 * Returns how many minutes the current amount of milliseconds represents.
	 * @return the minutes.
	 */
	public final double getMinutes() {
		return getSeconds() / 60;
	}
	
	/**
	 * Returns how many hours the current amount of milliseconds represents.
	 * @return the hours.
	 */
	public final double getHours() {
		return getMinutes() / 60;
	}
	
	/**
	 * Returns how many days the current amount of milliseconds represents.
	 * @return the days.
	 */
	public final double getDays() {
		return getHours() / 24;
	}
	
	/**
	 * Returns how many weeks the current amount of milliseconds represents.
	 * @return the weeks.
	 */
	public final double getWeeks() {
		return getDays() / 7;
	}
	
	/**
	 * Returns how many months the current amount of milliseconds represents.
	 * @return the months.
	 */
	public final double getMonths() {
		return getWeeks() / 4.34812D;
	}
	
	/**
	 * Returns how many years the current amount of milliseconds represents.
	 * @return the years.
	 */
	public final double getYears() {
		return getMonths() / 12;
	}
	
	/**
	 * Returns how many centuries the current amount of milliseconds represents.
	 * @return the centuries.
	 */
	public final double getCenturies() {
		return getYears() / 100;
	}
	
}
