import java.io.Serializable;

public enum ProjectStatus  implements Serializable {
    ACTIVE,
    TERMINATED_OS,
    TERMINATED_RM,
    TERMINATED_PM;

    public String getStatus() {
        return this.name();
    }

}
class PercentBookingAmounts {
    private Double expected;
    private Double received;
    private Double pending;
    private Double commissionCollected;

    //getter, setters and constructors
}

class BookingAmountDashboard {
    private String crnId;
    private String customerName;
    private String city;
    private String meetingDate;
    private String conversionDate;
    private String OSName;
    private String RMName;
    private Integer NDV;
    private Integer DV;
    private Double commission;
    private PercentBookingAmounts OSBookingAmount;
    private PercentBookingAmounts RMBookingAmount;
    private ProjectStatus projectStatus;
    private Boolean handedOver;

    //getters, setters and constructors
}