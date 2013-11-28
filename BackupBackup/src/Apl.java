import model.MainModel;
import view.MainFrame;

public class Apl {
	public static void main(String[] args) {
		// new MainInterface();
		// new DatabaseApl();

		// BackupGui
		MainModel model = new MainModel();
		MainFrame main = new MainFrame(model);
	}
}