package ayurvihar.somaiya.com.ayurvihar.utility;

/**
 * Created by mikasa on 7/7/17.
 */

public class UnderFiveCr {

    public String fname="",lname="",moname="",fatname="",childid="",room="",bldg="",town="",area="",ac=""
            ,mob="",dob="",nic="",gen="";

    public UnderFiveCr(){

    }

    public UnderFiveCr(String fname, String lname, String moname, String fatname, String childid, String room, String bldg, String town, String area, String ac, String mob, String dob, String nic, String gen) {
        this.fname = fname;
        this.lname = lname;
        this.moname = moname;
        this.fatname = fatname;
        this.childid = childid;
        this.room = room;
        this.bldg = bldg;
        this.town = town;
        this.area = area;
        this.ac = ac;
        this.mob = mob;
        this.dob = dob;
        this.nic = nic;
        this.gen = gen;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMoname() {
        return moname;
    }

    public String getFatname() {
        return fatname;
    }

    public String getChildid() {
        return childid;
    }

    public String getRoom() {
        return room;
    }

    public String getBldg() {
        return bldg;
    }

    public String getTown() {
        return town;
    }

    public String getArea() {
        return area;
    }

    public String getAc() {
        return ac;
    }

    public String getMob() {
        return mob;
    }

    public String getDob() {
        return dob;
    }

    public String getNic() {
        return nic;
    }

    public String getGen() {
        return gen;
    }
}
