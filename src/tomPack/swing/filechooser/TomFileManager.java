package tomPack.swing.filechooser;

import java.io.File;

import javax.swing.JFileChooser;

import lombok.Data;
import tomPack.swing.filechooser.TomFileFilter;
import tomPack.swing.filechooser.TomFileChooser;

@Data
public class TomFileManager {

    private final TomFileChooser fc = new TomFileChooser();

    private File currDir; // current selected directory
    private File currFile; // current selected file

    public TomFileManager() {
	// all file extensions will be accepted
    }
    
    public TomFileManager(String ext, String description) {
	fc.setFileFilter(new TomFileFilter(ext, description));
    }

    /** @return the selected File to open. */
    public File showOpenDialog() {
	int result = fc.showOpenDialog(currDir);
	if (result == JFileChooser.APPROVE_OPTION) {
	    File selected = fc.getSelectedFile();
	    if (selected != null) {
		currFile = selected;
		currDir = selected.getParentFile();
		return currFile;
	    }
	}
	return null;
    }

    /** @return the selected File to write on. */
    public File showSaveDialog() {
	int result = fc.showSaveDialog(currDir);
	if (result == JFileChooser.APPROVE_OPTION) {
	    // TODO check if is overriding existing file
	    File selected = fc.getSelectedFile();
	    if (selected != null) {
		currFile = selected;
		currDir = selected.getParentFile();
		return currFile;
	    }
	}
	return null;
    }

}