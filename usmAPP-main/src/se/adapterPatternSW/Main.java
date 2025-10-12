package softeng.adapterPatternSW;

public class Main {

    public static void main(String[] args) {

        AttendanceSystem as = new AttendanceSystem();
        GradingSystem gs = new GradingSystem();
        LibrarySystem ls = new LibrarySystem();

        AttendanceSystemAdapter aadapt = new AttendanceSystemAdapter(as);
        GradingSystemAdapter gradingAdapter = new GradingSystemAdapter(gs);
        LibrarySystemAdapter libraryAdapter = new LibrarySystemAdapter(ls);

        aadapt.integrateSystem();
        gradingAdapter.integrateSystem();
        libraryAdapter.integrateSystem();

    }

}
