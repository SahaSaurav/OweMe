package Model;

import Model.Date;
import Model.Exception.DeductionTooLargeException;
import Model.Exception.IncorrectDateFormatException;
import Model.Exception.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SauravSaha on 4/5/18.
 */
public class Person {

    private String name;
    private double totalAmount;
    private List<Date> dates;
    private Date selected;

    public Person(String name) {
        this.name = name;
        this.totalAmount = 0;
        selected = null;
        dates = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public double getTotalAmount() {

        return totalAmount;
    }

    public List<Date> getDates() {

        return dates;
    }

    public void addToTotalAmount(double amount) throws NegativeAmountException {

        if (amount < 0 ) {
            throw new NegativeAmountException("Cannot enter a negative amount");
        }
        totalAmount += amount;
    }

    public void deductFromTotalAmount(double amount) throws DeductionTooLargeException, NegativeAmountException {

        if((totalAmount - amount) < 0) {
            throw new DeductionTooLargeException("deduction amount is too large");
        } else if (amount < 0) {
            throw new NegativeAmountException("Cannot enter a negative amount");
        }

        totalAmount = totalAmount - amount;
    }

    public void addDate(String date, String message, double amount) throws IncorrectDateFormatException, NegativeAmountException {

        if (!date.matches("^((0|1)\\d{1})-((0|1|2|3)\\d{1})-((19|20)\\d{2})")) {
            throw new IncorrectDateFormatException("Enter date in this format: MM-DD-YYYY");
        } else if (amount < 0) {
            throw new NegativeAmountException("Cannot enter negative amount");
        } else {
            Date d = new Date(date, amount, message);
            dates.add(d);
        }

    }

    public void setSelected(Date date) {
        selected = date;
    }

    public Date getSelected() {
        return selected;
    }

    public void clearSelected() {
        selected = null;
    }

    public void removeDate(Date date) {
        int i = dates.indexOf(date);
        dates.remove(i);

    }





}
