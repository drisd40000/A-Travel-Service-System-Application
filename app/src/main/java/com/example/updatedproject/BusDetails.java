package com.example.updatedproject;

public class BusDetails {
    private int bd_busid;
    private String bd_busname;
    private String bd_busnumber;
    private String bd_busstart;
    private String bd_busend;
    private String bd_busdate;
    private String bd_bustime;
    private String splitinfo;

    public BusDetails(int bd_busid, String bd_busname, String bd_busnumber){
        this.bd_busid = bd_busid;
        this.bd_busname = bd_busname;
        this.bd_busnumber = bd_busnumber;
    }
    public BusDetails(int bd_busid, String bd_busname, String bd_busnumber, String bd_busstart, String bd_busend) {
        this.bd_busid = bd_busid;
        this.bd_busname = bd_busname;
        this.bd_busnumber = bd_busnumber;
        this.bd_busstart = bd_busstart;
        this.bd_busend = bd_busend;
    }
    public BusDetails(String bd_busname, String bd_busnumber, String bd_busstart, String bd_busend) {
        this.bd_busname = bd_busname;
        this.bd_busnumber = bd_busnumber;
        this.bd_busstart = bd_busstart;
        this.bd_busend = bd_busend;
    }
    public BusDetails(int bd_busid,String bd_busname, String bd_busnumber, String bd_busstart, String bd_busend,String bd_busdate, String bd_bustime) {
        this.bd_busid = bd_busid;
        this.bd_busname = bd_busname;
        this.bd_busnumber = bd_busnumber;
        this.bd_busstart = bd_busstart;
        this.bd_busend = bd_busend;
        this.bd_busdate = bd_busdate;
        this.bd_bustime = bd_bustime;
    }
    public BusDetails(String splitinfo){
        this.splitinfo = splitinfo;
    }
    public int getBd_busid() {
        return bd_busid;
    }

    public void setBd_busid(int bd_busid) {
        this.bd_busid = bd_busid;
    }

    public String getBd_busname() {
        return bd_busname;
    }

    public void setBd_busname(String bd_busname) {
        this.bd_busname = bd_busname;
    }

    public String getBd_busnumber() {
        return bd_busnumber;
    }

    public void setBd_busnumber(String bd_busnumber) {
        this.bd_busnumber = bd_busnumber;
    }

    public String getBd_busstart() {
        return bd_busstart;
    }

    public void setBd_busstart(String bd_busstart) {
        this.bd_busstart = bd_busstart;
    }

    public String getBd_busend() {
        return bd_busend;
    }

    public void setBd_busend(String bd_busend) {
        this.bd_busend = bd_busend;
    }

    public String getBd_busdate() { return bd_busdate; }

    public void setBd_busdate(String bd_busdate) { this.bd_busdate = bd_busdate; }

    public String getBd_bustime() { return bd_bustime; }

    public void setBd_bustime(String bd_bustime) { this.bd_bustime = bd_bustime; }


    public void splitBusDetails(String splitinfo){

        String[] infos = splitinfo.split("\\n");
         String busname = infos[0];
         String busnumber = infos[1];
         String busstart = infos[2];
         String busend = infos[3];
        new BusDetails(busname,busnumber,busstart,busend);
        setBd_busname(busname);
        setBd_busnumber(busnumber);
        setBd_busstart(busstart);
        setBd_busend(busend);
    }
}
