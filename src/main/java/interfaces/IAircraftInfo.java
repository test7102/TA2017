package main.java.interfaces;

import main.java.AirCompany;
import main.java.Aircraft;

/**
 * This interface has 2 implementations:
 * @see AirCompany#printAircraftInfo()
 * @see Aircraft#printAircraftInfo()
 */
public interface IAircraftInfo {
	public void printAircraftInfo();
}
