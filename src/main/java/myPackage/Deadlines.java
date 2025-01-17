package myPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadlines extends Task {
    private String deadline;
    private LocalDate localDate;

    public Deadlines(String description, String deadline) {
        super(description);
       // isDone = false;
        try {
            String[] dateUnformatted = deadline.split("by ");
            String[] dateSplit = dateUnformatted[1].split("-");
            localDate = LocalDate.of(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]));
            this.deadline = localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        } catch (Exception e) {
            //System.out.println("not proper date");
            this.deadline = deadline;
        }
        //System.out.printf("[D][ ] %s (%s)", this.description, this.deadline);
    }

    public String markAsDone() {
        return String.format("Nice! I've marked this task as done:\n[D][%s] %s%n", this.getStatusIcon(), this.description);
    }

    public String unmarkAsDone() {
        return String.format("OK, I've marked this task as not done yet:\n[D][%s] %s%n", this.getStatusIcon(), this.description);
    }

    public String getTaskType() {
        return "D";
    }

    @Override
    public String getDescription() {
        return String.format("%s", this.description, deadline);
    }

    public String getOriginalDescription() {
        return description;
    }

    @Override
    public String getFullDescription() {
        return String.format("[D][ ] %s (%s)", this.description, deadline);
    }

    public String getTiming() {
        return this.deadline;
    }



}
