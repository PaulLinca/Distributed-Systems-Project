package ro.linca.MedicalMonitorApp.helper.CustomExceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException()
    {
        super("Could not find the required data");
    }
}