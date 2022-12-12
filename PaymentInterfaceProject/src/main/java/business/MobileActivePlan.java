/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author nbabu
 */
public class MobileActivePlan {
   private int id;
   private User user;
   private long mobile;
   private MobilePlan plan;
   private LocalDate planStartDate;
   private LocalDate rechargeDate;

    public MobileActivePlan(int id, User user, long mobile, MobilePlan plan, LocalDate planStartDate, LocalDate rechargeDate) {
        this.id = id;
        this.user = user;
        this.mobile = mobile;
        this.plan = plan;
        this.planStartDate = planStartDate;
        this.rechargeDate = rechargeDate;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public long getMobile() {
        return mobile;
    }

    public MobilePlan getPlan() {
        return plan;
    }

    public LocalDate getPlanStartDate() {
        return planStartDate;
    }

    public LocalDate getRechargeDate() {
        return rechargeDate;
    }
}
