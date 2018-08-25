package com.example.Controllers;

import java.util.Date;

/**
 * Created by Buddhima on 3/22/2018.
 */
public class Template {

    private int usage;
    private String name;
    private String LastSync;
    private String BillDate;
    private String CurrentOuts;
    private String LastBill;





    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastSync() {
        return LastSync;
    }

    public void setLastSync(String lastSync) {
        LastSync = lastSync;
    }

    public String getBillDate() {
        return BillDate;
    }

    public void setBillDate(String billDate) {
        BillDate = billDate;
    }

    public String getCurrentOuts() {
        return CurrentOuts;
    }

    public void setCurrentOuts(String currentOuts) {
        CurrentOuts = currentOuts;
    }
}
