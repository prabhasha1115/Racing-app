
package com.mycompany.racingApp;

abstract class Driver {

       
    String name;
    String location;
    String teamName;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeam(String teamName) {
        this.teamName = teamName;
    }
    
    
}
