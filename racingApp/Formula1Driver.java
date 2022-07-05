
package com.mycompany.racingApp;


class Formula1Driver extends Driver{
    
    
    private int currentPoints;
    private int noOfRaces;
    private String positions;

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }
    

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getNoOfRaces() {
        return noOfRaces;
    }

    public void setNoOfRaces(int noOfRaces) {
        this.noOfRaces = noOfRaces;
    }
    
    @Override
	public String toString() {
		return "Name:" + name + "\nLocation: " + location + "\nTeam name: " + teamName;
	}
    
}
